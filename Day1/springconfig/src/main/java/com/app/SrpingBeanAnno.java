package com.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.MyConfig1;
import com.config.MyConfig2;
import com.logic.A;
import com.logic.Employee;

public class SrpingBeanAnno {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig1.class, MyConfig2.class);

		//ctx.register(MyConfig.class);
		//ctx.refresh();
		
		Employee emp = ctx.getBean(Employee.class);
		emp.setName("fevbrgver");
		
		System.out.println(emp.getName());
		
		A oa = ctx.getBean(A.class, 100);
		System.out.println(oa);
		
	}

}
