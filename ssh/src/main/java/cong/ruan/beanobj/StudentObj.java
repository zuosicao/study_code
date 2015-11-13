package cong.ruan.beanobj;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class StudentObj {
	private List<String> nameList;
	
	private List<StudentObj> datas;
	private String name;
	private Integer id;
	private Integer totle;
	
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
	
	
}
