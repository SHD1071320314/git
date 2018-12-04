package com.signin.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class Mail {
	public static void Mails(String mail,String name)throws Exception{
		//�ռ�������
		String MailName=name;
		//������Ϣ����
		String Mail=mail;
		Properties prop = new Properties();
		// ����debug���ԣ��Ա��ڿ���̨�鿴
		prop.setProperty("mail.debug", "true"); 
		// �����ʼ�������������
		prop.setProperty("mail.host", "smtp.qq.com");
		// ���ͷ�������Ҫ�����֤
		prop.setProperty("mail.smtp.auth", "true");
		// �����ʼ�Э������
		prop.setProperty("mail.transport.protocol", "smtp");

		// ����SSL���ܣ������ʧ��
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.socketFactory", sf);

		// ����session
		Session session = Session.getInstance(prop);
		// ͨ��session�õ�transport����
		Transport ts = session.getTransport();
		// �����ʼ����������������ͣ��ʺţ���Ȩ��������루����ȫ��
		ts.connect("smtp.qq.com","1372727770", "yecwgonnxjmifgfd");//������ַ�����Ȩ�룬��qq���뷴������ʧ���ˣ����Լ��ģ������ҵģ����������Ϲ��ģ�Ϊ�ˡ���������
		// �����ʼ�
		Message message = createSimpleMail(session,Mail,MailName);
		// �����ʼ�
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
		}

		/**
		* @Method: createSimpleMail
		* @Description: ����һ��ֻ�����ı����ʼ�
		*/
		public static MimeMessage createSimpleMail(Session session,String Mail,String MailName)
		throws Exception {
		// �����ʼ�����
		MimeMessage message = new MimeMessage(session);
		// ָ���ʼ��ķ�����
		message.setFrom(new InternetAddress("1372727770@qq.com"));
		// ָ���ʼ����ռ��ˣ����ڷ����˺��ռ�����һ���ģ��Ǿ����Լ����Լ���
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(MailName));
		// �ʼ��ı���
		message.setSubject("������֤��");
		// �ʼ����ı�����
		message.setContent("��֤��Ϊ:"+Mail+",����5��������д���ע����Ϣ", "text/html;charset=UTF-8");
		// ���ش����õ��ʼ�����
		return message;
		}
		}
