package cn.demo.easybuys.dao.impl;

import cn.demo.easybuys.dao.UserDao;
import cn.demo.easybuys.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO easybuy_user(`loginName`,`userName`,`password`,`sex`,`identityCode`,`email`,`mobile`,`type`)VALUES(?,?,?,?,?,?,?,?)";
        Object[] param ={user.getLoginName(),user.getUserName(),user.getPassword(),user.getSex(),user.getIdentityCode(),user.getEmail(),user.getMobile(),user.getType()};
        super.execute(sql,param);
    }

    @Override
    public void delUser(int id) {
        String sql = "DELETE FROM easybuy_user WHERE id = ?";
        Object[] param = {id};
        super.execute(sql,param);

    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE easybuy_user SET loginName=?,userName=?,password=?,sex=?,identityCode=?,email=?,mobile=?,type=? WHERE id =?";
        Object[] param ={user.getLoginName(),user.getUserName(),user.getPassword(),user.getSex(),user.getIdentityCode(),user.getEmail(),user.getMobile(),user.getType(),user.getId()};
        super.execute(sql,param);

    }

    @Override
    public List<User> getUserList() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT *FROM easybuy_user";
        List<User> list = new ArrayList<User>();
        try {
            connection = super.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                User user1 = new User();
                user1.setId(rs.getInt("id"));
                user1.setLoginName(rs.getString("loginName"));
                user1.setUserName(rs.getString("userName"));
                user1.setPassword(rs.getString("password"));
                user1.setSex(rs.getInt("sex"));
                user1.setIdentityCode(rs.getString("identityCode"));
                user1.setEmail(rs.getString("email"));
                user1.setMobile(rs.getString("mobile"));
                user1.setType(rs.getInt("type"));
                list.add(user1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User Login(String loginName, String password) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM easybuy_user  WHERE loginName = ? AND password = ?";
        User user2 =null;
        try {
            connection = super.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,loginName);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if (rs.next()){
                user2 = new User();
                user2.setId(rs.getInt("id"));
                user2.setLoginName(rs.getString("loginName"));
                user2.setUserName(rs.getString("userName"));
                user2.setPassword(rs.getString("password"));
                user2.setSex(rs.getInt("sex"));
                user2.setIdentityCode(rs.getString("identityCode"));
                user2.setEmail(rs.getString("email"));
                user2.setMobile(rs.getString("mobile"));
                user2.setType(rs.getInt("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.closeAll(connection,ps,rs);
        }
        return user2;
 }
}
