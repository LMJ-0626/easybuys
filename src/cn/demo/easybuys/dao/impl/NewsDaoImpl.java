package cn.demo.easybuys.dao.impl;

import cn.demo.easybuys.dao.NewsDao;
import cn.demo.easybuys.entity.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl extends BaseDao implements NewsDao {
    @Override
    public void addNews(News news) {
        String sql="INSERT into easybuy_news(`title`,`content`,`createTime`)VALUES(?,?,?)";
        Object[] param ={news.getTitle(),news.getContent(),news.getCreateTime()};
        super.execute(sql,param);

    }

    @Override
    public void delNews(int id) {
        String sql = "DELETE FROM easybuy_news WHERE id = ?";
        Object[] param ={id};
        super.execute(sql,param);

    }

    @Override
    public void upadteNews(News news) {
        String sql ="update easybuy_news set title=?,content=?,createTime=? where id=?";
        Object[] param={news.getTitle(),news.getContent(),news.getCreateTime(),news.getId()};
        super.execute(sql,param);

    }

    @Override
    public News findNews(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs= null;
        String sql = "SELECT * FROM easybuy_news where id=?";
        News news =null;
        try {
            connection = super.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
           if (rs.next()){
                news = new News();
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setContent(rs.getString("content"));
                news.setCreateTime(rs.getString("createTime"));
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.closeAll(connection,ps,rs);
        }

        return news;
    }

    @Override
    public List<News> getList(int PageCurrPageNO, int PageSize) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs= null;
        String sql = "SELECT * FROM easybuy_news limit ?,?";
        List<News> list = new ArrayList<News>();
        try {
            connection = super.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,(PageCurrPageNO-1)*PageSize);
            ps.setInt(2,PageSize);
            rs = ps.executeQuery();
            while (rs.next()){
                News news = new News();
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setContent(rs.getString("content"));
                news.setCreateTime(rs.getString("createTime"));
                list.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.closeAll(connection,ps,rs);
        }

        return list;

    }

    @Override
    public int getNewsCount() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs= null;
        String sql = "SELECT count(0) as  num FROM easybuy_news ";
        int count =0;
        try {
            connection = super.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                count=rs.getInt("num");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.closeAll(connection,ps,rs);
        }
        return count;

    }


}
