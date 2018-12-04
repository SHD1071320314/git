package com.signin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.signin.Transformation.Transformation;
import com.signin.pojo.Accounts;
import com.signin.pojo.Dictionary;
import com.signin.pojo.Student;
import com.signin.pojo.StudentInquire;
import com.signin.redis.RedisCacheManager;
import com.signin.servicet.AddzyServicet;


@Controller
@RequestMapping("/home")
public class QiandaoConroller {
	@Autowired
	private AddzyServicet addzyServicet;
	@Autowired
	private RedisCacheManager redisCacheManager;
	
	//������
	@RequestMapping("/qiandao")
	public String qiandao(HttpServletRequest request)throws Exception{
		
		//session.setMaxInactiveInterval(5);//session����ʱ��20��
		return "qiandao";
	}
	//��ҳ
	@RequestMapping("/page")
	public String neirong1()throws Exception{
		return "neirong1";
	}
	//���ѧ��
	@RequestMapping("/add")
	public String add()throws Exception{
		return "addstudent";
	}
	//���ѧ����ߴ���
	@RequestMapping("/addz")
	public String addz(Model model,HttpServletRequest request)throws Exception{
		 HttpSession session = request.getSession();
		 int id = (int)session.getAttribute("teacher_id");
		 String spi="Signin_people_id_";//ѧ�����
		 spi+=id;
		 String sci="Signin_class_id_";//�γ�
		 sci+=id;
		 if(redisCacheManager.lGetListSize(spi)>0) {
			 	String scis=redisCacheManager.lGet(spi, 0, -1).toString();
				scis=scis.substring(0, scis.length()-1);
				scis=scis.substring(1);
				List<StudentInquire> studentInquireTransFormation = Transformation.StudentInquireTransFormation(scis, StudentInquire.class);
				model.addAttribute("student", studentInquireTransFormation);
		 }else {
			 List<StudentInquire> addzq = addzyServicet.addzq(id);
			 String stringSTransFormation = Transformation.StringSTransFormation(addzq);
			 redisCacheManager.lSet(spi, stringSTransFormation);
			 String aa=redisCacheManager.lGet(spi, 0, -1).toString();
			 aa=aa.substring(0, aa.length()-1);//ɾ�����һ��
			 aa=aa.substring(1);//ɾ����һ��
			 List<StudentInquire> studentInquireTransFormation = Transformation.StudentInquireTransFormation(aa,StudentInquire.class);
			 model.addAttribute("student", studentInquireTransFormation);
		 }
		 if(redisCacheManager.lGetListSize(sci)>0) {
			    String scis=redisCacheManager.lGet(sci, 0, -1).toString();
				scis=scis.substring(0, scis.length()-1);
				scis=scis.substring(1);
				List<Dictionary> dictionaryListTransFormation = Transformation.DictionaryListTransFormation(scis, Dictionary.class);
				model.addAttribute("dictionary", dictionaryListTransFormation);
		 }else {
			 	List<Dictionary> addy = addzyServicet.addy(id);
				String stringDTransFormation = Transformation.StringDTransFormation(addy);
				redisCacheManager.lSet(sci, stringDTransFormation);
				String aa=redisCacheManager.lGet(sci, 0, -1).toString();
				aa=aa.substring(0, aa.length()-1);//ɾ�����һ��
				aa=aa.substring(1);//ɾ����һ��
				List<Dictionary> dictionaryListTransFormation = Transformation.DictionaryListTransFormation(aa, Dictionary.class);
				model.addAttribute("dictionary", dictionaryListTransFormation);
		 }
		 return "addstudentz";
	}
	//���ѧ���ұߴ���@ModelAttribute("form")
		@RequestMapping("/addy")
		public String addy(Dictionary dictionary,Model model,HttpServletRequest request)throws Exception{	//student��ѯ�ṹ����Ĭ��ȫ��
			HttpSession session = request.getSession();
			int id = (int)session.getAttribute("teacher_id");
			String sci="Signin_class_id_";//�γ�
			sci+=id;
			if(redisCacheManager.lGetListSize(sci)>0) {
				String scis=redisCacheManager.lGet(sci, 0, -1).toString();
				scis=scis.substring(0, scis.length()-1);
				scis=scis.substring(1);
				System.out.println(scis);
				List<Dictionary> dictionaryListTransFormation = Transformation.DictionaryListTransFormation(scis, Dictionary.class);
				model.addAttribute("dictionary", dictionaryListTransFormation);
			}else{
				List<Dictionary> addy = addzyServicet.addy(id);
				String stringDTransFormation = Transformation.StringDTransFormation(addy);
				System.out.println(stringDTransFormation);
				redisCacheManager.lSet(sci, stringDTransFormation);
				String aa=redisCacheManager.lGet(sci, 0, -1).toString();
				aa=aa.substring(0, aa.length()-1);//ɾ�����һ��
				aa=aa.substring(1);//ɾ����һ��
				List<Dictionary> dictionaryListTransFormation = Transformation.DictionaryListTransFormation(aa, Dictionary.class);
				model.addAttribute("dictionary", dictionaryListTransFormation);
			}
			
			return "addstudenty";
		}
	
	//ѧ��ǩ��
	@RequestMapping("/Sign")
	public String Sign(HttpServletRequest request,Model model,Accounts accounts)throws Exception{
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("teacher_id");
		accounts.setTeacher_id(id);//��ʦid//sessionֻ�洢��ʦid����ʦ���֣���ά���Ƿ�ر��ж�
		accounts.setTeacher_name((String)session.getAttribute("teacher_name"));//��ʦ����
		model.addAttribute("Teacher_name", accounts);
		return "neirong2";
	}
	//ʵʱ���
	@RequestMapping("/situation")
	public String situation(HttpServletRequest request,Model model)throws Exception{
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("teacher_id");
		String tid = "Signin_student_id_";
		tid+=id;
		System.out.println(redisCacheManager.lGet(tid, 0, -1).toString());
		List<Student> studentsTransFormation = Transformation.StudentsTransFormation(redisCacheManager.lGet(tid, 0, -1).toString(), Student.class);
		for (Student student : studentsTransFormation) {
			System.out.println(student);
		}
		model.addAttribute("student", studentsTransFormation);
		return "neirong3";
	}
	//��ʷ��¼
	@RequestMapping("/History")
	public String History(HttpServletRequest request,Model model)throws Exception{
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("teacher_id");
		String tid = "Signin_students_id_";
		tid+=id;
		if(redisCacheManager.lGetListSize(tid)>0) {
			String tos=redisCacheManager.lGet(tid, 0, -1).toString();
			tos=tos.substring(0, tos.length()-1);//ɾ�����һ��
			tos=tos.substring(1);//ɾ����һ��
			List<StudentInquire> studentInquireTransFormation = Transformation.StudentInquireTransFormation(tos, StudentInquire.class);
			model.addAttribute("student", studentInquireTransFormation);
		}else {
			List<StudentInquire> neirong4 = addzyServicet.neirong4(id);
			String stringSTransFormation = Transformation.StringSTransFormation(neirong4);
			redisCacheManager.lSet(tid, stringSTransFormation);
			String tos=redisCacheManager.lGet(tid, 0, -1).toString();
			tos=tos.substring(0, tos.length()-1);//ɾ�����һ��
			tos=tos.substring(1);//ɾ����һ��
			List<StudentInquire> studentInquireTransFormation = Transformation.StudentInquireTransFormation(tos, StudentInquire.class);
			model.addAttribute("student", studentInquireTransFormation);
		}
		return "neirong4";
	}
	
	
	
}
