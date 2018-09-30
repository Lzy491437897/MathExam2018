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
 * @author 211606317 林泽宇   211606388 尹海川
 * 命令行工具MathExam  参数 ：n = args[0]  grade = args[1]
 * grade = 1 自动生成一份小学一年级的数学加减运算计算题
 * grade = 2 自动生成一份小学二年级的数学乘除运算计算题
 * grade = 3 自动生成一份小学三年级的数学加减乘除混合运算计算题
 */
public class MathExam6317 {

	public static String[] str;//没搞懂为什么
	
	public static void main(String[] args) throws IOException,Exception  {
		// TODO Auto-generated method stub
		int n = Integer.valueOf(args[1]).intValue();//输入题数
		int grade = Integer.valueOf(args[3]).intValue();//输入年级
		if(args[0].equals("-grade")) {
			int temp = 0;
			temp = n;
			n= grade;
			grade = temp;
		}
		
//		str1 = str.getByte
		//将输出保存在文件out.txt中
//		FileOutputStream out = new FileOutputStream("out.txt");
//		out.write(arg0);
		
		File file = new File("out.txt");
//		//创建指向文件的数据输出流
//		DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
		PrintStream ps = new PrintStream(file);
//		System.setOut(ps);
		System.out.println(ps);
		//判断年级的方法
		judgeGrade(n,grade);
		
		//*************************************************************************
		
//		System.out.println();
//		out.close();
//		//创建指向文件的数据输入流
//		DataInputStream in = new DataInputStream(new FileInputStream(file));
//		//读数据   输出题目和答案
//		for (int i = 0; i < n; i++) {
//			System.out.println(in.readUTF());
//		}
//		in.close();
	}//main
	
