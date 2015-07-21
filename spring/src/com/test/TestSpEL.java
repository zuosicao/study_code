package com.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.beans.Person;
import com.beans.Society;

public class TestSpEL {
	public static void main(String[] args) {
		Society sociey = new Society();
		
		List<Person> members = new ArrayList<Person>();
		
		Person p1 = new Person();
		p1.setAge(22);p1.setName("p1");
		
		Person p2 = new Person();
		p2.setAge(23);p2.setName("p2");
		
		Person p3 = new Person();
		p3.setAge(16);p3.setName("p3");
		members.add(p1);
		members.add(p2);
		members.add(p3);
		
		sociey.setMembers(members);
		
		ExpressionParser eParser = new SpelExpressionParser();
		
		EvaluationContext societyContext = new StandardEvaluationContext(sociey);		
		
		List<Person> persons = (List<Person>)eParser.parseExpression("members.?[age > 20]").getValue(societyContext);
		System.out.println(persons.size());
		
	}
}
