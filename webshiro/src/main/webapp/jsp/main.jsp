<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理系统-主页面</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">   
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>   
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/rotate.js"></script>
<script type="text/javascript">
$(function(){
	$("#main_photo").mouseover(function(){
		rotation();
	}).mouseout(function(){
		$("#main_photo").stopRotate();
		$("#main_photo").rotate({angle:0});
	});
	
	var rotation = function (){
	  $("#main_photo").rotate({
	    angle:0,
	    animateTo:360,
	    callback: rotation
	  });
	}
	//菜单
	$('#main_tree').tree({    
	    url:'showMenu',
	    onClick:function(node){
	    	//如果已经有这个名称不添加,选中
	    	if($("#main_tabs").tabs("getTab",node.text)==null){
		    	$("#main_tabs").tabs('add',{
		    		title: node.text,
		    		selected: true,
		    		closable:true,
		    		href:node.attributes.filename
		    	});
		    	//href引用的页面,相当于把引用页面<body>内容粘贴到当前页面
	    	}else{
	    		//选中
	    		$("#main_tabs").tabs("select",node.text)
	    	}
	    }
	});
	
})
</script>
</head>
<body class="easyui-layout">   
    <div data-options="region:'north',title:'网站',split:false,collapsible:false" style="height:100px;">
    	<div>
    		<img style="border-radius:25px;" src="${user.photo }" id="main_photo" width="50" height="50"/> 
    		<span style="font-size:25px;font-weight:bold;">后台管理系统 </span>
    		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">退出登录</a>  
    	</div>
    </div>   
    <div data-options="region:'west',title:'菜单',collapsible:false" style="width:200px;">
    	<ul id="main_tree"></ul> 
    </div>   
    <div data-options="region:'center',title:'内容',collapsible:false" style="padding:5px;background:#eee;">
    	<div id="main_tabs" class="easyui-tabs" style="width:500px;height:250px;" data-options="fit:true">   
		    <div title="首页" style="padding:20px;">   
		        欢迎使用后台管理系统  
		    </div>   
		</div>
    </div>   
    <div data-options="region:'south',title:'底部信息',collapsible:false" style="height:100px;">
    	<div style="text-align:center;color:gray;height:70px;line-height:70px;">
    		Copyright &copy; xxxxx-202 2018-
    	</div>
    </div>   
</body> 
</html>