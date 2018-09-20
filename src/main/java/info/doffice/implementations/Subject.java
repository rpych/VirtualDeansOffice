package info.doffice.implementations;

import java.io.Serializable;

public class Subject implements Serializable{

private String name;
private float ects;
private String subjectType;


public Subject(String name, float ects, String subjectType) {
	super();
	this.name = name;
	this.ects = ects;
	this.subjectType = subjectType;
}



public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getEcts() {
	return ects;
}
public void setEcts(float ects) {
	this.ects = ects;
}
public String getSubjectType() {
	return subjectType;
}
public void setSubjectType(String subjectType) {
	this.subjectType = subjectType;
}



@Override
public String toString() {
	return "Subject [name=" + name + ", ects=" + ects + ", subjectType=" + subjectType + "]";
} 



	
	
}
