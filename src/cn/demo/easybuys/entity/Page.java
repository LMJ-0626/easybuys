package cn.demo.easybuys.entity;

public class Page {
    private int currPageNo = 1;
    // 当前页码
    private int pageSize = 5;
    // 页面大小，即每页显示记录数
    private int totalCount;
    // 记录总数
    private int totalPageCount;
    // 总页数

    public int getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(int currPageNo) {
        this.currPageNo = currPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPageCount() {
        if(totalCount % pageSize == 0){
            this.totalPageCount=totalCount/pageSize;
        }else{
            this.totalPageCount=totalCount/pageSize+1;
        }
        return totalPageCount;
    }


}
