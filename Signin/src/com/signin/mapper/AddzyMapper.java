package com.signin.mapper;

import java.util.List;

import com.signin.pojo.Dictionary;
import com.signin.pojo.StudentInquire;

public interface AddzyMapper {
	public List<Dictionary> finDictionaryByid(Dictionary dictionary);//��ѯ�γ�
	
	public List<Dictionary> finDictionaryByidf(int dictionary_corresponding);//ѧ����ӳ�ʼҳ���ң������˵�
	
	public List<Dictionary> finDictionaryByyq(int id);//��ʾȫ���γ�
	
	public List<StudentInquire> finSqlStudentByzq(int id);//��ʾȫ��ѧ��
	
	public List<StudentInquire> finSqlStudentByneiron(int id);//��ʾȫ��ѧ��
}
