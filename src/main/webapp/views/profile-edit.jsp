<%@ page import="com.macmie.crm_cybersoft.Pojo.User_CRM" %>
<%@ page import="com.macmie.crm_cybersoft.Constants.Constants" %>
<%@ page import="com.macmie.crm_cybersoft.DTO.ProjectAssignmentUser" %>
<%@ page import="java.util.List" %>
<%@ page import="com.macmie.crm_cybersoft.Pojo.Project_CRM" %><%--
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
    User_CRM user = (User_CRM) request.getAttribute(Constants.SELECTED_USE);
    ProjectAssignmentUser selectedPAU = (ProjectAssignmentUser) request.getAttribute(Constants.SELECTED_PAU);
    List<Project_CRM> listProjects = (List<Project_CRM>) request.getAttribute(Constants.LIST_PROJECTS);
    List<String> listAssignmentStatus = (List<String>) request.getAttribute(Constants.LIST_ASSIGNMENTS_STATUS);
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
    <!-- animation CSS -->
    <link href="<%= contextPath %>/assets/css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<%= contextPath %>/assets/css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="<%= contextPath %>/assets/css/colors/blue-dark.css" id="theme" rel="stylesheet">
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
                    <h4 class="page-title">C???p nh???t c??ng vi???c</h4>
                </div>
            </div>
            <!-- /.row -->
            <!-- .row -->
            <div class="row">
                <div class="col-md-2 col-12"></div>
                <div class="col-md-8 col-xs-12">
                    <div class="white-box">
                        <form class="form-horizontal form-material" method="POST" action="<%= contextPath + Constants.URL_PROFILE_EDIT %>">
                            <div class="form-group">
                                <label class="col-md-12">D??? ??n</label>
                                <div class="col-md-12">
                                    <select class="form-control form-control-line" name= "<%= Constants.ASSIGNMENT_CRM_PROJECT_ID %>">
                                        <%for(Project_CRM element : listProjects){%>
                                        <option value="<%= element.getProject_ID()%>"><%= element.getProject_Name() %></option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">T??n c??ng vi???c</label>
                                <div class="col-md-12">
                                    <input type="text" placeholder="T??n c??ng vi???c"
                                           class="form-control form-control-line" name= "<%= Constants.ASSIGNMENT_CRM_NAME %>">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Ng??y b???t ?????u</label>
                                <div class="col-md-12">
                                    <input type="text" placeholder="dd/MM/yyyy"
                                           class="form-control form-control-line" name= "<%= Constants.ASSIGNMENT_CRM_START_DATE %>" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Ng??y k???t th??c</label>
                                <div class="col-md-12">
                                    <input type="text" placeholder="dd/MM/yyyy"
                                           class="form-control form-control-line" name= "<%= Constants.ASSIGNMENT_CRM_END_DATE %>">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Tr???ng th??i</label>
                                <div class="col-md-12">
                                    <select class="form-control form-control-line" name= "<%= Constants.ASSIGNMENT_CRM_STATUS %>">
                                        <%for(String element : listAssignmentStatus){%>
                                        <option value="<%= element %>"> <%= element %> </option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-12">
                                    <button type="submit" class="btn btn-success">L??u l???i</button>
                                    <a href="<%= contextPath %> <%= Constants.URL_PROFILE %>" class="btn btn-primary">Quay l???i</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-2 col-12"></div>
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
<!--Wave Effects -->
<script src="<%= contextPath %>/assets/js/waves.js"></script>
<!-- Custom Theme JavaScript -->
<script src="<%= contextPath %>/assets/js/custom.min.js"></script>
</body>

</html>
