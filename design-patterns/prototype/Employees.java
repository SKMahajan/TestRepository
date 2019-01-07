package com.dec.designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable{

	private List<String> empList;

	public Employees(List<String> empList) {
		this.empList = empList;
	}

	public Employees() {
		empList = new ArrayList<>();
	}

	public void loadData() {
		empList.add("asd");
		empList.add("xzc");
		empList.add("xcv");
		empList.add("fdg");
		empList.add("tyl");
		empList.add("piu");
	}

	public List<String> getEmpList() {
		return empList;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		List<String> temp = new ArrayList<>();
		for (String s :this.getEmpList()) {
			temp.add(s);
		}
		return new Employees(temp);
	}

	@Override
	public String toString() {
		return "Employees [empList=" + empList + "]";
	}
	
	
}
