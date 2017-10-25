<%@page import="entity.Emp"%>
<%@page import="java.util.List"%>
<%@page import="dao.EmpDAO"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!--  继承-->
<%@page pageEncoding="utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--指令文件，设置页面编码格式-->
<!DOCTYPE>
<html>
	<head>
	<base href="<%=basePath%>">
	</head>
	<body>
		<table border="1px solid black" >
			<thead>
				<tr>
				<th>姓名</th>
				<th>薪水</th>
				<th>年龄</th>
				<th>删除</th>
				<th>修改</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${emps}"  var="emp" varStatus="vs">
					<tr>
					<td>${emp.name} </td>
					<td>${emp.salary }</td>
					<td>${emp.age}</td>
					<td><a href="del.do?id=${emp.id} "  onclick="return confirm('确认删除该条记录吗？')">删除</a></td>
					<td><a href="find.do?id=${emp.id} ">修改</a></td>
					</tr>
				</c:forEach>
				</tbody>
					<style type="text/css">
						a{
							text-decoration: none;
							font-size: 12px;
							background-color: orange;
						}
						a:hover{
						text-decoration: underline;
						font-size: 14px;
						}
					</style>
		</table>
	</body>
</html>