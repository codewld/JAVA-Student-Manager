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
	private boolean[] ishealth = new boolean[15];
	private String[] time = new String[15];
	private int index = -1;
	 
	//���캯��
	Student(){
		
	}
	
	Student(int instuID, String inname, boolean inishealth, String intime){
		stuID = instuID;
		name = inname;
		college = schoolname[(stuID / 1000) % 100];
		index++;
		ishealth[index] = inishealth;
		time[index] = intime;
    }

	//����
	public void setStuID(int instuID) {
	 	stuID = instuID;
	}
	 
	public void setName(String inname) {
	 	name = inname;
	}
	
	//��ȡ��Ϣ
	public long getstuID() {
		return stuID;
	}
	 
	public String getname() {
		return name;
	}

	public String getcollege() {
		return college;
	}
	
	public boolean getishealth() {
		return ishealth[index];
	}
	
	public boolean getdayheal(int i) {
		return ishealth[i];
	}
	
	public String gettime() {
		return time[index];
	}
	
	public String getdaytime(int i) {
		return time[i];
	}
	
	public int getindex() {
		return index;
	}
	
	//��������
	public void updata(boolean inishealth, String intime) {
		index++;
		ishealth[index] = inishealth;
		time[index] = intime;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

