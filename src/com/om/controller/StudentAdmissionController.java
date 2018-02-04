package com.om.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.om.configuration.HibernateUtil;
import com.om.pojo.Address;
import com.om.pojo.Student;
import com.om.handler.StudentHandler;
import com.om.propertyeditor.SkillDataBinder;
import com.om.propertyeditor.StudentNameEditor;

@Controller
public class StudentAdmissionController {

	@Autowired
	StudentHandler studentHandler;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		//binder.setDisallowedFields(new String[] {"studentMobile"});
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy****MM****dd");
		//binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
		binder.registerCustomEditor(HashSet.class, "skills", new SkillDataBinder());
	}

	@RequestMapping(value="/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {

		ModelAndView model1 = new ModelAndView("AdmissionForm");
		return model1;
	}

	@ModelAttribute
    public void addingCommonObjects(Model model1) {
		
		model1.addAttribute("headerMessage", "Gontu College of Engineering, India");
	}

	@RequestMapping(value="/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("student1") Student student, BindingResult result,SessionLocaleResolver  locale) {
		
		 if (result.hasErrors()) {
			 	
				ModelAndView model1 = new ModelAndView("exception");
				return model1;
		 }
		/*Session session=HibernateUtil.getSessionFactory().openSession();
		Student s= new Student();
		s.setStudentName(student.getStudentName());*/
		
		try {
			if(student!=null) {
			int id=studentHandler.save(student);
			student.setId(id);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView model1 = new ModelAndView("AdmissionSuccess");
		model1.addObject("student1",student);
		return model1;
		
	}
	
	//Webservice
	/*@RequestMapping(value="/students",method=RequestMethod.GET)
	@ResponseBody
	public String Exceptionhandler() throws JsonProcessingException {
		ArrayList<Student> list= new ArrayList<Student>();
		list.add(new Student("Om","Coding",new Address("Pune")));
		list.add(new Student("Swapnil","Wealth",new Address("Pune")));
		list.add(new Student("Amit","Business",new Address("Delhi")));
		list.add(new Student("Khushboo","Analytics",new Address("Mumbai")));
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(list);
		jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
		return jsonInString;
	}*/
	
}

