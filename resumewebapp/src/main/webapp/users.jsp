<%@page import="com.company.main.Context"%>
<%@page import="com.company.dao.inter.UserDaoInter"%>
<%@page import="com.company.entity.User"%>
<%@ page import="java.util.List" %>
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

            String name = request.getParameter("name");
            String surname = request.getParameter("surname");

            String nationalityIdStr = request.getParameter("nid");
            Integer nationalityId=null;
            if(nationalityIdStr!=null && !nationalityIdStr.trim().isEmpty()) {
                nationalityId = Integer.parseInt(nationalityIdStr);
            }

            out.println("surname="+surname);
            List<User> list = userDao.getAll(name, surname, nationalityId);
        %>
        <div>
            <form action="users.jsp" method="GET">
                <label for="name">name:</label>
                <input type="text" name="name" value=""/>
                <br/>
                <label for="surname">surname</label>
                <input type="text" name="surname" value=""/>

                <input type="submit" name="search" value="Search"/>
            </form>
        </div>

        <div>
            <table>
                <thead>
                    <tr>
                        <th>name</th>
                        <th>surname</th>
                        <th>nationality</th>
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
                    </tr>
                <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
