<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Show</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=devich-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap5/css/bootstrap.css">
</head>
<body>
<script src="${pageContext.request.contextPath}/bootstrap5/js/bootstrap.js"></script>
<%	
	String userName="";
	String password="";
	com.lccnet.model.User user=null;
	Object obj=session.getAttribute("user");
	if(obj instanceof com.lccnet.model.User){
		user=(com.lccnet.model.User)obj;
		userName=user.getUserName();
		password=user.getPassword();
	}
%>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h2 class="mb-4 justify-content-center">Welcome</h2>
            
            <!-- Welcome 信息 -->
            <div class="mb-3">
                <p>UserName: <%= userName %></p>
                <p>Password: <%= password %></p>
            </div>

            <!-- Logout 表单 -->
            <form action="/EmployeeSystem/Logout.do" method="post" class="mb-3">
                <button type="submit" class="btn btn-danger w-100">Logout</button>
            </form>

            <!-- Change Password 表单 -->
            <form method="post" action="/EmployeeSystem/changePassword.jsp">
                <button type="submit" class="btn btn-secondary w-100">更改密碼</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>