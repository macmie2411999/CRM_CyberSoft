<%@ page import="com.macmie.crm_cybersoft.Pojo.Project_CRM" %>
<%@ page import="com.macmie.crm_cybersoft.Constants.Constants" %>
<%@ page import="com.macmie.crm_cybersoft.Pojo.Assignment_CRM" %>
<%@ page import="java.util.List" %>
<%@ page import="com.macmie.crm_cybersoft.DTO.ProjectAssignmentUser" %><%--
  Created by IntelliJ IDEA.
  User: macmie
  Date: 17.08.2022
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%
    String contextPath = request.getContextPath();
    Project_CRM project = (Project_CRM) request.getAttribute(Constants.SELECTED_PROJECT);
    List<ProjectAssignmentUser> listAll_PAU = (List<ProjectAssignmentUser>) request.getAttribute(Constants.LIST_PAU_PROJECT);
    List<ProjectAssignmentUser> listCompleted_PAU = (List<ProjectAssignmentUser>) request.getAttribute(Constants.LIST_COMPLETED_ASSIGNMENTS);
    List<ProjectAssignmentUser> listProcessing_PAU= (List<ProjectAssignmentUser>) request.getAttribute(Constants.LIST_PROCESSING_ASSIGNMENTS);
    List<ProjectAssignmentUser> listStill_PAU = (List<ProjectAssignmentUser>) request.getAttribute(Constants.LIST_STILL_ASSIGNMENTS);
    Integer numberAll_PAU = listAll_PAU.size();
    Integer numberCompleted_PAU = listCompleted_PAU.size();
    Integer numberProcessing_PAU = listProcessing_PAU.size();
    Integer numberStill_PAU = listStill_PAU.size();
    Integer Completed_PAU_Percentage=0;
    Integer Processing_PAU_Percentage=0;
    Integer Still_PAU_Percentage=0;

    if(numberAll_PAU!=0){
        Completed_PAU_Percentage = numberCompleted_PAU*100/numberAll_PAU;
        Processing_PAU_Percentage = numberProcessing_PAU*100/numberAll_PAU;
        Still_PAU_Percentage = numberStill_PAU*100/numberAll_PAU;
    }
%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="<%= contextPath %>/assets/plugins/images/favicon.png">
    <title>Pixel Admin</title>
    <!-- Bootstrap Core CSS -->
    <link href="<%= contextPath %>/assets/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="<%= contextPath %>/assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <!-- Animation CSS -->
    <link href="<%= contextPath %>/assets/css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<%= contextPath %>/assets/css/style.css" rel="stylesheet">
    <!-- color CSS you can use different color css from css/colors folder -->
    <!-- We have chosen the skin-blue (blue.css) for this starter
          page. However, you can choose any other skin from folder css / colors .
