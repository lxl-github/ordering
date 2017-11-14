$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/user/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			userNumber : {
				required : true,
				remote : {
					url : "/user/exists", // 后台处理程序
					type : "post", // 数据发送方式
					dataType : "json", // 接受数据格式
					data : { // 要传递的数据
						userNumber : function() {
							return $("#userNumber").val();
						}
					}
				}
			},
			userName : {
				required : true
			},
			status : {
				required : true
			}
		},
		messages : {

			userNumber : {
				required : icon + "请输入工号",
				remote : icon + "工号已经存在"
			},
			userName : {
				required : icon + "请输入姓名"
			},
			status : {
				required : icon + "请输入选择状态"
			}
		}
	})
}