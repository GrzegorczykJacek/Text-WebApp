package com.jg.twitter.service;

import com.jg.twitter.exception.ImproperLoginCredentials;
import com.jg.twitter.persistance.DAO.UserDAO;
import com.jg.twitter.persistance.entities.TbUser;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public TbUser getUserByUserName(String userName, String password) throws ImproperLoginCredentials {
        TbUser userByLogin = userDAO.getUserByLogin(userName);
        if (userByLogin == null || !userByLogin.getPassword().equals(password)) {
            throw new ImproperLoginCredentials("Username or password doesn't match!");
        }
        return userByLogin;
    }

}
