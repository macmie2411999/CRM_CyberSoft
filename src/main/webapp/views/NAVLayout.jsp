<%@ page import="com.macmie.crm_cybersoft.Constants.Constants" %><%--
  Created by IntelliJ IDEA.
  User: macmie
  Date: 20.08.2022
  Time: 08:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<% String contextPath = request.getContextPath(); %>

<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top m-b-0">
    <div class="navbar-header">
        <a class="navbar-toggle hidden-sm hidden-md hidden-lg " href="javascript:void(0)" data-toggle="collapse"
           data-target=".navbar-collapse">
            <i class="fa fa-bars"></i>
        </a>
        <div class="top-left-part">
            <a class="logo" href="<%=contextPath%>/home">
                <b>
                    <img src="<%= contextPath %>/assets/plugins/images/pixeladmin-logo.png" alt="home"/>
                </b>
                <span class="hidden-xs">
                            <img src="<%= contextPath %>/assets/plugins/images/pixeladmin-text.png" alt="home"/>
                        </span>
            </a>
        </div>
        <ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
            <li>
                <form role="search" class="app-search hidden-xs">
                    <input type="text" placeholder="Search..." class="form-control">
                    <a href="">
                        <i class="fa fa-search"></i>
                    </a>
                </form>
            </li>
        </ul>
        <ul class="nav navbar-top-links navbar-right pull-right">
            <li>
                <div class="dropdown">
                    <a class="profile-pic dropdown-toggle" data-toggle="dropdown" href="#">
                        <img src="<%= contextPath %>/assets/plugins/images/users/varun.jpg" alt="user-img" width="36"
                             class="img-circle"/>
                        <b class="hidden-xs">Cybersoft</b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="<%= contextPath %><%= Constants.URL_PROFILE %>">Thông tin cá nhân và Công việc</a></li>
<%--                                                <li><a href="<%=contextPath%>/profile">Thống kê công việc</a></li>--%>

                        <%--                    mm adjust start--%>
                        <%--                    Check Role--%>
                        <%
                            HttpServletRequest requestHttp = (HttpServletRequest) request;
                            String message = "" + requestHttp.getSession().getAttribute(Constants.ID_CURRENT_USER_ROLE).toString();
                            if(message.equals(Constants.ROLE_ADMIN)){
                                message = "Role: Admin";
                            } else if(message.equals(Constants.ROLE_LEADER)){
                                message = "Role: Leader";
                            } else{
                                message = "Role: Member";
                            }
                        %>
                        <li> <a><%= message %></a> </li>
                        <%--                    mm adjust end--%>

                        <li><a href="<%= contextPath %><%= Constants.URL_LOGOUT %>">Đăng xuất</a></li>
                    </ul>
                </div>
            </li>
        </ul>
    </div>
    <!-- /.navbar-header -->
    <!-- /.navbar-top-links -->
    <!-- /.navbar-static-side -->
</nav>
<!-- Left navbar-header -->
<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse slimscrollsidebar">
        <ul class="nav" id="side-menu">
            <li style="padding: 10px 0 0;">
                <a href="<%= contextPath %><%= Constants.URL_HOME %>" class="waves-effect"><i class="fa fa-clock-o fa-fw"
                                                                          aria-hidden="true"></i><span
                        class="hide-menu">Dashboard</span></a>
            </li>
            <li>
                <a href="<%= contextPath %><%= Constants.URL_USER %>" class="waves-effect"><i class="fa fa-user fa-fw"
                                                                          aria-hidden="true"></i><span
                        class="hide-menu">Thành viên</span></a>
            </li>
            <li>
                <a href="<%= contextPath %><%= Constants.URL_ROLE %>" class="waves-effect"><i class="fa fa-modx fa-fw"
                                                                          aria-hidden="true"></i><span
                        class="hide-menu">Quyền</span></a>
            </li>
            <li>
                <a href="<%= contextPath %><%= Constants.URL_PROJECT %>" class="waves-effect"><i class="fa fa-table fa-fw"
                                                                             aria-hidden="true"></i><span
                        class="hide-menu">Dự án</span></a>
            </li>
            <li>
                <a href="<%= contextPath %>/assignment" class="waves-effect"><i class="fa fa-table fa-fw"
                                                                                aria-hidden="true"></i><span
                        class="hide-menu">Công việc</span></a>
            </li>
            <li>
                <a href="<%= contextPath %><%= Constants.URL_BLANK %>" class="waves-effect"><i class="fa fa-table fa-fw"
                                                                           aria-hidden="true"></i><span
                        class="hide-menu">Blank Page</span></a>
            </li>
            <li>
                <a href="<%= contextPath %><%= Constants.URL_PNG %>" class="waves-effect"><i class="fa fa-info-circle fa-fw"
                                                                         aria-hidden="true"></i><span
                        class="hide-menu">Error 404</span></a>
            </li>
        </ul>
    </div>
</div>
<!-- Left navbar-header end -->
