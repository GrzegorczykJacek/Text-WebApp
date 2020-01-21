package com.jg.twitter.servlet;

import com.jg.twitter.exception.ImproperLoginCredentials;
import com.jg.twitter.persistance.entities.TbUser;
import com.jg.twitter.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response
    ) throws IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            TbUser tbUser = userService.getUserByUserName(userName, password);
            response.sendRedirect("/");
        } catch (ImproperLoginCredentials improperLoginCredentials) {
            improperLoginCredentials.printStackTrace();
            response.sendRedirect("login.jsp");
        }
    }

}
