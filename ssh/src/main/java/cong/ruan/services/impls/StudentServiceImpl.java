package cong.ruan.services.impls;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import cong.ruan.beans.Student;
import cong.ruan.dao.BaseDao;
import cong.ruan.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

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

}
