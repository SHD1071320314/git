package com.signin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.signin.Transformation.Transformation;
import com.signin.mail.Mail;
import com.signin.pojo.Accounts;
import com.signin.pojo.Student;
import com.signin.pojo.StudentInquire;
import com.signin.redis.RedisCacheManager;
import com.signin.servicet.DictionaryServicet;
import com.signin.servicet.IndexServicet;


@Controller
@RequestMapping("/ewm")
public class EwmConroller {
	@Autowired
	private RedisCacheManager redisCacheManager;
	@Autowired
	private DictionaryServicet dictionaryServicet;
	@Autowired
	private IndexServicet indexServicet;
	
	@RequestMapping("/index")
	public String index(Model model)throws Exception{
		
		return "index";
	}
	//ѧ��ɨ��
	@RequestMapping("/code")
	public String ewm(Accounts accounts,HttpServletRequest request,Model model)throws Exception{
		String id = "Signin_teacher_id_";
		id+=accounts.getTeacher_id();
		if(accounts.getTeacher_id()==0) {
			return "jingzhi";
		}else {
			if(redisCacheManager.get(id)!=null) {
				System.out.println(redisCacheManager.get(id).toString());
				if((int)redisCacheManager.get(id)==accounts.getTeacher_id()) {
					model.addAttribute("Teacher_name", accounts.getTeacher_id());//1Ϊ��ʦid
				}else{
					return "jingzhi";
				}
				}else{
			return "jingzhi";
		}}
		
		 return "student";
	}
	//�򿪹ر�ѧ��ɨ��
	@RequestMapping("/kgcode")
	public void kgewm(int judge,int teacher_id,HttpServletRequest request)throws Exception{
		String id = "Signin_teacher_id_";
		id+=teacher_id;
		redisCacheManager.set(id, judge);
	}
	//ѧ��ǩ���ύ��Ϣsubmission
	@RequestMapping(value="/submission",method=RequestMethod.POST)
	public  void Submission(StudentInquire Students,String student,int teacher_id,Model model,HttpServletResponse response)throws Exception{
		String tid="Signin_teacher_id_";
		tid+=teacher_id;
		if((int)redisCacheManager.get(tid)==teacher_id) {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String id = "Signin_student_id_";
		String ssi="Signin_students_id_";
		id+=teacher_id;
		ssi+=teacher_id;
		Student students = Transformation.StudentTransformation(student, Student.class);
		Students.setStudents_school(students.getStudent_school());
		Students.setStudents_corresponding(teacher_id);
		try {
			if(redisCacheManager.lSet(id, student)) {
				redisCacheManager.del(ssi);
				dictionaryServicet.qupdate(Students);
				response.getWriter().println(1);
			}else{
				response.getWriter().println(0);
				}
		} catch (Exception e) {
			response.getWriter().println(0);
		}
		}else {
			response.sendRedirect("/Signin/ewm/jinzhi.action");
		}
	}
	
	
	//��ת��ֹҳ��
		@RequestMapping("/tiaozhuan")
		public String jingzhi()throws Exception{
			return "tiaozhuan";
		}
		//��ֹҳ��
		@RequestMapping("/jinzhi")
		public String jinzhi()throws Exception{
			return "jingzhi";
		}
		/**
		 * ��֤mail�Ƿ�����Լ�������֤��
		 * @param MailName
		 * 			���͵��ʼ�
		 * @param response
		 * @param request
		 * @throws Exception
		 */
		@RequestMapping(value="/mail",method=RequestMethod.POST)
		public void outs(String MailName,HttpServletResponse response,HttpServletRequest request)throws Exception{
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			if(indexServicet.selectAcc(MailName)!=MailName) {
			int i=0;
			String j="";
			while(i++<6) {
				j+=String.valueOf((int)(Math.random()*(10)));
			}
			Mail.Mails(j, MailName);
			response.getWriter().println(j);
			}else {
				response.getWriter().println(0);
			}
		}
		
		@RequestMapping(value="/mails",method=RequestMethod.POST)
		public void outss(Accounts accounts,HttpServletResponse response,HttpServletRequest request)throws Exception{
			try {
				indexServicet.insertAcc(accounts);
				response.getWriter().println(1);
			} catch (Exception e) {
				response.getWriter().println(0);
			}	
		}
		
		@RequestMapping(value="/confirm",method=RequestMethod.POST)
		public String confirm(Accounts accounts,Model model,HttpServletRequest request)throws Exception{
			HttpSession session = request.getSession();
			Accounts selectAccID = indexServicet.selectAccID(accounts);
			if(selectAccID!=null) {
				if(selectAccID.getTeacher_enable()==1) {
					session.setAttribute("teacher_id", selectAccID.getTeacher_id());//session��ȡ������teacher_id,String="teacher_id1"��¼�����ȡ����session
					session.setAttribute("teacher_name",selectAccID.getTeacher_name());
					int i=(int)session.getAttribute("teacher_id");
					String id="Signin_teacher_id_";
					id+=i;
					redisCacheManager.set(id, 0);
					return "redirect:/home/qiandao.action";
				}else {
					model.addAttribute("information", "�ʺ��ѱ���");
				}
			}else {
				model.addAttribute("information", "�ʺŻ��������");
			}
			return "index";
		}
		@RequestMapping("/out")
		public void out(HttpServletResponse response,HttpServletRequest request)throws Exception{
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("/Signin/ewm/index.action");
		}
}
