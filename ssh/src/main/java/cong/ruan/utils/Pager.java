package cong.ruan.utils;

import java.util.List;

/**
 * 分页
 * @author ruanc
 *
 * @param <T>
 */
public class Pager<T> {

	private List<T> datas;
	private int pageSize = 10;//默认大小为10
	private int currentPage;//当前页
	private int totalPages;//总页数 
	private int total;//元素总个数
	
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if (pageSize >= 1){
			this.pageSize = pageSize;
		}
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
		if (pageSize != 0){
			this.totalPages = total % pageSize == 0 ? (total / pageSize) :  (total / pageSize + 1) ;
		}
	}
	
}
