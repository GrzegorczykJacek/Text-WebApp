package com.jg.twitter.servlet;

import com.jg.twitter.exception.ImproperLoginCredentials;
import com.jg.twitter.persistance.entities.TbUser;
import com.jg.twitter.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        final String currentURIfromLoginJSP = request.getParameter("currentURIfromLoginJSP");
        try {
            TbUser tbUser = userService.getUserByUserName(userName, password);
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", tbUser); // dodajemy własy atrybut o swojej nazwie currentUser - takich atrybutów mozemy dodać wiele
            if (currentURIfromLoginJSP == null
                    || "login.jsp".equals(currentURIfromLoginJSP)
                    || currentURIfromLoginJSP.isEmpty()) {
                response.sendRedirect("/");
            } else {
                response.sendRedirect(currentURIfromLoginJSP);
            }
        } catch (ImproperLoginCredentials improperLoginCredentials) {
            improperLoginCredentials.printStackTrace();
            response.sendRedirect("login.jsp");
        }
    }

}
