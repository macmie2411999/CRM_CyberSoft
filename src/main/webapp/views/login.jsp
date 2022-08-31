<%--
  Created by IntelliJ IDEA.
  User: macmie
  Date: 17.08.2022
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%	String contextPath = request.getContextPath(); %>
<%@ page import="com.macmie.crm_cybersoft.Constants.Constants" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="row mt-5">
        <div class="col-md-5 m-auto mt-5">
            <h3 class="text-center">ĐĂNG NHẬP HỆ THỐNG</h3>
            <div class="p-4 border mt-4">
                <form method="POST" action="">
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" name="<%= Constants.LOGIN_JSP_EMAIL %>">
                    </div>
                    <div class="form-group">
                        <label>Mật khẩu</label>
                        <input type="password" class="form-control" name="<%= Constants.LOGIN_JSP_PASSWORD %>">
                    </div>

                    <%--                    mm adjust start--%>
                    <div class="pass-link">
                        <%
                            String message = "";
                            if(request.getAttribute(Constants.MESSAGE_LOGIN) != null){
                                message = (String) request.getAttribute(Constants.MESSAGE_LOGIN);
                            }
                        %>
                        <a style="color: red"><%= message%></a>
                        <br/>
                    </div>
                    <%--                    mm adjust end--%>

                    <button type="submit" class="btn btn-primary">Đăng nhập</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>

