import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapExample {

	private String testPath="C:\\Users\\crookfion\\Downloads\\data.txt";
	//or drop data.txt into package and don't need file path
	private Map<Integer,Student> studentMap=new HashMap<Integer,Student>();
	private Map<Integer,Course> courseMap=new HashMap<Integer,Course>();
	
	public HashMapExample() {
		
	}
	
	public static void main(String[] args) {
		
		HashMapExample hash1 =new HashMapExample();		
		hash1.loadStudentData();
		hash1.printStudentData();
		
		HashMapExample hash2 =new HashMapExample();
		hash2.loadCourses();
		//hash2.printCourseData();
		
//		hash2.newCourse("SWEN501");
//		hash2.printCourseData();
		
		//hash1.addStudent("John Smith");
		//hash1.unenrollStudent("Mark White", "WRIT101");
		//hash1.printStudentData();
		
//		hash2.enrollStudent("WRIT102","Mark While");
//		hash2.assignGrade("WRIT101", "Mark White", "-");
	}
	
	
	public void printStudentData() {
		System.out.println("Student List");
		for(Integer i: studentMap.keySet()) {
			System.out.println("ID: "+i+" Student: "+studentMap.get(i).getName());
			studentMap.get(i).printCourseGrade();
			//studentMap.get(i).coursesComplete();
			//studentMap.get(i).coursesIncomplete();
		}
	}
	
	
	public void printCourseData() {
		System.out.println("Course List");
		for(Integer i: courseMap.keySet()) {
			System.out.println("ID: "+i+" Course: "+courseMap.get(i).getCourse());
			//courseMap.get(i).printAllStudent();
			//courseMap.get(i).printStudentEnrolled();
			//courseMap.get(i).printStudentCompleted();
			
		}
	}
	
	public int findLastKeyCourse(Map<Integer, Course> map) {
		int lastID=Integer.MIN_VALUE;
		for(Integer id:map.keySet()) {
			if(id>lastID) {
				lastID=id;
			}
		}
		return lastID;
	}
	
	public int findLastKeyStudent(Map<Integer, Student> map) {
		int lastID=Integer.MIN_VALUE;
		for(Integer id:map.keySet()) {
			if(id>lastID) {
				lastID=id;
			}
		}
		return lastID;
	}
	
	//Enroll a student into a course
	public void enrollStudent(String courseName, String stuName) {
		boolean enrolled=false;
		for(Integer id:courseMap.keySet()) {
			if(courseName.equals(courseMap.get(id).getCourse())) {
				if(!courseMap.get(id).studentInCourse(stuName)) {
					courseMap.get(id).addData(stuName, "-");
					System.out.println(stuName+" has been added to "+courseName);
					enrolled=true;
					break;
				} else {
					System.out.println(stuName+" is already in "+courseName);
				}
				
			}
		}
		if(!enrolled) {
			System.out.println(stuName+" could not be added to "+courseName);
		}
	}
	
	//Create a new course in the system
	public void newCourse(String newCourseName) {
		boolean canAdd=true;
		//find last key value used
		int newID=findLastKeyCourse(courseMap)+1;
		for(Integer id:courseMap.keySet()) {
			if(newCourseName.equals(courseMap.get(id).getCourse())){
				canAdd=false;
				System.out.println("Sorry, this course is already in use");
				break;
			}
		}
		if(canAdd) {
			courseMap.put(newID, new Course(newCourseName));
			System.out.println(newCourseName+" has been added.");
		} else {
			System.out.println("Cannot add "+newCourseName+" into system.");
		}
	}
	
	//Assign a grade to a student in a course <<maybe not working
	public void assignGrade(String course, String stuName,String grade) {
		boolean assigned=false;
		for(Integer id:courseMap.keySet()) {
			if(courseMap.get(id).getCourse().equals(course)) {
				assigned=courseMap.get(id).setGrade(stuName, grade);
			}
		}
		if(assigned) {
			System.out.println("Grade changed");
		} else {
			System.out.println("Grade change failed");
		}
	}
	
	//Unenroll a student from a course
	public void unenrollStudent(String stuName, String course) {
		for(Integer id: studentMap.keySet()) {
			if(studentMap.get(id).getName().equals(stuName)) {
				studentMap.get(id).removeCourse(course);
				System.out.println(stuName+" has been removed from "+course);			
			}
		}
	}
	
	
	//Add a new student to the system, with a unique name and ID number
	public void addStudent(String newName) {
		boolean canAdd=true;
		int newID=findLastKeyStudent(studentMap)+1;
		for(Integer id:studentMap.keySet()) {
			if(newName.equals(studentMap.get(id).getName())) {
				canAdd=false;
				System.out.println("Sorry, this name is already in use");
				break;
			}
		}
		if(canAdd) {
			studentMap.put(newID,new Student(newName,newID));
			System.out.println(newName+" has been added.");
		}else {
			System.out.println("Cannot add "+newName+" into system.");
		}
	}
	
	
	//Add a new student to the system, with a unique name and ID number
	public void addStudentAllValues(String n, String c, String g, int i) {
		boolean canAdd=true;
		//check id not used
		for(Integer id:studentMap.keySet()) {
			if(i==id) {
				canAdd=false;
				System.out.println("Sorry, this id is already in use");
				break;
			}
		}		
		//check student name not used
		for(Integer id:studentMap.keySet()) {
			if(n.equals(studentMap.get(id).getName())){
				canAdd=false;
				System.out.println("Sorry, this name is already in use");
				break;
			}
		}
		if(canAdd) {
			studentMap.put(i, new Student(n,c,g,i));
		}
	}
	
	
	public void loadCourses() {
		try {
			Scanner scan=new Scanner(new File(testPath));
			int id=1;
			String course=scan.next();
			String grade=scan.next();
			String name=scan.nextLine().trim();
			Course cTemp=new Course(course,name,grade);
			courseMap.put(id, cTemp);
			id++;
			while(scan.hasNext()) {
				course=scan.next();
				grade=scan.next();
				name=scan.nextLine().trim();
				boolean inList=false;
				int idtemp=0;
				for(Integer i:courseMap.keySet()) {
					if(course.equals(courseMap.get(i).getCourse())) {
						inList=true;
						idtemp=i;
						break;						
					} 

				} //end for every element				
				if(inList) {
					courseMap.get(idtemp).addData(name,grade);
				} else {
					Course cTemp1=new Course(course,name,grade);
					courseMap.put(id, cTemp1);
					id++;
				}
			} //end while
			scan.close();
		}catch(IOException e){System.out.println("Table loading failed: "+e);}
	}
	
	
	public void loadStudentData() {
		System.out.println("loading students");
		try {
			Scanner scan=new Scanner(new File(testPath));
			int id=1000000;
			String course=scan.next();
			String grade=scan.next();
			String name=scan.nextLine().trim();
			Student sTemp=new Student(name,course,grade,id);
			studentMap.put(id, sTemp);
			id++;
			while(scan.hasNext()) {
				course=scan.next();
				grade=scan.next();
				name=scan.nextLine().trim();
				boolean inList=false;
				int idtemp=0;
				for(Integer i:studentMap.keySet()) {
					if(name.equals(studentMap.get(i).getName())) {					
						inList=true;
						idtemp=i;
						break;											
					} 
				} //end for every element
				if(inList) {
					studentMap.get(idtemp).addCourseGrade(course,grade);
				} else {
					Student sTemp1=new Student(name,course,grade,id);
					studentMap.put(id, sTemp1);
					id++;
				}
			} //end while
			scan.close();
		}catch(IOException e){System.out.println("Table loading failed: "+e);}
	}
	
}
