package cn.demo.easybuys.dao;

import cn.demo.easybuys.entity.News;

import java.util.List;

public interface NewsDao {
    //添加数据
    void  addNews(News news);
    //删除数据
    void delNews(int id);
    //更新数据
    void  upadteNews(News news);
    //更新数据
    News findNews(int id);
   //查询数据
    List<News> getList(int PageCurrPageNO,int PageSize);
    //获取总页数
    int getNewsCount();
}
