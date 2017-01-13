package javacommon.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Paginator
 * @Description 分页器
 * @author Andy
 */
public class Paginator<T>{
	
	public static final int DEFAULT_PAGESIZE = 15;
	
	public static final int DEFAULT_CURRENTPAGE = 1; 

	private int pageSize;
	
	private int currentPage;
	
	private long total;
	
	private List<T> dataList;			//数据列表

	private Map<String, Object> criteria; //查询条件

	private String solrSortCriteria; //solr排序字段

	private String[] solrField = {"bid", "createTime", "bType", "bTypeName", "content"}; //solr需要返回的字段

	private boolean sortDesc = true;
	
	public Paginator() {
		this(DEFAULT_CURRENTPAGE);
	}
	
	public Paginator(int currentPage) {
		this(currentPage, DEFAULT_PAGESIZE);
	}
	
	public Paginator(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getStart() {
		return pageSize * (currentPage-1);
	}
	
	public long getEnd() {
		return pageSize * currentPage -1;
	}
	
	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	public void setParam(String key, Object value) {
		if (criteria == null) criteria = new HashMap<String, Object>();
		criteria.put(key, value);
	}
	
	public void setCriteria(Map<String, Object> criteria) {
		this.criteria = criteria;
	}

	public Map<String, Object> getCriteria() {
        if (criteria == null) {
            criteria = new HashMap<String, Object>();
        }
        return criteria;
	}

	public String getSolrSortCriteria() {
		return solrSortCriteria;
	}

	public void setSolrSortCriteria(String solrSortCriteria) {
		this.solrSortCriteria = solrSortCriteria;
	}

	public boolean isSortDesc() {
		return sortDesc;
	}

	public void setSortDesc(boolean sortDesc) {
		this.sortDesc = sortDesc;
	}

	public String[] getSolrField() {
		return solrField;
	}

	public void setSolrField(String[] solrField) {
		this.solrField = solrField;
	}
}
