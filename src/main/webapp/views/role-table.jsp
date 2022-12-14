<%@ page import="com.macmie.crm_cybersoft.Pojo.Role_CRM" %>
<%@ page import="com.macmie.crm_cybersoft.Constants.Constants" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: macmie
  Date: 17.08.2022
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%
    String contextPath = request.getContextPath();
    List<Role_CRM> listRoles = (List<Role_CRM>) request.getAttribute(Constants.LIST_ROLES);
%>

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
    <link href="<%= contextPath %>/assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
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
                    <h4 class="page-title">Danh s??ch quy???n</h4>
                </div>
                <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                    <a href="<%= contextPath %><%= Constants.URL_ROLE_ADD %>" class="btn btn-sm btn-success">Th??m m???i</a>
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
                                    <th>T??n Quy???n</th>
                                    <th>M?? T???</th>
                                    <th>H??nh ?????ng</th>
                                </tr>
                                </thead>

                                <tbody>
                                <%for(Role_CRM element : listRoles){ %>
                                <tr>
                                    <td><%= element.getRole_ID() %></td>
                                    <td><%= element.getRole_Name() %></td>
                                    <td><%= element.getRole_Description() %></td>
                                    <td>
<%--                                        <a href="<%= contextPath + Constants.URL_ROLE_EDIT + "?id=" + role.getId()%>" class="btn btn-sm btn-info">--%>
<%--                                            <i class="fa fa-pencil-square-o"></i>--%>
<%--                                        </a>--%>
                                        <a href="<%= contextPath %><%= Constants.URL_ROLE_DELETE %>?id=<%= element.getRole_ID() %>" class="btn btn-sm btn-danger">X??a</a>
                                    </td>
                                </tr>
                                <%} %>
                                </tbody>

                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
        <footer class="footer text-center"> 2018 &copy; myclass.com </footer>
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
