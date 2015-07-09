package com.test;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import com.beans.Person;
import com.validations.PersonValidation;

public class TestValidation {
	public static void main(String[] args) {
		Person p = new Person();
		p.setAge(-2);
		PersonValidation pv = new PersonValidation();

		DataBinder binder = new DataBinder(p);
		binder.setValidator(pv);
		
		binder.validate();
		BindingResult bResult = binder.getBindingResult();
		System.out.println(bResult.getFieldError().getCode());
	}
}
