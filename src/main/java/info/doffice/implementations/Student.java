package info.doffice.implementations;

import info.doffice.api.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Student extends Person {

private Map<String, Float> grades;
private float average;
private boolean scholarship;
	
	
public Student(int id, String name, String surname, boolean isStudent, Map<String, Float> grades,
		float average, boolean scholarship) {
	super(id, name, surname, isStudent);
	this.grades = grades;
	this.average = average;
	this.scholarship = scholarship;
}


public void seeGrades() {
	for(Map.Entry<String, Float> entry: grades.entrySet()) {
		System.out.println(entry.getKey() + "-" + entry.getValue());
	}
}


public float calcAverage(List<Subject> subjects) {
	float avg = 0.0f;
	float w = 0.0f;
	for(Map.Entry<String, Float> entry: grades.entrySet()) {
		for(Subject s: subjects) {
			if(entry.getKey().equals(s.getName())) {
				avg += entry.getValue() * s.getEcts();
				w += s.getEcts();
			}
		}
	}
	average = avg / w;
	return average;
}


public void grantScholarship() {
	if(average >= 4.25) scholarship = true;
}


public void generateGrades(List<Subject> subjects) {
	Random r = new Random();
	for(Subject s: subjects) {
		grades.put(s.getName(), (float)(2 + r.nextInt(4)));
	}
}

public void viewDetail() {
	super.viewDetail();
	seeGrades();
	System.out.println("Scholarship = " + scholarship + ", with average = " + average);
}


public Map<String, Float> getGrades() {
	return grades;
}

public void setGrades(Map<String, Float> grades) {
	this.grades = grades;
}

public float getAverage() {
	return average;
}

public void setAverage(float average) {
	this.average = average;
}

public boolean isScholarship() {
	return scholarship;
}

public void setScholarship(boolean scholarship) {
	this.scholarship = scholarship;
}



@Override
public String toString() {
	return "Student [Id=" + getId() + ", Name=" + getName() + ", Surname=" + getSurname() + "]";
}




}
