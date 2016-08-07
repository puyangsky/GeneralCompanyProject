<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>威远中保管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/style.css" rel='stylesheet' type='text/css' />
    <link rel="shortcut icon" href="/img/favicon.ico">
    <style rel="stylesheet" type="text/css">
        #warn1, #warn2 {
            display: none;
            color: #ff0000;
            margin: 3px 0px 15px;
        }
        #warn3, #warn4 {
            text-align: center;
            display: none;
            color: #ff0000;
            margin-top: 35px;
        }
    </style>
    <script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
    <script>
        function login() {
            var username = $("#username").val();
            var password = $("#password").val();
            if("" == username || username.length == 0) {
                $("#warn1").show();
                return;
            }
            if("" == password || password.length == 0) {
                $("#warn2").show();
                return;
            }
            var admin = {"username": username, "password":password};
            $.ajax({
                url:"/admin/login",
                type:"POST",
                dataType:"json",
                data:JSON.stringify(admin),
                contentType:"application/json;charset=UTF-8",
                success:function(data) {
                    console.log(data);
                    if(data.result == true) {
                        $("#warn4").text("登录成功，即将跳转···");
                        $("#warn4").show();
                        setTimeout(function () {
                            location.href = "/admin/admin";
                        }, 2000);
                    }else {
//                        alert("登录失败，请重新输入用户名和密码");
                        $("#warn3").show();
                        setTimeout(function () {
                            $("#username").val("");
                            $("#password").val("");
                        }, 500);
                    }
                },
                error:function(data) {
                    alert("error");
                    console.log(data);
                    location.href = "/admin";
                }
            });
        }
        function enter(e) {
            var e1 = e || event;
            if(e1.keyCode == 13) {
                login();
            }
        }
        function clearWarn() {
            if($("#username").val() != "") {
                $("#warn1").hide();
            }
            if($("#password").val() != "") {
                $("#warn2").hide();
            }
        }

        function clearWarn1() {
            $("#warn3").hide();
        }
        $(function () {
            $("#login").click(function () {
                login();
            });
        })
    </script>
</head>
<body onkeydown="enter(event);">
	<div class="main">
		<div class="login">
			<h1>威远中保管理系统</h1>
			<div class="inset">
				<!--start-main-->
				<form>
			         <div>
						<span><label>用户名</label></span>
						<span><input id="username" type="text" class="textbox" onkeyup="clearWarn();" onfocus="clearWarn1();"/></span>
					 </div>
                    <div id="warn1">
                        用户名不能为空！
                    </div>
					 <div>
						<span><label>密码</label></span>
					    <span><input id="password" type="password" class="password" onkeyup="clearWarn();" onfocus="clearWarn1();"></span>
					 </div>
                    <div id="warn2">
                        密码不能为空！
                    </div>
					<div class="sign">
                        <input id="login" type="button" value="登录" class="submit"/>
					</div>
                    <div id="warn3">
                        登录失败，用户名和密码错误！
                    </div>
                    <div id="warn4"></div>
					</form>
				</div>
			</div>
		<!--//end-main-->
		</div>

<div class="copy-right">
	<p>&copy; 2016 威远中保劳务有限公司. All Rights Reserved</p>

</div>

</body>
</html>