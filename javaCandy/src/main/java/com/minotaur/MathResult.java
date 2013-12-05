package com.minotaur;

public class MathResult {

	public static void main(String[] args){
		for(int i=1;i<100;i++){
			int result=9*i+3;
			if(check(i,result)){
				System.out.println("i is "+i);
				System.out.println(result);
			}
		}
	}
	
	public static boolean check(int i,int result){
		int j=i;
		boolean f=false;
		for(;8*j+2<=result;j++){
			if(result==8*j+2){
				f=true;
				break;
			}
		}
		if(!f){
			return false;
		}
		for(int o=i;o*10+4>=result;o--){
			if(result==10*o+4){
				System.out.println("j is "+j);
				System.out.println("o is "+o);
				return true;
			}
		}
		return false;
	}
}
