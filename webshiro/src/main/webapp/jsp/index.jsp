<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">   
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>   
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
$(function(){
	//提交按钮
	$("#login_submit").click(function(){
		$('#login_form').form('submit', {    
		    url:'login',    
		    onSubmit: function(){    
		        // do some check    
		        // return false to prevent submit;  
		        //验证所有内容是否有效
		        var result = $(this).form("validate");
		        if(!result){
		        	$.messager.alert('系统消息','请填写完整信息'); 
		        	return false;
		        }
		    },    
		    success:function(data){   
		    	var dataJson = eval("("+data+")");
		        if(dataJson.status==200){
		        	location.href="main";
		        }else{
		        	$.messager.alert('系统消息',dataJson.msg); 
		        }
		    }    
		});
	});
	
	//看不清
	$("#login_change").click(function(){
		//浏览器具有缓存功能,不允许重复多次异步请求相同地址
		$("#login_validate_code").attr("src","validCode?date="+new Date());
		return false;
	})
})
</script>
</head>
<body>
	<div style="width:500px;height:350px;margin:100px auto;">
		<!-- 可能出现id重复的问题. 命名时:文件名_功能 -->
		<div id="login_login" class="easyui-panel"     
				style="width:500px;height:350px;padding:10px;background:#fafafa;" 
		        data-options="iconCls:'icon-cancel',closable:false,title:'登录'">   
		    <div style="text-align:center; font-size:30px; font-weight:bold;padding:10px;">后台管理中心</div> 
			<form id="login_form" method="post" style="width:480px; height:220px;text-align:center ">
				<input style="width:400px;margin:10px;height:40px;font-size:26px;" class="easyui-validatebox" type="text" name="username" data-options="required:true,missingMessage:'用户名不能为空'" />  <br/>
				<input style="width:400px;margin:10px;height:40px;font-size:26px;" class="easyui-validatebox" type="password" name="password" data-options="required:true,missingMessage:'密码不能为空'" />  <br/>
				<input style="width:200px;margin:10px;height:40px;font-size:26px;" class="easyui-validatebox" type="text" name="validCode" data-options="required:true,missingMessage:'请输入验证码'"/><img src="validCode" width="180" height="40" id="login_validate_code"/><a href="" id="login_change">看不清</a><br/>
				<input type="checkbox" name="rememberMe" value="true"/>2天免登录<br/>
				<a style="width:380px;height:20px;padding:10px;" id="login_submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">登录</a>  
			</form>
		</div> 
	</div> 
</body>
</html>