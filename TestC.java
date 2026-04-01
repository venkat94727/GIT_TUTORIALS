package com.net.c;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestC {

	public static void main(String[] args) {
	
		

		Employees ll=new Employees();
		
		List<Employees> listEmployees=ll.listEmployees();
		
		
List<Employees> greterSalarys=		listEmployees.stream()
		.collect(Collectors.filtering(e->e.getSalary()>3000, Collectors.toList()));

 Map<String,List<Employees>>   deptCollectEmployee=listEmployees.stream()
   .collect(Collectors.groupingBy(e->e.getDepartment(),
		   Collectors.filtering(e->e.getSalary()>4500, Collectors.toList())
		   
	
		   ));
 
 
  List<Object> listsl=   listEmployees.stream()
                         .collect(Collectors.filtering(e->e.getSalary()>3000, Collectors.mapping(e->e.getFirstName(), Collectors.toList())));
  
	
  listsl.forEach((a)->{
	System.out.println(a+":");
});


	
	}

}
