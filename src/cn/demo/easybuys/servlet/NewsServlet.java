package cn.demo.easybuys.servlet;

import cn.demo.easybuys.entity.News;
import cn.demo.easybuys.entity.Page;
import cn.demo.easybuys.service.NewsService;
import cn.demo.easybuys.service.impl.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspPage;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@WebServlet(name = "NewsServlet")
public class NewsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String opt = request.getParameter("opt");
        NewsService newsService = new NewsServiceImpl();
        PrintWriter out = response.getWriter();


        if (opt == null || opt.equals("list")){
            Page  page=new Page();
            page.setPageSize(10);
            page.setTotalCount(newsService.getNewsCount());
            int pageindex=1;
            try {
                pageindex =Integer.parseInt(request.getParameter("page"));
                //从url获取页数
                if(pageindex  <= 1){
                    pageindex=1;
                    //如果小于1就是1
                }
                if(pageindex >= page.getTotalPageCount()){
                    pageindex=page.getTotalPageCount();
                    //如果大于总页数就是最后一页
                }
                page.setCurrPageNo(pageindex);
                //设置要查的页面页数
            }catch ( Exception e){
                pageindex=1;
                //如果报错，就是第一页
            }
            List<News> list = newsService.getList(page.getCurrPageNo(),page.getPageSize());
            request.setAttribute("newslist",list);
            request.setAttribute("firstPage",1);
            request.setAttribute("prePage",pageindex <= page.getTotalPageCount() ?1:pageindex-1);
            request.setAttribute("nextPage",pageindex >= page.getTotalPageCount() ?page.getTotalPageCount():pageindex+1);
            request.setAttribute("lastPage",page.getTotalPageCount());
            request.setAttribute("currPage",pageindex);
            request.setAttribute("totalPage",page.getTotalPageCount());
            request.getRequestDispatcher("admin/news/list.jsp").forward(request,response);
        }else if (opt.equals("del")){
            //删除
           String id =  request.getParameter("id");
           newsService.delNews(Integer.valueOf(id));
           out.print("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> </html> <script>alert('删除成功！');location.href='../../NewsServlet?opt=list'</script>");
        }else if(opt.equals("add")){
           String title= request.getParameter("txtATitle");
           String content =request.getParameter("txtAContent");
           News model = new News();
           model.setTitle(title);
           model.setContent(content);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            model.setCreateTime(df.format(new Date()));
           newsService.addNews(model);
           response.sendRedirect("../../NewsServlet?opt=list");
        }else if (opt.equals("find")){
            //根据id获取实体 更新
            String id = request.getParameter("id");
            News news = newsService.findNews(Integer.valueOf(id));
            request.setAttribute("newsOne",news);
            request.getRequestDispatcher("admin/news/info.jsp").forward(request,response);
        }else  if (opt.equals("up")){
            //更新
            int id=Integer.parseInt(request.getParameter("id"));
            String title= request.getParameter("txtATitle");
            String content =request.getParameter("txtAContent");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            News model = new News();
            model.setId(id);
            model.setTitle(title);
            model.setContent(content);
            model.setCreateTime(df.format(new Date()));
            newsService.upadteNews(model);
            out.print("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> </html> <script>alert('修改成功！');location.href='../../NewsServlet?opt=list'</script>");
        }
         out.flush();
         out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
