import java.io.*;
import java.util.Collection;
import java.util.Scanner;

public class Manager {
	public static void main(String[] args) {
		recover();
		while(true) {
			print(); //打印菜单
			Scanner in=new Scanner(System.in);
			int option = in.nextInt();
			switch(option) {
				case 1:
					// 1、增加
					add();
					break;
				case 2:
					// 2.查询
					query();
					break;
				case 3:
					// 3.列举
					list();
					break;
				case 4:
					// 4.打印
					save();
					break;
				case 5:
					// 5.清空
					clear();
					break;
				case 6:
					// 6.退出
					exit();
					break;
				default:
					System.out.println("输入错误，请重新输入:");
			}
		}
	}

	// 恢复备份
	private static void recover() {
		try
				(
						FileInputStream stream = new FileInputStream("students.txt");
						ObjectInputStream objectInputStream = new ObjectInputStream(stream);
				)
		{
			Object student;
			while ((student = objectInputStream.readObject()) != null) {
				Students.addStudent((Student) student);
			}
		}
		catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	// 打印菜单
	private static void print() {
		System.out.println("******欢迎进入学生管理系统******");
		System.out.println("1.增加");
		System.out.println("2.查询");
		System.out.println("3.列举");
		System.out.println("4.保存");
		System.out.println("5.清空");
		System.out.println("6.退出");
		System.out.print("请输入选项:");
	}

	// 1.增加
	private static void add() {
		// 学号
		int ID;
		Scanner in = new Scanner(System.in);
		while (true) {
			try
			{
				System.out.print("请输入学号：");
				in = new Scanner(System.in);
				ID = in.nextInt();
				if (ID < 100 || ID > 999) {
					throw new WrongValueException();
				}
				break;
			}
			catch (WrongValueException e)
			{
				System.out.println("学号不合法，请重新输入：");
			}
			catch (Exception e)
			{
				System.out.println("输入错误，请重新输入：");
			}
		}

		// 姓名
		System.out.print("请输入姓名：");
		in = new Scanner(System.in);
		String name = in.nextLine();

		// 学院
		System.out.print("请输入学院：");
		in = new Scanner(System.in);
		String college = in.nextLine();

		// 通过构造函数新建学生信息
		Student student = new Student(ID, name, college);

		// 放入 students 中
		if (Students.addStudent(student)) {
			System.out.println("添加成功！");
		}else {
			System.out.println("添加失败");
		}
	}

	// 2.查询
	private static void query() {
		System.out.print("请输入要查询的学生学号:");
		Scanner in=new Scanner(System.in);
		int ID = in.nextInt();
		Student student = Students.getStudent(ID);
		System.out.println(student == null ? "学生不存在" : "学号\t\t姓名\t\t学院\n" + student);
	}

	// 3.列举
	private static void list() {
		if (Students.isEmpty()) {
			System.out.println("还没有学生呢!");
			return;
		}
		Collection<Student> students = Students.getStudents();
		System.out.println("学号\t\t姓名\t\t学院");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	// 4.保存
	private static void save() {
		Collection<Student> students = Students.getStudents();
		System.out.println("正在保存，请等待！");
		try
		(
			FileOutputStream stream = new FileOutputStream("students.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream);
		)
		{
			for (Student student : students) {
				objectOutputStream.writeObject(student);
			}
			objectOutputStream.writeObject(null);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("保存成功！");
	}

	// 5.清空
	private static void clear() {
		Students.clear();
		save();
		System.out.println("已清空!");
	}

	// 6.退出
	private static void exit() {
		System.out.println("正在退出~");
		System.exit(0);
	}

	private Manager() {
	}
}
