package studentmanager;

import java.util.Scanner;

public class StudentManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("******��ӭ����ѧ������ϵͳ******\n");
		int size = 100;  //ѧ������
		Student[] stu = new Student[size];
		Operate op = new Operate();
		while(true) {
			op.print(); //��ӡ�˵�
			int option = in.nextInt();
			switch(option) {
				case 1: 
					op.add(stu, size);  //����ѧ������������С
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
					System.out.println("�˳�ϵͳ���ټ���"); 
					System.exit(0);
				default: 
					System.out.println("�����������������:");
			}
		}
	}
}
