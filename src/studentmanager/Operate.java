package studentmanager;

import java.util.Scanner;

public class Operate {
	Scanner in = new Scanner(System.in);
	
	//��ӡ�˵�
	public void print() {
		System.out.println("******��ӭ����ѧ������ϵͳ******\n");
		System.out.println("1������ѧ����Ϣ");
		System.out.println("2��ÿ����Ϣ¼��");
		System.out.println("3����ѯ��ϸ��Ϣ");
		System.out.println("4����ѯ����ѧ��");
		System.out.println("5��Σ��ѧ����Ϣ");
		System.out.println("6���˳�ϵͳ");
		System.out.printf("������ѡ��:");
	}
	
	// 1.����ѧ����Ϣ
	public void add(Student[] stu, int size) {
		int length = stunum(stu);  // ��ȡ�Ѵ洢��ѧ������
		if (length >= size) {
			System.out.println("�Ѵ���"+size+"��ѧ����");
			return;
		}
		
		// ѧ��
		System.out.printf("������ѧ�ţ�");
		int id = in.nextInt();
		if (notstuID(id)) {
			System.out.println("ѧ�Ŵ���");
			return;
		}
		if (exist(stu, id)) {
			System.out.println("��ѧ������Ϣ�Ѵ��ڣ�");
			return;
		}
		
		// ����
		System.out.printf("������������");
		in.nextLine();  //�����س���Ӱ��
		String name = new String(in.nextLine());
		
		// ����
		System.out.printf("���������£�");
		double temperature = in.nextDouble();
		
		// �Ƿ����
		System.out.printf("�������Ƿ���ԣ���1��ʾ�� 0��ʾ��");
		int intishealth = in.nextInt();
		boolean iscough = false;
		if (intishealth == 1) {
			iscough = true;
		}
		
		// ���ʱ��
		System.out.printf("��������ʱ�䣺");
		in.nextLine();  //�����س���Ӱ��
		String time = new String(in.nextLine());
		
		// ͨ�����캯���½�ѧ����Ϣ
		Student p = new Student(id, name, temperature, iscough, time);
		stu[length] = p;
		System.out.println("��ӳɹ���");
	}
	
	// 2��ÿ����Ϣ¼��
	public void updata(Student[] stu) {
		int i;
		int length = stunum(stu); //��ȡѧ������
		
		// �ж�ѧ���Ƿ���ڣ����ҵ���
		System.out.println("������ѧ����ѧ�ţ�");
		int stuID = in.nextInt();
		if (!exist(stu, stuID)) {
			System.out.println("��ѧ������Ϣ�����ڣ�");
			return;
		}
		for (i = 0; i < length; i++) {
			if (stuID == stu[i].getstuID())
				break;
		}
		
		// ����
		System.out.printf("���������£�");
		double temperature = in.nextDouble();
		
		// �Ƿ����
		System.out.printf("�������Ƿ���ԣ���1��ʾ�� 0��ʾ��");
		int intishealth = in.nextInt();
		boolean iscough = false;
		if (intishealth == 1) {
			iscough = true;
		}
		
		// ���ʱ�� 
		System.out.printf("��������ʱ�䣺");
		in.nextLine();  //�����س���Ӱ��
		String time = new String(in.nextLine());
		
		// ͨ��update��������ÿ����Ϣ
		stu[i].update(temperature, iscough, time);
		System.out.println("�Ѹ���ѧ���Ľ��ռ������");
	 }
	
	// 3����ѯ��ϸ��Ϣ
	public void search(Student[] stu) {
		int length = stunum(stu); //��ȡѧ������
		System.out.println("������Ҫ��ѯ��ѧ��:");
		int searchID = in.nextInt();
		for (int i = 0; i < length; i++)
			if (stu[i].getstuID() == searchID) {
				System.out.println("���ҵ���ѧ��!");
				System.out.printf("ѧ�ţ�%d\n", stu[i].getstuID());
				System.out.printf("������%s\n", stu[i].getname());
				System.out.printf("ѧԺ��%s\n", stu[i].getcollege());
				for (int j = 0; j <= stu[i].getindex(); j++) {
					System.out.printf("��"+(j+1)+"��\tʱ�䣺"+stu[i].gettime(j)+"\t���£�"+stu[i].gettemperature(j)
							+"\t ���ԣ�"+stu[i].getiscough(j)+"\t������"+stu[i].getishealth(j)+"\n");
				}
				return;
			}
		System.out.println("δ�ҵ���ѧ��!");
		return;
	}
	
	// 4����ѯ����ѧ��
	public void display(Student[] stu) {
		int length = stunum(stu);  //��ȡѧ������
		System.out.println("����ѧ������Ϣ���£�");
		for (int i = 0; i < length; i++) {
			System.out.printf("ѧ�ţ�"+stu[i].getstuID()+"\t������"+stu[i].getname()+"\tѧԺ��"+stu[i].getcollege()
					+"\t������"+stu[i].getishealth(i)+"\n");
		}
	}
	
	// 5��Σ��ѧ����Ϣ
	public void danger(Student[] stu) {
		int length = stunum(stu); //��ȡѧ������
		for (int i = 0; i < length; i++) {
			if (!stu[i].getishealth()) {
				System.out.printf("ѧ�ţ�%d\t������%s\tѧԺ��%s\t������false\n",stu[i].getstuID(), stu[i].getname(), stu[i].getcollege());
			}
		}
		System.out.println("����ΪΣ��ѧ����Ϣ���뾡�촦��");
	}
	
	 //��ȡ��ǰѧ���ĸ���
	private int stunum(Student[] stu) {
		for (int i = 0; i < stu.length; i++) {
			if(stu[i] == null)    return i;
		}
		return 0;
	}
	 
	//����ѧ����Ϣ�Ƿ����
	private boolean exist(Student[] stu, int number) {
		for (int i = 0; i < stunum(stu); i++) {
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
