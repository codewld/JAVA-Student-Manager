package studentmanager;

import java.util.Scanner;

public class StudentManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("******欢迎进入学生管理系统******\n");
		int size = 100;  //学生数量
		Student[] stu = new Student[size];
		Operate op = new Operate();
		while(true) {
			op.print(); //打印菜单
			int option = in.nextInt();
			switch(option) {
				case 1: 
					op.add(stu, size);  //传入学生数组和数组大小
					break;
				case 2: 
					op.delete(stu); 
					break;
				case 3: 
					op.search(stu); 
					break;
				case 4: 
					op.display(stu); 
					break;
				case 5: 
					op.danger(stu); 
					break;
				case 6:
					System.out.println("退出系统，再见。"); 
					System.exit(0);
				default: 
					System.out.println("输入错误，请重新输入:");
			}
		}
	}
}
