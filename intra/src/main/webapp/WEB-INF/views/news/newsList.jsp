<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<title>후기 게시판</title>
</head>
   <body>
   <div class="container w-75 mt-5 mx-auto">
    <h2>후기 목록</h2>
    <hr>
   	<form method="post" action="/news/search">
    	<div class="input-group mb-3">
	  		<select class="form-select" id="inputGroupSelect02" name="key">
	  			<option value="title">제목</option>
	  			<option value="reporter">기자</option>
	  		</select>
	  		<input type="text" class="form-control" placeholder="검색어 입력" aria-label="value" aria-describedby="basic-addon1" name="value">
	  		<button class="btn btn-outline-secondary" type="submit">검색</button>
		</div>
  	</form>
    <ul class="list-group">
		<c:forEach var="news" items="${newslist}" varStatus="status">
		  <li class="list-group-item list-group-item-action d-flex justify-content-between align-items-center"><a href="/news/${news.aid}" class="text-decoration-none">[${news.aid}] ${news.title} | ${news.date}</a>
		  <a href="/news/delete/${news.aid }"><span class="badge bg-secondary">&times;</span></a>
		  </li>
		</c:forEach> 
	</ul>
	<hr>
	<c:if test="${error != null }">
		<div class="alert alert-danger alert-dismissible fade show mt-3">
				에러 발생: ${error}
			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
		</div>
	</c:if>
	<button class="btn btn-outline-info mb-3" type="button" data-bs-toggle="collapse" data-bs-target="#addForm" aria-expanded="false" aria-controls="addForm">리뷰 등록</button>
	<div class="collapse" id="addForm">
	  <div class="card card-body">
		<form method="post" action="/news/add" enctype="multipart/form-data">
			<label class="form-label">제목</label>
			<input type="text" name="title" class="form-control">
			<label class="form-label">이미지</label>
			<input type="file" name="file" class="form-control">
			<label class="form-label">후기내용</label>
			<textarea cols="50" rows="5" name="content" class="form-control"></textarea>
			<label class="form-label">기자</label>
			<input type="text" name="reporter" class="form-control">
			<button type="submit" class="btn btn-success mt-3">저장</button>
		</form>
	  </div>
	</div>
	</div>
</body>
</html>