package cong.ruan.beanobj;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class StudentObj extends BaseObj{
	private List<String> nameList;
	
	private List<StudentObj> datas;
	private String name;
	private Integer id;
	private Integer totle;
	
	private int results;//记录总数
	private boolean hasError; //是否存在错误
	private String error;
	private List<StudentObj> rows;
	
	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StudentObj> getRows() {
		return rows;
	}

	public void setRows(List<StudentObj> rows) {
		this.rows = rows;
	}

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	public List<StudentObj> getDatas() {
		return datas;
	}

	public void setDatas(List<StudentObj> datas) {
		this.datas = datas;
	}

	public Integer getTotle() {
		return totle;
	}

	public void setTotle(Integer totle) {
		this.totle = totle;
	}

	public int getResults() {
		return results;
	}

	public void setResults(int results) {
		this.results = results;
	}

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
}
