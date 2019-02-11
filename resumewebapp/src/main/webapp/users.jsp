<%@page import="com.company.main.Context"%>
<%@page import="com.company.dao.inter.UserDaoInter"%>
<%@page import="com.company.entity.User"%>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/users.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UserDaoInter userDao = Context.instanceUserDao();

            String name = request.getParameter("name");
            String surname = request.getParameter("surname");

            String nationalityIdStr = request.getParameter("nid");
            Integer nationalityId=null;
            if(nationalityIdStr!=null && !nationalityIdStr.trim().isEmpty()) {
                nationalityId = Integer.parseInt(nationalityIdStr);
            }


            List<User> list = userDao.getAll(name, surname, nationalityId);
        %>
        <div class="container">
            <%--<div class="row">--%>
                <%--<div class="col-sm-8">col-sm-8</div>--%>
                <%--<div class="col-sm-4">col-sm-4</div>--%>
            <%--</div>--%>
            <%--<div class="row">--%>
                <%--<div class="col-sm">col-sm</div>--%>
                <%--<div class="col-sm">col-sm</div>--%>
                <%--<div class="col-sm">col-sm</div>--%>
            <%--</div>--%>
            <div class="row">
                <div class="col-4">
                    <form action="users.jsp" method="GET">
                        <div class="form-group">
                            <label for="name">name:</label>
                            <input placeholder="Enter name" class="form-control" type="text" name="name" value=""/>
                        </div>
                        <div class="form-group">
                            <label for="surname">surname:</label>
                            <input placeholder="Enter surname" class="form-control" type="text" name="surname" value=""/>
                        </div>

                        <input class="btn btn-primary" type="submit" name="search" value="Search"/>
                    </form>
                </div>
            </div>
            <div>
                <table class="table">
                    <thead>
                    <tr>
                        <th>name</th>
                        <th>surname</th>
                        <th>nationality</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for(User u: list){
                    %>
                    <tr>
                        <td><%=u.getName()%></td>
                        <td><%=u.getSurname()%></td>
                        <td><%=u.getNationality().getName()==null?"N/A":u.getNationality().getName()%></td>
                        <td>
                            <button class="btn btn-danger" type="submit" value="delete" name="action">
                                <i class="fas fa-trash-alt"></i>
                            </button>

                            <button class="btn btn-secondary" type="submit" value="update" name="action">
                                <i class="fas fa-pen-square"></i>
                            </button>
                        </td>
                    </tr>
                    <%}%>
                    </tbody>
                </table>

            </div>
        </div>

    </body>
</html>
