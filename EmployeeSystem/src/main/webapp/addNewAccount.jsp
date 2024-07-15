<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>新建帳號</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap5/css/bootstrap.css">


</head>
<body>
<!-- Bootstrap JavaScript -->
<script src="${pageContext.request.contextPath}/bootstrap5/js/bootstrap.bundle.min.js"></script>

<div class="container mt-5">
    <div class="row justify-content-center">
	    <div class="col-md-6">
	        <h2 class="mb-6 text-center">New Account</h2>
	        
	        <!-- Form 开始 -->
	        <form method="post" action="${pageContext.request.contextPath}/EmployeeSystem/NewAccount">
	            <!-- 輸入帳號 -->
	            <div class="mb-3">
	                <label for="userName" class="form-label">輸入帳號</label>
	                <input type="text" class="form-control" id="userName" name="userName" value="Grace" required>
	            </div>
	            
	            <!-- 輸入密碼 -->
	            <div class="mb-3">
	                <label for="password" class="form-label">輸入密碼</label>
	                <input type="password" class="form-control" id="password" name="password" value="0001" required>
	            </div>
	
	            <!-- 提交按钮 -->
	            <div class="mb-3">
	                <button type="submit" class="btn btn-primary w-100">Submit</button>
	            </div>
	        </form>
	        <!-- Form 结束 -->
	    </div>
	</div>
</div>

</body>
</html>