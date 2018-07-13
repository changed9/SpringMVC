<%--
  Created by IntelliJ IDEA.
  User: wbyanwj
  Date: 2018-07-13
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <link rel="stylesheet" href="../static/main.css">
    <script src="../static/vue.js"></script>
    <script src="../static/common.js"></script>
    <script src="../static/jquery.min.js"></script>
    <script src="../static/layer/layer.js"></script>
</head>
<body>
<div class="body" id="app">
    <div class="listIn">
        <div class="title"><p>图书管理</p></div>
        <div class="listMain">
            <p><span> <a href="javascript:history.go(-1)">< 返回</a> </span><span> <a href="javascript:void(0)" @click="add">新增</a> </span></p>
            <table class="itable">
                <thead>
                <tr>
                    <td>图书ID</td>
                    <td>图书名称</td>
                    <td>图书作者</td>
                    <td>入库时间</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <tr v-for="book in list">
                    <td>{{book.id}}</td>
                    <td>{{book.name}}</td>
                    <td>{{book.bookWriter}}</td>
                    <td>{{book.storageTime}}</td>
                    <td><a href="javascript:void(0)" @click="del(book)">删除</a></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div id="project" style="display: none">
        <br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" v-model="name" placeholder="请输入书名">&nbsp;&nbsp;
        <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" v-model="writer" placeholder="请输入作者名">&nbsp;&nbsp;
        <button @click="submit">确定</button>
    </div>
</div>
</body>
<script>
    var vm = new Vue({
        el: "#app",
        data: {
            list: [],
            name:null,
            writer:null
        },
        methods: {
            reload: function () {
                var self = this;
                $.ajax({
                    url: "/book/booklist.do",
                    type: "post",
                    dataType: "json",
                    success: function (res) {
                        self.list = res;
                    }
                })
            },
            del: function (book) {
                var self = this;
                confirm('确定要删除id为' + book.id + '的记录？', function () {
                    $.ajax({
                        url: "/book/delete.do",
                        type: "post",
                        dataType: "json",
                        data: {"name":book.name,"id":book.id},
                        success: function (res) {
                            if (res.code==0){
                                alert("操作成功")
                                self.reload();
                            } else{
                                alert(res.msg);
                            }
                        }
                    })
                });

            },
            add:function () {
                this.name=null;
                this.writer=null;

                layer.open({
                    type: 1,
                    title: '新增',
                    area: ['300px', '200px'],
                    shade: 0.8,
                    closeBtn: 1,
                    shadeClose: true,
                    content: $("#project")
                });
            },
            submit:function () {
                var self = this;
                $.ajax({
                    url: "/book/save.do",
                    type: "post",
                    dataType:"json",
                    data: {name:this.name,writer:this.writer},
                    success: function (res) {
                        if (res.code==0){
                            layer.closeAll();
                            self.reload();
                        } else{
                            alert(res.msg);
                        }
                    }
                })
            }
        },
        mounted: function () {
            this.reload();
        }
    })
</script>
</html>
