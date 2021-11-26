package myfirstarray;

	import java.util.Scanner;
	public class Array
	{
	    public static void main(String[] args) 
	    {
	        int n, sum = 0;
	        float average;
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter no. of elements you want in array:");
	        n = sc.nextInt();
	        int a[] = new int[n];
	        System.out.println("Enter all the elements:");
	        for(int i = 0; i < n ; i++)
	        {
	            a[i] = sc.nextInt();
	            sum = sum + a[i];
	        }
	        System.out.println("Sum of the elements are : "+sum);
	        average = (float)sum / n;
	        System.out.println("Average of the elements are : "+average);
	    }
	}
