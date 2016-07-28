$(document).ready(function () {
    $("#regbtn").click(function () {

    });
});

function getCookie(c_name) {
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(c_name + "=");
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1;
            c_end = document.cookie.indexOf(";", c_start);
            if (c_end == -1)
                c_end = document.cookie.length;
            return decodeURI(document.cookie.substring(c_start, c_end));
        }
    }
    return ""
}
function setCookie(c_name, value) {
    var expiredays = 30;
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + expiredays);
    document.cookie = c_name + "=" + encodeURI(value) + ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString());
    //alert(document.cookie);
}
function delCookie(name)
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null) document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

function format(date) {
    dates = date.split("/");
    if(dates.length == 3) {
        if(dates[1].length == 1) {
            dates[1] = "0" + dates[1];
        }
        if (dates[2].length == 1) {
            dates[2] = "0" + dates[2];
        }
        date = dates.join("-");
        return date;
    } else {
        return null;
    }
}
function parseTime(timestamp) {
    var date = new Date(parseInt(timestamp)).toLocaleDateString();
    date = format(date);
    console.log(date);
    return date;
}

function upload() {
    var files = $("#upload_btn").prop("files");
    var data = new FormData();
    data.append("avatar", files[0]);
    $.ajax({
        url: "/user/upload",
        type: "POST",
        data: data,
        cache: false,
        processData: false,
        contentType: false,
        success: function(data) {
            json = JSON.parse(data);
            console.log("path>>>>>" + json.imgpath);
            $("#a0").html(json.imgpath);
        }
    });
}

