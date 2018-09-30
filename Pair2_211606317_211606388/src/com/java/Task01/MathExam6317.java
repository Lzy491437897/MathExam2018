package com.java.Task01;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.io.DataInputStream;

/**
 * 
 * @author 211606317 ������   211606388 ������
 * �����й���MathExam  ���� ��n = args[0]  grade = args[1]
 * grade = 1 �Զ�����һ��Сѧһ�꼶����ѧ�Ӽ����������
 * grade = 2 �Զ�����һ��Сѧ���꼶����ѧ�˳����������
 * grade = 3 �Զ�����һ��Сѧ���꼶����ѧ�Ӽ��˳�������������
 */
public class MathExam6317 {

	public static String[] str;//û�㶮Ϊʲô
	
	public static void main(String[] args) throws IOException,Exception  {
		// TODO Auto-generated method stub
		int n = Integer.valueOf(args[1]).intValue();//��������
		int grade = Integer.valueOf(args[3]).intValue();//�����꼶
		if(args[0].equals("-grade")) {
			int temp = 0;
			temp = n;
			n= grade;
			grade = temp;
		}
		
//		str1 = str.getByte
		//������������ļ�out.txt��
//		FileOutputStream out = new FileOutputStream("out.txt");
//		out.write(arg0);
		
		File file = new File("out.txt");
//		//����ָ���ļ������������
//		DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
		PrintStream ps = new PrintStream(file);
//		System.setOut(ps);
		System.out.println(ps);
		//�ж��꼶�ķ���
		judgeGrade(n,grade);
		
		//*************************************************************************
		
//		System.out.println();
//		out.close();
//		//����ָ���ļ�������������
//		DataInputStream in = new DataInputStream(new FileInputStream(file));
//		//������   �����Ŀ�ʹ�
//		for (int i = 0; i < n; i++) {
//			System.out.println(in.readUTF());
//		}
//		in.close();
	}//main
	
