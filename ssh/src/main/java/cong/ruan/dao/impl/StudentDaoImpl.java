package cong.ruan.dao.impl;

import org.springframework.stereotype.Repository;

import cong.ruan.beans.Student;

@Repository("stuDao")
public class StudentDaoImpl extends BaseDao<Student>{
	
	public Student saveStudent(Student stu){
		return save(stu);
	}
}