function setInfo(email) {
    $.ajax({
        url: "/user/getuserbyemail/" + email,
        type: "GET",
        dataType:"JSONP",
        data:"",
        jsonp:"callback",
        success: function (data) {
            var id = data["id"];
            setCookie("uid", id);
            var date = data["birthday"];
            date = parseTime(date);
            //console.log("date>>>" + date);
            $("#birth").val(date);
            $("#tel").val(data["tel"]);
            $("#idnumber").val(data["idnum"]);
            $("#email").val(data["email"]);
            $("#xueli").val(data["xueli"]);
            $("#hight").val(data["hight"]);
            $("#upload_img").attr("src", data["avatar"]);
            $("#weight").val(data["weight"]);
            $("#wishsalary").val(data["wishsalary"]);
            $("#address").val(data["address"]);
            $("#addressnum").val(data["addressnum"]);
            $("#hujiaddress").val(data["hujiaddress"]);
            $("#hujiaddressnum").val(data["hujiaddressnum"]);
            $("#huji").val(data["huji"]);
            $("#shenfen").val(data["shenfen"]);
            var worktime = data["worktime"];
            $("#worktime").val(data["worktime"]);
            if(data["jiankangzheng"] == "有") {
                $("#x13").attr("checked", "checked");
                $("#x14").removeAttr("checked");
            }else{
                $("#x13").removeAttr("checked");
                $("#x14").attr("checked", "checked");
            }
            if(data["gender"] == "男") {
                $("#x11").attr("checked", "checked");
                $("#x12").removeAttr("checked");
            }else{
                $("#x11").removeAttr("checked");
                $("#x12").attr("checked", "checked");
            }
            if(data["huji"] == "本地城镇") {
                $("#x15").attr("checked", "checked");
                $("#x16").removeAttr("checked");
                $("#x17").removeAttr("checked");
                $("#x18").removeAttr("checked");
            }
            if(data["huji"] == "本地农村") {
                $("#x16").attr("checked", "checked");
                $("#x15").removeAttr("checked");
                $("#x17").removeAttr("checked");
                $("#x18").removeAttr("checked");
            }
            if(data["huji"] == "外埠城镇") {
                $("#x17").attr("checked", "checked");
                $("#x16").removeAttr("checked");
                $("#x18").removeAttr("checked");
                $("#x15").removeAttr("checked");
            }
            if(data["huji"] == "外埠农村") {
                $("#x18").attr("checked", "checked");
                $("#x16").removeAttr("checked");
                $("#x17").removeAttr("checked");
                $("#x15").removeAttr("checked");
            }
            if(data["shenfen"] == "一般劳动者") {
                $("#x19").attr("checked", "checked");
                $("#x20").removeAttr("checked");
                $("#x21").removeAttr("checked");
                $("#x22").removeAttr("checked");
                $("#x23").removeAttr("checked");
            }
            if(data["shenfen"] == "学生") {
                $("#x20").attr("checked", "checked");
                $("#x19").removeAttr("checked");
                $("#x21").removeAttr("checked");
                $("#x22").removeAttr("checked");
                $("#x23").removeAttr("checked");
            }
            if(data["shenfen"] == "军人") {
                $("#x21").attr("checked", "checked");
                $("#x20").removeAttr("checked");
                $("#x19").removeAttr("checked");
                $("#x22").removeAttr("checked");
                $("#x23").removeAttr("checked");
            }
            if(data["shenfen"] == "兼职") {
                $("#x22").attr("checked", "checked");
                $("#x20").removeAttr("checked");
                $("#x21").removeAttr("checked");
                $("#x19").removeAttr("checked");
                $("#x23").removeAttr("checked");
            }
            if(data["shenfen"] == "其他") {
                $("#x23").attr("checked", "checked");
                $("#x20").removeAttr("checked");
                $("#x21").removeAttr("checked");
                $("#x22").removeAttr("checked");
                $("#x19").removeAttr("checked");
            }


            $("#workhours").val(data["workhours"]);
            $("#starttime").val(data["starttime"]);
            $("#distance").val(data["distance"]);
            $("#wishoffer").val(data["wishoffer"]);
            $("#vehicle").val(data["vehicle"]);
            $("#hunyin").val(data["hunyin"]);
            $("#xuexing").val(data["xuexing"]);
            $("#realusername").val(data["realname"]);
            $("#a11").val(data["a11"]);
            $("#a12").val(data["a12"]);
            $("#a13").val(data["a13"]);
            $("#a14").val(data["a14"]);
            $("#a15").val(data["a15"]);
            $("#a21").val(data["a21"]);
            $("#a22").val(data["a22"]);
            $("#a23").val(data["a23"]);
            $("#a24").val(data["a24"]);
            $("#a25").val(data["a25"]);
            $("#a31").val(data["a31"]);
            $("#a32").val(data["a32"]);
            $("#a33").val(data["a33"]);
            $("#a34").val(data["a34"]);
            $("#a35").val(data["a35"]);
            $("#z1").val(data["z1"]);
            $("#z2").val(data["z2"]);
            $("#z3").val(data["z3"]);
            $("#z4").val(data["z4"]);
            $("#z5").val(data["z5"]);
            $("#b11").val(data["b11"]);
            $("#b12").val(parseTime(data["b12"]));
            $("#b13").val(data["b13"]);
            $("#b14").val(data["b14"]);
            $("#b15").val(data["b15"]);
            $("#b21").val(data["b21"]);
            $("#b22").val(parseTime(data["b22"]));
            $("#b23").val(data["b23"]);
            $("#b24").val(data["b24"]);
            $("#b25").val(data["b25"]);
            $("#b31").val(data["b31"]);
            $("#b32").val(parseTime(data["b32"]));
            $("#b33").val(data["b33"]);
            $("#b34").val(data["b34"]);
            $("#b35").val(data["b35"]);
            $("#b41").val(data["b41"]);
            $("#b42").val(parseTime(data["b42"]));
            $("#b43").val(data["b43"]);
            $("#b44").val(data["b44"]);
            $("#b45").val(data["b45"]);
            $("#b51").val(data["b51"]);
            $("#b52").val(parseTime(data["b52"]));
            $("#b53").val(data["b53"]);
            $("#b54").val(data["b54"]);
            $("#b55").val(data["b55"]);
            $("#c11").val(data["c11"]);
            $("#c12").val(parseTime(data["c12"]));
            $("#c13").val(data["c13"]);
            $("#c14").val(data["c14"]);
            $("#c15").val(data["c15"]);
            $("#c16").val(data["c16"]);
            $("#c17").val(data["c17"]);
            $("#c21").val(data["c21"]);
            $("#c22").val(parseTime(data["c22"]));
            $("#c23").val(data["c23"]);
            $("#c24").val(data["c24"]);
            $("#c25").val(data["c25"]);
            $("#c26").val(data["c26"]);
            $("#c27").val(data["c27"]);
            $("#c31").val(data["c31"]);
            $("#c32").val(parseTime(data["c32"]));
            $("#c33").val(data["c33"]);
            $("#c34").val(data["c34"]);
            $("#c35").val(data["c35"]);
            $("#c36").val(data["c36"]);
            $("#c37").val(data["c37"]);
            $("#c41").val(data["c41"]);
            $("#c42").val(parseTime(data["c42"]));
            $("#c43").val(data["c43"]);
            $("#c44").val(data["c44"]);
            $("#c45").val(data["c45"]);
            $("#c46").val(data["c46"]);
            $("#c47").val(data["c47"]);
            $("#c51").val(data["c51"]);
            $("#c52").val(parseTime(data["c52"]));
            $("#c53").val(data["c53"]);
            $("#c54").val(data["c54"]);
            $("#c55").val(data["c55"]);
            $("#c56").val(data["c56"]);
            $("#c57").val(data["c57"]);
        },
        error: function (data) {
            console.log("error>>>" + data);
        }
    });
}