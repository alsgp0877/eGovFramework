package com.rubypaper.persistence.mybatis;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeVO {

	private Long id;//직원아이디
	private String name;//직원이름
	private Timestamp startDate;//입사일
	private String title;//직급
	private String deptName;//부서이름
	private Double salary;//급여
	
/*	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeVO [id=" + id + ", name=" + name + ", startDate=" + startDate + ", title=" + title
				+ ", deptName=" + deptName + ", salary=" + salary + "]";
	}*/
	
	

}
