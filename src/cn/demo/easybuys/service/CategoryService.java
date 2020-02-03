package cn.demo.easybuys.service;

import cn.demo.easybuys.entity.Category;

import java.util.List;

public interface CategoryService {
    //查询
    List<Category> getCategoryList();
    //查询一级分类
    List<Category> getCategoryList(int type);
    //根据上级分类id查询下级分类
    List<Category> getCategoryList(int type,int parentId);
}
