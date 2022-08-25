<%--
  Created by IntelliJ IDEA.
  User: macmie
  Date: 17.08.2022
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="<%= contextPath %>/assets/plugins/images/favicon.png">
    <title>403 - Forbidden</title>
    <!-- Bootstrap Core CSS -->
    <link href="<%= contextPath %>/assets/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- animation CSS -->
    <link href="<%= contextPath %>/assets/css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<%= contextPath %>/assets/css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="<%= contextPath %>/assets/css/colors/blue.css" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<!-- Preloader -->
<div class="preloader">
    <div class="cssload-speeding-wheel"></div>
</div>
<section id="wrapper" class="error-page">
    <div class="error-box">
        <div class="error-body text-center">
            <h1>403</h1>
            <h3 class="text-uppercase">Bạn không có quyền truy cập !</h3>
            <p class="text-muted m-t-30 m-b-30">YOU SEEM TO BE TRYING TO FIND HIS WAY HOME</p>
            <a href="<%= contextPath %>/home" class="btn btn-info btn-rounded waves-effect waves-light m-b-40">Về trang
                chủ</a></div>
        <footer class="footer text-center">2018 © Pixel Admin.</footer>
    </div>
</section>
<!-- jQuery -->
<script src='<%= contextPath %>/assets/plugins/bower_components/jquery/dist/jquery.min.js'></script>
<!-- Bootstrap Core JavaScript -->
<script src='<%= contextPath %>/assets/bootstrap/dist/js/bootstrap.min.js'></script>
<script type="text/javascript">
    $(function () {
        $(".preloader").fadeOut();
    });
</script>
</body>

</html>
