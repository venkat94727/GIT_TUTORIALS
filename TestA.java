package com.net.c;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.net.b.Employee;
import com.net.b.TEST_F;

public class TestA {

	public static void main(String[] args) {
		
	
		Employees ll=new Employees();
		
		List<Employees> listEmployees=ll.listEmployees();
		
		
		
		
		
Object name=		listEmployees.stream()
		.collect(Collectors.collectingAndThen(
				Collectors.maxBy(Comparator.comparing(e->e.getSalary()))
				, empOtp->empOtp.map(e->e.getFirstName()))).get();
	
	
Object nameTwo=	               listEmployees.stream()
               .collect(Collectors.collectingAndThen(
            		   Collectors.minBy(Comparator.comparing(e->e.getSalary()))
            		   , emps->emps.map(e->e.getFirstName())));
System.out.println(nameTwo);



        
	}

}
