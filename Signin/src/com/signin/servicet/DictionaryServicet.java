package com.signin.servicet;

import com.signin.pojo.Dictionary;
import com.signin.pojo.SqlStudent;
import com.signin.pojo.StudentInquire;

public interface DictionaryServicet {
	//�γ����
	public void addy(Dictionary dictionary);
	//�γ�ɾ��
	public void addydelete(Dictionary dictionary_id);
	//ѧ�����
	public void addz(SqlStudent sqlstudent);
	public void adds(StudentInquire students);
	//ѧ��ɾ��
	public void addzdelete(SqlStudent sqlStudent);
	//��ʷѧ��ɾ��
	public void lishidelete(StudentInquire students);
	//ѧ���޸�
	public void addzupdate(SqlStudent sqlStudent);
	
	public void qupdate(StudentInquire studentInquire);
	
}
