import java.util.ArrayList;

public class Course {

	private String course;
	private ArrayList<String> names=new ArrayList<>();
	private ArrayList<String> grades=new ArrayList<>();
	
	public Course(String course) {
		this.course=course;
	}
	
	public Course(String course, String name, String grade) {
		this.course=course;
		this.names.add(name);
		this.grades.add(grade);
	}
	
	public boolean studentInCourse(String name) {
		for(int i=0;i<names.size();i++) {
			if(name.equals(names.get(i))) {
				return true;
			}
		}
		return false;
	}
	
	public void addData(String name, String grade) {
		this.names.add(name);
		this.grades.add(grade);
	}
	
	public String getCourse() {
		return this.course;
	}
	
	public boolean setGrade(String name, String grade) {
		for(int i=0;i<this.names.size();i++) {
			if(this.names.get(i).equals(name)) {
				this.grades.set(i, grade);
				return true;
				
			}
		}
		return false;
	}
	
	//How many students are in the course >> all - + grade
	public void printAllStudent() {
		for (int i=0;i<names.size();i++){
			System.out.println(names.get(i)+" has grade "+grades.get(i));
		}
	}
	
	
	
	//All students currently enrolled in the course >> all -
	public void printStudentEnrolled() {
		for (int i=0;i<names.size();i++){
			if(grades.get(i).equals("-")) {
				System.out.println(names.get(i)+" has grade "+grades.get(i));
			}
		}
	}
	
	
	//The grades given to all students who have completed the course >> all grade
	public void printStudentCompleted() {
		for (int i=0;i<names.size();i++){
			if(!grades.get(i).equals("-")) {
				System.out.println(names.get(i)+" has grade "+grades.get(i));
			}
		}
	}
}
