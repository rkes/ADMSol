package com.chap3;

public class ProductM_array_3_28 {

	public static void main(String[] args) {
		int []ar={5,2,3,5};
		int []left = new int[ar.length];
		int []right = new int[ar.length];
		right[ar.length-1]=left[0] = 1;
		int []product = new int[ar.length];// Op --> [24,60,40,30]
		for(int i=1;i<ar.length;i++){
			left[i] = left[i-1]*ar[i-1];
		}
		for(int j=ar.length-2;j>=0;j--){
			right[j] = right[j+1]*ar[j+1];
		}
		for(int i=0;i<ar.length;i++){
			product[i] = left[i]*right[i];
		}
		for(int i=0;i<ar.length;i++){
			System.out.println(product[i]);
		}
	}

}
