package cn.demo.easybuys.dao.impl;

import cn.demo.easybuys.dao.CategoryDao;
import cn.demo.easybuys.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl extends BaseDao implements CategoryDao {
    @Override
    public List<Category> getCategoryList() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * from easybuy_product_category";
        List<Category> list = new ArrayList<Category>();
        try {
            connection = super.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setParentId(rs.getInt("parentId"));
                category.setType(rs.getInt("type"));
                category.setIconClass(rs.getString("iconClass"));
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.closeAll(connection,ps,rs);
        }

        return list;
    }

    @Override
    public List<Category> getCategoryList(int type) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * from easybuy_product_category WHERE type =?";
        List<Category> list = new ArrayList<Category>();
        try {
            connection = super.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,type);
            rs = ps.executeQuery();
            while (rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setParentId(rs.getInt("parentId"));
                category.setType(rs.getInt("type"));
                category.setIconClass(rs.getString("iconClass"));
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.closeAll(connection,ps,rs);
        }
          return list;
    }

    @Override
    public List<Category> getCategoryList(int type, int parentId) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * from easybuy_product_category WHERE type =? AND parentId=?;";
        List<Category> list = new ArrayList<Category>();
        try {
            connection = super.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,type);
            ps.setInt(2,parentId);
            rs = ps.executeQuery();
            while (rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setParentId(rs.getInt("parentId"));
                category.setType(rs.getInt("type"));
                category.setIconClass(rs.getString("iconClass"));
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.closeAll(connection,ps,rs);
        }
        return list;
    }
}
