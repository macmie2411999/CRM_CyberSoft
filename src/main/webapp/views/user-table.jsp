<%--
  Created by IntelliJ IDEA.
  User: macmie
  Date: 17.08.2022
  Time: 18:22
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
    <title>Pixel Admin</title>
    <!-- Bootstrap Core CSS -->
    <link href="<%= contextPath %>/assets/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="<%= contextPath %>/assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css"
          rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    <!-- animation CSS -->
    <link href="<%= contextPath %>/assets/css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<%= contextPath %>/assets/css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="<%= contextPath %>/assets/css/colors/blue-dark.css" id="theme" rel="stylesheet">
    <link rel="stylesheet" href="<%= contextPath %>/assets/css/custom.css">
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
<div id="wrapper">

    <%-- Embed Navigation and Nav-bar--%>
    <jsp:include page="NAVLayout.jsp"></jsp:include>

    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <h4 class="page-title">Danh sách thành viên</h4>
                </div>
                <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                    <a href="<%= contextPath %>/user/add" class="btn btn-sm btn-success">Thêm mới</a>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /row -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="white-box">
                        <div class="table-responsive">
                            <table class="table" id="example">
                                <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Username</th>
                                    <th>Role</th>
                                    <th>#</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Deshmukh</td>
                                    <td>Prohaska</td>
                                    <td>@Genelia</td>
                                    <td>admin</td>
                                    <td>
                                        <a href="#" class="btn btn-sm btn-primary">Sửa</a>
                                        <a href="#" class="btn btn-sm btn-danger">Xóa</a>
                                        <a href="<%= contextPath %>/user/details" class="btn btn-sm btn-info">Xem</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Deshmukh</td>
                                    <td>Gaylord</td>
                                    <td>@Ritesh</td>
                                    <td>member</td>
                                    <td>
                                        <a href="#" class="btn btn-sm btn-primary">Sửa</a>
                                        <a href="#" class="btn btn-sm btn-danger">Xóa</a>
                                        <a href="<%= contextPath %>/user/details" class="btn btn-sm btn-info">Xem</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Sanghani</td>
                                    <td>Gusikowski</td>
                                    <td>@Govinda</td>
                                    <td>developer</td>
                                    <td>
                                        <a href="#" class="btn btn-sm btn-primary">Sửa</a>
                                        <a href="#" class="btn btn-sm btn-danger">Xóa</a>
                                        <a href="<%= contextPath %>/user/details" class="btn btn-sm btn-info">Xem</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>4</td>
                                    <td>Roshan</td>
                                    <td>Rogahn</td>
                                    <td>@Hritik</td>
                                    <td>supporter</td>
                                    <td>
                                        <a href="#" class="btn btn-sm btn-primary">Sửa</a>
                                        <a href="#" class="btn btn-sm btn-danger">Xóa</a>
                                        <a href="<%= contextPath %>/user/details" class="btn btn-sm btn-info">Xem</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>5</td>
                                    <td>Joshi</td>
                                    <td>Hickle</td>
                                    <td>@Maruti</td>
                                    <td>member</td>
                                    <td>
                                        <a href="#" class="btn btn-sm btn-primary">Sửa</a>
                                        <a href="#" class="btn btn-sm btn-danger">Xóa</a>
                                        <a href="<%= contextPath %>/user/details" class="btn btn-sm btn-info">Xem</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>6</td>
                                    <td>Nigam</td>
                                    <td>Eichmann</td>
                                    <td>@Sonu</td>
                                    <td>supporter</td>
                                    <td>
                                        <a href="#" class="btn btn-sm btn-primary">Sửa</a>
                                        <a href="#" class="btn btn-sm btn-danger">Xóa</a>
                                        <a href="<%= contextPath %>/user/details" class="btn btn-sm btn-info">Xem</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>Deshmukh</td>
                                    <td>Prohaska</td>
                                    <td>@Genelia</td>
                                    <td>admin</td>
                                    <td>
                                        <a href="#" class="btn btn-sm btn-primary">Sửa</a>
                                        <a href="#" class="btn btn-sm btn-danger">Xóa</a>
                                        <a href="<%= contextPath %>/user/details" class="btn btn-sm btn-info">Xem</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Deshmukh</td>
                                    <td>Gaylord</td>
                                    <td>@Ritesh</td>
                                    <td>member</td>
                                    <td>
                                        <a href="#" class="btn btn-sm btn-primary">Sửa</a>
                                        <a href="#" class="btn btn-sm btn-danger">Xóa</a>
                                        <a href="<%= contextPath %>/user/details" class="btn btn-sm btn-info">Xem</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Sanghani</td>
                                    <td>Gusikowski</td>
                                    <td>@Govinda</td>
                                    <td>developer</td>
                                    <td>
                                        <a href="#" class="btn btn-sm btn-primary">Sửa</a>
                                        <a href="#" class="btn btn-sm btn-danger">Xóa</a>
                                        <a href="<%= contextPath %>/user/details" class="btn btn-sm btn-info">Xem</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>4</td>
                                    <td>Roshan</td>
                                    <td>Rogahn</td>
                                    <td>@Hritik</td>
                                    <td>supporter</td>
                                    <td>
                                        <a href="#" class="btn btn-sm btn-primary">Sửa</a>
                                        <a href="#" class="btn btn-sm btn-danger">Xóa</a>
                                        <a href="<%= contextPath %>/user/details" class="btn btn-sm btn-info">Xem</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>5</td>
                                    <td>Joshi</td>
                                    <td>Hickle</td>
                                    <td>@Maruti</td>
                                    <td>member</td>
                                    <td>
                                        <a href="#" class="btn btn-sm btn-primary">Sửa</a>
                                        <a href="#" class="btn btn-sm btn-danger">Xóa</a>
                                        <a href="<%= contextPath %>/user/details" class="btn btn-sm btn-info">Xem</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>6</td>
                                    <td>Nigam</td>
                                    <td>Eichmann</td>
                                    <td>@Sonu</td>
                                    <td>supporter</td>
                                    <td>
                                        <a href="#" class="btn btn-sm btn-primary">Sửa</a>
                                        <a href="#" class="btn btn-sm btn-danger">Xóa</a>
                                        <a href="<%= contextPath %>/user/details" class="btn btn-sm btn-info">Xem</a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
        <footer class="footer text-center"> 2018 &copy; myclass.com</footer>
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<!-- jQuery -->
<script src="<%= contextPath %>/assets/plugins/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="<%= contextPath %>/assets/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Menu Plugin JavaScript -->
<script src="<%= contextPath %>/assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
<!--slimscroll JavaScript -->
<script src="<%= contextPath %>/assets/js/jquery.slimscroll.js"></script>
<script src="<%= contextPath %>/assets/js/jquery.dataTables.js"></script>
<!--Wave Effects -->
<script src="<%= contextPath %>/assets/js/waves.js"></script>
<!-- Custom Theme JavaScript -->
<script src="<%= contextPath %>/assets/js/custom.min.js"></script>
<script>
    $(document).ready(function () {
        $('#example').DataTable();
    });
</script>
</body>

</html>
