package util;

import java.util.Random;

public class ClickPointRandom {

	public static final int RandomClick(int a,int b){
		Random random=new Random();
		int r=0;
		int i=(b-a)/5;
		a=a+i;
		b=b-i;
		r=random.nextInt(b-a)+a+1;
		return r;
	}
}
