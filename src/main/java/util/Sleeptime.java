package util;

import java.util.Random;

public class Sleeptime {

	public static final int ClicksleepRandom(){
		Random r=new Random();
		return r.nextInt(150)+100;
	}
	
	public static final int RandomSleepAfterClick(){
		Random r=new Random();
		return r.nextInt();
	}
	
	public static final int RandomSleepSeconds(int minSecond,int maxSecond){
		minSecond=1000*minSecond;
		maxSecond=1000*maxSecond;
		Random random=new Random();
		return random.nextInt(maxSecond-minSecond)+minSecond;
	}
	
	public static final int RandomSleepMinSeconds(int minSecond,int maxSecond){
		Random random=new Random();
		return random.nextInt(maxSecond-minSecond)+minSecond;
	}
}
