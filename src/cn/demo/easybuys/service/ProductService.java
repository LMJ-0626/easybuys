package cn.demo.easybuys.service;

import cn.demo.easybuys.entity.Product;

import java.util.List;

public interface ProductService {
    //添加数据
    void  addProduct(Product product);
    //删除数据
    void  delProduct(int id);
    //更新数据
    void updateProduct(Product product);
    //更新数据
    Product findProduct(int id);
    //查询数据
    List<Product> getProductList(int PageCurrPageNO,int PageSize);
    //获取总页数
    int getProductCount();
}
