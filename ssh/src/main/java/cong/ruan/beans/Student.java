package cong.ruan.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stu_students")
public class Student {
	
	@Id
	@GeneratedValue
	@Column(name="stu_id")
	private Integer id;
	
	@Column(name="stu_name")
	private String name;
	
	@Column(name="stu_money")
	private double money;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
}
