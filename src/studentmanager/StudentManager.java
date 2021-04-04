package studentmanager;

import java.util.Scanner;

public class StudentManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 新建 Student 对象数组
		int size = 1000;
		Student[] stu = new Student[size];
		// 新建 Operate 对象
		Operate op = new Operate();
		
		Scanner in = new Scanner(System.in);
		while(true) {
			op.print(); //打印菜单
			int option = in.nextInt();
			switch(option) {
				case 1: 
					// 1、增加学生信息
					op.add(stu, size);  //传入学生数组和数组大小
					break;
				case 2: 
					// 2、每日信息录入
					op.updata(stu); 
					break;
				case 3: 
					// 3、查询详细信息
					op.search(stu); 
					break;
				case 4: 
					// 4、查询所有学生
					op.display(stu); 
					break;
				case 5: 
					// 5、危险学生信息
					op.danger(stu); 
					break;
				case 6:
					// 退出系统
					System.out.println("您已成功退出系统。"); 
					System.exit(0);
				default: 
					System.out.println("输入错误，请重新输入:");
			}
		}
	}
}
