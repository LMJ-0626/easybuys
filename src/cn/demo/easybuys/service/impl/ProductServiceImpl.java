package cn.demo.easybuys.service.impl;

import cn.demo.easybuys.dao.ProductDao;
import cn.demo.easybuys.dao.impl.ProductDaoImpl;
import cn.demo.easybuys.entity.Product;
import cn.demo.easybuys.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDaoImpl();
    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public void delProduct(int id) {
       productDao.delProduct(id);
    }

    @Override
    public void updateProduct(Product product) {
       productDao.updateProduct(product);
    }

    @Override
    public Product findProduct(int id) {
        Product product = productDao.findProduct(id);
        return product;
    }

    @Override
    public List<Product> getProductList(int PageCurrPageNO, int PageSize) {
        List<Product> list = productDao.getProductList(PageCurrPageNO,PageSize);
        return list;
    }

    @Override
    public int getProductCount() {
        int count = productDao.getProductCount();
        return count;
    }


}
