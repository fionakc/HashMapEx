
public class CourseD3 {

	private String course;
	private int id;
	
	public CourseD3(String course, int id) {
		this.course=course;
		this.id=id;
	}
	
	public String getCourse() {
		return this.course;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getIDString() {
		return Integer.toString(this.id);
	}
	
}
