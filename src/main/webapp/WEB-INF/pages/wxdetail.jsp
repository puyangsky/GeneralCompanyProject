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
        #upload_process {
            display: none;
        }
    </style>
    <script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
    <script>
        $(document).ready(function() {
            function pic_change() {
                $("#upload_img").addClass("weui_uploader_status");
                var process = 0;
                var timer = window.setInterval(function () {
                    $("#upload_process").html(process + "%");
                    $("#upload_process").show();
                    process += 10;
                    console.log(process);
                    if(process > 100) {
                        $("#upload_process").hide();
                        $("#upload_img").removeClass("weui_uploader_status");
                        clearInterval(timer);
                    }
                }, 1000);

            }

//            $("#upload_btn").change(function () {
//                console.log("helli");
//                window.URL.createObjectURL
//                $("#upload_img").attr("src", $("#upload_btn").val());
//            });

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

<h1 class="page_title">详细信息填写</h1>
<div class="weui_cells weui_cells_form">
    <div class="weui_cell">
        <div class="weui_cell_hd">
            <label class="weui_label">姓名</label>
        </div>
        <div class="weui_cell_bd weui_cell_primary">
            <input id="username" class="weui_input" type="text" placeholder="请输入用户名(中文)"/>
        </div>
    </div>

    <div class="weui_cells_title">性别</div>
    <div class="weui_cells weui_cells_checkbox">
        <label class="weui_cell weui_check_label" for="s11">
            <div class="weui_cell_hd">
                <input type="checkbox" class="weui_check" name="checkbox1" id="s11" checked="checked">
                <i class="weui_icon_checked"></i>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <p>男</p>
            </div>
        </label>
        <label class="weui_cell weui_check_label" for="s12">
            <div class="weui_cell_hd">
                <input type="checkbox" name="checkbox1" class="weui_check" id="s12">
                <i class="weui_icon_checked"></i>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <p>女</p>
            </div>
        </label>
    </div>

    <div class="weui_cell">
        <div class="weui_cell_bd weui_cell_primary">
            <div class="weui_uploader">
                <div class="weui_uploader_hd weui_cell">
                    <div class="weui_cell_bd weui_cell_primary">照片上传</div>
                </div>
                <div class="weui_uploader_bd">
                    <%--<ul class="weui_uploader_files">--%>
                        <%--<li id="upload_img" class="weui_uploader_file" style="background-image:url(http://localhost:8080/img/default_pic.jpg)">--%>
                            <%--<div id="upload_process" class="weui_uploader_status_content"></div>--%>
                        <%--</li>--%>

                        <%--&lt;%&ndash;<li class="weui_uploader_file weui_uploader_status" style="background-image:url(http://shp.qpic.cn/weixinsrc_pic/pScBR7sbqjOBJomcuvVJ6iacVrbMJaoJZkFUIq4nzQZUIqzTKziam7ibg/)">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<div class="weui_uploader_status_content">50%</div>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
                    <%--</ul>--%>
                    <div>
                        <img id="upload_img" class="weui_uploader_file" src="/img/default_pic.jpg">
                    </div>
                    <div class="weui_uploader_input_wrp">
                        <input id="upload_btn" class="weui_uploader_input" onchange="uploadImg(this)" type="file" accept="image/*" multiple />
                    </div>
                </div>
            </div>
        </div>
    </div>









    <div class="weui_toptips weui_warn" id="warn"></div>
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

<script>
    function uploadImg(sender) {
        console.log(window.URL.createObjectURL(sender.files[0]));
        $("#upload_img").attr("src", window.URL.createObjectURL(sender.files[0]));
    }
</script>

</body>
</html>