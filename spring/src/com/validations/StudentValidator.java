package com.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.web.beans.Student;

/**
 * 
 * @author ruanc
 *可以通过这种方式来验证输入  ，调用Error.reject()方法后，将错误信息存储在ObjectError中
 */
public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> classs) {
		return Student.class.equals(classs);
	}

	@Override
	public void validate(Object obj, Errors error) {
		Student stu = (Student)obj;

		if (stu.getAge() >= 88)
		{
			//error.reject("age2","invalidateAge");
			error.rejectValue("age","age.old","年龄太大了");
			System.out.println("年龄太大了>>>>>>>");
		}
		if (stu.getStu().getName().equals("123")){
			error.rejectValue("stu.name","","里面的姓名不能为123");
		}
	}

}
