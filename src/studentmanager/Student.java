package studentmanager;

import java.util.Scanner;

public class Student {
	Scanner in = new Scanner(System.in);
	static String[] schoolname = {"占位", "通信学院", "计算机学院 ",
		     "光电学院", "自动化学院", "经管学院 ", "研究生院",
		     "外语学院", "安法学院", "体育学院", "传媒学院",
		     "先进制造学院", "马克思主义学院"};
	private int stuID;  //学号
	private String name; //姓名
	private String college;  //学院名
	private double[] temperature = new double[15];  //体温
	private boolean[] iscough = new boolean[15];  //是否咳嗽
	private boolean[] ishealth = new boolean[15];  //是否健康
	private String[] time = new String[15];  //统计时间
	private int index = -1;
	 
	// 构造函数
	Student(){
		
	}
	// 输入ID，姓名，温度，咳嗽情况，时间  自动生成学院名和健康情况
	Student(int stuID, String name, double temperature, boolean iscough, String time){
		this.stuID = stuID;
		this.name = name;
		college = schoolname[(stuID / 1000) % 100];
		index++;
		this.temperature[index] = temperature;
		this.iscough[index] = iscough;
		// 根据体温和咳嗽判断是否健康
		if (temperature < 37.3 && !iscough)
			this.ishealth[index] = true;
		else
			this.ishealth[index] = false;
		this.time[index] = time;
	}

	
	// 输入
	public void setStuID(int stuID) {
		this.stuID = stuID;
	}
	 
	public void setName(String name) {
		this.name = name;
	}
	
	// 获取信息
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
	
	// 更新内容
	public void update(double temperature, boolean iscough, String time) {		
		index++;
		this.temperature[index] = temperature;
		this.iscough[index] = iscough;
		// 根据体温和咳嗽判断是否健康
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

