<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:shiro="http://shiro.apache.org/tags">
<!-- xmlns:shiro="http://shiro.apache.org/tags" 不起作用-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="../../js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../../js/easyui/themes/icon.css">
<script type="text/javascript" src="../../js/jquery-1.7.2.js"></script>
<script type="text/javascript"
	src="../../js/easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<script type="text/javascript">
		$(function() {
			$('#lygl_datagrid').datagrid({
				url : 'showComment',
				columns : [ [ {
					field : 'id',
					title : 'ID',
					width : 100
				}, {
					field : 'name',
					title : '姓名',
					width : 100
				}, {
					field : 'phone',
					title : '电话',
					width : 100
				}, {
					field : 'email',
					title : '邮箱',
					width : 100
				}, {
					field : 'other',
					title : '其他',
					width : 100
				}, {
					field : 'content',
					title : '内容',
					width : 100
				}, {
					field : 'createtime',
					title : '时间',
					width : 100
				} ] ],
				pagination : true,
				fitColumns : true,
				pageList : [ 1, 2, 3, 4 ],
				pageSize : 2
			});

			$("#search_btn").click(function() {
				$('#operation_form').form('submit', {
					url : 'search',
					success : function(data) {
						var dataJson = eval("(" + data + ")");
						if (dataJson.status == 200) {
							location.href = "main";
						} else {
							$.messager.alert('系统消息', dataJson.msg);
						}
					}
				});
			});
			
			$("#del_btn").click(function() {
				$('#operation_form').form('submit', {
					url : 'del',
					success : function(data) {
						var dataJson = eval("(" + data + ")");
						if (dataJson.status == 200) {
							location.href = "main";
						} else {
							$.messager.alert('系统消息', dataJson.msg);
						}
					}
				});
			});
		})
	</script>
	<table id="lygl_datagrid"></table>
	<div
		style="padding: 5px; background: #fafafa; border: 1px solid #ccc; text-align: center">

		<form id="operation_form" method="post"
			style="text-align: center">
			<a id="search_btn" href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-search'">浏览</a>
			<shiro:hasPermission name="ADD">
				<a id="create_btn" href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-add'">新建</a>
			</shiro:hasPermission>
			<shiro:hasPermission name="UPD">
				<a id="upd_btn" href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-edit'">更新</a>
			</shiro:hasPermission>
			<shiro:hasPermission name="DEL">
				<a id="del_btn" href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-remove'">删除</a>
			</shiro:hasPermission>

		</form>
	</div>
</body>
</html>