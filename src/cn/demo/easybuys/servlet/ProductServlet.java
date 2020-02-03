package cn.demo.easybuys.servlet;

import cn.demo.easybuys.entity.Page;
import cn.demo.easybuys.entity.Product;
import cn.demo.easybuys.service.ProductService;
import cn.demo.easybuys.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class ProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           request.setCharacterEncoding("UTF-8");
           response.setCharacterEncoding("UTF-8");

           String opt = request.getParameter("opt");
           ProductService productService = new ProductServiceImpl();
           PrintWriter out = response.getWriter();

           if (opt == null || opt.equals("list")){
               Page  page=new Page();
               page.setPageSize(10);
               page.setTotalCount(productService.getProductCount());
               int pageIndex=1;
               try {
                   pageIndex =Integer.parseInt(request.getParameter("page"));
                   //从url获取页数
                   if(pageIndex  <= 1){
                       pageIndex=1;
                       //如果小于1就是1
                   }
                   if(pageIndex >= page.getTotalPageCount()){
                       pageIndex=page.getTotalPageCount();
                       //如果大于总页数就是最后一页
                   }
                   page.setCurrPageNo(pageIndex);
                   //设置要查的页面页数
               }catch ( Exception e){
                   pageIndex=1;
                   //如果报错，就是第一页
               }

               List<Product> list = productService.getProductList(page.getCurrPageNo(),page.getPageSize());
               request.setAttribute("productList",list);
               request.setAttribute("firstPage",1);
               request.setAttribute("prePage",pageIndex<=page.getTotalPageCount()? 1:pageIndex-1);
               request.setAttribute("nextPage",pageIndex>=page.getTotalPageCount()? page.getTotalPageCount():pageIndex+1);
               request.setAttribute("lastPage",page.getTotalPageCount());
               request.setAttribute("currPage",pageIndex);
               request.setAttribute("totalPage",page.getTotalPageCount());
               request.getRequestDispatcher("admin/product/list.jsp").forward(request,response);
          }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request, response);
    }
}
