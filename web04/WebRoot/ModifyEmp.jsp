<%@page import="entity.Emp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>


<html>
  <head>
    <title>员工修改界面</title>
  </head>
  <body>
	<form action="modify.do"  method="post">
		<!-- 表单隐藏域:不在浏览器页面显示，但有此标签
		hidden-->
		<input id="id" type="hidden" name="id" value="${emp.id}">
    	<label for="name">姓名：</label><input type="text"  id="name" name="name" value="${emp.name}"> <br>
    	<label for="salary">薪资：</label><input type="text"  id="salary" name="salary"value="${emp.salary} "> <br>
    	<label for="age">年龄：</label><input type="text"  id="age" name="age" value="${emp.age} "> <br>
    	<input type="submit" value="提交" onclick="return confirm('确认修改该记录')">
    </form>
  </body>
  </body>
</html>
