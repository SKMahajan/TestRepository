package com.dec.designpatterns.prototype;

import java.util.List;

public class PrototypePatternTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		Employees emps = new Employees();
		emps.loadData();
		Employees empNew = (Employees)emps.clone();
		Employees empNew1 = (Employees)emps.clone();
		List<String> list = empNew.getEmpList();
		list.add("pankaj");
		List<String> list1 = empNew1.getEmpList();
		list1.remove("asd");
		
		System.out.println("empNew : "+empNew);
		System.out.println("empNew1 :"+empNew1);
	}
	
}
