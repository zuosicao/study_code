package cong.ruan.actions;

public class Index extends BaseAction {
	private static final long serialVersionUID = 7961846712231772686L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String execute(){
		System.out.println("Index action invoked!!");
		return SUCCESS;
	}
	
}
