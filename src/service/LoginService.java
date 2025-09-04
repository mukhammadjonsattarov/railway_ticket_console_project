package service;

import model.User;

import static db.DataBase.users;

public class LoginService {
    public User login(String username, String password) {
        for (User u : users) {
            if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}
