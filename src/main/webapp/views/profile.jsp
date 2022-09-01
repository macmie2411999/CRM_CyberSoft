<%@ page import="com.macmie.crm_cybersoft.Pojo.User_CRM" %>
<%@ page import="com.macmie.crm_cybersoft.Constants.Constants" %>
<%@ page import="com.macmie.crm_cybersoft.DTO.ProjectAssignmentUser" %>
<%@ page import="java.util.List" %>
<%--
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
    User_CRM user = (User_CRM) request.getAttribute(Constants.SELECTED_USE);
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
                    <h4 class="page-title">Chi tiết thành viên</h4>
                </div>
            </div>
            <!-- /.row -->
            <!-- .row -->
            <div class="row">
                <div class="col-md-4 col-xs-12">
                    <div class="white-box">
                        <div class="user-bg"><img width="100%" alt="user"
                                                  src="<%= contextPath %>/assets/plugins/images/large/img1.jpg">
                            <div class="overlay-box">
                                <div class="user-content">
                                    <a href="javascript:void(0)"><img
                                            src="<%= contextPath %>/assets/plugins/images/users/genu.jpg"
                                            class="thumb-lg img-circle" alt="img"></a>
                                    <h4 class="text-white"><%= user.getUser_Name()%>></h4>
                                    <h5 class="text-white"><%= user.getUser_Email()%></h5>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="col-md-8 col-xs-12">
                    <!-- BEGIN THỐNG KÊ -->
                    <div class="row">
                        <!--col -->
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                            <div class="white-box">
                                <div class="col-in row">
                                    <div class="col-xs-12">
                                        <h3 class="counter text-right m-t-15 text-danger"><%= Still_PAU_Percentage %></h3>
                                    </div>
                                    <div class="col-xs-12">
                                        <i data-icon="E" class="linea-icon linea-basic"></i>
                                        <h5 class="text-muted vb text-center">CHƯA BẮT ĐẦU</h5>
                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-danger" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 20%"></div>
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
                                    <div class="col-xs-12">
                                        <h3 class="counter text-right m-t-15 text-megna"><%= Processing_PAU_Percentage %></h3>
                                    </div>
                                    <div class="col-xs-12">
                                        <i class="linea-icon linea-basic" data-icon="&#xe01b;"></i>
                                        <h5 class="text-muted vb text-center">ĐANG THỰC HIỆN</h5>
                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-megna" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 50%"></div>
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
                                    <div class="col-xs-12">
                                        <h3 class="counter text-right m-t-15 text-primary"><%= Completed_PAU_Percentage %></h3>
                                    </div>
                                    <div class="col-xs-12">
                                        <i class="linea-icon linea-basic" data-icon="&#xe00b;"></i>
                                        <h5 class="text-muted vb text-center">HOÀN THÀNH</h5>
                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-primary" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 30%"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- END THỐNG KÊ -->

                </div>
            </div>
            <br/>
            <!-- /.row -->
            <!-- BEGIN DANH SÁCH CÔNG VIỆC -->
            <h4>DANH SÁCH CÔNG VIỆC</h4>
            <div class="row">
                <div class="col-sm-12">
                    <div class="white-box">
                        <div class="table-responsive">
                            <table class="table" id="example">
                                <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Tên Công Việc</th>
                                    <th>Dự Án</th>
                                    <th>Ngày Bắt Đầu</th>
                                    <th>Ngày Kết Thúc</th>
                                    <th>Trạng Thái</th>
                                    <th>Hành Động</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    for(ProjectAssignmentUser element : listAll_PAU){
                                %>
                                <tr>
                                    <td><%= element.getAssignment_ID() %></td>
                                    <td><%= element.getAssignment_Name() %></td>
                                    <td><%= element.getProject_Name() %></td>
                                    <td><%= element.getAssignment_Start_Date() %></td>
                                    <td><%= element.getAssignment_End_Date() %></td>
                                    <td><%= element.getAssignment_Status() %></td>
                                    <td>
                                        <a href="<%= contextPath %><%= Constants.URL_PROFILE_EDIT %>?id=<%= element.getAssignment_ID() %>" class="btn btn-sm btn-primary">Cập nhật</a>
                                    </td>
                                </tr>

                                <% } %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END DANH SÁCH CÔNG VIỆC -->
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
<!--Wave Effects -->
<script src="<%= contextPath %>/assets/js/waves.js"></script>
<!-- Custom Theme JavaScript -->
<script src="<%= contextPath %>/assets/js/custom.min.js"></script>
</body>

</html>