-->
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
                    <h4 class="page-title">Chi tiết công việc </h4>
                </div>
                <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                    <ol class="breadcrumb">
                        <li><a href="#">Dashboard</a></li>
                        <li class="active">Blank Page</li>
                    </ol>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- BEGIN THỐNG KÊ -->
            <div class="row">
                <!--col -->
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="white-box">
                        <div class="col-in row">
                            <div class="col-md-6 col-sm-6 col-xs-6"> <i data-icon="E"
                                                                        class="linea-icon linea-basic"></i>
                                <h5 class="text-muted vb">CHƯA BẮT ĐẦU</h5>
                            </div>
                            <div class="col-md-6 col-sm-6 col-xs-6">
                                <h3 class="counter text-right m-t-15 text-danger"><%= Still_PAU_Percentage %>%</h3>
                            </div>
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="progress">
                                    <div class="progress-bar progress-bar-danger" role="progressbar"
                                         aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.col -->
                <!--col -->
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="white-box">
                        <div class="col-in row">
                            <div class="col-md-6 col-sm-6 col-xs-6"> <i class="linea-icon linea-basic"
                                                                        data-icon="&#xe01b;"></i>
                                <h5 class="text-muted vb">ĐANG THỰC HIỆN</h5>
                            </div>
                            <div class="col-md-6 col-sm-6 col-xs-6">
                                <h3 class="counter text-right m-t-15 text-megna"><%= Processing_PAU_Percentage %>%</h3>
                            </div>
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="progress">
                                    <div class="progress-bar progress-bar-megna" role="progressbar"
                                         aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 50%">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.col -->
                <!--col -->
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="white-box">
                        <div class="col-in row">
                            <div class="col-md-6 col-sm-6 col-xs-6"> <i class="linea-icon linea-basic"
                                                                        data-icon="&#xe00b;"></i>
                                <h5 class="text-muted vb">HOÀN THÀNH</h5>
                            </div>
                            <div class="col-md-6 col-sm-6 col-xs-6">
                                <h3 class="counter text-right m-t-15 text-primary"><%= Completed_PAU_Percentage %>%</h3>
                            </div>
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="progress">
                                    <div class="progress-bar progress-bar-primary" role="progressbar"
                                         aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 30%">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.col -->
            </div>
            <!-- END THỐNG KÊ -->

            <!-- BEGIN DANH SÁCH CÔNG VIỆC -->
            <%
                for (ProjectAssignmentUser elementAll_PAU : listAll_PAU){
            %>
            <div class="row">
                <div class="col-xs-12">
                    <a href="#" class="group-title">
                        <img width="30" src="<%= contextPath %>/assets/plugins/images/users/pawandeep.jpg" class="img-circle" />
                        <span><%= elementAll_PAU.getUser_Name() %></span>
                    </a>
                </div>
                <div class="col-md-4">
                    <div class="white-box">
                        <h3 class="box-title">Chưa thực hiện</h3>
                        <div class="message-center">
                            <%
                                for (ProjectAssignmentUser elementStill_PAU : listStill_PAU){
                                    if (elementStill_PAU.getUser_Name().equals(elementAll_PAU.getUser_Name())) {
                            %>
                            <a href="#">
                                <div class="mail-contnet">
                                    <h5><%= elementStill_PAU.getAssignment_Name() %></h5>
                                    <span class="mail-desc"></span>
                                    <span class="time">Tên Công Việc: <%= elementStill_PAU.getAssignment_Name() %></span>
                                    <span class="time">Bắt đầu: <%= elementStill_PAU.getAssignment_Start_Date() %></span>
                                    <span class="time">Kết thúc: <%= elementStill_PAU.getAssignment_End_Date() %></span>
                                </div>
                            </a>
                            <%
                                    }
                                }
                            %>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="white-box">
                        <h3 class="box-title">Đang thực hiện</h3>
                        <div class="message-center">
                            <%
                                for (ProjectAssignmentUser elementProcessing_PAU : listProcessing_PAU){
                                    if (elementProcessing_PAU.getUser_Name().equals(elementAll_PAU.getUser_Name())) {
                            %>
                            <a href="#">
                                <div class="mail-contnet">
                                    <h5><%= elementProcessing_PAU.getAssignment_Name() %></h5>
                                    <span class="mail-desc"></span>
                                    <span class="time">Tên Công Việc: <%= elementProcessing_PAU.getAssignment_Name() %></span>
                                    <span class="time">Bắt đầu: <%= elementProcessing_PAU.getAssignment_Start_Date() %></span>
                                    <span class="time">Kết thúc: <%= elementProcessing_PAU.getAssignment_End_Date() %></span>
                                </div>
                            </a>
                            <%
                                    }
                                }
                            %>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="white-box">
                        <h3 class="box-title">Đã hoàn thành</h3>
                        <div class="message-center">
                            <%
                                for (ProjectAssignmentUser elementCompleted_PAU : listCompleted_PAU){
                                    if (elementCompleted_PAU.getUser_Name().equals(elementAll_PAU.getUser_Name())) {
                            %>
                            <a href="#">
                                <div class="mail-contnet">
                                    <h5><%= elementCompleted_PAU.getAssignment_Name() %></h5>
                                    <span class="mail-desc"></span>
                                    <span class="time">Tên Công Việc: <%= elementCompleted_PAU.getAssignment_Name() %></span>
                                    <span class="time">Bắt đầu: <%= elementCompleted_PAU.getAssignment_Start_Date() %></span>
                                    <span class="time">Kết thúc: <%= elementCompleted_PAU.getAssignment_End_Date() %></span>
                                </div>
                            </a>
                            <%
                                    }
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>
            <%
                }
            %>
            <!-- END DANH SÁCH CÔNG VIỆC -->
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
