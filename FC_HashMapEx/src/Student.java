import java.util.ArrayList;

public class Student {

	private String name;
	//private String course;
	private ArrayList<String> courses=new ArrayList<>();
	//private String grade;
	private ArrayList<String> grades=new ArrayList<>();
	private int id;
	
	public Student(String n, String c, String g,int i) {
		this.name=n;
		this.courses.add(c);
		this.grades.add(g);
		this.id=i;
	}
	
	public String toString() {
		return this.name+" "+this.id;
	}
	
	public void printCourseGrade() {
		for (int i=0;i<courses.size();i++){
			System.out.println("Course "+courses.get(i)+" has grade "+grades.get(i));
		}
	}
	
	public void addCourseGrade(String c,String g ) {
//		boolean replaced=false;
//		for(int i=0;i<courses.size();i++) {
//			if(courses.get(i).equals(c) && grades.get(i).equals("-")) {
//				grades.set(i,g);
//				replaced=true;
//				break;
//			}
//		}
//		if(!replaced) {
			this.courses.add(c);
			this.grades.add(g);
//		}
		
	}

	//The grades the student received in all courses they have completed
	public void coursesComplete() {
		for (int i=0;i<courses.size();i++){
			if(!grades.get(i).equals("-")) {
				System.out.println("Course "+courses.get(i)+" has grade "+grades.get(i));
			}
		}
	}
	
	//A list of all courses the student is currently enrolled in (those which do not yet have grades)
	public void coursesIncomplete() {
		for (int i=0;i<courses.size();i++){
			if(grades.get(i).equals("-")) {
				System.out.println("Course "+courses.get(i)+" has grade "+grades.get(i));
			}
		}
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getCourse() {
//		return this.course;
//	}
//
//	public void setCourse(String course) {
//		this.course = course;
//	}

//	public String getGrade() {
//		return tgrade;
//	}

//	public void setGrade(String grade) {
//		this.grade = grade;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
