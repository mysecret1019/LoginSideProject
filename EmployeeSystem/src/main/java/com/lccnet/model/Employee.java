package com.lccnet.model;

public class Employee {
	private int salary;
	private int workAge;
	private int grade;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int salary, int workAge, int grade) {
		super();
		this.salary = salary;
		this.workAge = workAge;
		this.grade = grade;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getWorkAge() {
		return workAge;
	}
	public void setWorkAge(int workAge) {
		this.workAge = workAge;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	

}
