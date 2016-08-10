<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用户详细信息</title>
    <script src="/js/jquery-1.9.1.min.js"></script>
    <style>
        div{
            text-align: left;
            margin-left: 43%;
            padding: 5px;
            font-family: 微软雅黑;
            font-weight: 300;
        }
        img {
            width: 100px;
            height: 100px;
        }
    </style>
</head>
<body>
<div>ID: &emsp; ${requestScope.user.id}</div>
<div>姓名：&emsp;${requestScope.user.realname}</div>
<div>性别：&emsp;${requestScope.user.gender}</div>
<div>照片：&emsp; <img src="${requestScope.user.avatar}">(右键查看大图)</div>
<div>出生年月：&emsp;${requestScope.user.birthday}</div>
<div>联系电话：&emsp;${requestScope.user.tel}</div>
<div>身份证号码：&emsp;${requestScope.user.idnum}</div>
<div>电子邮箱：&emsp;${requestScope.user.email}</div>
<div>最高学历：&emsp;${requestScope.user.xueli}</div>
<div>婚姻状况：&emsp;${requestScope.user.hunyin}</div>
<div>血型：&emsp;${requestScope.user.xuexing}</div>
<div>有无健康证：&emsp;${requestScope.user.jiankangzheng}</div>
<div>身高：&emsp;${requestScope.user.hight}厘米</div>
<div>体重：&emsp;${requestScope.user.weight}公斤</div>
<div>希望月平均收入：&emsp;${requestScope.user.wishsalary}元</div>
<div>邮寄送达地址：&emsp;${requestScope.user.address}</div>
<div>邮政编码：&emsp;${requestScope.user.addressnum}</div>
<div>户籍所在地地址：&emsp;${requestScope.user.hujiaddress}</div>
<div>户籍所在地邮政编码：&emsp;${requestScope.user.hujiaddressnum}</div>
<div>户籍状况：&emsp;${requestScope.user.huji}</div>
<div>身份类型：&emsp;${requestScope.user.shenfen}</div>
<div>可工作时间：&emsp;${requestScope.user.worktime}</div>
<div>每星期上班总时数：&emsp;${requestScope.user.workhours}</div>
<div>始于/下午（时）：&emsp;${requestScope.user.starttime}</div>
<div>住处距离：&emsp;${requestScope.user.distance}</div>
<div>希望待遇：&emsp;${requestScope.user.wishoffer}</div>
<div>交通工具：&emsp;${requestScope.user.vehicle}</div>
<div><h3>家庭成员一</h3></div>
<div>成员姓名：&emsp;${requestScope.user.a11}</div>
<div>成员称谓：&emsp;${requestScope.user.a12}</div>
<div>工作单位：&emsp;${requestScope.user.a13}</div>
<div>联系地址：&emsp;${requestScope.user.a14}</div>
<div>联系电话：&emsp;${requestScope.user.a15}</div>
<div><h3>家庭成员二</h3></div>
<div>成员姓名：&emsp;${requestScope.user.a21}</div>
<div>成员称谓：&emsp;${requestScope.user.a22}</div>
<div>工作单位：&emsp;${requestScope.user.a23}</div>
<div>联系地址：&emsp;${requestScope.user.a24}</div>
<div>联系电话：&emsp;${requestScope.user.a25}</div>
<div><h3>家庭成员三</h3></div>
<div>成员姓名：&emsp;${requestScope.user.a31}</div>
<div>成员称谓：&emsp;${requestScope.user.a32}</div>
<div>工作单位：&emsp;${requestScope.user.a33}</div>
<div>联系地址：&emsp;${requestScope.user.a34}</div>
<div>联系电话：&emsp;${requestScope.user.a35}</div>
<div><h3>紧急联络人</h3></div>
<div>联络人姓名：&emsp;${requestScope.user.z1}</div>
<div>与本人关系：&emsp;${requestScope.user.z2}</div>
<div>固定电话：&emsp;${requestScope.user.z3}</div>
<div>移动电话：&emsp;${requestScope.user.z4}</div>
<div>紧急联络人地址：&emsp;${requestScope.user.z5}</div>
<div><h3>主要学习经历</h3></div>
<div><h3>学习经历一</h3></div>
<div>学校：&emsp;${requestScope.user.b11}</div>
<div>时间：&emsp;${requestScope.user.b12}</div>
<div>学历：&emsp;${requestScope.user.b13}</div>
<div>证明人（老师）：&emsp;${requestScope.user.b14}</div>
<div>电话：&emsp;${requestScope.user.b15}</div>
<div><h3>学习经历二</h3></div>
<div>学校：&emsp;${requestScope.user.b21}</div>
<div>时间：&emsp;${requestScope.user.b22}</div>
<div>学历：&emsp;${requestScope.user.b23}</div>
<div>证明人（老师）：&emsp;${requestScope.user.b24}</div>
<div>电话：&emsp;${requestScope.user.b25}</div>
<div><h3>学习经历三</h3></div>
<div>学校：&emsp;${requestScope.user.b31}</div>
<div>时间：&emsp;${requestScope.user.b32}</div>
<div>学历：&emsp;${requestScope.user.b33}</div>
<div>证明人（老师）：&emsp;${requestScope.user.b34}</div>
<div>电话：&emsp;${requestScope.user.b35}</div>
<div><h3>学习经历四</h3></div>
<div>学校：&emsp;${requestScope.user.b41}</div>
<div>时间：&emsp;${requestScope.user.b42}</div>
<div>学历：&emsp;${requestScope.user.b43}</div>
<div>证明人（老师）：&emsp;${requestScope.user.b44}</div>
<div>电话：&emsp;${requestScope.user.b45}</div>
<div><h3>学习经历五</h3></div>
<div>学校：&emsp;${requestScope.user.b51}</div>
<div>时间：&emsp;${requestScope.user.b52}</div>
<div>学历：&emsp;${requestScope.user.b53}</div>
<div>证明人（老师）：&emsp;${requestScope.user.b54}</div>
<div>电话：&emsp;${requestScope.user.b55}</div>
<div><h3>主要工作经历</h3></div>
<div><h3>工作经历一</h3></div>
<div>工作单位：&emsp;${requestScope.user.c11}</div>
<div>时间：&emsp;${requestScope.user.c12}</div>
<div>待遇：&emsp;${requestScope.user.c13}</div>
<div>职务：&emsp;${requestScope.user.c14}</div>
<div>离职原因：&emsp;${requestScope.user.c15}</div>
<div>证明人 （上级主管）：&emsp;${requestScope.user.c16}</div>
<div>证明人电话：&emsp;${requestScope.user.c17}</div>
<div><h3>工作经历二</h3></div>
<div>工作单位：&emsp;${requestScope.user.c21}</div>
<div>时间：&emsp;${requestScope.user.c22}</div>
<div>待遇：&emsp;${requestScope.user.c23}</div>
<div>职务：&emsp;${requestScope.user.c24}</div>
<div>离职原因：&emsp;${requestScope.user.c25}</div>
<div>证明人 （上级主管）：&emsp;${requestScope.user.c26}</div>
<div>证明人电话：&emsp;${requestScope.user.c27}</div>
<div><h3>工作经历三</h3></div>
<div>工作单位：&emsp;${requestScope.user.c31}</div>
<div>时间：&emsp;${requestScope.user.c32}</div>
<div>待遇：&emsp;${requestScope.user.c33}</div>
<div>职务：&emsp;${requestScope.user.c34}</div>
<div>离职原因：&emsp;${requestScope.user.c35}</div>
<div>证明人 （上级主管）：&emsp;${requestScope.user.c36}</div>
<div>证明人电话：&emsp;${requestScope.user.c37}</div>
<div><h3>工作经历四</h3></div>
<div>工作单位：&emsp;${requestScope.user.c41}</div>
<div>时间：&emsp;${requestScope.user.c42}</div>
<div>待遇：&emsp;${requestScope.user.c43}</div>
<div>职务：&emsp;${requestScope.user.c44}</div>
<div>离职原因：&emsp;${requestScope.user.c45}</div>
<div>证明人 （上级主管）：&emsp;${requestScope.user.c46}</div>
<div>证明人电话：&emsp;${requestScope.user.c47}</div>
<div><h3>工作经历五</h3></div>
<div>工作单位：&emsp;${requestScope.user.c51}</div>
<div>时间：&emsp;${requestScope.user.c52}</div>
<div>待遇：&emsp;${requestScope.user.c53}</div>
<div>职务：&emsp;${requestScope.user.c54}</div>
<div>离职原因：&emsp;${requestScope.user.c55}</div>
<div>证明人 （上级主管）：&emsp;${requestScope.user.c56}</div>
<div>证明人电话：&emsp;${requestScope.user.c57}</div>
<div>更新时间：&emsp;${requestScope.user.updatetime}</div>
</body>
</html>
