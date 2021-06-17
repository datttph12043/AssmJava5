<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<title>Insert title here</title>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/bootstrap.min.css"></link>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">IT15306-UD</a>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">User</a>
				</li>
				<li class="nav-item active"><a class="nav-link" href="#">Post</a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="col-10 offset-1 mt-5">
		<div class="col-10 offset-1 mt-3">
		<div class="col-10 offset-1 mt-5">
			<table class="table table-strip table-dark">
				<thead>
					<tr>
						<td>Id</td>
						<td>Tên SP</td>
						<td>Giá</td>
						<td>Số lượng</td>
						<td>Ảnh</td>
						<td>Loại SP</td>
						<td>Thao tác</td>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${ listProduct }" var="product">
						<tr>
							<td>${product.id }</td>
							<td>${product.name }</td>
							<td>${product.price }</td>
							<td>${product.available }</td>
							<td>${product.image }</td>
							<td>${product.categorie.name }</td>

							<td><a class="btn btn-primary"
								href="${ pageContext.request.contextPath }/home/addToCard/${ product.id }">Add to Card</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>