package com.dxhyl.servicet;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dxhyl.pojo.BaseSchoolView;

@Service
public interface SchoolViewService {
	//�ϴ�У��
	public void finSchoolViewBy(String BaseSchoolView);
	
	//�û���ʾУ��
	public List<BaseSchoolView> finSchoolViewBySv();
	
	//������ʾУ��
	public List<BaseSchoolView> finSchoolViewByguanli();
	
	//�����û�У��
	public void  finSchoolViewByss(List<BaseSchoolView> baseSchoolView);
}
