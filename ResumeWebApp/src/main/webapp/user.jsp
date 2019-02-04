<%-- 
    Document   : user
    Created on : Feb 4, 2019, 10:19:10 PM
    Author     : sarkhanrasullu
--%>

<%@page import="com.company.main.Context"%>
<%@page import="com.company.dao.inter.UserDaoInter"%>
<%@page import="com.company.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            UserDaoInter userDao = Context.instanceUserDao();
            User u = userDao.getById(6);
        %>

        <div>
            <form action="UserController" method="POST">
                <input type="hidden" name="id" value="<%=u.getId()%>"/>
                <label for="name">name:</label>
                <input type="text" name="name" value="<%=u.getName()%>"/>
                <br/>
                <label for="surname">surname</label>
                <input type="text" name="surname" value="<%=u.getSurname()%>"/>

                <input type="submit" name="save" value="Save"/>
            </form>
        </div>
    </body>
</html>
