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
                    <td><a href="javascript:void(0)" @click="del(userbook.id)">删除</a></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div id="project" style="display: none">
        <br/>
        <div style="text-align: center">
            <select v-model="borrowUser" style="width: 100px;">
                <option v-for="item in user" :value="item.name">{{item.name}}</option>
            </select>
            <select v-model="bookName" style="width: 100px;">
                <option v-for="item in book" :value="item.name">{{item.name}}</option>
            </select>
            <br/><br/>
            <button @click="submit">确定</button>
        </div>



    </div>
</div>
</body>
<script>
    var vm = new Vue({
        el: "#app",
        data: {
            list: [],
            name:null,
            borrowUser:null,
            bookName:null,
            user:[],
            book:[]
        },
        methods: {
            reload: function () {
                var self = this;
                $.ajax({
                    url: "/userbook/userbooklist.do",
                    type: "post",
                    dataType: "json",
                    success: function (res) {
                        console.log(res);
                        self.list = res.userBooks;
                        self.user = res.users;
                        self.book = res.books;
                    }
                })
            },
            del: function (id) {
                var self = this;
                confirm('确定要删除id为' + id + '的1条记录？', function () {
                    $.ajax({
                        url: "/userbook/delete.do",
                        type: "post",
                        dataType: "json",
                        data: {id:id},
                        success: function (res) {
                            if (res.code==0){
                                alert("操作成功",function () {
                                    self.reload();
                                } )
                            } else{
                                alert(res.msg);
                            }
                        }
                    })
                });

            },
            add:function () {
                this.name=null;
                this.borrowUser=null;
                this.bookName=null;
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
                    data: {bookName:this.bookName,borrowUser:this.borrowUser},
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
