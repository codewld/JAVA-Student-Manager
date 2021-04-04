package studentmanager;

import java.util.Scanner;

public class Student {
	Scanner in = new Scanner(System.in);
	static String[] schoolname = {"ռλ", "ͨ��ѧԺ", "�����ѧԺ ",
		     "���ѧԺ", "�Զ���ѧԺ", "����ѧԺ ", "�о���Ժ",
		     "����ѧԺ", "����ѧԺ", "����ѧԺ", "��ýѧԺ",
		     "�Ƚ�����ѧԺ", "���˼����ѧԺ"};
	private int stuID;  //ѧ��
	private String name; //����
	private String college;  //ѧԺ��
	private double[] temperature = new double[15];  //����
	private boolean[] iscough = new boolean[15];  //�Ƿ����
	private boolean[] ishealth = new boolean[15];  //�Ƿ񽡿�
	private String[] time = new String[15];  //ͳ��ʱ��
	private int index = -1;
	 
	// ���캯��
	Student(){
		
	}
	// ����ID���������¶ȣ����������ʱ��  �Զ�����ѧԺ���ͽ������
	Student(int stuID, String name, double temperature, boolean iscough, String time){
		this.stuID = stuID;
		this.name = name;
		college = schoolname[(stuID / 1000) % 100];
		index++;
		this.temperature[index] = temperature;
		this.iscough[index] = iscough;
		// �������ºͿ����ж��Ƿ񽡿�
		if (temperature < 37.3 && !iscough)
			this.ishealth[index] = true;
		else
			this.ishealth[index] = false;
		this.time[index] = time;
	}

	
	// ����
	public void setStuID(int stuID) {
		this.stuID = stuID;
	}
	 
	public void setName(String name) {
		this.name = name;
	}
	
	// ��ȡ��Ϣ
	public long getstuID() {
		return stuID;
	}
	 
	public String getname() {
		return name;
	}

	public String getcollege() {
		return college;
	}
	
	public double gettemperature() {
		return temperature[index];
	}
	
	public double gettemperature(int i) {
		return temperature[i];
	}
	
	public boolean getiscough() {
		return iscough[index];
	}
	
	public boolean getiscough(int i) {
		return iscough[i];
	}
	
	public boolean getishealth() {
		return ishealth[index];
	}
	
	public boolean getishealth(int i) {
		return ishealth[i];
	}
	
	public String gettime() {
		return time[index];
	}
	
	public String gettime(int i) {
		return time[i];
	}
	
	public int getindex() {
		return index;
	}
	
	// ��������
	public void update(double temperature, boolean iscough, String time) {		
		index++;
		this.temperature[index] = temperature;
		this.iscough[index] = iscough;
		// �������ºͿ����ж��Ƿ񽡿�
		if (temperature < 37.3 && !iscough)
			this.ishealth[index] = true;
		else
			this.ishealth[index] = false;
		this.time[index] = time;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

