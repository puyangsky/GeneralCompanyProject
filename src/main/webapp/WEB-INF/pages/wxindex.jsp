<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/6
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>WeUI</title>
    <link rel="stylesheet" href="/css/weui.min.css"/>
    <style type="text/css">
        .page_title {
            text-align:center;
            font-size:34px;
            color:#3cc51f;
            font-weight:400;
            margin:0 15%
        }
    </style>
    <script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
    <script>
        $(document).ready(function() {
            $("#regbtn").click(function () {
                var username = $("#username").val();
                var password = $("#password").val();
                var repwd = $("#repassword").val();
                if(username == "") {
                    $("#warn2").show();
                    setTimeout(function () {
                        $("#warn2").hide();
                    }, 3000);
                    return;
                }
                if(password == "") {
                    $("#warn3").show();
                    setTimeout(function () {
                        $("#warn3").hide();
                    }, 3000);
                    return;
                }
                if(repwd != password) {
                    $("#warn").show();
                    setTimeout(function () {
                        $("#warn").hide();
                    }, 3000);
                    return;
                }
                var user = {"username": username, "password":password};
                $.ajax({
                    url:"/user/register",
                    type:"POST",
                    dataType:"json",
                    data:JSON.stringify(user),
                    contentType:"application/json;charset=UTF-8",
                    success:function(data) {
                        console.log(data);
                        if(data.result == "200") {
//                            alert("注册成功");
                            $("#toast").show();
                            setTimeout(function () {
                                location.href = "/wx/reg";
                            }, 2000);
                        }else if(data.result == "400"){
//                            alert("注册失败，请重新输入用户名和密码");
                            location.href = "/wx/reg";
                        }else if(data.result == "500"){
//                            alert("注册失败，用户名已存在");
                            $("#warn1").show();
                            setTimeout(function() {
                                $("#warn1").hide();
                            }, 3000);
                        }
                    },
                    error:function(data) {
                        alert("error");
                        console.log(data);
                        location.href = "/wx/reg";
                    }
                });
            });


        });

    </script>
</head>
<body>

<h1 class="page_title">威远中保首页</h1>
<div class="weui_cells weui_cells_form">
    <div class="weui_cell">
        <div class="weui_cell_hd">
            <label class="weui_label">用户名</label>
        </div>
        <div class="weui_cell_bd weui_cell_primary">
            <input id="username" class="weui_input" type="text" pattern="[a-zA-Z0-9]*" placeholder="请输入用户名(英文和数字)"/>
        </div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_hd"><label class="weui_label">密码</label></div>
        <div class="weui_cell_bd weui_cell_primary">
            <input id="password" class="weui_input" type="password" placeholder="请输入密码(不少于9位)"/>
        </div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_hd"><label class="weui_label">确认密码</label></div>
        <div class="weui_cell_bd weui_cell_primary">
            <input id="repassword" class="weui_input" type="password" placeholder="请输入确认密码"/>
        </div>
    </div>
    <div class="weui_toptips weui_warn" id="warn">两次密码不一致</div>
    <div class="weui_toptips weui_warn" id="warn1">用户名已存在</div>
    <div class="weui_toptips weui_warn" id="warn2">用户名不能为空</div>
    <div class="weui_toptips weui_warn" id="warn3">密码不能为空</div>
    <%--<div class="btndiv">--%>
        <%--<a href="javascript:;"  class="weui_btn weui_btn_primary">注册</a>--%>
    <%--</div>--%>
    <div class="weui_btn_area">
        <a class="weui_btn weui_btn_primary" id="regbtn" href="javascript:" >注册</a>
    </div>
    <div id="toast" style="display: none;">
        <div class="weui_mask_transparent"></div>
        <div class="weui_toast">
            <i class="weui_icon_toast"></i>
            <p class="weui_toast_content">注册成功</p>
        </div>
    </div>
</div>



</body>
</html>