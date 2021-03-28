package studentmanager;

import java.util.Scanner;

public class Operate {
	Scanner in = new Scanner(System.in);
	
	//��ӡ�˵�
	public void print() {
		System.out.println("1������ѧ����Ϣ");
		System.out.println("2��ÿ����Ϣ¼��");
		System.out.println("3����ѯѧ��ÿ�����");
		System.out.println("4���鿴����ѧ��");
		System.out.println("5��Σ��ѧ����Ϣ");
		System.out.println("6���˳�ϵͳ");
		System.out.printf("������ѡ��:");
	}
	
	//�����Ϣ
	public void add(Student[] stu, int size) {
		int length = index(stu); //��ȡ�Ѵ洢��ѧ������
		if (length >= size) {
			System.out.println("�Ѵ���"+size+"��ѧ����");
			return;
		}
		//ѧ��
		System.out.printf("������ѧ�ţ�");
		int id = in.nextInt();
		in.nextLine();  //�����س���Ӱ��
		if (notstuID(id)) {
			System.out.println("ѧ�Ŵ���");
			return;
		}
		if (exist(stu, id)) {
			System.out.println("��ѧ������Ϣ�Ѵ��ڣ�");
			return;
		}
		//����
		System.out.printf("������������");
		String name = new String(in.nextLine());
		
		//�Ƿ񽡿�
		System.out.printf("�������Ƿ񽡿���1��ʾ��0��ʾ��");
		int intishealth = in.nextInt();
		boolean ishealth;
		if (intishealth == 0) {
			ishealth = false;
		}
		else {
			ishealth = true;
		}
		
		//���ʱ��
		System.out.printf("��������ʱ�䣺");
		in.nextLine();  //�����س���Ӱ��
		String time = new String(in.nextLine());
		
		
		Student p = new Student(id, name, ishealth, time);
		stu[length] = p;
		System.out.println("��ӳɹ���");
	}
	
	//ÿ����Ϣ¼��
	public void delete(Student[] stu) {
		int i;
		int length = index(stu); //��ȡѧ������
		System.out.println("������ѧ����ѧ�ţ�");
		int deleteID = in.nextInt();
		if (!exist(stu, deleteID)) {
			System.out.println("��ѧ������Ϣ�����ڣ�");
			return;
		}
		for (i = 0; i < length; i++) {
			if (deleteID == stu[i].getstuID())
				break;
		}
		
		//�Ƿ񽡿�
		System.out.printf("�������Ƿ񽡿���1��ʾ��0��ʾ��");
		int intishealth = in.nextInt();
		boolean ishealth;
		if (intishealth == 0) {
			ishealth = false;
		}
		else {
			ishealth = true;
		}
				
		//���ʱ��
		System.out.printf("��������ʱ�䣺");
		in.nextLine();  //�����س���Ӱ��
		String time = new String(in.nextLine());
		
		stu[i].updata(ishealth, time);
		System.out.println("�Ѹ���ѧ���Ľ��ռ������");
	 }
	
	
	
	//��ѯѧ��ÿ�����
		public void search(Student[] stu) {
			int length = index(stu); //��ȡѧ������
			System.out.println("������Ҫ��ѯ��ѧ��:");
			int searchID = in.nextInt();
			for (int i = 0; i < length; i++)
				if (stu[i].getstuID() == searchID) {
					System.out.println("���ҵ���ѧ��!");
					System.out.printf("ѧ�ţ�%d\n", stu[i].getstuID());
					System.out.printf("������%s\n", stu[i].getname());
					for (int j = 0; j <= stu[i].getindex(); j++) {
						if (stu[i].getdayheal(j)) {
							System.out.printf("��%d��\tʱ�䣺%s\t�������true\n", j + 1, stu[i].getdaytime(j));
						}else {
							System.out.printf("��%d��\tʱ�䣺%s\t�������false\n", j + 1, stu[i].getdaytime(j));
						}
					}
					return;
				}
			System.out.println("δ�ҵ���ѧ��!");
			return;
		}
	
	//�鿴����ѧ��
	public void display(Student[] stu) {
		int length = index(stu);  //��ȡѧ������
		System.out.println("����ѧ������Ϣ���£�");
		for (int i = 0; i < length; i++) {
			if (stu[i].getishealth()) {
				System.out.printf("ѧ�ţ�%d\t������%s\t�������true\n",stu[i].getstuID(), stu[i].getname());
			}else {
				System.out.printf("ѧ�ţ�%d\t������%s\t�������false\n",stu[i].getstuID(), stu[i].getname());
			}
		}
	}
	
	//Σ��ѧ����Ϣ
	public void danger(Student[] stu) {
		int length = index(stu); //��ȡѧ������
		for (int i = 0; i < length; i++) {
			if (!stu[i].getishealth()) {
				System.out.printf("ѧ�ţ�%d\t������%s\t�������false\n",stu[i].getstuID(), stu[i].getname());
			}
		}
		System.out.println("���Ͼ���Σ��ѧ����Ϣ���뾡�촦��");
	}
	
	 //��ȡ��ǰѧ���ĸ���
	private int index(Student[] stu) {
		for (int i = 0; i < stu.length; i++) {
			if(stu[i] == null)    return i;
		}
		return 0;
	}
	 
	//����ѧ����Ϣ�Ƿ����
	private boolean exist(Student[] stu, int number) {
		for (int i = 0; i < index(stu); i++) {
			if (number == stu[i].getstuID())
				return true;
		}
		return false;
	}
	
	//����ѧ��ID�Ƿ���ȷ
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
