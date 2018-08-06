import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapExample {

	private String testPath="C:\\Users\\crookfion\\Downloads\\data.txt";
	private Map<Integer,Student> studentMap=new HashMap<Integer,Student>();
	private Map<Integer,Course> courseMap=new HashMap<Integer,Course>();
	
	public HashMapExample() {
		
	}
	
	public static void main(String[] args) {
		
		HashMapExample hash1 =new HashMapExample();
		
		//hash1.loadStudentData();
		//hash1.loadStudents();
		//hash1.printData();
		
		HashMapExample hash2 =new HashMapExample();
		hash2.loadCourses();
		hash2.printCourseData();
		
		
	}
	
	public void printData() {
		System.out.println("List");
		for(Integer i: studentMap.keySet()) {
			System.out.println("ID: "+i+" Student: "+studentMap.get(i).getName());
			studentMap.get(i).printCourseGrade();
			//studentMap.get(i).coursesComplete();
			//studentMap.get(i).coursesIncomplete();
		}
	}
	
	public void printCourseData() {
		System.out.println("List");
		for(Integer i: courseMap.keySet()) {
			System.out.println("ID: "+i+" Course: "+courseMap.get(i).getCourse());
			courseMap.get(i).printStudentGrade();
			//studentMap.get(i).coursesComplete();
			//studentMap.get(i).coursesIncomplete();
		}
	}
	
	
	public void loadCourses() {
		try {
			Scanner scan=new Scanner(new File(testPath));
			int id=1;
			String course=scan.next();
			String grade=scan.next();
			String name=scan.nextLine();
			Course cTemp=new Course(course,name,grade);
			courseMap.put(id, cTemp);
			id++;
			while(scan.hasNext()) {
				course=scan.next();
				grade=scan.next();
				name=scan.nextLine();
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
			}
			
		}catch(IOException e){System.out.println("Table loading failed: "+e);}
	}
	
	public void loadStudents() {
		
		for (int i=1;i<6;i++) {
			Student temp=new Student("stu"+i,"course","grade",i);
			studentMap.put(i,temp);
		}
		
		
	}
	
	public void loadStudentData() {
		System.out.println("loading students");
		//ArrayList<String> studentTemp=new ArrayList<String>();
		try {
			//System.out.println("trying");
			Scanner scan=new Scanner(new File(testPath));
			//System.out.println("created scanner");
			int id=1000000;
			String course=scan.next();
			String grade=scan.next();
			String name=scan.nextLine();
			//String fullname=name+" "+scan.next();
			Student sTemp=new Student(name,course,grade,id);
			//System.out.println("First student "+sTemp.toString());
			studentMap.put(id, sTemp);
			id++;
			while(scan.hasNext()) {
				//System.out.println("scan has next");
				course=scan.next();
				grade=scan.next();
				name=scan.nextLine();
				//fullname=name+" "+scan.next();
				//System.out.println(course+" "+grade+" "+name);
				boolean inList=false;
				int idtemp=0;
				for(Integer i:studentMap.keySet()) {
					//System.out.println(studentMap.get(i).toString());
					//System.out.println("for every key");
				
					if(name.equals(studentMap.get(i).getName())) {
						//System.out.println("if already on list");
						inList=true;
						idtemp=i;
						break;
						//studentMap.get(i).addCourseGrade(course, grade);
						
					} //else {
//						System.out.println("add into list");
//						Student sTemp1=new Student(name,course,grade,id);
//						studentMap.put(id, sTemp1);
//						id++;
//					}
				} //end for every element
				if(inList) {
					studentMap.get(idtemp).addCourseGrade(course,grade);
				} else {
					//System.out.println("add into list");
					Student sTemp1=new Student(name,course,grade,id);
					studentMap.put(id, sTemp1);
					id++;
				}
			}
			scan.close();
		}catch(IOException e){System.out.println("Table loading failed: "+e);}
		
		//return null;
	}
	
}

/**public String[ ][ ] loadTable( ){
try {
Scanner sc = new Scanner(new File(UIFileChooser.open()));
int rows =sc.nextInt();
int cols = sc.nextInt();
String[ ][ ] ans = new String[ rows ][ cols ];
for (int row=0; row<rows; row++){
for (int col=0; col<cols; col++){
	ans[row][col] = sc.next();
}
}
return ans;
} catch(IOException e){UI.out.println("Table loading failed: "+e);}
return null;
}
*/