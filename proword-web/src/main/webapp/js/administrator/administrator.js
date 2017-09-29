$(function () {
    //left_color('role_manage_id')
    getDataNew('1');

})

$(".addOkBtn").click(function(){
    console.log(1);
    adminInsert();
});

//获取数据列表
function getDataNew(msg) {
    var adminName = $("#adminName").val();
    var t = true;
    $.ajax({
        type: "post",
        url: 'http://192.168.102.98:8080/pro-word-web/admin/getList.do',
        data: {
            currentPage: msg,
            adminName: adminName
        },
        dataType: "json", //返回数据形式为json
        contentType: 'application/x-www-form-urlencoded;charset=UTF-8',

        success: function (result) {
            console.log(result)
            var html = '',
                res = result.adminList;
            // currentPage = result.current_page;
            // start = (currentPage - 1) * 10
            for (var i = 0; i < res.length; i++) {
                // var data = res[i].fields;
                // var pk = res[i].pk ;
                // if(data.create_time != null){
                //     var s11=data.create_time.substr(0,10);
                //     var s12=data.create_time.substr(11,8);
                // }
                // if(data.update_time != null){
                //     var s13=data.update_time.substr(0,10);
                //     var s14=data.update_time.substr(11,8);
                // }
                html += '<tr>';
                html += '<td class="num">' + res.id + '</td>';
                html += '<td>' + res.adminName + '</td>';
                html += '<td>' + res.adminPassWord+ '</td>';
                html += "<td style='text-align: center'><span onclick=\"roleUpdateInfo('" + res.id + "')\" class='update' data-target='#updateModal' data-toggle='modal'>修改</span>";
                html += "<span onclick=\"roleInfo('" + res.id + "')\" class='update' data-target='#searchModal' data-toggle='modal'>查看</span>";
                html += "<span onclick=\"setId('" + res.id + "')\" class='delete' data-target='#deleModal' data-toggle='modal'>删除</span></td>";
            }
            $(".table tbody").html(html);
           //  totalNumber = result.role_sum;
           //  $(function () {
           //      $("[data-toggle='popover']").popover();
           //  });
           //  $("#role_sum").html(totalNumber);

           //  totalPage = result.pages;
           // producePage(totalNumber, currentPage, totalPage);
           //  $("#totalPage_all").html(totalPage);
           //  return t;
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        }
    });
    return t;
}

function setId(id) {
    $("#delete_id").val(id)
}

function adminDelete() {
    id = $("#delete_id").val()
    var csrftoken = getCookie('csrftoken');
    $.ajax({
        type: "POST",
        url: "/admin/delete.do",
        data: {'id': id},
        dataType: 'json',
        success: function (res) {
            if (res.code == '200') {
                $('#deleModal').modal('hide');
                //成功调用的提示
                successMsg(true, '删除成功！', '', 2000);
                getDataNew('1');
            }
            else {
                $('#deleModal').modal('hide');
                //失败调用的提示
                errorMsg(true, '删除失败！', res.message, 2000)
            }
        }
    })
}

function adminUpdate(id) {
    $("#update_id").val(id)
    // var listchk = $("input[name=inlineCheckbox2]");
    // for (i = 0; i < listchk.length; i++) {
    //     listchk[i].checked = false;
    // }
    $.ajax({
        type: "POST",
        url: "/admin/update.do",
        data: {'id': id},
        dataType: 'json',
        token: csrftoken,
        success: function (res) {
            var treeObj = $.fn.zTree.getZTreeObj("treeDemo1");
			treeObj.checkAllNodes(false);
			checked(res.permissionIds,"treeDemo1");
            $("#row_name_update").val(res.roleName)
            var permissions = res.permissions;
            var arrs = permissions.split(';');
            arrs.pop();
            var listchk = $("input[name=inlineCheckbox2]");
            for (j = 0; j < arrs.length; j++) {
                for (i = 0; i < listchk.length; i++) {
                    if (listchk[i].value == arrs[j]) {
                        listchk[i].checked = true;
                    }

                }
            }
        }
    })
}

function adminInsert() {
    //var csrftoken = getCookie('csrftoken');
    var adminName = $("#adminName").val();
    var adminPassWord = $("#adminPassWord").val();
    if(adminName.trim().length > 8){
        errorMsg(true, '名称过长!', '', 2000);
        return;
    }
    if(adminName.trim().length < 4){
        errorMsg(true, '名称过短!', '', 2000);
        return;
    }
    if(adminPassWord.trim().length > 12){
        errorMsg(true, '密码过长!', '', 2000);
        return;
    }
    if(adminPassWord.trim().length < 6){
        errorMsg(true, '密码过短!', '', 2000);
        return;
    }
    // var t=/[\+\*_]/;
    // if(adminName.trim().match(t)){
    //     errorMsg(true, '非法字符', '', 2000)
    //     return;
    // }
    var data = {"id":$("#id").val(), "adminName": adminName, "adminPassWord": $("#adminPassWord").val()};
    $.ajax({
        type: "POST",
        url: "http://192.168.102.98:8080/pro-word-web/admin/insert.do",
        data: data,
        dataType: 'json',
        success: function (res) {
            console.log(res);
            if (res.code == '200') {
                $('#myModal').modal('hide');
                $("#row_name").val('');
                //成功调用的提示
                successMsg(true, '新增成功！', '', 2000);
                getDataNew('1');
            }
            else {
                // $('#myModal').modal('hide');
                errorMsg(true, '新增失败！', res.message, 2000)
            }
        }
    })
}

function checkAdminName() {
	var data = {"adminName": row_name};
	$.ajax({
        type: "POST",
        url: "/admin/checkAdminName.do",
        data: data,
        dataType: 'json',
        success: function (res) {
            if (res.code == '200') {
                $('#myModal').modal('hide');
                $("#row_name").val('');
                //成功调用的提示
                successMsg(true, '新增成功！', '', 2000);
                getDataNew('1');
            }
            else {
                // $('#myModal').modal('hide');
                errorMsg(true, '新增失败！', res.message, 2000)
            }
        }
    })
}