	//*************************************************************************
	//�ж������꼶�ķ���
	public static int judgeGrade(int n, int grade) throws Exception {
		// TODO Auto-generated method stub
		int i=0;
		if(grade == 1) {
			//��Ϊһ�꼶ʱ ����
			gradeOne(n);
			i=1;
		}
		else if(grade == 2) {
			//��Ϊ���꼶ʱ ����
			gradeTwo(n);
			i=2;
		}
		else if(grade == 3) {
			//��Ϊ���꼶ʱ ����
			gradeThree(n);
			i=3;
		}
		return i;
	}
	//*************************************************************************
	//һ�꼶�Ӽ�����100�������ļӼ�������Ϊ��ʮ�����߸�λ����������Ϊ������
	public static void gradeOne(int n){
		// TODO Auto-generated method stub
		str = new String[n];
		//������Ŀ
		for (int i = 1; i <= n; i++) {
			//��������0~100�������
			int num1 = (int)(Math.random()*100+1);
			int num2 = (int)(Math.random()*100+1);
			//�����������Ŀ
			if(num1 > num2) {//���������ڼ��� ��֤������Ϊ����
				//���ɼ���
				if(num2 >= 10) {
					num2 = num2/10*10;//����ȡ��ʮ��
				}				
				System.out.println("("+ i +") " + num1 +" - "+ num2);
//				String str = ("("+ i +") " + num1 +" - "+ num2 + " = " + (num1-num2));
				str[i-1] = ("("+ i +") " + num1 +" - "+ num2 + " = " + (num1-num2));
//				//д������
//				out.writeUTF(str);
			}	
			else {
				//���ɼӷ�
				if(num2 >= 10)
					num2 = num2/10*10;//ȡ��ʮ��
				if(num1 + num2 >100)
					num2 = num2/10;//��֤�����Ͳ�����100
				System.out.println("("+ i +") " + num1 +" + "+ num2);
//				String str = ("("+ i +") " + num1 +" + "+ num2 + " = " + (num1+num2));
				str[i-1] = ("("+ i +") " + num1 +" + "+ num2 + " = " + (num1+num2));
//				//д������
//				out.writeUTF(str);
			}
		}
		System.out.println();
		//�����
		for(String a:str)
			System.out.println(a);
		//������ں�ѧ������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm");
		System.out.println();
		System.out.println("211606317 ������  &  211606388 ������  " +sdf.format(new Date()));
	}//gradeOne
	//*************************************************************************
	//���꼶�˳�����100�������ĳ˳�����������Ϊ��λ����
	public static void gradeTwo(int n) {
		// TODO Auto-generated method stub
		str = new String[n];
		//������Ŀ
		for (int i = 1; i <= n; i++) {
			//��������0~100�������
			int num1 = (int)(Math.random()*100+1);
			int num2 = (int)(Math.random()*100+1);
			//�����������Ŀ
			if(num1 > num2) {//���������ڼ���
				//���ɳ���
				if(num2 >= 10) {
					num2 = num2/10;//����ȡ��λ��
				}				
				System.out.println("("+ i +") " + num1 +" �� "+ num2);
				if(num1%num2 == 0) {
					//���Ա����������
//					String str = ("("+ i +") " + num1 +" �� "+ num2 + " = " + (num1/num2));
					str[i-1] = ("("+ i +") " + num1 +" �� "+ num2 + " = " + (num1/num2));
//					//д������
//					out.writeUTF(str);
				}
				else {
					//���ɱ���������� ������
//					String str = ("("+ i +") " + num1 +" �� "+ num2 + " = " + (num1/num2) +"..."+(num1%num2));
					str[i-1] = ("("+ i +") " + num1 +" �� "+ num2 + " = " + (num1/num2) +"..."+(num1%num2));
//					//д������
//					out.writeUTF(str);
				}
			}	
			else {
				//���ɳ˷�
//				if(num2 >= 10)
//					num2 = num2/10;//ȡ��λ��
//				if(num1 * num2 >100)
//					num2 = num2/10;//��֤�����Ͳ�����100
				System.out.println("("+ i +") " + num1 +" �� "+ num2);
//				String str = ("("+ i +") " + num1 +" �� "+ num2 + " = " + (num1*num2));
				str[i-1] = ("("+ i +") " + num1 +" �� "+ num2 + " = " + (num1*num2));
//				//д������
//				out.writeUTF(str);
			}
		}
		System.out.println();
		//�����
		for(String a:str)
			System.out.println(a);
		//������ں�ѧ������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm");
		System.out.println();
		System.out.println("211606317  ������  &  211606388 ������  " +sdf.format(new Date()));
	}//gradeTwo
	//*************************************************************************
	//���꼶�Ӽ��˳��������
	@SuppressWarnings("null")
	public static void gradeThree(int n) {
		// TODO Auto-generated method stub
		str = new String[n];
		String s[] = {"+","-","��","��"}; 
		//������Ŀ
		for (int i = 1; i <= n; i++) {
			//�����ĸ�0~100�������
			int num1 = (int)(Math.random()*100+1);
			int num2 = (int)(Math.random()*100+1);
			int num3 = (int)(Math.random()*100+1);
//			int num4 = (int)(Math.random()*100+1);
			
			//��������������
//			int sighNum = (int)(Math.random()*4); // +-����
			String sigh[] = null;
			for (int j = 0; j < 2; j++) {
				int sighNum = (int)(Math.random()*4);
				sigh[j] = s[sighNum];
//				System.out.println("sigh :" + sigh[j]);
//				System.out.println("s :" + s[sighNum]);
			}
			//�����������Ŀ
			System.out.println("("+ i +") " + num1 + sigh[0] + num2 + sigh[1] + num3 );
			
			int answer = 0;
			//��һ���������**************************************************************
			//�ȳ˳�
			if(sigh[0] == s[2] || sigh[0] == s[3]) {
				if(sigh[0] == s[2]) {//��
					answer = num1*num2;
				}
				else {//��
					answer = num1/num2;
				}
			}
			//��Ӽ�
			if(sigh[0] == s[0] || sigh[0] == s[1]) {
				if(sigh[0] == s[2]) {//��
					answer = num1+num2;
				}
				else {//��
					answer = num1-num2; 
				}
			}
			//�ڶ����������**************************************************************
			//�ȳ˳�
			if(sigh[1] == s[2] || sigh[1] == s[3]) {
				if(sigh[1] == s[2]) {//��
					answer = answer*num3;
				}
				else {//��
					answer = answer/num3;
				}
			}
			//��Ӽ�
			if(sigh[1] == s[0] || sigh[1] == s[1]) {
				if(sigh[1] == s[2]) {//��
					answer = answer+num3;
				}
				else {//��
					answer = answer-num3;
				}
			}
			str[i-1] = ("("+ i +") " + num1 + sigh[0] + num2 + sigh[1] + num3 + "=" + answer);
			//*************************************************************************
		}
		System.out.println();
		//�����
		for(String a:str)
			System.out.println(a);
		//������ں�ѧ������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm");
		System.out.println();
		System.out.println("211606317 ������  &  211606388 ������  " +sdf.format(new Date()));
	}//gradeThree
	//*************************************************************************
}
