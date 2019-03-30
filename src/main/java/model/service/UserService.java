package model.service;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entity.User;

import java.util.Optional;

public class UserService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public Optional<User> login(String email) {
        Optional<User> result;

        try (UserDao userDao = daoFactory.createUserDao()) {
            result = userDao.findByEmail(email);
        }

        return result;
    }

}
