package info.doffice.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import info.doffice.implementations.Student;
import info.doffice.implementations.Subject;
import info.doffice.implementations.Teacher;

public class Main {

public static void main(String[] args) {
	
ApplicationContext xmlContext = new ClassPathXmlApplicationContext("context.xml");
Subject os = xmlContext.getBean("os", Subject.class);
Subject stat = xmlContext.getBean("stat", Subject.class);
ControllerDAO con = xmlContext.getBean("controllerDAO", ControllerDAO.class);
UserInterface mainController = xmlContext.getBean("mainController", UserInterface.class);



System.out.println("Przedmiot os " + os);
System.out.println("Przedmiot stat " + stat);
for(Subject subject: con.getSubjects())
	System.out.println("Przedmiot: " + subject);


mainController.enterService();

List<Student> st = mainController.getController().getStudents();
for(Student s: st)
	System.out.println("student: " + s);

	
List<Teacher> tch = mainController.getController().getTeachers();
for(Teacher t: tch)
	System.out.println("teacher: " + t);
}
}
