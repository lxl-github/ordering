var prefix = "/app"
$(function() {
	validateRule();
});
$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : prefix + "/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			laryer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("保存成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				layer.alert(data.msg)
			}

		}
	});

}
// function validate() {
// 	var icon = "<i class='fa fa-times-circle'></i> ";
// 	$("#signupForm").validate({
// 		rules : {
// 			name : {
// 				required : true
// 			},
// 			title : {
// 				required : true
// 			},
// 			appKey : {
// 				required : true
// 			},
// 			basePath : {
// 				required : true
// 			},
// 			orders : {
// 				required : true
// 			},
// 			status : {
// 				required : true
// 			}
// 		},
// 		messages : {
// 			name : {
// 				required : icon + "请输入应用系统名称"
// 			},
// 			title : {
// 				required : icon + "请输入应用系统标题"
// 			},
// 			appKey : {
// 				required : icon + "请输入应用系统唯一码"
// 			},
// 			basePath : {
// 				required : icon + "请输入应用系统地址"
// 			},
// 			orders : {
// 				required : icon + "请输入排序值(必须正整数)"
// 			},
// 			status : {
// 				required : icon + "请选择状态"
// 			}
// 		}
// 	})
// }
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			},
			title : {
				required : true
			},
			appKey : {
				required : true
			},
			basePath : {
				required : true
			},
			orders : {
				required : true
			},
			status : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入应用系统名称"
			},
			title : {
				required : icon + "请输入应用系统标题"
			},
			appKey : {
				required : icon + "请输入应用系统唯一码"
			},
			basePath : {
				required : icon + "请输入应用系统地址"
			},
			orders : {
				required : icon + "请输入排序值(必须正整数)"
			},
			status : {
				required : icon + "请选择状态"
			}
		}
	})
}