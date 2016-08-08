
var curr = 1;
$(function () {
    loadData();
});

function loadData() {
    $.ajax({
        url:"/user/getusers",
        type:"GET",
        dataType:"JSONP",
        data:"",
        jsonp:"callback",
        success: function (data) {
            console.log(data);
            for(var i=0;i<data.length;i++) {
                var birthday = data[i].birthday;
                try {
                    var id = data[i].id;
                    var username = (data[i].realname == undefined) ? "" : data[i].realname;
                    var gender = (data[i].gender == undefined) ? "" : data[i].gender;
                    var hometown = (data[i].address == undefined) ? "" : data[i].address;
                    var date = new Date(birthday);
                    var Y = date.getFullYear() + '-';
                    var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
                    var D = date.getDate() < 10 ? '0'+ date.getDate() : date.getDate();
                    var formatbirthday = Y+M+D;
                    var tel = (data[i].tel == undefined) ? "" : data[i].tel;
                    var email = (data[i].email == undefined) ? "" : data[i].email;
                    var xueli = (data[i].xueli == undefined) ? "" : data[i].xueli;
                    var hunyin = (data[i].hunyin == undefined) ? "" : data[i].hunyin;
                    var idnum = (data[i].idnum == undefined) ? "" : data[i].idnum;
                    var updatetime = (data[i].updatetime == undefined) ? "" : data[i].updatetime;
                    var updateDate = new Date();
                    updateDate.setTime(updatetime);
                    updatetime = updateDate.toLocaleString();
                }catch(ex) {
                    id = "空";
                    username = "空";
                    gender = "空";
                    hometown = "空";
                    formatbirthday = "空";
                    console.log(ex);
                }
                var trbegin = "<tr>";
                var trbody = "<td> <input name='check_list' type='checkbox' id='" + id +  "'/> </td>";
                trbody += "<td>" + id + "</td>";
                trbody += "<td>" + username + "</td>";
                trbody += "<td>" + formatbirthday + "</td>";
                trbody += "<td>" + gender + "</td>";
                trbody += "<td>" + hometown + "</td>";
                trbody += "<td>" + tel + "</td>";
                trbody += "<td>" + email + "</td>";
                trbody += "<td>" + xueli + "</td>";
                trbody += "<td>" + hunyin + "</td>";
                trbody += "<td>" + idnum + "</td>";
                trbody += "<td>" + updatetime + "</td>";
                var trend = "</tr>";
                var tr = trbegin + trbody + trend;
                $("#tbody").append(tr);
            }
        }
    });
}
function load(curr) {
    $.ajax({
        url: "",
        timeout: 300000,
        dataType: "json",
        type: "get",
        data: { "flag": "load", "curr": curr },
        success: function (data) {

            var html = "#";
            $.each(data.items, function (i, item) {
                html += " <tr> " +
                        " <td>" + item.userName + "</td> " +
                        " <td>" + item.Chinese + "</td> " +
                        " <td>" + item.Math + "</td> " +
                        " <td>" + item.English + "</td> " +
                        " <td><a class=\"btn btn-info\" onclick='openedt(\"" + item.userName + "\");'>修改</a>&nbsp;&nbsp;<a class=\"btn btn-warning\" onclick='del(\"" + item.userName + "\");'>删除</a></td> " +
                        " </tr>";
            })
            $("#tbody").html(html);
            laypage({
                cont: 'page', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
                pages: Math.ceil(data.cnt / 10), //通过后台拿到的总页数
                skin: "#49afcd",
                curr: curr || 1, //当前页
                jump: function (obj, first) { //触发分页后的回调
                    if (!first) { //点击跳页触发函数自身，并传递当前页：obj.curr
                        curr = obj.curr;
                        load(curr);
                    }
                }
            });

        }
    })
}

function addItem() {
    $("#myModalLabel").text("添加人员信息");
    $("#userName").attr("readonly", false);
    $("input").val("");
    $("#addModal").modal("show");
    $("#add").show();
    $("#edt").hide();
}

