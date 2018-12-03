package org;
import java.util.Date;

import util.ClickPointRandom;
import util.CompareZone;

public class Run {
public static void main(String[] args) {

		//System.out.println(ClickPointRandom.RandomClick(10, 30));;
        System.out.println(new Date());
	    CompareZone compareZone=new CompareZone();
	    boolean flag=compareZone.toCompareZone("D:/key.png");
	    System.out.println(flag);
	    System.out.println(new Date());
 }
}
