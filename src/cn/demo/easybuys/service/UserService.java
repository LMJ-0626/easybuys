package cn.demo.easybuys.service;

import cn.demo.easybuys.entity.User;

import java.util.List;

public interface UserService {
    //添加数据
    void addUser(User user);
    //删除数据
    void delUser(int id);
    //更新数据
    void updateUser(User user);
    //查询
    List<User> getUserList();
    //修改当前用户的密码
    User Login(String loginName,String password);

}
