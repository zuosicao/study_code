package cong.ruan.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cong.ruan.beanobj.StudentObj;
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
	
	public StudentObj getOneStudentByName(String name);
	
	/**
	 * 分页得到数据
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public StudentObj getPageStudent(Integer page,Integer pageSize);
	
	public List<StudentObj> getAllStudents();
}
