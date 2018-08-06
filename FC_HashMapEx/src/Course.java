import java.util.ArrayList;

public class Course {

	private String course;
	private ArrayList<String> names=new ArrayList<>();
	private ArrayList<String> grades=new ArrayList<>();
	
	
	public Course(String course, String name, String grade) {
		this.course=course;
		this.names.add(name);
		this.grades.add(grade);
	}
	
	public void addData(String name, String grade) {
		this.names.add(name);
		this.grades.add(grade);
	}
	
	public String getCourse() {
		return this.course;
	}
	
	public void printStudentGrade() {
		for (int i=0;i<names.size();i++){
			System.out.println(names.get(i)+" has grade "+grades.get(i));
		}
	}
}
