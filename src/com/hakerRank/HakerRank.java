package com.hakerRank;
 
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HakerRank{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//shift();
		//sparseArrays();
		//crush();
		//sortListStrDate();
		reversepartialArray();
	}
	
	public static void reversepartialArray(){ 
		int[] t={3,4,1,5,6,8,9,2}; 
        int[] arr=reversepartialArray(t, 4); 
        for(int i=0;i<arr.length;i++){ 
                System.out.println(arr[i]); 
        } 
	}
	 public static int[] reversepartialArray(int[] str,int loc){ 
         int[] arr=new int[str.length]; 
         int temp=loc; 
         for(int i=0;i<arr.length;i++){ 
                 if(temp<=loc && temp>=0){ 
                         arr[i]=str[temp]; 
                         temp--; 
                 }else{ 
                         arr[i]=str[i]; 
                 } 
         } 
         
         return arr; 
 } 
	 
	public static void sortArrStrDate(){
		String dates[]={"01/01/2017","02/02/1987","02/03/2016"};
		Arrays.sort(dates, new Comparator<String>() {
			public int compare(String d1, String d2){
				//SimpleDateFormat sdf=new SimpleDateFormat("mm/dd/YYYY");
				Date date1=new Date(d1);
				Date date2=new Date(d2);
//				sdf.format(date1);
//				sdf.format(date2);
				return date1.compareTo(date2);
			}
		} );
		System.out.println("Array sort: ");
		for(String date:dates)
			System.out.println(date);
	}
	
	public static void sortListStrDate(){
		String dates[]={"01/01/2017","02/02/1987","02/03/2016"};
		List<String> lst=Arrays.asList(dates);
		Collections.sort(lst, new Comparator<String>() {
			public int compare(String d1, String d2){
				//SimpleDateFormat sdf=new SimpleDateFormat("mm/dd/YYYY");
				Date date1=new Date(d1);
				Date date2=new Date(d2);
//				sdf.format(date1);
//				sdf.format(date2);
				return date1.compareTo(date2);
			}
		} );
		System.out.println("List sort: ");
		for(String date:lst)
			System.out.println(date);
	}
	/*
	 input:
5 3
1 2 100
2 5 100
3 4 100

output: 200
	 */
	public static void crush(){
		Scanner in = new Scanner(System.in);
		
        int n = in.nextInt();
        int m = in.nextInt();
        long maxVal=0;
        long tempVal=0; 
        long[] deltas = new long[n];
		for (int i = 0; i < m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int k = in.nextInt();

			deltas[a - 1] += k;
			if (b < deltas.length) {
				deltas[b] -= k;
			}
		}

		long maxNumber = Long.MIN_VALUE;
		long number = 0;
		for (int i = 0; i < deltas.length; i++) {
			number += deltas[i];
			maxNumber = Math.max(maxNumber, number);
		}
		System.out.println(maxNumber); 
        in.close();
        /*
         * https://github.com/charles-wangkai/hackerrank/blob/master/crush/Solution.java
         * https://github.com/rshaghoulian/HackerRank_solutions/blob/master/Data%20Structures/Arrays/Algorithmic%20Crush/Solution.java
         * 
         * 
long[] deltas = new long[n];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int k = sc.nextInt();

			deltas[a - 1] += k;
			if (b < deltas.length) {
				deltas[b] -= k;
			}
		}

		long maxNumber = Long.MIN_VALUE;
		long number = 0;
		for (int i = 0; i < deltas.length; i++) {
			number += deltas[i];
			maxNumber = Math.max(maxNumber, number);
		}
		System.out.println(maxNumber);         
         */
	}
	
	/*
	 There is a collection of N strings ( There can be multiple occurences of a particular string ). Each string's length is no more than 20 characters. There are also Q queries. For each query, you are given a string, and you need to find out how many times this string occurs in the given collection of N strings.
	 */
	public static void sparseArrays(){
		Scanner in = new Scanner(System.in);
		int i=in.nextInt();
		Map<String,Integer> data=new HashMap<String,Integer>();
		String str="";
		for(int j=0;j<i;j++){
			str=in.next();
			if(data.containsKey(str)){
				data.put(str, data.get(str)+1);
			}else{
				data.put(str, 1);
			}
		}
		List<Integer> dataOut=new ArrayList<Integer>();
		i=in.nextInt();//ask to find occurance
		for(int j=0;j<i;j++){
			str=in.next();
			dataOut.add((data.get(str) ==null)?0:data.get(str));
//			if(data.containsKey(str)){
//				System.out.println(data.get(str));
//			}else{
//				data.put(str, 1);
//			}
		} 
		for(Integer c:dataOut){
			System.out.println(c);
		}
		in.close();
	}
	/*
	When we perform 4 left rotations in [1,2,3,4,5], the array undergoes the following sequence of changes:
	Thus, we print the array's final state as a single line of space-separated values, which is 5 1 2 3 4.
	 */
	public static void shift(){
		int a[]={1,2,3,4,5};
		int b[]=new int[a.length];
		int shift=4;
		int k=0;
		for(int i=0;i<a.length;i++){
			if(i+shift<a.length){
				b[i]=a[i+shift];
			}else{
				b[i]=a[k++];
			}
		}
		for(int r:b)
			System.out.println(r+"");
	}

}
