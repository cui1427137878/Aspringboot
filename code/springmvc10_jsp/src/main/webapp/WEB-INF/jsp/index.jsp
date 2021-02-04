<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 相当于import 5.11.6-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=2>
	<!-- 遍历itemList 取出来的数据叫item-->
	<c:forEach items="${itemList}" var="item">
		<tr>
			<td>${item.itemName}</td>
			<td>${item.itemPrice}</td>
		</tr>
	</c:forEach>	
	</table>
</body>
</html>