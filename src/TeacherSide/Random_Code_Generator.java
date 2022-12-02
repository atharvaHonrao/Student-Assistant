package TeacherSide;

import java.lang.Math;

public class Random_Code_Generator {

	int b; 
	
	protected int code(){
		int max = 9999;
		int min = 1000;
		b = (int)(Math.random()*(max-min+1)+min); 
		return b;
	}		
	
//	public static void main(String [] args) {
//		
//		Random_Code_Generator m = new Random_Code_Generator();
//	
//		int h = m.code();
//		System.out.println(h);
//	}
}
