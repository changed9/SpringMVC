<%--
  Created by IntelliJ IDEA.
  User: wbyanwj
  Date: 2018-07-13
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>借书管理</title>
    <link rel="stylesheet" href="../static/main.css">
    <script src="../static/vue.js"></script>
    <script src="../static/common.js"></script>
    <script src="../static/jquery.min.js"></script>
    <script src="../static/layer/layer.js"></script>
</head>
<body>
<div class="body" id="app">
    <div class="listIn">
        <div class="title"><p>借书管理</p></div>
        <div class="listMain">
            <p><span> <a href="javascript:history.go(-1)">< 返回</a> </span><span> <a href="javascript:void(0)" @click="add">新增</a> </span></p>
            <table class="itable">
                <thead>
                <tr>
                    <td>借书记录ID</td>
                    <td>借书人名称</td>
                    <td>借书名称</td>
                    <td>借书时间</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <tr v-for="userbook in list">
                    <td>{{userbook.id}}</td>
                    <td>{{userbook.borrowUser}}</td>
                    <td>{{userbook.bookName}}</td>
                    <td>{{userbook.borrowTime}}</td>
                    <td><a href="javascript:void(0)" @click="del(userbook)">删除</a></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div id="project" style="display: none">
        <br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" v-model="name" placeholder="请输入书名">&nbsp;&nbsp;
        <button @click="submit">确定</button>
    </div>
</div>
</body>
<script>
    var vm = new Vue({
        el: "#app",
        data: {
            list: [],
            name:null
        },
        methods: {
            reload: function () {
                var self = this;
                $.ajax({
                    url: "/userbook/userbooklist.do",
                    type: "post",
                    dataType: "json",
                    success: function (res) {
                        self.list = res;
                    }
                })
            },
            del: function (user) {
                confirm('确定要删除id为' + user.id + '的1条记录？', function () {
                    $.ajax({
                        url: "/userbook/delete.do",
                        type: "post",
                        dataType: "json",
                        contentType: "application/json",
                        data: JSON.stringify(book),
                        success: function (res) {
                            if (res.code==0){
                                alert("操作成功")
                            } else{
                                alert(res.msg);
                            }
                        }
                    })
                });

            },
            add:function () {
                this.name=null;
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
                    url: "/userbook/save.do",
                    type: "post",
                    dataType:"json",
                    data: {name:this.name},
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
