package com.web.services;

import java.util.List;

import com.web.beans.Student;

public interface StudentSerivce {
  public List<Student> getPageStudent(int pageNum);
}
