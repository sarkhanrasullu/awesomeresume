/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.firstwebapp;

import com.company.dao.impl.UserDaoImpl;
import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.main.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sarkhanrasullu
 */
@WebServlet(name = "MyFavoritePage", urlPatterns = {"/MyFavoritePage"})
public class MyFavoritePage extends HttpServlet {

    private SkillDaoInter skillDao = Context.instanceSkillDao();

    private int i = 0;
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service");
        super.service(req, resp);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        System.out.println("GET");
        response.setContentType("text/html;charset=UTF-8");
        i++;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title >Servlet MyFavoritePage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("i="+i);
            out.println( skillDao.getAll().get(0).getId()+ "<br>");

            out.println(skillDao.getAll() + "<br>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        try {
            String requestStr = getAllDataFromRequest(req);
            System.out.println("request="+requestStr);
            String name = String.valueOf(req.getParameter("name"));
            System.out.println("name="+name);
            
            req.setAttribute("processed", true);
            System.out.println("attribute="+req.getAttribute("name"));
            Skill s = new Skill(0, name);
            boolean b = skillDao.insertSkill(s);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title >Servlet MyFavoritePage</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("I GOT POST REQUEST");
                out.println("user inserted:" + s + "<br>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (Exception ex) {
            Logger.getLogger(MyFavoritePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void foo(HttpServletRequest req){
       boolean b = Boolean.valueOf(String.valueOf(req.getAttribute("processed")));
    }

    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("PUT");   
        
        int id = Integer.valueOf(req.getParameter("id"));
            String name = String.valueOf(req.getParameter("name"));
           
            Skill s = skillDao.getById(id);
            s.setName(name);
            skillDao.updateSkill(s);
           
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public static String getAllDataFromRequest(HttpServletRequest request) throws Exception {

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        body = stringBuilder.toString();

        return body;
    }
}
