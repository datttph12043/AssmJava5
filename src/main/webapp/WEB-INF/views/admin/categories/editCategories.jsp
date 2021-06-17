<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="form" %>
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css"></link>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap-datepicker.min.css"></link>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light px-5">
	  <a class="navbar-brand" href="#">Navbar</a>
	
	  <div class="collapse navbar-collapse">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="#">Users</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#">Categories</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#">Products</a>
	      </li>
	    </ul>
	  </div>
	</nav>

	<div class="mt-5 col-10 offset-1">
		<form:form
			modelAttribute="categories"
			method="POST"
			action="${ pageContext.request.contextPath }/admin/categories/update/${categories.id }">
			<input type="hidden" name="_method" value="put"/>
			<div class="form-group mt-3">
				<label for="name">Tên Danh Mục</label>
				<form:input path="name" cssClass="form-control" />
			    <form:errors path="name" element="span" cssClass="text-danger" />
			</div>
			<div class="form-group mt-3">
				<button class="btn btn-primary">Submit</button>
				<button type="reset" class="btn btn-danger">Clear</button>
			</div>
		</form:form>
	</div>

	<script src="${ pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script src="${ pageContext.request.contextPath }/js/bootstrap-datepicker.min.js"></script>
	<script src="${ pageContext.request.contextPath }/js/admin/users/edit.js"></script>
</body>
</html>