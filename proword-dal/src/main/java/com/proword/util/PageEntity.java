package com.proword.util;

/**
 * 
* @ClassName: PageEntity 
* @Description: 分页设置
* @author zhuweimin
* @date 2017年9月25日 上午11:01:51 
*
 */
public class PageEntity {
	/**当前页数,从1开始 */
	private int currentPage = 1;

	/**总页数*/
	private int totalPage;
    
    private int lpage;
    
    private int rpage;
	
    private int totalItemsCount;
    
	/**
	 * 每页数据条数
	 */
	private int pageSize = 10;

    // 上页
    private int upper;
    
    // 下页
    private int next;
	

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * 计算总页数
	 * 
	 * @return
	 */
	public void getPageCount(int totalItemsCount) {
		this.totalItemsCount = totalItemsCount;

		totalPage = totalItemsCount / pageSize;
		if (totalItemsCount % pageSize > 0) {
			totalPage++;
		}
		 //分页计算
        int leftcount =2,    //需要向上一页执行多少次
            rightcount =2;
        //起点页
        this.lpage =currentPage;
        //结束页
        this.rpage =currentPage;
        
        //2点判断
        this.lpage = currentPage-leftcount;            //正常情况下的起点
        this.rpage = currentPage+rightcount;        //正常情况下的终点
        
        //页差=总页数和结束页的差
        int topdiv = this.totalPage-rpage;                //判断是否大于最大页数
        
        /***
         * 起点页
         * 1、页差<0  起点页=起点页+页差值
         * 2、页差>=0 起点和终点判断
         */   
        this.lpage=topdiv<0? this.lpage+topdiv:this.lpage;
        
        /***
         * 结束页
         * 1、起点页<=0   结束页=|起点页|+1
         * 2、起点页>0    结束页
         */
        this.rpage=this.lpage<=0? this.rpage+(this.lpage*-1)+1: this.rpage;
        
        /***
         * 当起点页<=0  让起点页为第一页
         * 否则不管
         */
        this.lpage=this.lpage<=0? 1:this.lpage;
        
        /***
         * 如果结束页>总页数   结束页=总页数 
         * 否则不管
         */
        this.rpage=this.rpage>totalPage? this.totalPage:this.rpage;
	}

	public int getLpage() {
		return lpage;
	}

	public void setLpage(int lpage) {
		this.lpage = lpage;
	}

	public int getRpage() {
		return rpage;
	}

	public void setRpage(int rpage) {
		this.rpage = rpage;
	}
	 //上一页
    public int getUpper() {
        return currentPage>1? currentPage-1: currentPage;
    }
    public int getNext() {
        return  currentPage<totalPage? currentPage+1: totalPage;
    }

	/**
	 * @return the totalItemsCount
	 */
	public int getTotalItemsCount() {
		return totalItemsCount;
	}

	/**
	 * @param totalItemsCount the totalItemsCount to set
	 */
	public void setTotalItemsCount(int totalItemsCount) {
		this.totalItemsCount = totalItemsCount;
	}

	/**
	 * @param upper the upper to set
	 */
	public void setUpper(int upper) {
		this.upper = upper;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(int next) {
		this.next = next;
	}
    
	
}
