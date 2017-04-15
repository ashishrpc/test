package com.sortingAlgo;

public class Insertion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int element[]={12,1,3,8,4};
		int j, temp;
		/*
		 for(i=1;i<n;i++)	{
		temp = data[i];
		j=i-1;
		while(temp<data[j] && j>=0)
To sort elements in descending order, change temp<data[j] to temp>data[j] in above line. 
		{
			data[j+1] = data[j];
			--j;
		}
		data[j+1]=temp;
	}
	printf("In ascending order: ");
	for(i=0; i<n; i++)
		printf("%d\t",data[i]);
		 */
		for(int i=1;i<element.length;i++){
			j=i-1;
			temp=element[i];
			while(j>=0 && temp<element[j]  ){
				element[j+1]=element[j];
				--j;
			}
			element[j+1]=temp;
			
				
		}
		System.out.println(element);
	}

}
