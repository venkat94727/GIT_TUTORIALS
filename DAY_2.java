package com.net;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DAY_2 {
	
	public static void printArray(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
			
		}
		System.out.println();
	}
	
	public void stockSpanproblem(int arr[])
	{
		int result[]=new int[arr.length];
		
		for(int i=arr.length-1;i>=0;i--)
		{
			int count=1;
			
			for(int j=i-1;j>=0;j--)
			{
				
				if(arr[j]<=arr[i])
				{
					count++;
				}else
				{
					break;
				}
			}
			result[i]=count;
			
		}
		result[0]=1;
		
		printArray(result);
	}
	
	public void stockSpanproblemTwo(int arr[])
	{
		
		
		int result[]=new int[arr.length];
		
		Stack<Integer> stack=new Stack<>();
		
		result[0]=1;
		stack.push(0);
		
		for(int i=1;i<arr.length;i++)
		{
			while(!stack.isEmpty() &&
				arr[stack.peek()]<=arr[i])
			{
				stack.pop();
			}
			
			if(stack.isEmpty())
			{
				result[i]=i+1;
			}else
			{
				result[i]=i-stack.peek();
			}
			stack.push(i);
			
			
			
					
		}
		printArray(result);
	}
	
	
	public int containsWithMostWater(int arr[])
	{
		int maxWater=Integer.MIN_VALUE;
		int start=0;
		int end=arr.length-1;
		while(start<end)
		{
			
			int height=Math.min(arr[start], arr[end]);
			
			int width=end-start;
			
			int water=height*width;
			System.out.println(water+" ");
			maxWater=Math.max(maxWater, water);
			
			if(arr[start]>arr[end])
			{
				end--;
			}else
			{
				start++;
			}
		}
			
		return maxWater;
	}
	
	public int leftBinarySearch(int arr[],int searchKey)
	{
		int start=0;
		int end=arr.length-1;
		int index=-1;
		while(start<=end)
		{
			int mid=start+(end-start)/2;
			if(arr[mid]==searchKey)
			{
				index=mid;
				end=mid-1;
			}else if(arr[mid]>searchKey)
			{
				end=mid-1;
			}else
			{
				start=mid+1;
			}
		}
		return index;
		
	}
	public int rightBinarySearch(int arr[],int searchKey)
	{
		int start=0;
		int end=arr.length-1;
		int index=-1;
		while(start<=end)
		{
			int mid=start+(end-start)/2;
			if(arr[mid]==searchKey)
			{
				index=mid;
				start=mid+1;
			}else if(arr[mid]>searchKey)
			{
				end=mid-1;
			}else
			{
				start=mid+1;
			}
		}
		return index;
		
	}
	
	public int numberOfGoodPairs(int arr[])
	{
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					count++;
				}
			}
		}
		return count;
	}
	
	public int numberOfGoodPairsTwo(int arr[])
	{
		int totalCount=0;
		
		int max=Arrays.stream(arr).min().getAsInt();
		
		int count[]=new int[102];
		for(int num:arr)
		{
			count[num]++;
		}
		
		for(int i:count)
		{
			totalCount+=((i)* (i-1))/2;
		}
		
		return totalCount;
	}
	
	public int climbStart(int n)
	{
		int dp[]=new int[n+1];
		dp[0]=1;
		dp[0]=1;
		for(int i=2;i<=n;i++)
		{
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	
	public void moveZeroes(int arr[])
	{
		int j=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!=0)
			{
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				j++;
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		
		DAY_2 ll=new DAY_2();
	
		int arr[]= {4,3,2,7,8,2,3,1};
		
	  
	
	}

}
