package com.om.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.om.pojo.Skill;

import javassist.bytecode.Descriptor.Iterator;

public class SkillDataBinder extends PropertyEditorSupport {
	 
	@Override
	public void setValue(Object value) {
		System.out.println(value.getClass());
		String[] value1 =	(String[]) value;
			Set<Skill> skills = new HashSet<Skill>();
			for (int i=0;i<value1.length;i++) {
				Skill skill = new Skill();
				skill.setName(value1[i]);
				skills.add(skill);
			}
			super.setValue(skills);
	}
		
	

}
