package studentmanager;

import java.util.Scanner;

public class StudentManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int size = 100;  //ѧ������
		Student[] stu = new Student[size];
		Operate op = new Operate();
		while(true) {
			op.print(); //��ӡ�˵�
			int option = in.nextInt();
			switch(option) {
				case 1: 
					// 1������ѧ����Ϣ
					op.add(stu, size);  //����ѧ������������С
					break;
				case 2: 
					// 2��ÿ����Ϣ¼��
					op.updata(stu); 
					break;
				case 3: 
					// 3����ѯÿ����Ϣ
					op.search(stu); 
					break;
				case 4: 
					// 4����ѯ����ѧ��
					op.display(stu); 
					break;
				case 5: 
					// 5��Σ��ѧ����Ϣ
					op.danger(stu); 
					break;
				case 6:
					// �˳�ϵͳ
					System.out.println("���ѳɹ��˳�ϵͳ��"); 
					System.exit(0);
				default: 
					System.out.println("�����������������:");
			}
		}
	}
}
