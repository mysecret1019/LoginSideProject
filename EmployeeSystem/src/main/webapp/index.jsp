<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入介面</title>
<meta name="viewport" content="width=devich-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap5/css/bootstrap.css">

</head>
<body>
<script src="${pageContext.request.contextPath}/bootstrap5/js/bootstrap.js"></script>
<%
	String error="";
	String CreatAccountResult="";
	Object obj=request.getAttribute("error");
	Object obj2=request.getAttribute("CreatAccountResult");
	
	if(obj!=null){
		error="Account Or Password Error";
	}
	if(obj2!=null&&obj2=="success"){
		CreatAccountResult="Congratulations! You Create a New Account Successful!!!";
	}else if(obj2==""){
		CreatAccountResult=" Fail!!!";
	}
%>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h2 class="mb-4">Employee System</h2>
            
            <!-- Form 开始 -->
            <form method="post" action="/EmployeeSystem/Servlet1">
                <!-- 帳號 -->
                <div class="mb-3">
                    <label for="userName" class="form-label">帳號</label>
                    <input type="text" class="form-control" id="userName" name="userName" value="Grace" required>
                </div>
                
                <!-- 密碼 -->
                <div class="mb-3">
                    <label for="password" class="form-label">密碼</label>
                    <input type="password" class="form-control" id="password" name="password" value="0001" required>
                </div>

                <!-- 提交按钮 -->
                <div class="mb-3">
                    <button type="submit" class="btn btn-primary w-100">Submit</button>
                </div>
            </form>
            <!-- Form 结束 -->

            <!-- 申辦帳號 -->
            <div class="mt-4">
                <form method="post" action="/EmployeeSystem/addNewAccount.jsp">
                    <button type="submit" class="btn btn-secondary w-100">申辦帳號</button>
                </form>
            </div>

            <!-- Error 和 CreatAccountResult -->
            <div class="mt-4">
                <p><%= error %></p>
                <p><%= CreatAccountResult %></p>
            </div>
        </div>
    </div>
</div>
</html>