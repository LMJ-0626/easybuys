package cn.demo.easybuys.service.impl;

import cn.demo.easybuys.dao.CategoryDao;
import cn.demo.easybuys.dao.impl.BaseDao;
import cn.demo.easybuys.dao.impl.CategoryDaoImpl;
import cn.demo.easybuys.entity.Category;
import cn.demo.easybuys.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl extends BaseDao implements CategoryService {
    CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> getCategoryList() {
        List<Category> list = categoryDao.getCategoryList();
        return list;
    }

    @Override
    public List<Category> getCategoryList(int type) {
        List<Category> list = categoryDao.getCategoryList(type);
        return list;
    }

    @Override
    public List<Category> getCategoryList(int type, int parentId) {
        List<Category> list = categoryDao.getCategoryList(type,parentId);
        return list;
    }
}
