package cn.demo.easybuys.service.impl;

import cn.demo.easybuys.dao.UserDao;
import cn.demo.easybuys.dao.impl.UserDaoImpl;
import cn.demo.easybuys.entity.User;
import cn.demo.easybuys.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void delUser(int id) {
       userDao.delUser(id);
    }

    @Override
    public void updateUser(User user) {
       userDao.updateUser(user);
    }

    @Override
    public List<User> getUserList() {
        List<User> list = userDao.getUserList();
        return list;
    }

    @Override
    public User Login(String loginName, String password) {
        User user = userDao.Login(loginName,password);
        return user;
    }
}
