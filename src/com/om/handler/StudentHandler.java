package com.om.handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import com.om.dao.StudentTransaction;
import com.om.pojo.Student;

@Configuration
public class StudentHandler {

	@Autowired
	StudentTransaction studentDAO;

	@Transactional
	public int save(Student s) {
		try {
			int id=studentDAO.save(s);
			return id;
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		return (Integer) null;
	}
/*
	public StudentTransaction getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentTransaction studentDao) {
		this.studentDao = studentDao;
	}*/
	
}
