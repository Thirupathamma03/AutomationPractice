package reports;

import java.util.Scanner;

// add two numbers

public class Demo1  {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number: ");
		
		N=sc.nextInt();
		
		int sum=0;
		
		for(int i=0;i<N;i++) {
			
			sum+=N;
		}
		
		System.out.println("sum of  input numbers :"+sum);
		
	}

}
