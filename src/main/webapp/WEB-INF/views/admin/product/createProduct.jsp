<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css"></link>
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
		<form
			method="POST"
			action="${ pageContext.request.contextPath }/admin/product/store">

			<div class="form-group">
				<label for="name">Tên SP</label>
			    <input type="text" class="form-control" id="name" name="name" autocomplete="off">
			    <small id="name_error" class="form-text text-danger"></small>
			</div>
			<div class="form-group">
				<label for="price">Price</label>
			    <input type="price" class="form-control" id="price" name="price" autocomplete="off">
			    <small id="price_error" class="form-text text-danger"></small>
			</div>
			<div class="form-group">
				<label for="available">Số Lượng</label>
			    <input type="available" class="form-control" id="available" name="available" autocomplete="off">
			    <small id="available_error" class="form-text text-danger"></small>
			</div>
			<div class="form-group">
				<label for="image">Image</label>
			    <input type="file" class="form-control" id="image" name="image" autocomplete="off">
			    <small id="image_error" class="form-text text-danger"></small>
			</div>
			<div class="form-group">
				<label for="categorie">Loại SP</label>
				<select name="categorie" id="categorie" class="form-control" required>
					<option selected disabled>Choose</option>
					<option value="3">Ti Vi</option>
					<option value="2">Máy Tính</option>
					<option value="8">Xe máy</option>
				</select>
			    <small id="categorie_error" class="form-text text-danger"></small>
			</div>

			<div class="form-group">
				<button class="btn btn-primary">Submit</button>
				<button type="reset" class="btn btn-danger">Clear</button>
			</div>
		</form>
	</div>
</body>
</html>