package org.hibernate.tutorial.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mg_user")
public class Mg_user {			//用户信息表
	
	private int userid;				//用户编号			
	private String mobilephone;   //手机号
	private String email;        //邮箱
	private String password;     //密码
	private String username;     //姓名
	private String nickname;     //昵称
	private Date birthday;      //生日
//	private Mg_area area;        //地区 关联地区表
	private String address;    //详细地址
	private int age;           //年龄
	private String sex;        //性别
	private String degree;     //学历
	private String marriage;   //婚姻状况 
	private String constellation;  //星座
	private int integrel;     //积分 关联积分表
	private String profile;	//个人简介
	private int level;	//等级(治愈师等级划分1-5星)
	private String goodat;	//擅长
	private int consultancy;//所属咨询机构*  关联咨询机构表
	private int usetype;//用户类型(0代表普通用户,1代表治愈师,2代码咨询机构,888,,普通管理员,999超级管理员)
	private int experience;//经验值
	// 头像
	private String headerimage;
	//是否设置手势密码（1为已设置，2为未设置）
	private String gesture;
	
    private int is_delete;//是否删除 0否  1是
    private int is_block;//是否被屏蔽 0否 1是
    private int is_hide;//是否被隐藏 0否 1是

	//private Mg_consultancy Mg_consultancy;//所属咨询机构*  关联咨询机构表
	//private Mg_qualifications_info qualifications_info;//资质信息
	//private Set<Mg_area_user> area_user;	//地区 用户所在的地区
	
	//private Set<Mg_order_info> order_info;//用户订单
	//private Set<Mg_appointment> appointment;//用户预约
    //private Set<Mg_article> artice;  //用户发表的文章
	//private Mg_coin usercoin;	//用户心灵币
	//private Set<Mg_question> question; //用户提问
	//private Set<Mg_question_reply> question_reply; //用户问题回复
	//private Set<Mg_evaluate>evaluate;	//用户评论

	
	@Id
	@GeneratedValue
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getMobilephone() {
		return mobilephone;
	}
	
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getMarriage() {
		return marriage;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	public String getConstellation() {
		return constellation;
	}
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "userid")
//	public Mg_integrel getIntegrel() {
//		return integrel;
//	}
//	public void setIntegrel(Mg_integrel integrel) {
//		this.integrel = integrel;
//	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
	public String getProfile() {
		return profile;
	}

	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getGoodat() {
		return goodat;
	}
	public void setGoodat(String goodat) {
		this.goodat = goodat;
	}

	public int getUsetype() {
		return usetype;
	}
	public void setUsetype(int usetype) {
		this.usetype = usetype;
	}
	public int getConsultancy() {
		return consultancy;
	}
	public void setConsultancy(int consultancy) {
		this.consultancy = consultancy;
	}
	public String getHeaderimage() {
		return headerimage;
	}
	public void setHeaderimage(String headerimage) {
		this.headerimage = headerimage;
	}
	public String getGesture() {
		return gesture;
	}
	public void setGesture(String gesture) {
		this.gesture = gesture;
	}
	public int getIntegrel() {
		return integrel;
	}
	public void setIntegrel(int integrel) {
		this.integrel = integrel;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}
	public int getIs_block() {
		return is_block;
	}
	public void setIs_block(int is_block) {
		this.is_block = is_block;
	}
	public int getIs_hide() {
		return is_hide;
	}
	public void setIs_hide(int is_hide) {
		this.is_hide = is_hide;
	}
	

	//订单信息
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="userid")
//	public Set<Mg_order_info> getOrder_info() {
//		return order_info;
//	}
//	public void setOrder_info(Set<Mg_order_info> order_info) {
//		this.order_info = order_info;
//	}
	
//	//预约
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="userid")
//	public Set<Mg_appointment> getAppointment() {
//		return appointment;
//	}
//	public void setAppointment(Set<Mg_appointment> appointment) {
//		this.appointment = appointment;
//	}
//	
//	
//	//文章
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="userid")
//	public Set<Mg_article> getArtice() {
//		return artice;
//	}
//	public void setArtice(Set<Mg_article> artice) {
//		this.artice = artice;
//	}
//	
//	//心灵币
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "userid")
//	public Mg_coin getUsercoin() {
//		return usercoin;
//	}
//	public void setUsercoin(Mg_coin usercoin) {
//		this.usercoin = usercoin;
//	}
	
	
//	//咨询机构
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "userid")
//	public Mg_consultancy getMg_consultancy() {
//		return Mg_consultancy;
//	}
//	public void setMg_consultancy(Mg_consultancy mg_consultancy) {
//		Mg_consultancy = mg_consultancy;
//	}
//	
//	
//	//资质信息
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "userid")
//	public Mg_qualifications_info getQualifications_info() {
//		return qualifications_info;
//	}
//	public void setQualifications_info(Mg_qualifications_info qualifications_info) {
//		this.qualifications_info = qualifications_info;
//	}
//	
//	
//	//用户提问
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="userid")
//	public Set<Mg_question> getQuestion() {
//		return question;
//	}
//	public void setQuestion(Set<Mg_question> question) {
//		this.question = question;
//	}
//	
//	
//	//用户提问回复
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="userid")
//	public Set<Mg_question_reply> getQuestion_reply() {
//		return question_reply;
//	}
//	public void setQuestion_reply(Set<Mg_question_reply> question_reply) {
//		this.question_reply = question_reply;
//	}
//	
//	
//	//用户评论
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="userid")
//	public Set<Mg_evaluate> getEvaluate() {
//		return evaluate;
//	}
//	public void setEvaluate(Set<Mg_evaluate> evaluate) {
//		this.evaluate = evaluate;
//	}
	
	
	//用户所在地区   认证的时候会有区域选择  所以暂时以一对多
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="userid")
//	public Set<Mg_area_user> getArea_user() {
//		return area_user;
//	}
//	public void setArea_user(Set<Mg_area_user> area_user) {
//		this.area_user = area_user;
//	}
//	
	
	
	
	

}
