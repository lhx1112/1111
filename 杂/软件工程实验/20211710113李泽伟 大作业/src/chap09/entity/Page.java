package chap09.entity;

public class Page {
    private int pageNow;
    private int pageCount;
    private int totalPage;
    private int totalRow;

    public Page(){}

    public Page(int pageNow, int pageCount, int totalPage, int totalRow) {
        this.pageNow = pageNow;
        this.pageCount = pageCount;
        this.totalPage = totalPage;
        this.totalRow = totalRow;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }
}
