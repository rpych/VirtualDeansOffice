package info.doffice.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import info.doffice.api.Person;
import info.doffice.implementations.Student;
import info.doffice.implementations.Subject;
import info.doffice.implementations.Teacher;
import static java.lang.Integer.parseInt;


// serves IO (serialization) and collections operations  
public class ControllerDAO {

private List<Subject> subjects;
private List<Student> students;
private List<Teacher> teachers;


public void writeStudentsToFile() {
	try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./database-files/students.bin"))){
		out.writeObject(students);
	}catch(FileNotFoundException e) {
		System.out.println("File not found ");
		e.printStackTrace();
	}catch(IOException e) {
		System.out.println("Problem with IO operation");
		e.printStackTrace();
	}
}


public void readstudentsFromFile() {
	try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("./database-files/students.bin"))){
		students = (List<Student>) in.readObject();
	} catch (FileNotFoundException e) {
		System.out.println("File not found ");
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("Problem with IO operation");
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		System.out.println("Cannot cast to List<Student> ");
		e.printStackTrace();
	}
}

public void writeTeachersToFile() {
	try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./database-files/teachers.bin"))){
		out.writeObject(teachers);
	}catch(FileNotFoundException e) {
		System.out.println("File not found ");
		e.printStackTrace();
	}catch(IOException e) {
		System.out.println("Problem with IO operation");
		e.printStackTrace();
	}
}

public void readTeachersFromFile() {
	try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("./database-files/teachers.bin"))){
		teachers = (List<Teacher>) in.readObject();
	} catch (FileNotFoundException e) {
		System.out.println("File not found ");
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("Problem with IO operation");
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		System.out.println("Cannot cast to List<Student> ");
		e.printStackTrace();
	}
}


public boolean personExists(String login, List< ? extends Person> people) {
	for(Person person: people) {
		if(parseInt(login) == (person.getId())) return true;
	}
	return false;
}


public Subject getMySubject(String subject) {
	for(Subject s: subjects) {
		if(s.getName().equals(subject)) return s;
	}
	return null;
}


public Person getPersonByLogin(int login) {
	for(Student s: students) {
		if(s.getId() == login) return s; 
	}
	for(Teacher t: teachers) {
		if(t.getId() == login) return t;
	}
	return null;
}


public void updateStudentDetails() {
	for(Student s: students) {
		s.calcAverage(subjects);
		s.grantScholarship();
	}
}

//additional, helpful function
public void deletePerson(int login) {
	Person p = getPersonByLogin(login);
	if(p instanceof Student) students.remove(p);
	else if (p instanceof Teacher) teachers.remove(p);
}


public List<Student> getStudents() {
	return students;
}

public void setStudents(List<Student> students) {
	this.students = students;
}

public List<Teacher> getTeachers() {
	return teachers;
}

public void setTeachers(List<Teacher> teachers) {
	this.teachers = teachers;
}

public List<Subject> getSubjects() {
	return subjects;
}

public void setSubjects(List<Subject> subjects) {
	this.subjects = subjects;
}
	


	
}
