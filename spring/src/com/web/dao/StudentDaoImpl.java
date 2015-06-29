package com.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.web.beans.Student;

public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao {

	@Override
	public List<Student> getPageStudent(int pageNum) {
		int start = (pageNum - 1) * DEFAULT_STUDENT_PER_PAGE_NUM;// 相应页数的数据开始位置
		int end = pageNum * DEFAULT_STUDENT_PER_PAGE_NUM;// 结束位置

		return getJdbcTemplate().query(PAGE_STUDENT_SQL, new Object[] { start, end },
				new int[] { Types.INTEGER, Types.INTEGER }, new RowMapper<Student>() {

					@Override
					public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						Student stu = new Student();
						stu.setStuId(rs.getInt(STU_ID_COL));
						stu.setAge(rs.getInt(STU_AGE_COL));
						stu.setName(rs.getString(STU_NAME_COL));
						stu.setSex(rs.getString(STU_SEX_COL));
						stu.setStuNum(rs.getInt(STU_NUM_COL));
						return stu;
					}
				});
	}
	
	/*public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/web/configs/dao.xml");
		StudentDao stuDao = context.getBean("stuDao",StudentDao.class);
		System.out.println(stuDao.getPageStudent(1).get(0).getName());
	}*/

}
