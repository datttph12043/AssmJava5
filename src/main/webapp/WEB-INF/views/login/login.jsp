<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css"></link>
</head>
<body>

	<div class="col-10 offset-1 mt-5">
		<c:if test="${ not empty sessionScope.errorMessage }">
			<div class="alert alert-danger col-10 offset-1">
				${ sessionScope.errorMessage }
			</div>
			
			<c:remove var="errorMessage" scope="session" />
		</c:if>
		
		<form method="POST" class="col-10 offset-1 mt-5"
			action="${ pageContext.request.contextPath }/login">
			<div class="mt-4">
				<label>Email</label>
				<input type="email" name="email" id="email" class="form-control" />
			</div>
			<div class="mt-4">
				<label>Password</label>
				<input type="password" name="password" id="password" class="form-control" />
			</div>
			<div class="mt-4">
				<button class="btn btn-primary">Login</button>
			</div>
		</form>
	</div>
</body>
</html>