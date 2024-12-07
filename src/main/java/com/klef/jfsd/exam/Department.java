package com.klef.jfsd.exam;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department_table")
public class Department 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int department_id;
	
	@Column(name = "dname",length = 25,nullable = false)
	private String name;
	
	@Column(name = "dlocation",length = 25,nullable = false)
	private String location;
	
	@Column(name = "dhodname",length = 25,nullable = false)
	private String HoDName;

	@Override
	public String toString() {
		return "\nDepartment \ndepartment_id=" + department_id + "\nname=" + name + "\nlocation=" + location + "\nHoDName="
				+ HoDName;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHoDName() {
		return HoDName;
	}

	public void setHoDName(String hoDName) {
		HoDName = hoDName;
	}
}
