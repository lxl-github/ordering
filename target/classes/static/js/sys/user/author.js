var roleIds;
$(function () {
    // getMenuTreeData();
    validateRule();
});
$.validator.setDefaults({
    submitHandler: function () {
        // getAllSelectNodes();
        save();
    }
});

// function getAllSelectNodes() {
//     var ref = $('#roleTree').jstree(true);// 获得整个树
//     menuIds = ref.get_selected(); // 获得所有选中节点的，返回值为数组
// }
// function getMenuTreeData() {
//     $.ajax({
//         type : "GET",
//         url : "/role/roleTree/",
//         success : function(roleTree) {
//             loadMenuTree(roleTree);
//         }
//     });
// }
// function loadMenuTree(menuTree) {
//     $('#roleTree').jstree({
//         'core' : {
//             'strings' :'加载中...',
//             'data' : menuTree
//         },
//         "checkbox" : {
//             "three_state" : true
//         },
//         "plugins" : [ "wholerow", "checkbox" ]
//     });
//     $('#roleTree').jstree("open_all");
// }

function getCheckedRoles() {
    var adIds = "";
    $("input:checkbox[name=role]:checked").each(function (i) {
        if (0 == i) {
            adIds = $(this).val();
        } else {
            adIds += ("," + $(this).val());
        }
    });
    return adIds;
}

function save() {

    roleIds = getCheckedRoles();

    if (roleIds == "") {
        parent.layer.msg("请选择要授权的角色");
        return;
    }

    $('#roleIds').val(roleIds);
    var role = $('#signupForm').serialize();
    $.ajax({
        cache: true,
        type: "POST",
        url: "/user/authorization",
        data: role,// 你的formid
        async: false,
        error: function (request) {
            alert("Connection error");
        },
        success: function (data) {
            if (data.code == 0) {
                parent.layer.msg("操作成功");
                parent.reLoad();
                var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                parent.layer.close(index);

            } else {
                parent.layer.msg(data.msg);
            }
        }
    });
}

function validateRule() {
    var icon = '<i class="fa fa-times-circle"></i>';
    $("#signupForm").validate({
        rules: {
            roleIds: {
                required: true
            }
        },
        messages: {
            roleIds: {
                required: icon + "请选择授权的角色"
            }
        }
    });
}