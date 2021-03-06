package com.web.dao.interfaces;

import java.util.List;

import com.web.beans.Student;

public interface StudentDao {
	// student 实体数据库中对应的列名
	public static String STU_ID_COL = "stu_id";
	public static String STU_AGE_COL = "stu_age";
	public static String STU_SEX_COL = "stu_sex";
	public static String STU_NAME_COL = "stu_name";
	public static String STU_NUM_COL = "stu_num";

	public static final int DEFAULT_STUDENT_PER_PAGE_NUM = 10;
	public static final String PAGE_STUDENT_SQL = "select * from students limit ?,?";
	public static final String INSERT_STUDENT = "insert into students (" + STU_ID_COL
			+ "," + STU_SEX_COL + ","+ STU_NAME_COL  + "," +STU_NUM_COL + "," + STU_AGE_COL  +") values (null,?,?,?,?)";

	public List<Student> getPageStudent(int pageNum);

	public Student saveStudent(Student stu);
}
