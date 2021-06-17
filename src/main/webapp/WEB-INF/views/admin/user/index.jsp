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
	        <a class="nav-link" href="/admin/product/">Product</a>
	      </li>
	      <li class="nav-item active">
	        <a class="nav-link" href="/admin/categories/">Categories</a>
	      </li>
	    </ul>
	  </div>
	</nav>
	
	<div class="col-10 offset-1 mt-5">
		<div class="col-10 offset-1 mt-3">
			<a
				class="btn btn-success"
				href="${ pageContext.request.contextPath }/admin/user/create">Create</a>
		</div>
		
		<div class="col-10 offset-1 mt-5">
			<table class="table table-strip table-dark">
				<thead>
					<tr>
						<td>Id</td>
						<td>Họ tên</td>
						<td>Email</td>
						<td>Avatar</td>
						<td>Trạng thái</td>
						<td>Phân quyền</td>
						<td colspan="2">Thao tác</td>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${ listUser }" var="user">
					<tr>
						<td>${ user.id }</td>
						<td>${ user.username }</td>
						<td>${ user.email }</td>
						<td>${ user.photo }</td>
						<td>${ user.activated == 1 ? "Đang hoạt động" : "Vô hiệu hóa" }</td>
						<td>${ user.admin == 1 ? "Admin" : "Member" }</td>
						<td>
							<a
								class="btn btn-primary"
								href="${ pageContext.request.contextPath }/admin/user/edit/${ user.id }">Update</a>
						</td>
						<td>
							<form action="${ pageContext.request.contextPath }/admin/user/delete/${ user.id }" method="POST">
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