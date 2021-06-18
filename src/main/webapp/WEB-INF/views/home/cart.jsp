<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<title>Cart information</title>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/bootstrap.min.css"></link>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">IT15306-UD</a>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="${ pageContext.request.contextPath }/home/">Home</a>
				</li>
				<li class="nav-item active"><a class="nav-link" href="${ pageContext.request.contextPath }/home/showCart">Cart</a>
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
						<td>Số lượng còn trong kho</td>
						<td>Số lượng yêu cầu</td>
						<td>Ảnh</td>
						<td>Loại SP</td>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${ listProduct }" var="product">
						<tr>
							<td>${product.id }</td>
							<td>${product.name }</td>
							<td>${product.price }</td>
							<td>${product.available }</td>
							<td>${product.quantity }</td>
							<td>${product.image }</td>
							<td>${product.categorie.name }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>