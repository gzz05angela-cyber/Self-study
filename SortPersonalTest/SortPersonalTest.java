package SortPersonalTest;

import java.util.ArrayList;
import java.util.List;

public class SortPersonalTest {
    public static void main(String[] args) {
        new SortPersonalTest().go();
    }

    public void go(){
        List<Student> studentList = SampleStudents.getGrade();
        System.out.println(studentList);

        studentList.sort((one, two) -> Integer.compare(one.getGrade(), two.getGrade()));
        System.out.println(studentList);

        studentList.sort((one, two) -> one.getName().compareTo(two.getName()));
        System.out.println(studentList);
    }
}

class SampleStudents{
    public static List<Student> getGrade(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Jame", 67));
        students.add(new Student("Washa", 87));
        students.add(new Student("Lily", 100));
        return students;
    }
}

class Student implements Comparable<Student>{
    private String name;
    private int grade;

    Student(String name, int grade){
        this.name = name;
        this.grade = grade;
    }

    public String getName(){
        return name;
    }

    public int getGrade(){
        return grade;
    }

    @Override
    public int compareTo(Student other){
        return Integer.compare(this.grade, other.grade);
    }

    @Override
    public String toString(){
        return name + ": " + grade;
    }
}
