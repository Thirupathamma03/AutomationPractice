package reports;

import java.math.BigInteger;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		 BigInteger sum;
		 
		 String input1 = "9482423949832423492342323546";
	     String input2 = "6484464684864864864864876543";
	 
	     BigInteger a=new BigInteger(input1);
	     BigInteger b=new BigInteger(input2);
	     
	     sum=a.add(b);
	     System.out.println(sum);
	}

}
