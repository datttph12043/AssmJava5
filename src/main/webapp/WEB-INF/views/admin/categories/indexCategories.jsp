<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css"></link>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="#">IT15306-UD</a>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="/admin/user/">User</a>
	      </li>
	      <li class="nav-item active">
	        <a class="nav-link" href="/admin/product/">Product</a>
	      </li>
	    </ul>
	  </div>
	</nav>
	
	<div class="col-10 offset-1 mt-5">
		<div class="col-10 offset-1 mt-3">
			<a
				class="btn btn-success"
				href="${ pageContext.request.contextPath }/admin/categories/create">Create</a>
		</div>
		
		<div class="col-10 offset-1 mt-5">
			<table class="table table-strip table-dark">
				<thead>
					<tr>
						<td>Id</td>
						<td>Tên Danh Mục</td>
						<td colspan="2">Thao tác</td>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${ listCategories }" var="categories">
					<tr>
						<td>${ categories.id }</td>
						<td>${ categories.name }</td>
						<td>
							<a
								class="btn btn-primary"
								href="${ pageContext.request.contextPath }/admin/categories/edit/${ categories.id }">Update</a>
						</td>
						<td>
							<form action="${ pageContext.request.contextPath }/admin/categories/delete/${ categories.id }" method="GET">
								<button class="btn btn-danger">Delete</button>
							</form>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>