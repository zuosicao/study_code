package cong.ruan.beanobj;

import java.util.List;

public class StudentObj {
	private List<String> nameList;
	
	private List<StudentObj> datas;
	private String name;
	private int id;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
}
