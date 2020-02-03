package cn.demo.easybuys.dao.impl;

import cn.demo.easybuys.dao.ProductDao;
import cn.demo.easybuys.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends BaseDao implements ProductDao {
    @Override
    public int getProductCount() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT count(0) as  num FROM easybuy_product";
        Product product = null;
        int count = 0;
        try {
            connection = super.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                count= rs.getInt("num");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.closeAll(connection,ps,rs);
        }

        return count;

    }

    @Override
    public void addProduct(Product product) {
        String sql = "INSERT INTO product(`name`,`description`,`price`,`stock`,`categoryLevel1Id`,`categoryLevel2Id`,`categoryLevel3Id`,`fileName`,`isDelete`)VALUES(?,?,?,?,?,?,?,?,?)";
        Object[] param = {product.getName(), product.getDescription(), product.getPrice(), product.getStock(), product.getCategoryLevel1Id(), product.getCategoryLevel2Id(), product.getCategoryLevel3Id(), product.getCategoryLevel3Id(), product.getFileName(), product.getIsDelete()};
        super.execute(sql,param);
    }

    @Override
    public void delProduct(int id) {
        String sql = "DELETE FROM easybuy_product WHERE id = ?";
        Object[] param = {id};
        super.execute(sql,param);

    }

    @Override
    public void updateProduct(Product product) {
        String sql = "UPDATE easybuy_product SET name=?,description=?,price=?,stock=?,categoryLevel1Id=?,categoryLevel2Id=?,categoryLevel3Id=?,fileName=?,isDelete=?  where id=?";
        Object[] param ={product.getName(), product.getDescription(), product.getPrice(), product.getStock(), product.getCategoryLevel1Id(), product.getCategoryLevel2Id(), product.getCategoryLevel3Id(), product.getCategoryLevel3Id(), product.getFileName(), product.getIsDelete(),product.getId()};
        super.execute(sql,param);
    }

    @Override
    public Product findProduct(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM easybuy_product where id = ?";
        Product product = null;
        try {
            connection = super.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()){
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getString("price"));
                product.setStock(rs.getInt("stock"));
                product.setCategoryLevel1Id(rs.getInt("categoryLevel1Id"));
                product.setCategoryLevel2Id(rs.getInt("categoryLevel2Id"));
                product.setCategoryLevel3Id(rs.getInt("categoryLevel3Id"));
                product.setFileName(rs.getString("fileName"));
                product.setIsDelete(rs.getInt("isDelete"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.closeAll(connection,ps,rs);
        }
        return product;
    }

    @Override
    public List<Product> getProductList(int PageCurrPageNO, int PageSize) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM easybuy_product limit ?,?";
        List<Product> list = new ArrayList<Product>();
        try {
            connection = super.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,(PageCurrPageNO-1)*PageSize);
            ps.setInt(2,PageSize);
            rs = ps.executeQuery();
            while (rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getString("price"));
                product.setStock(rs.getInt("stock"));
                product.setCategoryLevel1Id(rs.getInt("categoryLevel1Id"));
                product.setCategoryLevel2Id(rs.getInt("categoryLevel2Id"));
                product.setCategoryLevel3Id(rs.getInt("categoryLevel3Id"));
                product.setFileName(rs.getString("fileName"));
                product.setIsDelete(rs.getInt("isDelete"));
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.closeAll(connection,ps,rs);
        }

        return list;

    }






}
