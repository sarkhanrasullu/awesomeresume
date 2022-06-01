<%@ page import="com.company.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: sarkhanrasullu
  Date: 2/28/19
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%
    User user= (User) session.getAttribute("loggedInUser");
%>
<%="Wellcome, "+user.getName()+"!!!"%>
