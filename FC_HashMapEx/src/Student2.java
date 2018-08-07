import java.util.HashMap;
import java.util.Map;

public class Student2 {

	private String name;
	private int id;
	private Map<Course2, String> gradeMap=new HashMap<Course2, String>();
	
	public Student2(String n, int i) {
		this.name=n.trim();
		this.id=i;
	}
	
//	public void addCourseGrade(String course, String grade) {
//		gradeMap.put(new Course2(course), grade);
//	}
	
	public void addCourseGrade(Course2 course, String grade) {
		gradeMap.put(course, grade);
	}

	public boolean checkCourseExists(String courseName) {
		for(Course2 course:gradeMap.keySet()) {
			if(course.getCourse().equals(courseName)) {
				return true;
			}
		}
		return false;
	}
	
	public String getName() {
		return this.name;
	}


	public int getId() {
		return id;
	}


}
