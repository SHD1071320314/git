package com.signin.pojo;
//��ά������Ϣ&ǩ��
public class Student {
	private int student_id;//ѧ����Ӧ����ʦ
	private String student_name;//ѧ������
	private String student_school;//ѧ��ѧ��
	private String student_class;//ѧ�����ڰ༶
	private String student_seat;//ѧ����ǰ��λ��
	private String student_position;//ѧ����ǰ���ڵ���λ��
	private int student_enable;//�Ƿ�ǩ��
	public int getStudent_enable() {
		return student_enable;
	}
	public void setStudent_enable(int student_enable) {
		this.student_enable = student_enable;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_school() {
		return student_school;
	}
	public void setStudent_school(String student_school) {
		this.student_school = student_school;
	}
	public String getStudent_class() {
		return student_class;
	}
	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}
	public String getStudent_seat() {
		return student_seat;
	}
	public void setStudent_seat(String student_seat) {
		this.student_seat = student_seat;
	}
	public String getStudent_position() {
		return student_position;
	}
	public void setStudent_position(String student_position) {
		this.student_position = student_position;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_school="
				+ student_school + ", student_class=" + student_class + ", student_seat=" + student_seat
				+ ", student_position=" + student_position + ", student_enable=" + student_enable + "]";
	}
	
	
}
