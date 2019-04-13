<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<script type="text/javascript">
$(function(){
	$('#lygl_datagrid').datagrid({    
	    url:'showComment',    
	    columns:[[    
	        {field:'id',title:'ID',width:100},    
	        {field:'name',title:'姓名',width:100},    
	        {field:'phone',title:'电话',width:100},
	        {field:'email',title:'邮箱',width:100},
	        {field:'other',title:'其他',width:100},
	        {field:'content',title:'内容',width:100},
	        {field:'createtime',title:'时间',width:100}
	    ]],
	    pagination:true,
	    fitColumns:true,
	    pageList:[1,2,3,4],
	    pageSize:2
	}); 
})
</script>
<table id="lygl_datagrid"></table>  
</body>
</html>