var prefix = "/menu"
$(document).ready(function() {
	load();
});
var load = function() {
	$('#exampleTable')
			.bootstrapTreeTable(
					{
						id : 'id',
						parentColumn : 'parentId',
						type : "GET", // 请求数据的ajax类型
						url : prefix + '/list', // 请求数据的ajax的url
						ajaxParams : {}, // 请求数据的ajax的data属性
						expandColumn : '1',// 在哪一列上面显示展开按钮
						striped : true, // 是否各行渐变色
						bordered : true, // 是否显示边框
						expandAll : false, // 是否全部展开
						// toolbar : '#exampleToolbar',
						columns : [
								{
									title : '编号',
									field : 'id',
									visible : false,
									align : 'center',
									valign : 'middle',
									width : '50px'
								},
								{
									title : '名称',
									field : 'name'
								},
								{
									title : '所属应用系统',
									field : 'appTitle'
								},
								{
									title : '类型',
									field : 'type',
									align : 'center',
									valign : 'middle',
									formatter : function(item, index) {
										if (item.type === 1) {
											return '<span class="label label-primary">目录</span>';
										}
										if (item.type === 2) {
											return '<span class="label label-success">菜单</span>';
										}
										if (item.type === 3) {
											return '<span class="label label-warning">按钮</span>';
										}
									}
								},
								{
									title : '地址',
									field : 'url'
								},
								{
									title : '权限标识',
									field : 'permissionValue'
								},
								{
									title : '排序',
									field : 'orders'
								},
								{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(item, index) {
										var e = '<a class="btn btn-primary btn-sm '
												+ s_edit_h
												+ '" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ item.id
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var p = '<a class="btn btn-primary btn-sm '
												+ s_add_h
												+ '" href="#" mce_href="#" title="添加下级" onclick="add(\''
												+ item.id
												+ '\')"><i class="fa fa-plus"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '
												+ s_remove_h
												+ '" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ item.id
												+ '\')"><i class="fa fa-remove"></i></a> ';
										return e + d + p;
									}
								} ]
					});
}
function reLoad() {
	load();
}
function add(pId) {
	//校验是否为按钮级别，如果为按钮级别不可以添加下一级
	$.ajax({
		url : prefix + "/isButtonLevel/" + pId,
		type : "get",
		async: true,
		success : function(data) {
			if (data) {
				layer.msg("按钮级别无法添加下一级");
			} else {
				layer.open({
					type : 2,
					title : '增加菜单',
					maxmin : true,
					shadeClose : false, // 点击遮罩关闭层
					area : [ '800px', '520px' ],
					content : prefix + '/add/' + pId // iframe的url
				});
			}
		}
	});
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix + "/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(data) {
				if (data.code == 0) {
					layer.msg("删除成功");
					reLoad();
				} else {
					layer.msg(data.msg);
				}
			}
		});
	})
}
function edit(id) {
	layer.open({
		type : 2,
		title : '菜单修改',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}
function batchRemove() {
	// var rows = $('#exampleTable').bootstrapTable('getSelections');

}