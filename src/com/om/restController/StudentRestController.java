package com.om.restController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.om.pojo.Address;
import com.om.pojo.Student;

@RestController
public class StudentRestController {


	//@RequestMapping(value="/students",method=RequestMethod.GET)
	@ResponseBody
	@GetMapping("/students")
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
	}
	@ResponseBody
	@RequestMapping(value="/students/{name}",method=RequestMethod.GET)
	public Student studentName(@PathVariable("name") String name) throws JsonProcessingException {
		Student s = new Student();
		s.setStudentName(name);
		ArrayList<String> l= new ArrayList<String>();
		l.add("Java");
		l.add("Oracle");
		s.setStudentSkills(l);
		return s;
		
	}

}
