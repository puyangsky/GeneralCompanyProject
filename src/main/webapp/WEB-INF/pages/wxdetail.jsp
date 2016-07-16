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
        .sub_title {
            text-align:center;
            font-size:25px;
            color:#3cc51f;
            font-weight:400;
            margin:10px
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
<form>
    <div class="weui_cells weui_cells_form">
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">姓名</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="username" class="weui_input" type="text" placeholder="请输入用户名(中文)"/>
            </div>
        </div>
    </div>
    <div class="weui_cells_title">性别</div>
    <div class="weui_cells weui_cells_radio">
        <label class="weui_cell weui_check_label" for="x11">
            <div class="weui_cell_bd weui_cell_primary">
                <p>男</p>
            </div>
            <div class="weui_cell_ft">
                <input type="radio" class="weui_check" name="radio1" id="x11"  checked="checked">
                <span class="weui_icon_checked"></span>
            </div>
        </label>
        <label class="weui_cell weui_check_label" for="x12">

            <div class="weui_cell_bd weui_cell_primary">
                <p>女</p>
            </div>
            <div class="weui_cell_ft">
                <input type="radio" name="radio1" class="weui_check" id="x12">
                <span class="weui_icon_checked"></span>
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
        <div class="weui_cells weui_cells_form">
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">出生年月</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input id="birth" class="weui_input" type="date" value=""/>
                </div>
            </div>
        </div>
        <div class="weui_cells_title">联系电话</div>
        <div class="weui_cells">

            <div class="weui_cell weui_cell_select weui_select_before">
                <div class="weui_cell_hd">
                    <select class="weui_select" name="select2">
                        <option value="1">+86</option>
                        <option value="2">+80</option>
                        <option value="3">+84</option>
                        <option value="4">+87</option>
                    </select>
                </div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input class="weui_input" type="number" pattern="[0-9]*" placeholder="请输入号码"/>
                </div>
            </div>
        </div>

    <div class="weui_cells weui_cells_form">

        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">身份证号码</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="idnumber" class="weui_input" type="text" pattern="[0-9]{17}[0-9]{0,1}[x]{0,1}"
                       title="请输入正确格式的18位身份证" placeholder="请输入身份证"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">电子邮箱</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="email" class="weui_input" type="email" title="请输入正确格式的email" placeholder="请输入email"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">最高学历</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="xueli" class="weui_input" type="text" placeholder="请输入最高学历"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">婚姻状况</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="hunyin" class="weui_input" type="text" placeholder="已婚/未婚/离异"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">血型</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="xuexing" class="weui_input" type="text" pattern="[ABO]{1,2,3}"
                       title="请输入A或B或AB或O" placeholder="A/B/AB/O"/>
            </div>
        </div>
    </div>
    <div class="weui_cells_title">有无健康证</div>
    <div class="weui_cells weui_cells_radio">
        <label class="weui_cell weui_check_label" for="x13">
            <div class="weui_cell_bd weui_cell_primary">
                <p>有</p>
            </div>
            <div class="weui_cell_ft">
                <input type="radio" class="weui_check" name="radio1" id="x13"  checked="checked">
                <span class="weui_icon_checked"></span>
            </div>
        </label>
        <label class="weui_cell weui_check_label" for="x14">

            <div class="weui_cell_bd weui_cell_primary">
                <p>无</p>
            </div>
            <div class="weui_cell_ft">
                <input type="radio" name="radio1" class="weui_check" id="x14">
                <span class="weui_icon_checked"></span>
            </div>
        </label>
    </div>
    <div class="weui_cells weui_cells_form">
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">身高</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="shengao" class="weui_input" type="number" pattern="[0-9]{3}"
                       title="请输入数字" placeholder="厘米"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">体重</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="tizhong" class="weui_input" type="number" pattern="[0-9]{3}"
                       title="请输入数字" placeholder="公斤"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">希望月平均收入</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="wishsalary" class="weui_input" type="number" pattern="[0-9]*"
                       title="请输入数字" placeholder="元"/>
            </div>
        </div>

        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">邮寄送达地址</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="address" class="weui_input" type="text" placeholder="邮寄送达地址"/>
            </div>
        </div>

        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">邮政编码</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="addressnumber" class="weui_input" type="number" pattern="[0-9]*"
                       title="请输入数字" placeholder="邮政编码"/>
            </div>
        </div>

        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">户籍所在地地址</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="hujidizhi" class="weui_input" type="text" placeholder="户籍所在地地址"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">邮政编码</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="hujiaddressnumber" class="weui_input" type="number" pattern="[0-9]*"
                       title="请输入数字" placeholder="邮政编码"/>
            </div>
        </div>
    </div>

    <div class="weui_cells_title">户籍状况</div>
    <div class="weui_cells weui_cells_radio">
        <label class="weui_cell weui_check_label" for="x15">
            <div class="weui_cell_bd weui_cell_primary">
                <p>本地城镇</p>
            </div>
            <div class="weui_cell_ft">
                <input type="radio" class="weui_check" name="radio4" id="x15"  checked="checked">
                <span class="weui_icon_checked"></span>
            </div>
        </label>
        <label class="weui_cell weui_check_label" for="x16">

            <div class="weui_cell_bd weui_cell_primary">
                <p>本地城镇</p>
            </div>
            <div class="weui_cell_ft">
                <input type="radio" name="radio4" class="weui_check" id="x16">
                <span class="weui_icon_checked"></span>
            </div>
        </label>
        <label class="weui_cell weui_check_label" for="x17">

            <div class="weui_cell_bd weui_cell_primary">
                <p>外埠城镇</p>
            </div>
            <div class="weui_cell_ft">
                <input type="radio" name="radio4" class="weui_check" id="x17">
                <span class="weui_icon_checked"></span>
            </div>
        </label>
        <label class="weui_cell weui_check_label" for="x18">

            <div class="weui_cell_bd weui_cell_primary">
                <p>外埠农村</p>
            </div>
            <div class="weui_cell_ft">
                <input type="radio" name="radio4" class="weui_check" id="x18">
                <span class="weui_icon_checked"></span>
            </div>
        </label>
    </div>

    <div class="weui_cells_title">身份类型</div>
    <div class="weui_cells weui_cells_radio">
        <label class="weui_cell weui_check_label" for="x19">
            <div class="weui_cell_bd weui_cell_primary">
                <p>一般劳动者</p>
            </div>
            <div class="weui_cell_ft">
                <input type="radio" class="weui_check" name="radio2" id="x19"  checked="checked">
                <span class="weui_icon_checked"></span>
            </div>
        </label>
        <label class="weui_cell weui_check_label" for="x20">

            <div class="weui_cell_bd weui_cell_primary">
                <p>学生</p>
            </div>
            <div class="weui_cell_ft">
                <input type="radio" name="radio2" class="weui_check" id="x20">
                <span class="weui_icon_checked"></span>
            </div>
        </label>
        <label class="weui_cell weui_check_label" for="x21">

            <div class="weui_cell_bd weui_cell_primary">
                <p>军人</p>
            </div>
            <div class="weui_cell_ft">
                <input type="radio" name="radio2" class="weui_check" id="x21">
                <span class="weui_icon_checked"></span>
            </div>
        </label>
        <label class="weui_cell weui_check_label" for="x22">

            <div class="weui_cell_bd weui_cell_primary">
                <p>兼职</p>
            </div>
            <div class="weui_cell_ft">
                <input type="radio" name="radio2" class="weui_check" id="x22">
                <span class="weui_icon_checked"></span>
            </div>
        </label>

        <label class="weui_cell weui_check_label" for="x23">

            <div class="weui_cell_bd weui_cell_primary">
                <p>其他</p>
            </div>
            <div class="weui_cell_ft">
                <input type="radio" name="radio2" class="weui_check" id="x23">
                <span class="weui_icon_checked"></span>
            </div>
        </label>
    </div>

    <div class="weui_cells_title">可工作时间</div>
    <div class="weui_cells weui_cells_checkbox">
        <label class="weui_cell weui_check_label" for="s11">
            <div class="weui_cell_hd">
                <input type="checkbox" class="weui_check" name="checkbox3" id="s11" checked="checked">
                <i class="weui_icon_checked"></i>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <p>周一</p>
            </div>
        </label>
        <label class="weui_cell weui_check_label" for="s12">
            <div class="weui_cell_hd">
                <input type="checkbox" name="checkbox3" class="weui_check" id="s12">
                <i class="weui_icon_checked"></i>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <p>周二</p>
            </div>
        </label>
        <label class="weui_cell weui_check_label" for="s13">
            <div class="weui_cell_hd">
                <input type="checkbox" name="checkbox3" class="weui_check" id="s13">
                <i class="weui_icon_checked"></i>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <p>周三</p>
            </div>
        </label>
        <label class="weui_cell weui_check_label" for="s14">
            <div class="weui_cell_hd">
                <input type="checkbox" name="checkbox3" class="weui_check" id="s14">
                <i class="weui_icon_checked"></i>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <p>周四</p>
            </div>
        </label>
        <label class="weui_cell weui_check_label" for="s15">
            <div class="weui_cell_hd">
                <input type="checkbox" name="checkbox3" class="weui_check" id="s15">
                <i class="weui_icon_checked"></i>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <p>周五</p>
            </div>
        </label>
        <label class="weui_cell weui_check_label" for="s16">
            <div class="weui_cell_hd">
                <input type="checkbox" name="checkbox3" class="weui_check" id="s16">
                <i class="weui_icon_checked"></i>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <p>周六</p>
            </div>
        </label>
        <label class="weui_cell weui_check_label" for="s17">
            <div class="weui_cell_hd">
                <input type="checkbox" name="checkbox3" class="weui_check" id="s17">
                <i class="weui_icon_checked"></i>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <p>周日</p>
            </div>
        </label>
    </div>

    <div class="weui_cells weui_cells_form">
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">每星期上班总时数
                </label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="workhour" class="weui_input" type="number" placeholder="每星期上班总时数"/>
            </div>
        </div>

        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">始于/下午（时）</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="start" class="weui_input" type="number" placeholder="始于/下午（时）"/>
            </div>
        </div>

        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">住处距离</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="distance" class="weui_input" type="number" placeholder="住处距离"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">希望待遇</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="wish" class="weui_input" type="text" placeholder="希望待遇"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">交通工具</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="vehicle" class="weui_input" type="text" placeholder="交通工具"/>
            </div>
        </div>
    </div>
    <div class="weui_cells weui_cells_form">
        <div class="sub_title">家庭状况</div>
        <div class="weui_cells_title">家庭成员一</div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">成员姓名</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="a11" class="weui_input" type="text" placeholder="成员姓名"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">成员称谓</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="a12" class="weui_input" type="text" placeholder="成员称谓"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">工作单位</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="a13" class="weui_input" type="text" placeholder="工作单位"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">联系地址</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="a14" class="weui_input" type="text" placeholder="联系地址"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">联系电话</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="a15" class="weui_input" type="number" placeholder="联系电话"/>
            </div>
        </div>
        <%--家庭成员二--%>
        <div class="weui_cells_title">家庭成员二</div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">成员姓名</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="a21" class="weui_input" type="text" placeholder="成员姓名"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">成员称谓</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="a22" class="weui_input" type="text" placeholder="成员称谓"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">工作单位</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="a23" class="weui_input" type="text" placeholder="工作单位"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">联系地址</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="a24" class="weui_input" type="text" placeholder="联系地址"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">联系电话</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="a25" class="weui_input" type="number" placeholder="联系电话"/>
            </div>
        </div>
        <%--家庭成员三--%>
        <div class="weui_cells_title">家庭成员三</div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">成员姓名</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="a31" class="weui_input" type="text" placeholder="成员姓名"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">成员称谓</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="a32" class="weui_input" type="text" placeholder="成员称谓"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">工作单位</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="a33" class="weui_input" type="text" placeholder="工作单位"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">联系地址</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="a34" class="weui_input" type="text" placeholder="联系地址"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">联系电话</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="a35" class="weui_input" type="number" placeholder="联系电话"/>
            </div>
        </div>
    </div>
    <div class="weui_cells weui_cells_form">
        <div class="sub_title">紧急联络人</div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">联络人姓名</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="b11" class="weui_input" type="text" placeholder="联络人姓名"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">与本人关系</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="b12" class="weui_input" type="text" placeholder="与本人关系"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">固定电话</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="b13" class="weui_input" type="number" placeholder="固定电话"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">移动电话</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="b14" class="weui_input" type="number" placeholder="移动电话"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">紧急联络人地址</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="b15" class="weui_input" type="text" placeholder="紧急联络人地址"/>
            </div>
        </div>
    </div>

    <div class="weui_cells weui_cells_form">
        <div class="sub_title">主要学习经历</div>
        <div class="weui_cells_title">学习经历一</div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">学校</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c11" class="weui_input" type="text" placeholder="学校"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd"><label class="weui_label">时间</label></div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c12" class="weui_input" type="date" value=""/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">学历</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c13" class="weui_input" type="text" placeholder="学历"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">证明人（老师）</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c14" class="weui_input" type="text" placeholder="证明人（老师）"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">电话</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c15" class="weui_input" type="number" placeholder="电话"/>
            </div>
        </div>
        <%--高中--%>
        <div class="weui_cells_title">学习经历二</div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">学校</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c21" class="weui_input" type="text" placeholder="学校"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd"><label class="weui_label">时间</label></div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c22" class="weui_input" type="date" value=""/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">学历</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c23" class="weui_input" type="text" placeholder="学历"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">证明人（老师）</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c24" class="weui_input" type="text" placeholder="证明人（老师）"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">电话</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c25" class="weui_input" type="number" placeholder="电话"/>
            </div>
        </div>
        <%--大学--%>
        <div class="weui_cells_title">学习经历三</div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">学校</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c31" class="weui_input" type="text" placeholder="学校"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd"><label class="weui_label">时间</label></div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c32" class="weui_input" type="date" value=""/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">学历</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c33" class="weui_input" type="text" placeholder="学历"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">证明人（老师）</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c34" class="weui_input" type="text" placeholder="证明人（老师）"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">电话</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c35" class="weui_input" type="number" placeholder="电话"/>
            </div>
        </div>
        <%--研究生--%>
        <div class="weui_cells_title">学习经历四</div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">学校</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c41" class="weui_input" type="text" placeholder="学校"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd"><label class="weui_label">时间</label></div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c42" class="weui_input" type="date" value=""/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">学历</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c43" class="weui_input" type="text" placeholder="学历"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">证明人（老师）</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c44" class="weui_input" type="text" placeholder="证明人（老师）"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">电话</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c45" class="weui_input" type="number" placeholder="电话"/>
            </div>
        </div>
        <%--博士--%>
        <div class="weui_cells_title">学习经历五</div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">学校</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c51" class="weui_input" type="text" placeholder="学校"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd"><label class="weui_label">时间</label></div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c52" class="weui_input" type="date" value=""/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">学历</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c53" class="weui_input" type="text" placeholder="学历"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">证明人（老师）</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c54" class="weui_input" type="text" placeholder="证明人（老师）"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">电话</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="c55" class="weui_input" type="number" placeholder="电话"/>
            </div>
        </div>
    </div>


    <div class="weui_cells weui_cells_form">
        <div class="sub_title">主要工作经历（如有曾在本公司的工作经历则必须注明）</div>

        <div class="weui_cells_title">工作经历一</div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">工作单位</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d11" class="weui_input" type="text" placeholder="工作单位"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd"><label class="weui_label">时间</label></div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d12" class="weui_input" type="date" value=""/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">待遇</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d13" class="weui_input" type="text" placeholder="待遇（元/月）"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">职务</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d14" class="weui_input" type="text" placeholder="职务"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">离职原因</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d15" class="weui_input" type="text" placeholder="离职原因"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">证明人 （上级主管）</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d16" class="weui_input" type="text" placeholder="证明人 （上级主管）"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">证明人电话</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d17" class="weui_input" type="number" placeholder="证明人电话"/>
            </div>
        </div>

        <div class="weui_cells_title">工作经历二</div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">工作单位</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d21" class="weui_input" type="text" placeholder="工作单位"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd"><label class="weui_label">时间</label></div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d22" class="weui_input" type="date" value=""/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">待遇</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d23" class="weui_input" type="text" placeholder="待遇（元/月）"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">职务</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d24" class="weui_input" type="text" placeholder="职务"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">离职原因</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d25" class="weui_input" type="text" placeholder="离职原因"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">证明人 （上级主管）</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d26" class="weui_input" type="text" placeholder="证明人 （上级主管）"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">证明人电话</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d27" class="weui_input" type="number" placeholder="证明人电话"/>
            </div>
        </div>

        <div class="weui_cells_title">工作经历三</div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">工作单位</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d31" class="weui_input" type="text" placeholder="工作单位"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd"><label class="weui_label">时间</label></div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d32" class="weui_input" type="date" value=""/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">待遇</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d33" class="weui_input" type="text" placeholder="待遇（元/月）"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">职务</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d34" class="weui_input" type="text" placeholder="职务"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">离职原因</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d35" class="weui_input" type="text" placeholder="离职原因"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">证明人 （上级主管）</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d36" class="weui_input" type="text" placeholder="证明人 （上级主管）"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">证明人电话</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d37" class="weui_input" type="number" placeholder="证明人电话"/>
            </div>
        </div>

        <div class="weui_cells_title">工作经历四</div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">工作单位</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d41" class="weui_input" type="text" placeholder="工作单位"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd"><label class="weui_label">时间</label></div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d42" class="weui_input" type="date" value=""/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">待遇</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d43" class="weui_input" type="text" placeholder="待遇（元/月）"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">职务</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d44" class="weui_input" type="text" placeholder="职务"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">离职原因</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d45" class="weui_input" type="text" placeholder="离职原因"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">证明人 （上级主管）</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d46" class="weui_input" type="text" placeholder="证明人 （上级主管）"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">证明人电话</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d47" class="weui_input" type="number" placeholder="证明人电话"/>
            </div>
        </div>

        <div class="weui_cells_title">工作经历五</div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">工作单位</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d51" class="weui_input" type="text" placeholder="工作单位"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd"><label class="weui_label">时间</label></div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d52" class="weui_input" type="date" value=""/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">待遇</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d53" class="weui_input" type="text" placeholder="待遇（元/月）"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">职务</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d54" class="weui_input" type="text" placeholder="职务"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">离职原因</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d55" class="weui_input" type="text" placeholder="离职原因"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">证明人 （上级主管）</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d56" class="weui_input" type="text" placeholder="证明人 （上级主管）"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label class="weui_label">证明人电话</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="d57" class="weui_input" type="number" placeholder="证明人电话"/>
            </div>
        </div>
    </div>

    <div class="weui_btn_area">
        <input type="submit" class="weui_btn weui_btn_primary" id="regbtn">
    </div>
</form>

    <div class="weui_toptips weui_warn" id="warn"></div>

    <div id="toast" style="display: none;">
        <div class="weui_mask_transparent"></div>
        <div class="weui_toast">
            <i class="weui_icon_toast"></i>
            <p class="weui_toast_content">注册成功</p>
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