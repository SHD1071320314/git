package com.signin.pojo;

public class Accounts {
	private int teacher_id;//��ʦ���
	private String teacher_name;//��ʦ����
	private String teacher_url;//��ʦ����
	private String teacher_password;//��ʦ����
	private int teacher_enable;//�ʺŷ��ʹ��
	private int judge;//�ж��Ƿ�ض�ά��
	
	@Override
	public String toString() {
		return "Accounts [teacher_id=" + teacher_id + ", teacher_name=" + teacher_name + ", teacher_url=" + teacher_url
				+ ", teacher_password=" + teacher_password + ", teacher_enable=" + teacher_enable + ", judge=" + judge
				+ "]";
	}
	public int getTeacher_id() {
		return teacher_id;
		
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getTeacher_url() {
		return teacher_url;
	}
	public void setTeacher_url(String teacher_url) {
		this.teacher_url = teacher_url;
	}
	public String getTeacher_password() {
		return teacher_password;
	}
	public void setTeacher_password(String teacher_password) {
		this.teacher_password = teacher_password;
	}
	public int getTeacher_enable() {
		return teacher_enable;
	}
	public void setTeacher_enable(int teacher_enable) {
		this.teacher_enable = teacher_enable;
	}
	public int getJudge() {
		return judge;
	}
	public void setJudge(int judge) {
		this.judge = judge;
	}
}
