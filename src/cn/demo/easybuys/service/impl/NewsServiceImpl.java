package cn.demo.easybuys.service.impl;

import cn.demo.easybuys.dao.NewsDao;
import cn.demo.easybuys.dao.impl.NewsDaoImpl;
import cn.demo.easybuys.entity.News;
import cn.demo.easybuys.service.NewsService;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    NewsDao newsDao = new NewsDaoImpl();
    @Override
    public void addNews(News news) {
       newsDao.addNews(news);
    }

    @Override
    public void delNews(int id) {
        newsDao.delNews(id);

    }

    @Override
    public void upadteNews(News news) {
        newsDao.upadteNews(news);
    }

    @Override
    public News findNews(int id) {
        News news = newsDao.findNews(id);
        return news;
    }

    @Override
    public List<News> getList(int PageCurrPageNO, int PageSize) {
        List<News> list = newsDao.getList(PageCurrPageNO,PageSize);
        return list;
    }

    @Override
    public int getNewsCount() {
        int count = newsDao.getNewsCount();
        return count;
    }


}
