public class Test {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s[] = {"+","-","×","÷"}; 
//		String sigh[] = null;
//		for (int j = 0; j < 2; j++) {
//			int sighNum = (int)(Math.random()*4);
////			System.out.println(sighNum);
//			sigh[j] = s[sighNum];
//			System.out.println(sigh[j]);
//			System.out.println(s[sighNum]);				
//		}
		
		int n = Integer.valueOf(args[1]).intValue();//输入题数
		int grade = Integer.valueOf(args[3]).intValue();//输入年级
		if(args[0] == "-grade") {
			int temp = 0;
			temp = n;
			n= grade;
			grade = temp;
		}
		
		System.out.println("n: " + n);
		System.out.println("grade: " + grade);
	}

}
