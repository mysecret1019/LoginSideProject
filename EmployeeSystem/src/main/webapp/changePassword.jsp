<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>密碼修改</title>
<meta name="viewport" content="width=devich-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap5/css/bootstrap.css">


</head>
<body>
<script src="${pageContext.request.contextPath}/bootstrap5/js/bootstrap.js"></script>
<div class="container mt-5 ">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h2 class="mb-4 text-center">Change Password</h2>
            
            <!-- Form 开始 -->
            <form method="post" action="/EmployeeSystem/ChangePassword">
                <!-- 新密碼 -->
                <div class="mb-3">
                    <label for="newPassword" class="form-label">新密碼</label>
                    <input type="password" class="form-control" id="newPassword" name="newPassword" required>
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