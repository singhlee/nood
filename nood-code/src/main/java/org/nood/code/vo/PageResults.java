package org.nood.code.vo;



import java.util.List;

public class PageResults<T> {
	    private int pageNo;

	    private int pageSize;

	    private int totalCount;

	    private int pageCount;

	    private List<T> results;
	 	private Object extra;
	    public int getPageCount() {
	        return pageCount;
	    }
	 
	    public void setPageCount(int pageCount) {
	        this.pageCount = pageCount;
	    }
	 
	    public int getPageNo() {
	        if (pageNo <= 0) {
	            return 1;
	        } else{
	            return pageNo > pageCount ? pageCount : pageNo;
	        }
	    }
	 
	    public void setPageNo(int pageNo) {
	        this.pageNo = pageNo;
	    }
	 
	    public List<T> getResults() {
	        return results;
	    }
	 
	    public void setResults(List<T> results) {
	        this.results = results;
	    }
	 
	    public int getPageSize() {
	        return pageSize;
	    }
	 
	    public void setPageSize(int pageSize) {
	        this.pageSize = pageSize <= 0 ? 10 : pageSize;
	    }
	 
	    public int getTotalCount() {
	        return totalCount;
	    }
	 
	    public void setTotalCount(int totalCount) {
	        this.totalCount = totalCount;
	        pageCount = totalCount % pageSize == 0 ? totalCount / pageSize
	        		: totalCount / pageSize + 1;
	    }

	public Object getExtra() {
		return extra;
	}

	public void setExtra(Object extra) {
		this.extra = extra;
	}
}
