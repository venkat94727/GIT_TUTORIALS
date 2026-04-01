package com.net;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DAY_1 {
	
	public void printArray(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public void singleNonRepeatingElement(int arr[])
	{
		
		for(int i=0;i<arr.length;i++)
		{
			
			boolean flag=false;
			for(int j=0;j<arr.length;j++)
			{
				if(i==j) continue;
				
				if(arr[i]==arr[j])
				{
					flag=true;
				}
			}
			if(!flag)
			{
				System.out.print(arr[i]);
			}
		}
	}
	
	
	public int maximumSumSubarray(int arr[])
	{
		
		int sum=0;
		int maximumSum=0;
		
		for(int right=0;right<arr.length;right++)
		{
			sum=Math.max(arr[right],sum+arr[right]);
			maximumSum=Math.max(sum, maximumSum);
		}
		return maximumSum;
	}
	
	public static void reverse(int arr[],int start,int end)
	{
		while(start<end)
		{
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
	}
	
	
	
	public void leftRotation(int arr[],int k)
	{
		
		int n=arr.length;
		k=k%n;
		reverse(arr,0,n);
		reverse(arr,0,k-1);
		reverse(arr,k,n);
	}
	
	public void rightRotation(int arr[],int k)
	{
		
		int n=arr.length;
		
		k=k%n;
		reverse(arr,0,n-1);
		reverse(arr,0,n-k-1);
		reverse(arr,n-k,n-1);
		
	}
	
	public int missingNumber(int arr[])
	{
		int n=arr.length;
		int excepected=n*(n+1)/2;
		int actual=0;
		for(int i=0;i<arr.length;i++)
		{
			actual+=arr[i];
		}
		System.out.println(excepected);
		System.out.println(actual);
		return excepected-actual;
	}
	
	
	public int numberOfPairsArrayElementDifferenceK(int arr[],int target)
	{
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(i==j) continue;
				
				if(Math.abs(arr[i]-arr[j])==target)
				{
					System.out.println(arr[i]+" "+arr[j]);
					count++;
					
				}
				
			}
		}
		return count;
	}
	
	
	public int numberOfPairsArrayElementDifferenceKTwo(int arr[],int target)
	{
		int count=0;
		Set<Integer> set=new HashSet<>();
		
		for(int i=0;i<arr.length;i++)
		{
			set.add(arr[i]);
		}
		
		
		
		for(int i=0;i<arr.length;i++)
		{
			int number=arr[i]-target;
			
			if(set.contains(number))
			{
				count++;
			}
		}
		
		return count;
	}
	
	
	
	public static boolean binary(int arr[],int number)
	{
		int left=0,right=arr.length-1;
		
		while(left<=right)
		{
			int mid=left+(right-left)/2;
			
			if(arr[mid]==number) return true;
			if(arr[mid]<number) left=mid+1;
			else right=mid-1;
		}
		return false;
	}
	
	public int pairs(int arr[],int k)
	{
		Arrays.sort(arr);
		
		int result=0;
		for(int i:arr)
		{
	     int numberToSearch=i-k;
	     if(binary(arr,numberToSearch)) {
	    	 result++;
	     }
		}
		return result;
	}
	
	
	public void twoSum(int arr[],int target)
	{
		int start=0;
		int end=arr.length-1;
		
		while(start<end)
		{
			int sum=arr[start]+arr[end];
			
			if(sum==target)
			{	
				System.out.print(start+" "+end);
				return;
			}
			
			else if(sum>target)
			{
				end--;
			}else
			{
				start++;
			}
			
		}
	}
	
	public int searchRotatedSortedArray(int arr[],int target,int left,int right)
	{
		
		if(left>right)
		{
			return -1;
		}
		
		int mid=left+((right-left)/2);
		
		if(arr[mid]==target)
		{
			return mid;
		}
		
		
		if(arr[mid]>=arr[left])
		{
			
			if(arr[left]<=target && target<=arr[mid])
			{
				return searchRotatedSortedArray(arr,target,left,mid-1);
			}
			else
			{
				return searchRotatedSortedArray(arr,target,mid+1,right);
			}
		}
		
		else
		{
			if(arr[mid]<=target && target<=arr[right])
			{
				return searchRotatedSortedArray(arr,target,mid+1,right);
				
			}else
			{
				return searchRotatedSortedArray(arr,target,left,mid-1);
			}
		}
	
	}
	
	
	
	public void appearTwiceElements(int arr[])
	{
		Arrays.sort(arr);
		
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]==arr[i-1])
			{
				System.out.println(arr[i]);
			}
		}
	}

	
	public void appearTwiceElementsTwo(int arr[])
	{
		
		Set<Integer> set=new HashSet<>();
		for(int i=0;i<arr.length;i++)
		{
			
			if(set.contains(arr[i]))
			{
				System.out.println(arr[i]);
			}
			set.add(arr[i]);
		}
	}
	
   public void	appearTwiceElementsThree(int arr[])
	{
	   
	   List<Integer> list=new ArrayList<>();
	   
	   for(int i=0;i<arr.length;i++)
	   {
		   int index=Math.abs(arr[i])-1;
		   
		   if(arr[index]<0)
		   {
			   list.add(index+1);
		   }
		   
		   arr[index]=arr[index]*-1;
	   }
	   System.out.println(list);
	
	}
   
   public int minimumChoclates(int arr[])
   {
	   int posibilities[]=new int[5];
	   
	   
	   int minimum=Arrays.stream(arr).min().getAsInt();
	   for(int i=0;i<posibilities.length;i++)
	   {
		   
		   for(int k:arr)
		   {
			   int diff=k-minimum;
			   int steps=diff/5 + (diff%5)/2 + ((diff%5)%2)/1;
			   posibilities[i]=steps;
			   
		   }
		   minimum--;
	   }
	   return Arrays.stream(posibilities).min().getAsInt();
   }
   
   public int minimumLoss(int arr[])
   {
	   int minimumLoss=Integer.MAX_VALUE;
	   
	   for(int i=0;i<arr.length;i++)
	   {
		   for(int j=i+1;j<arr.length;j++)
		   {
			   
			   if(arr[i]>arr[j])
			   {
			   int loss=arr[i]-arr[j];
			   minimumLoss=Math.min(minimumLoss, loss);
			   }
			   
			  
		   }
	   }
	   
	   return minimumLoss;
   }
   
   public void sortingASentence(String sentence)
   {
	   String words[]=sentence.split(" ");
	   String result[]=new String[words.length];
	   
	 for(int i=0;i<words.length;i++)
	 {
		 String small=words[i];
		 int index=Character.getNumericValue(small.charAt(small.length()-1));
		 
		 result[index-1]=small;
		 
	 }
	  
	 
	for(int i=0;i<result.length;i++)
	{
		System.out.print(result[i]+" ");
	}
	   
   }
	public static void main(String[] args) {
		
		DAY_1 ll=new DAY_1();
		
		String sentence="is2 sentence4 This1 a3";
		 ll.sortingASentence(sentence);
		
	  
	}

}
