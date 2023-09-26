package javaProgramPackage;

import java.io.*;
import java.util.*;
 
/**
 * Student.java
 * @author Manikandan Ravi
 */

public class Student extends Person implements Serializable {
    public static final long serialVersionUID = 1234L;
 
    private long studentId;
    private String name;
    private transient int age; //Important place to be noted
 
    public Student(long studentId, String name, int age) {
        super();
        this.studentId = studentId;
        this.name = name;
        this.age = age;
 
        System.out.println("Constructor");
    }
    
    public String toString() {
        return String.format("%d - %s - %d", studentId, name, age);
    }
}
