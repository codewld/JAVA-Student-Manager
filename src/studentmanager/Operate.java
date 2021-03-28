package studentmanager;

import java.util.Scanner;

public class Operate {
	Scanner in = new Scanner(System.in);
	
	//打印菜单
	public void print() {
		System.out.println("1、增加学生信息");
		System.out.println("2、每日信息录入");
		System.out.println("3、查询学生每日情况");
		System.out.println("4、查看所有学生");
		System.out.println("5、危险学生信息");
		System.out.println("6、退出系统");
		System.out.printf("请输入选项:");
	}
	
	//添加信息
	public void add(Student[] stu, int size) {
		int length = index(stu); //获取已存储的学生个数
		if (length >= size) {
			System.out.println("已存满"+size+"个学生！");
			return;
		}
		//学号
		System.out.printf("请输入学号：");
		int id = in.nextInt();
		in.nextLine();  //消除回车的影响
		if (notstuID(id)) {
			System.out.println("学号错误！");
			return;
		}
		if (exist(stu, id)) {
			System.out.println("该学生的信息已存在！");
			return;
		}
		//姓名
		System.out.printf("请输入姓名：");
		String name = new String(in.nextLine());
		
		//是否健康
		System.out.printf("请输入是否健康：1表示是0表示否");
		int intishealth = in.nextInt();
		boolean ishealth;
		if (intishealth == 0) {
			ishealth = false;
		}
		else {
			ishealth = true;
		}
		
		//检查时间
		System.out.printf("请输入检查时间：");
		in.nextLine();  //消除回车的影响
		String time = new String(in.nextLine());
		
		
		Student p = new Student(id, name, ishealth, time);
		stu[length] = p;
		System.out.println("添加成功！");
	}
	
	//每日信息录入
	public void delete(Student[] stu) {
		int i;
		int length = index(stu); //获取学生个数
		System.out.println("请输入学生的学号：");
		int deleteID = in.nextInt();
		if (!exist(stu, deleteID)) {
			System.out.println("该学生的信息不存在！");
			return;
		}
		for (i = 0; i < length; i++) {
			if (deleteID == stu[i].getstuID())
				break;
		}
		
		//是否健康
		System.out.printf("请输入是否健康：1表示是0表示否");
		int intishealth = in.nextInt();
		boolean ishealth;
		if (intishealth == 0) {
			ishealth = false;
		}
		else {
			ishealth = true;
		}
				
		//检查时间
		System.out.printf("请输入检查时间：");
		in.nextLine();  //消除回车的影响
		String time = new String(in.nextLine());
		
		stu[i].updata(ishealth, time);
		System.out.println("已更新学生的今日检测数据");
	 }
	
	
	
	//查询学生每日情况
		public void search(Student[] stu) {
			int length = index(stu); //获取学生个数
			System.out.println("请输入要查询的学号:");
			int searchID = in.nextInt();
			for (int i = 0; i < length; i++)
				if (stu[i].getstuID() == searchID) {
					System.out.println("已找到该学生!");
					System.out.printf("学号：%d\n", stu[i].getstuID());
					System.out.printf("姓名：%s\n", stu[i].getname());
					for (int j = 0; j <= stu[i].getindex(); j++) {
						if (stu[i].getdayheal(j)) {
							System.out.printf("第%d天\t时间：%s\t健康与否：true\n", j + 1, stu[i].getdaytime(j));
						}else {
							System.out.printf("第%d天\t时间：%s\t健康与否：false\n", j + 1, stu[i].getdaytime(j));
						}
					}
					return;
				}
			System.out.println("未找到该学生!");
			return;
		}
	
	//查看所有学生
	public void display(Student[] stu) {
		int length = index(stu);  //获取学生个数
		System.out.println("所有学生的信息如下：");
		for (int i = 0; i < length; i++) {
			if (stu[i].getishealth()) {
				System.out.printf("学号：%d\t姓名：%s\t健康与否：true\n",stu[i].getstuID(), stu[i].getname());
			}else {
				System.out.printf("学号：%d\t姓名：%s\t健康与否：false\n",stu[i].getstuID(), stu[i].getname());
			}
		}
	}
	
	//危险学生信息
	public void danger(Student[] stu) {
		int length = index(stu); //获取学生个数
		for (int i = 0; i < length; i++) {
			if (!stu[i].getishealth()) {
				System.out.printf("学号：%d\t姓名：%s\t健康与否：false\n",stu[i].getstuID(), stu[i].getname());
			}
		}
		System.out.println("以上就是危险学生信息，请尽快处理！");
	}
	
	 //获取当前学生的个数
	private int index(Student[] stu) {
		for (int i = 0; i < stu.length; i++) {
			if(stu[i] == null)    return i;
		}
		return 0;
	}
	 
	//检索学生信息是否存在
	private boolean exist(Student[] stu, int number) {
		for (int i = 0; i < index(stu); i++) {
			if (number == stu[i].getstuID())
				return true;
		}
		return false;
	}
	
	//检索学生ID是否正确
	private boolean notstuID(int num) {
		if (num/100000<=2019 && num/100000>=2016 && (num/1000)%100>=1 && (num/1000)%100<=12){
            return false;
        }
		else return true;
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
