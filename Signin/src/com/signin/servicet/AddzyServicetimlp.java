package com.signin.servicet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signin.mapper.AddzyMapper;
import com.signin.pojo.Dictionary;
import com.signin.pojo.StudentInquire;
@Service
public class AddzyServicetimlp implements AddzyServicet {
	@Autowired
	private AddzyMapper addzyMapper;
	//ѧ���༶��Ӳ�ѯ�༶
	@Override
	public List<Dictionary> addyy(Dictionary dictionary) {
		List<Dictionary> finDictionaryByid = addzyMapper.finDictionaryByid(dictionary);
		return finDictionaryByid;
	}
	//ѧ����ӳ�ʼҳ���ң������˵�
	@Override
	public List<Dictionary> addy(int dictionary_corresponding) {
		List<Dictionary> finDictionaryByidf = addzyMapper.finDictionaryByidf(dictionary_corresponding);
		return finDictionaryByidf;
	}
	//ѧ����ӳ�ʼҳ���ң�ҳ��Ĭ����ʾȫ��
	@Override
	public List<Dictionary> addyq(int id) {
		List<Dictionary> finDictionaryByyq = addzyMapper.finDictionaryByyq(id);
		return finDictionaryByyq;
	}
	@Override
	public List<StudentInquire> addzq(int id) {
		  List<StudentInquire> finSqlStudentByzq = addzyMapper.finSqlStudentByzq(id);
		  return finSqlStudentByzq;
	}
	@Override
	public List<StudentInquire> neirong4(int id) {
		List<StudentInquire> finSqlStudentByneiron = addzyMapper.finSqlStudentByneiron(id);
		return finSqlStudentByneiron;
	}

}
