package info.doffice.api;

import java.io.Serializable;

public class Person implements Serializable{


	
private int id;
private String name;
private String surname;
private boolean isStudent;
private String password;


public Person(int id, String name, String surname, boolean isStudent) {
	this.id = id;
	this.name = name;
	this.surname = surname;
	this.isStudent = isStudent;
}


public void viewDetail() {
	System.out.println("Personal data: \n"
			+ toString());
}


public void setSafePassword(String password) {
	setPassword(password);
}

public String getSafePassword() {
	String passw = getPassword();
	return passw;
}

private String getPassword() {
	return password;
}

private void setPassword(String password) {
	this.password = password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public boolean isStudent() {
	return isStudent;
}
public void setStudent(boolean isStudent) {
	this.isStudent = isStudent;
}


@Override
public String toString() {
	return "Person [id=" + id + ", name=" + name + ", surname=" + surname + "]";
}




	
	
}
