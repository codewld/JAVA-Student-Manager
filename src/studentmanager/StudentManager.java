package studentmanager;

import java.util.Scanner;

public class StudentManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �½� Student ��������
		int size = 1000;
		Student[] stu = new Student[size];
		// �½� Operate ����
		Operate op = new Operate();
		
		Scanner in = new Scanner(System.in);
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
					// 3����ѯ��ϸ��Ϣ
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
