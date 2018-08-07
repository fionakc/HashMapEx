
public class StudentD3 {

	private String name;
	private int id;
	
	public StudentD3(String name, int id) {
		this.name=name;
		this.id=id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getIDString() {
		return Integer.toString(this.id);
	}
}