function deleteItem() {
    //$("#delModal").modal("show");
    //$("#del").show();
    del();
}
function del1() {

}
function updateItem() {

}

function selectAll() {
    $("input[name='check_list']").prop("checked", true);
}
//反选，使用了jquery的each函数，并且发现通过attr("checked", true)来设置经常失效，但是采用了prop就可以
//应该跟jquery版本有关····反正多试试吧···
function reverseAll() {
    $("input[name='check_list']").each(function () {
        if($(this).is(":checked")) {
            $(this).removeAttr("checked");
        }else {
            $(this).prop("checked", true);
        }
    });
}

function add() {
    if ($("#userName").val() == "") {
        layer.tips('不能为空', '#userName');
        return;
    }
    if ($("#Password").val() == "") {
        layer.tips('不能为空', '#Password');
        return;
    }
    if ($("#Gender").val() == "") {
        layer.tips('不能为空', '#Gender');
        return;
    }
    if ($("#Hometown").val() == "") {
        layer.tips('不能为空', '#Hometown');
        return;
    }
    var user={
        "username": $("#userName").val(),
        "password": $("#Password").val(),
        "gender": $("#Gender").val(),
        "hometown": $("#Hometown").val()
    };
    $.ajax({
        url: "/user/adduser",
        timeout: 300000,
        contentType: "application/json;charse=UTF-8",
        type: "post",
        data: JSON.stringify(user),
        success: function (data) {
            console.log(data.result);
            $("#addModal").modal("hide");
            layer.alert(data.msg);
            $("input").val("");
            //loadData();
            location.href = "/tmp/table.html";
        }
    })
}


function openedt(userName) {
    $.ajax({
        url: "#",
        timeout: 300000,
        dataType: "json",
        type: "post",
        data: { "flag": "getUser", "userName": userName },
        success: function (data) {
            $("#myModalLabel").text("修改成绩");
            $("#userName").val(data.userName);
            $("#userName").attr("readonly", true);
            $("#Chinese").val(data.Chinese);
            $("#Math").val(data.Math);
            $("#English").val(data.English);

            $("#edt").show();
            $("#add").hide();
            $("#addModal").modal("show");
        }
    })
}

function edt() {
    if ($("#userName").val() == "") {
        layer.tips('不能为空', '#userName');
        return;
    }
    if ($("#Chinese").val() == "") {
        layer.tips('不能为空', '#Chinese');
        return;
    }
    if ($("#Math").val() == "") {
        layer.tips('不能为空', '#Math');
        return;
    }
    if ($("#English").val() == "") {
        layer.tips('不能为空', '#English');
        return;
    }
    var formdata = {
        flag: "edt",
        userName: $("#userName").val(),
        Chinese: $("#Chinese").val(),
        Math: $("#Math").val(),
        English: $("#English").val()
    }
    $.ajax({
        url: "#",
        timeout: 300000,
        dataType: "json",
        type: "post",
        data: formdata,
        success: function (data) {
            $("#addModal").modal("hide");
            layer.alert(data.msg);
            $("input").val("");
            load(curr);
        }
    })
}


function del() {
    var check = $("input[name='check_list']:checked");
    var num = $(check).length;
    if(num == 0) {
        layer.alert("您需要选取删除的对象！");
    }else {
        //询问框
        layer.confirm('您确定要删除这' + num + '项？', {
            btn: ['确定', '取消'] //按钮
        }, function () {
            var userIds = [];
            $("input[name='check_list']:checked").each(function () {
                var id = {"id":$(this).attr("id")};
                userIds.push(id);
            });
            var id_json = JSON.stringify(userIds);
            console.log("id in json>>>>" + id_json);
            $.ajax({
                url: "/user/deleteusers",
                timeout: 300000,
                dataType: "json",
                type: "POST",
                data: id_json,
                contentType:"application/json;charset=UTF-8",
                success: function (data) {
                    console.log(data);
                    if(data.res == true)
                        layer.alert("删除成功");
                    setTimeout(function () {
                        loadData();
                    }, 1000);
                }
            })
        }, function () {
            //  layer.close();
        });
    }
}