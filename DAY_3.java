package com.net;

import java.util.ArrayList;
import java.util.List;

public class DAY_3 {
	
	public static  void printArray(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	
	public void nextGreaterElement(int arr1[],int arr2[])
	{
		
		int result[]=new int[arr1.length];
		for(int i=0;i<arr1.length;i++)
		{
			int search=arr1[i];
			
			int index=0;
			for(int j=0;j<arr2.length;j++)
			{
				if(i==j) continue;
				if(arr2[j]==search)
				{
					index=j;
					
				}
			}
			int value=-1;
			for(int k=index;k<arr2.length;k++)
			{
				if(arr2[k]>search)
				{
					value=arr2[k];
					break;
				}
			}
			result[i]=value;
		}
		
		printArray(result);
	}
  

	public static void main(String[] args) {
		
		DAY_3  ll=new DAY_3();
	
		int arr[]= {4,1,2};
		int arr2[]= {1,3,4,2};
		ll.nextGreaterElement(arr, arr2);
		

	}

}
