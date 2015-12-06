package cong.ruan.services.impls;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import cong.ruan.beanobj.StudentObj;
import cong.ruan.beans.Student;
import cong.ruan.dao.BaseDao;
import cong.ruan.services.StudentService;
import cong.ruan.utils.Constants;
import cong.ruan.utils.Pager;

@Service
public class StudentServiceImpl implements StudentService {

	private static String GET_STUDENT_BY_NAME = "select stu_name `name`,stu_id `id` from stu_students where stu_name = ?";
	private static String GET_STUDENTS_INFO = "select stu_name `name`,stu_id `id` from stu_students";
	private static String GET_ALL_STUDENTS = "select stu_name `name`,stu_id `id` from stu_students";
	
	private static String GET_STUDENTS_INFO_HQL = "select stu.id as id,stu.name as name from Student stu";
	
	@Resource
	private BaseDao baseDao;
	
	@Override
	public Student saveStudent(Student stu) {
		return baseDao.save(stu);
	}

	@Override
	public Student getStudentById(Integer id) {
		return baseDao.get(id, Student.class);
	}

	@Override
	public void saveAllStudentsOrNone(Student[] stus) throws Exception {
		int i = 0;
		for (Student stu : stus) {
			if (i == 2){
				System.out.println(">>is 2");
				//throw new RuntimeException();
			}
			baseDao.save(stu);
			i++;
		}
	}

	@Override
	@Transactional(isolation=Isolation.SERIALIZABLE)
	public void reduceMoney(Integer stuId, Double money) {
		Student stu = baseDao.get(stuId, Student.class);
		if (stu != null){
			if (stu.getMoney() < money){
				System.out.println("钱少了！！");
				return ;
			}else{
				try {
					Thread.sleep(8000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				stu.setMoney(stu.getMoney() - money);
				Student add = new Student();
				add.setName("added");
				baseDao.save(add);
				System.out.println("付款一次");
				baseDao.update(stu);
			}
		}
	}

	@Override
	public StudentObj getOneStudentByName(String name) {
		if (name == null){
			return null;
		}
		
		return baseDao.getObjectBySql(GET_STUDENT_BY_NAME, new Object[]{name}, StudentObj.class);
	}

	@Override
	public StudentObj getPageStudent(Integer page, Integer pageSize) {
		StudentObj result = new StudentObj();

		//Pager<StudentObj> aPage = baseDao.pagerListObjToEntityBySql(GET_STUDENTS_INFO, null, StudentObj.class, page, pageSize);
		Pager<StudentObj> aPage = baseDao.pagerListObjToEntityByHql(GET_STUDENTS_INFO_HQL, null, StudentObj.class, page, pageSize);

		result.setDatas(aPage.getDatas());
		result.setTotle(aPage.getTotal());
		return result;
	}

	@Override
	public List<StudentObj> getAllStudents() {
	  return baseDao.listAllToEntityBySql(GET_ALL_STUDENTS, null, StudentObj.class);
	}

	@Override
	public Pager<StudentObj> pagerStudent(Integer page, Integer pageSize) {
		return baseDao.pagerListObjToEntityByHql(GET_STUDENTS_INFO_HQL, null, StudentObj.class, page, pageSize);
	}

}
