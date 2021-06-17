import java.util.Scanner;

public class Operate {
	Scanner in = new Scanner(System.in);

	// 打印菜单
	public void print() {
		System.out.println("******欢迎进入学生管理系统******\n");
		System.out.println("1、增加学生信息");
		System.out.println("2、每日信息录入");
		System.out.println("3、查询详细信息");
		System.out.println("4、查询所有学生");
		System.out.println("5、危险学生信息");
		System.out.println("6、退出系统");
		System.out.printf("请输入选项:");
	}

	// 1.增加学生信息
	public void add(Student[] stu, int size) {
		int length = stunum(stu);  // 获取已存储的学生个数
		if (length >= size) {
			System.out.println("已存满"+size+"个学生！");
			return;
		}

		// 学号
		System.out.printf("请输入学号：");
		int id = in.nextInt();
		if (notstuID(id)) {
			System.out.println("学号错误！");
			return;
		}
		if (exist(stu, id)) {
			System.out.println("该学生的信息已存在！");
			return;
		}

		// 姓名
		System.out.printf("请输入姓名：");
		in.nextLine();  //消除回车的影响
		String name = new String(in.nextLine());

		// 体温
		System.out.printf("请输入体温：");
		double temperature = in.nextDouble();

		// 是否咳嗽
		System.out.printf("请输入是否咳嗽：（1表示是 0表示否）");
		int intishealth = in.nextInt();
		boolean iscough = false;
		if (intishealth == 1) {
			iscough = true;
		}

		// 检查时间
		System.out.printf("请输入检查时间：");
		in.nextLine();  //消除回车的影响
		String time = new String(in.nextLine());

		// 通过构造函数新建学生信息
		Student p = new Student(id, name, temperature, iscough, time);
		stu[length] = p;
		System.out.println("添加成功！");
	}

	// 2、每日信息录入
	public void updata(Student[] stu) {
		int i;
		int length = stunum(stu); //获取学生个数

		// 判断学生是否存在，并找到他
		System.out.println("请输入学生的学号：");
		int stuID = in.nextInt();
		if (!exist(stu, stuID)) {
			System.out.println("该学生的信息不存在！");
			return;
		}
		for (i = 0; i < length; i++) {
			if (stuID == stu[i].getstuID())
				break;
		}

		// 体温
		System.out.printf("请输入体温：");
		double temperature = in.nextDouble();

		// 是否咳嗽
		System.out.printf("请输入是否咳嗽：（1表示是 0表示否）");
		int intishealth = in.nextInt();
		boolean iscough = false;
		if (intishealth == 1) {
			iscough = true;
		}

		// 检查时间
		System.out.printf("请输入检查时间：");
		in.nextLine();  //消除回车的影响
		String time = new String(in.nextLine());

		// 通过update方法更新每日信息
		stu[i].update(temperature, iscough, time);
		System.out.println("已更新学生的今日检测数据");
	}

	// 3、查询详细信息
	public void search(Student[] stu) {
		int length = stunum(stu); //获取学生个数
		System.out.println("请输入要查询的学号:");
		int searchID = in.nextInt();
		for (int i = 0; i < length; i++)
			if (stu[i].getstuID() == searchID) {
				System.out.println("已找到该学生!");
				System.out.printf("学号：%d\n", stu[i].getstuID());
				System.out.printf("姓名：%s\n", stu[i].getname());
				System.out.printf("学院：%s\n", stu[i].getcollege());
				for (int j = 0; j <= stu[i].getindex(); j++) {
					System.out.printf("第"+(j+1)+"天\t时间："+stu[i].gettime(j)+"\t体温："+stu[i].gettemperature(j)
							+"\t 咳嗽："+stu[i].getiscough(j)+"\t健康："+stu[i].getishealth(j)+"\n");
				}
				return;
			}
		System.out.println("未找到该学生!");
		return;
	}

	// 4、查询所有学生
	public void display(Student[] stu) {
		int length = stunum(stu);  //获取学生个数
		System.out.println("所有学生的信息如下：");
		for (int i = 0; i < length; i++) {
			System.out.printf("学号："+stu[i].getstuID()+"\t姓名："+stu[i].getname()+"\t学院："+stu[i].getcollege()
					+"\t健康："+stu[i].getishealth(i)+"\n");
		}
	}

	// 5、危险学生信息
	public void danger(Student[] stu) {
		int length = stunum(stu); //获取学生个数
		for (int i = 0; i < length; i++) {
			if (!stu[i].getishealth()) {
				System.out.printf("学号：%d\t姓名：%s\t学院：%s\t健康：false\n",stu[i].getstuID(), stu[i].getname(), stu[i].getcollege());
			}
		}
		System.out.println("以上为危险学生信息，请尽快处理！");
	}

	// 获取当前学生的个数
	private int stunum(Student[] stu) {
		for (int i = 0; i < stu.length; i++) {
			if(stu[i] == null)    return i;
		}
		return 0;
	}

	// 检索学生信息是否存在
	private boolean exist(Student[] stu, int number) {
		for (int i = 0; i < stunum(stu); i++) {
			if (number == stu[i].getstuID())
				return true;
		}
		return false;
	}

	// 检索学生ID是否正确
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
