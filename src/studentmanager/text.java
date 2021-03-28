package studentmanager;

import java.io.FileWriter;
import java.io.PrintWriter;


public class text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw = null;
		int count=5;
		Student[] s=new Student[10];
		s[0]=new Student(001, "a");
		s[1]=new Student(002, "b");
		s[2]=new Student(003, "c");
		s[3]=new Student(004, "d");
		s[4]=new Student(005, "e");
		String savepath="admin1.txt";
		Write(savepath,s);
	}
	
	public static void Write(String savepath,Student[] s){
		try{
			PrintWriter ps = new PrintWriter(new FileWriter(savepath),true);
			ps.println(s.length);
			ps.println("学号\t姓名\t年龄\t性别\t成绩");
			for(int i=0;i<s.length-1;i++){
				ps.println(s[i].stuID+"|"+s[i].name);
			}
			ps.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
