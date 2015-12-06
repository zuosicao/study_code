package cong.ruan.beanobj;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import cong.ruan.utils.Code;

@JsonInclude(Include.NON_NULL)
public class BaseObj {
	
	private String code; //接口调用结果编码
	private String information;//接口调用结果信息
	
	private Integer currentPage;//当前页
	private Integer totalPages;//总页数
	private Integer total;//总纪录数
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getInformation() {
		return information;
	}


	public void setInformation(String information) {
		this.information = information;
	}


	/**
	 * 设置结果编码 和结果 信息
	 * @param code
	 * @param information
	 * void
	 */
	public void setCodeAndInfo(String code,String information){
		setCode(code);
		setInformation(information);
	}
	
	
	/**
	 * 打印异常，构造异常信息
	 * @param ex
	 * void
	 */
	public void handleException(Exception ex){
		ex.printStackTrace();
		this.setCodeAndInfo(Code.EXCEPTION_CODE, "发生异常");
	}
	
	/**
	 * 处理参数错误异常
	 * @param ex
	 * void
	 */
	public void handleParmarError(){
		this.setCodeAndInfo(Code.PARAMS_ERROR_CODE, "参数不正确");
	}
	
	public void handleSuccess(){
		this.setCodeAndInfo(Code.SUCCESS_CODE, "操作成功");
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
}
