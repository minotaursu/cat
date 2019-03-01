package com.minotaur;

public class Dp {
	public int ii=0;

	public int sumSeque(int[] a){
		int len=a.length;
		int[] d=new int[len];
		int ll=1;
		for(int i=0;i<len;i++){
			d[i]=1;
			for(int j=0;j<i;j++){
				//a[j]<a[i] find the smallest d[j]
				if(a[j]<=a[i]&&d[j]+1>d[i]){
					d[i]=d[j]+1;
				}
			}
			if(d[i]>ll){
				ll=d[i];
			}
		}
		return ll;
	}
	
	public void sum(){
		if((ii^100)==0){
			return;
		}
		ii++;
		sum();
	}
	
	
	public static void main(String[] args){
		Dp dp=new Dp();
		dp.sum();
		System.out.println(dp.ii);
	}
/**
 * fatal error
 */
//	public int cirSeque(int[] a,int len){
//		if(len==2){
//			if(a[0]<a[1]){
//				return 2;
//			}else{
//				return 1;
//			}
//		}else{
//			if(a[len-1]<a[len-2]){
//				return cirSeque(a,--len);
//			}else{
//				System.out.print(a[--len]+",");
//				return 1+cirSeque(a,len);
//			}
//		}
//	}
}
