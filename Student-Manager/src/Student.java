import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
	private int ID;  //学号
	private String name; //姓名
	private String college;  //学院名

	public Student(int ID, String name, String college) {
		this.ID = ID;
		this.name = name;
		this.college = college;
	}

	@Override
	public String toString() {
		return ID + "\t\t" + name + "\t\t" + college;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public Student() {
	}
}