	//*************************************************************************
	//判断输入年级的方法
	public static int judgeGrade(int n, int grade) throws Exception {
		// TODO Auto-generated method stub
		int i=0;
		if(grade == 1) {
			//当为一年级时 运行
			gradeOne(n);
			i=1;
		}
		else if(grade == 2) {
			//当为二年级时 运行
			gradeTwo(n);
			i=2;
		}
		else if(grade == 3) {
			//当为二年级时 运行
			gradeThree(n);
			i=3;
		}
		return i;
	}
	//*************************************************************************
	//一年级加减法（100以内数的加减，减数为整十数或者个位数，得数不为负数）
	public static void gradeOne(int n){
		// TODO Auto-generated method stub
		str = new String[n];
		//生成题目
		for (int i = 1; i <= n; i++) {
			//生成两个0~100的随机数
			int num1 = (int)(Math.random()*100+1);
			int num2 = (int)(Math.random()*100+1);
			//生成题序和题目
			if(num1 > num2) {//被减数大于减数 保证得数不为负数
				//生成减法
				if(num2 >= 10) {
					num2 = num2/10*10;//减数取整十数
				}				
				System.out.println("("+ i +") " + num1 +" - "+ num2);
//				String str = ("("+ i +") " + num1 +" - "+ num2 + " = " + (num1-num2));
				str[i-1] = ("("+ i +") " + num1 +" - "+ num2 + " = " + (num1-num2));
//				//写入数据
//				out.writeUTF(str);
			}	
			else {
				//生成加法
				if(num2 >= 10)
					num2 = num2/10*10;//取整十数
				if(num1 + num2 >100)
					num2 = num2/10;//保证两数和不大于100
				System.out.println("("+ i +") " + num1 +" + "+ num2);
//				String str = ("("+ i +") " + num1 +" + "+ num2 + " = " + (num1+num2));
				str[i-1] = ("("+ i +") " + num1 +" + "+ num2 + " = " + (num1+num2));
//				//写入数据
//				out.writeUTF(str);
			}
		}
		System.out.println();
		//输出答案
		for(String a:str)
			System.out.println(a);
		//输出日期和学号姓名
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		System.out.println();
		System.out.println("211606317 林泽宇  &  211606388 尹海川  " +sdf.format(new Date()));
	}//gradeOne
	//*************************************************************************
	//二年级乘除法（100以内数的乘除，除数、商为个位数）
	public static void gradeTwo(int n) {
		// TODO Auto-generated method stub
		str = new String[n];
		//生成题目
		for (int i = 1; i <= n; i++) {
			//生成两个0~100的随机数
			int num1 = (int)(Math.random()*100+1);
			int num2 = (int)(Math.random()*100+1);
			//生成题序和题目
			if(num1 > num2) {//被除数大于减数
				//生成除法
				if(num2 >= 10) {
					num2 = num2/10;//除数取个位数
				}				
				System.out.println("("+ i +") " + num1 +" ÷ "+ num2);
				if(num1%num2 == 0) {
					//可以被整除的情况
//					String str = ("("+ i +") " + num1 +" ÷ "+ num2 + " = " + (num1/num2));
					str[i-1] = ("("+ i +") " + num1 +" ÷ "+ num2 + " = " + (num1/num2));
//					//写入数据
//					out.writeUTF(str);
				}
				else {
					//不可被整除的情况 有余数
//					String str = ("("+ i +") " + num1 +" ÷ "+ num2 + " = " + (num1/num2) +"..."+(num1%num2));
					str[i-1] = ("("+ i +") " + num1 +" ÷ "+ num2 + " = " + (num1/num2) +"..."+(num1%num2));
//					//写入数据
//					out.writeUTF(str);
				}
			}	
			else {
				//生成乘法
//				if(num2 >= 10)
//					num2 = num2/10;//取个位数
//				if(num1 * num2 >100)
//					num2 = num2/10;//保证两数和不大于100
				System.out.println("("+ i +") " + num1 +" × "+ num2);
//				String str = ("("+ i +") " + num1 +" × "+ num2 + " = " + (num1*num2));
				str[i-1] = ("("+ i +") " + num1 +" × "+ num2 + " = " + (num1*num2));
//				//写入数据
//				out.writeUTF(str);
			}
		}
		System.out.println();
		//输出答案
		for(String a:str)
			System.out.println(a);
		//输出日期和学号姓名
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		System.out.println();
		System.out.println("211606317  林泽宇  &  211606388 尹海川  " +sdf.format(new Date()));
	}//gradeTwo
	//*************************************************************************
	//三年级加减乘除混合运算
	@SuppressWarnings("null")
	public static void gradeThree(int n) {
		// TODO Auto-generated method stub
		str = new String[n];
		String s[] = {"+","-","×","÷"}; 
		//生成题目
		for (int i = 1; i <= n; i++) {
			//生成四个0~100的随机数
			int num1 = (int)(Math.random()*100+1);
			int num2 = (int)(Math.random()*100+1);
			int num3 = (int)(Math.random()*100+1);
//			int num4 = (int)(Math.random()*100+1);
			
			//生成随机运算符号
//			int sighNum = (int)(Math.random()*4); // +-×÷
			String sigh[] = null;
			for (int j = 0; j < 2; j++) {
				int sighNum = (int)(Math.random()*4);
				sigh[j] = s[sighNum];
//				System.out.println("sigh :" + sigh[j]);
//				System.out.println("s :" + s[sighNum]);
			}
			//生成题序和题目
			System.out.println("("+ i +") " + num1 + sigh[0] + num2 + sigh[1] + num3 );
			
			int answer = 0;
			//第一个运算符号**************************************************************
			//先乘除
			if(sigh[0] == s[2] || sigh[0] == s[3]) {
				if(sigh[0] == s[2]) {//乘
					answer = num1*num2;
				}
				else {//除
					answer = num1/num2;
				}
			}
			//后加减
			if(sigh[0] == s[0] || sigh[0] == s[1]) {
				if(sigh[0] == s[2]) {//加
					answer = num1+num2;
				}
				else {//减
					answer = num1-num2; 
				}
			}
			//第二个运算符号**************************************************************
			//先乘除
			if(sigh[1] == s[2] || sigh[1] == s[3]) {
				if(sigh[1] == s[2]) {//乘
					answer = answer*num3;
				}
				else {//除
					answer = answer/num3;
				}
			}
			//后加减
			if(sigh[1] == s[0] || sigh[1] == s[1]) {
				if(sigh[1] == s[2]) {//加
					answer = answer+num3;
				}
				else {//减
					answer = answer-num3;
				}
			}
			str[i-1] = ("("+ i +") " + num1 + sigh[0] + num2 + sigh[1] + num3 + "=" + answer);
			//*************************************************************************
		}
		System.out.println();
		//输出答案
		for(String a:str)
			System.out.println(a);
		//输出日期和学号姓名
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		System.out.println();
		System.out.println("211606317 林泽宇  &  211606388 尹海川  " +sdf.format(new Date()));
	}//gradeThree
	//*************************************************************************
}
