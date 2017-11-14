var menuIds;

$.validator.setDefaults({
    submitHandler : function() {
        getAllSelectNodes();
        save();
    }
});

function getAllSelectNodes() {
    var ref = $('#menuTree').jstree(true);// 获得整个树
    menuIds = ref.get_selected(); // 获得所有选中节点的，返回值为数组
}
function getMenuTreeData(appId,roleId) {
    $.ajax({
        type : "GET",
        url : "/menu/tree/" + appId + "/" + roleId,
        success : function(menuTree) {
            loadMenuTree(menuTree);
        }
    });
}
function loadMenuTree(menuTree) {
    $('#menuTree').jstree({
        'core' : {
            'data' : menuTree
        },
        "checkbox" : {
            "three_state" : true
        },
        "plugins" : [ "wholerow", "checkbox" ]
    });
    $('#menuTree').jstree("open_all");
}

function save() {
    if (menuIds == "") {
        parent.layer.msg("请选择菜单权限");
        return;
    }
    if (menuIds == "-1") {
        parent.layer.msg("没有可选的菜单权限");
        return;
    }

    $('#menuIds').val(menuIds);
    var role = $('#signupForm').serialize();
    $.ajax({
        cache : true,
        type : "POST",
        url : "/role/setPermis",
        data : role,// 你的formid
        async : false,
        error : function(request) {
            alert("Connection error");
        },
        success : function(data) {
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
        rules : {
            menuIds : {
                required : true
            }
        },
        messages : {
            menuIds : {
                required : icon + "请选择菜单权限"
            }
        }
    });
}