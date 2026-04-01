package com.net.c;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TestB {

	public static void main(String[] args) {
		
		

		Employees ll=new Employees();
		
		List<Employees> listEmployees=ll.listEmployees();
		
		
List<Object> names=		listEmployees.stream()
		.collect(Collectors.mapping(e->e.getSalary(), Collectors.toList()));

	

List<String> salaryGreater=  listEmployees.stream()
  .filter(e->e.getSalary()>3000)
  .collect(Collectors.mapping(e->e.getFirstName(), Collectors.toList()));



Set<Object> salariesSet=  listEmployees.stream()
  .collect(Collectors.mapping(e->e.getSalary()>5000, Collectors.toSet()));


Map<String,List<Integer>> grouptIdDepartment=            listEmployees.stream()
            .collect(Collectors.groupingBy(
            		e->e.getDepartment(),
            		Collectors.mapping(e->e.getId(), Collectors.toList())
            		));


Map<String,Integer> sumSalarys=   listEmployees.stream()
   .collect(Collectors.groupingBy(e->e.getDepartment(),
		   Collectors.summingInt(e->e.getSalary())
		   ));


 Map<String,Integer> sumSal=       listEmployees.stream()
        .collect(Collectors.groupingBy(e->e.getDepartment(),
        		Collectors.summingInt(e->e.getSalary())
        		));
            
 sumSal.forEach((a,b)->{
	  System.out.println(a+" :"+b);
	  
  });
	}

}
