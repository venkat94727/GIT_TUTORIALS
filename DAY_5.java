package com.net;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DAY_5 {
	
	public void printArray(int arr[])
	{
		for(int i=0;i<arr.length;i++){
			
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	
	public void topKElements(int arr[],int k)
	{
		
		
		List<Integer>[] bucket=new List[arr.length+1];
		
		Map<Integer,Integer> frequencyMap=new HashMap<>();
		
		
		for(int i=0;i<arr.length;i++)
		{
			frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0)+1);
			
		}
		
		
		for(int key:frequencyMap.keySet())
		{
			int frequency=frequencyMap.get(key);
			
			if(bucket[frequency]==null)
			{
				bucket[frequency]=new ArrayList<>();
			}
			
			bucket[frequency].add(key);
		}
		
		int res[]=new int[k];
		int count=0;
		
		for(int pos=bucket.length-1;pos>=0;pos--)
		{
			if(bucket[pos]!=null)
			{
				for(Integer integer:bucket[pos])
				{
					if(count<k)
					{
					res[count]=integer;
					count++;
					}else
					{
						break;
					}
				}
				
			}
		}
		
		printArray(res);
	}
	
	public boolean containsDuplicate(int arr[])
	{
		Set<Integer> set=new HashSet<>();
		
		for(int i=0;i<arr.length;i++)
		{
			if(set.contains(arr[i]))
			{
				return false;
			}
			set.add(arr[i]);
		}
		return true;
	}
	
	
	public void squareSortedArray(int arr[])
	{
		int result[]=new int[arr.length];
		
		int left=0;
		int right=arr.length-1;
		int size=arr.length-1;
		while(left<right)
		{
			int leftSquare=arr[left]* arr[left];
			int rightSquare=arr[right] * arr[right];
			
			if(leftSquare>rightSquare)
			{
				result[size]=leftSquare;
				left++;
			}else
			{
				result[size]=rightSquare;
				right--;
				
			}
			size--;
		}
		
		printArray(result);
	}

	
	public void productArrayItSelf(int arr[])
	{
		int result[]=new int[arr.length];
		
		for(int i=0;i<arr.length;i++)
		{
			int left=i-1;
			int right=i+1;
			
			int leftMul=1;
			int rightMul=1;
			
			while(left>=0)
			{
				leftMul*=arr[left];
				left--;
			}
			while(right<arr.length)
			{
				rightMul*=arr[right];
				right++;
			}
			
			result[i]=leftMul*rightMul;
			
		}
		printArray(result);
	}
	
	
	public void productArrayItSelfTwo(int arr[])
	{
		int result[]=new int[arr.length];
		int leftArr[]=new int[arr.length];
		
		int rightArr[]=new int[arr.length];
		
		leftArr[0]=1;
		for(int i=1;i<arr.length;i++)
		{
			leftArr[i]=leftArr[i-1] * arr[i-1];
		}
		
		rightArr[arr.length-1]=1;
		
		for(int i=arr.length-2;i>=0;i--)
		{
			rightArr[i]=rightArr[i+1]*rightArr[i+1];
		}
		
		for(int i=0;i<arr.length;i++)
		{
			result[i]=leftArr[i]*rightArr[i];
		}
		
		printArray(result);
	}
	
	public int longestConsecutive(int arr[])
	{
		Arrays.sort(arr);
		
		int longestCount=0;
		int count=1;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]-arr[i-1]==1)
			{
				count++;
				longestCount=Math.max(longestCount, count);
			}else
			{
				count=1;
			}
		}
		return longestCount;
	}
	
	public int longestConsecutiveTwo(int arr[])
	{
		
		int longestLength=0;
		Map<Integer,Boolean> map=new HashMap<>();
		
		for(int i=0;i<arr.length;i++)
		{
			map.put(arr[i], Boolean.FALSE);
		}
		
		for(int num:arr)
		{
		  int currentLength=1;
		  
		  int nextNum=num+1;
		  while(map.containsKey(nextNum) && !map.get(nextNum))
		  {
			  map.put(nextNum, Boolean.FALSE);
			  nextNum++;
			  currentLength++;  
		  }
		  
		  int prevNum=num-1;
		  
		  while(map.containsKey(prevNum) && !map.get(prevNum))
		  {
			  map.put(prevNum, Boolean.FALSE);
			  prevNum--;
			  currentLength++;
		  }
			 
		  longestLength=Math.max(currentLength, longestLength);
		}
		return longestLength;
	}
	
	public int bestTimetoBuyAndSellStock(int arr[])
	{
		int maximumProfit=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				maximumProfit=Math.max(maximumProfit, arr[j]-arr[i]);
				
			}
		}
		return maximumProfit;
	}
	
	public int bestTimetoBuyAndSellStockTwo(int arr[])
	{
		
		int minPrice=Integer.MAX_VALUE;
		int maxProfit=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]<minPrice)
			{
				minPrice=arr[i];
			}else
			{
				maxProfit=Math.max(maxProfit, arr[i]-minPrice);
			}
			
		}
		return maxProfit;
	}
	
	public int majorityElement(int arr[])
	{
	  int majorityElement=0;
	  int votes=0;
	 for(int i=0;i<arr.length;i++)
	 {
		 if(votes==0)
		  {
			  majorityElement=arr[i];
			  votes++;
		  }else if(majorityElement==arr[i])
		  {
			  votes++;
		  }else
		  {
			  votes--;
		  }
	 }
	 
	 return majorityElement;
	}
	
	
	public void swap(int arr[],int start,int end)
	{
		int temp=arr[start];
		arr[start]=arr[end];
		arr[end]=temp;
		
	}
	
	public void sortColors(int arr[])
	{
		int start=0;
		int mid=0;
		int end=arr.length-1;
		while(mid<=end)
		{
			switch(arr[mid])
			{
			case 0:
				swap(arr,start,mid);
				start++;
				mid++;
				break;
			case 1:
				mid++;
				break;
				
			case 2:
				swap(arr,mid,end);
				end--;
				break;
			}
		}
	}
	
	public int maximumProductSubArray(int arr[])
	{
		int leftProduct=1;
		int rightProduct=1;
		int maximumProduct=1;
		int n=arr.length;
		
		for(int i=0;i<arr.length;i++)
		{
			
			leftProduct=leftProduct==0?1:leftProduct;
			rightProduct=rightProduct==0?1:rightProduct;
			leftProduct*=arr[i];
			
			rightProduct*=arr[n-1-i];
			
			maximumProduct=Math.max(maximumProduct, Math.max(leftProduct, rightProduct));
		}
		
		return maximumProduct;
	}
	
	public void shuffleString (String word,int arr[])
	{
		char result[]=new char[word.length()];
		
		for(int i=0;i<word.length();i++)
		{
			result[arr[i]]=word.charAt(i);
		}
		
		System.out.println(new String(result));
		
	}
	
	public boolean jumpGame(int arr[])
	{
		int destination=arr.length-1;
		
		for(int i=arr.length-2;i>=0;i--)
		{
			if(i+arr[i]>=destination)
			{
				destination=i;
			}
		}
		return destination==0;
	}
	
	public int fruitCount(int arr[])
	{
		Map<Integer,Integer> fruitBasket=new HashMap<>();
		
		int left=0;
		int maxFruits=0;
		
		for(int right=0;right<arr.length;right++)
		{
			fruitBasket.put(arr[right], fruitBasket.getOrDefault(arr[right], 0)+1);
			
			while(fruitBasket.size()>2)
			{
				int fruitCount=fruitBasket.get(arr[left]);
				
				fruitBasket.put(arr[left], fruitCount-1);
				
				if(fruitBasket.get(arr[left])==0)
				{
					fruitBasket.remove(arr[left]);
				}
				left++;
			}
			
			maxFruits=Math.max(maxFruits, right-left+1);
		}
		return maxFruits;
	}
	
	public boolean checkVowel(char ch)
	{
		if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
		{
			return true;
		}
		return false;
			
	}
	
	public int maximumVowelSubString(String word,int k)
	{
		int vowelCount=0;
		
		for(int i=0;i<k;i++)
		{
			if(checkVowel(word.charAt(i)))
			{
				vowelCount++;
			}
		}
		
		int maximumVowel=vowelCount;
		int left=0;
		for(int right=k;right<word.length();right++)
		{
			if(checkVowel(word.charAt(left))) vowelCount--;
			left++;
			if(checkVowel(word.charAt(right))) vowelCount++;
			
			maximumVowel=Math.max(maximumVowel, vowelCount);
		}
		return maximumVowel;
		
	}
	
	
	
	public int jumpTwo(int arr[])
	{
	  int totalJumps=0;
	  int coverage=0;
	  int lastJumpIdx=0;
	  int destination=arr.length-1;
	  for(int i=0;i<=lastJumpIdx &&i<arr.length;i++)
	  {
		  coverage=Math.max(coverage, i+arr[i]);
		  if(i==lastJumpIdx)
		  {
			  lastJumpIdx=coverage;
			  totalJumps++;
			  
			  if(coverage>=destination)
			  {
				  return totalJumps;
			  }
		  }
		 
	  }
	  return -1;
	}
	
	
	
	public static void main(String[] args) {
		
		
		DAY_5 ll=new DAY_5();
	    int arr[]= {2,4,1,2,3,1,1,2};
		System.out.println(ll.jumpTwo(arr));
	
	
	}

}
