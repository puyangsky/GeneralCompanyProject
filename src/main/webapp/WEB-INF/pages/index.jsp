<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
<title>威远中保</title>
    <link href="/css/css.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/js/jquery.jslides.js"></script>
    <script type="text/javascript" src="/js/jquery-1.8.0.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#loginuser").hide();
            $.ajax({
                url: "/user/getLoginUser",
                type:"GET",
                dataType:"json",
                contentType:"application/json;charset=UTF-8",
                success:function(data) {
//                    alert("success:" + data);
                    console.log(data);
                    if(data.user == "null") {
                        $("#loginuser").hide();
                    }else{
                        var username = data.user;
                        $("#loginuser").show();
                        $("#loginusername").html(username.trim());
                        console.log(username.trim());
                        $("#unlogin").hide();
                    }
                },
                error: function (data) {
                    alert("error:" + data);
                }
            });
        });
        
    </script>
    
</head>

<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" background="/img/in_02.jpg">
  <tr>
    <td height="99"><table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="328" height="99" align="center" background="/img/in_04.jpg"><img src="/img/in_07.jpg" width="287" height="51" /></td>
        <td width="672" valign="middle"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="font_wr">
          <tr>
            <td height="35" align="right"><div id="unlogin"><a href="/dashboard/login.html">登录</a> - <a href="/dashboard/register.html">注册</a></div><div id="loginuser">欢迎您，<div id="loginusername"></div>，<a href="/user/logout">登出</a></div></td>
          </tr>
          <tr>
            <td height="50" align="right" class="font_15"><table width="95%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td align="center"><strong><a href="http://bj-wyzb.cn:11111/home">网站首页</a></strong></td>
                <td align="center"><img src="/img/shux.jpg" width="2" height="16" /></td>
                <td align="center"><strong><a href="/dashboard/about.html">关于我们</a></strong></td>
                <td align="center"><img src="/img/shux.jpg" width="2" height="16" /></td>
                <td align="center"><strong><a href="/dashboard/new.html">新闻中心</a></strong></td>
                <td align="center"><img src="/img/shux.jpg" width="2" height="16" /></td>
                <td align="center"><strong><a href="/dashboard/product.html">产品中心</a></strong></td>
                <!--<td align="center"><img src="images/shux.jpg" width="2" height="16" /></td>-->
                <!--<td align="center"><strong><a href="case.html">工程案例</a></strong></td>-->
                <td align="center"><img src="/img/shux.jpg" width="2" height="16" /></td>
                <td align="center"><strong><a href="/dashboard/service.html">服务中心</a></strong></td>
                <td align="center"><img src="/img/shux.jpg" width="2" height="16" /></td>
                <td align="center"><strong><a href="/dashboard/contact.html">联系我们</a></strong></td>
              </tr>
            </table>              </td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="500">
      <div id="full-screen-slider">
        <ul id="slides">
          <li><img src="/img/in_10.jpg" /></li>
          <li><img src="/img/case_03.jpg" width="100%" height="500" /></li>
        </ul>
      </div>
    </td>
  </tr>
</table>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="24" background="/img/in_12.jpg">&nbsp;</td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="180"><table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="260" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="26%" align="left" class="font_14"><strong>产品中心</strong></td>
              <td width="47%" align="left" class="font_999">Product</td>
              <td width="27%" align="center"><img src="/img/in_19.jpg" width="37" height="11" /></td>
            </tr>
          </table>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="103" align="left"><img src="/img/in_23.jpg" width="76" height="76" /></td>
                <td align="center"><img src="/img/in_23.jpg" width="76" height="76" /></td>
                <td align="right"><img src="/img/in_23.jpg" width="76" height="76" /></td>
              </tr>
          </table></td>
        <td valign="top"><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td width="19%" align="left" class="font_14"><strong>新闻中心</strong></td>
              <td width="71%" align="left" class="font_999">News</td>
              <td width="10%" align="center"><img src="/img/in_19.jpg" width="37" height="11" /></td>
            </tr>
            <tr>
              <td height="103" colspan="3" align="left" ><table width="100%" border="0" align="center" cellpadding="3" cellspacing="0">
                  <tr>
                    <td width="71%" align="left" class="xuxian"><a href="/dashboard/newsite.html" target="_blank">·欢洗“威远中保” TOTO全国优惠促销</a></td>
                    <td width="25%" align="left" class="xuxian">2013-11-11</td>
                  </tr>
                  <tr>
                    <td align="left" class="xuxian"><a href="/dashboard/newsite.html" target="_blank">·为什么要选择高温瓷产品？</a></td>
                    <td align="left" class="xuxian">2013-11-11</td>
                  </tr>
                  <tr>
                    <td align="left" class="xuxian"><a href="/dashboard/newsite.html" target="_blank">·威远中保旗舰展厅盛装登陆无锡</a></td>
                    <td align="left" class="xuxian">2013-11-11</td>
                  </tr>
              </table></td>
            </tr>
        </table></td>
        <td width="332" valign="top"><img src="/img/in_16.jpg" width="332" height="122" /></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="79" background="/img/in_28.jpg"><table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="195" align="center"><img src="/img/in_34.jpg" width="174" height="34" /></td>
        <td width="39" align="center"><img src="/img/in_31.jpg" width="4" height="50" /></td>
        <td width="766" align="left" class="font_999">地址：北京市丰台区黄土岗高场村2号A座3003室   电话：010-57258985<br />
          Copyright © 2013 - 2014 北京威远中保劳务服务有限公司 版权所有</td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
