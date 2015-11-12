package cong.ruan.services;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import cong.ruan.beans.Student;

public interface StudentService {

	public Student saveStudent(Student stu);
	
	public Student getStudentById(Integer id);
	
	/**
	 * 全部保存成功或者全部失败
	 * @param stus
	 */
	@Transactional
	public void saveAllStudentsOrNone (Student[] stus) throws Exception;
	
	/**
	 * 减少钱,减一次钱加一个学生记录
	 * @param stuId
	 * @param money
	 */
	public void reduceMoney(Integer stuId,Double money);
}
