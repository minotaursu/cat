package com.minotaur;

public class EightQueen {
	
	public final int NUM=8;
	public int count=0;
	
	public static void main(String[] args){
		EightQueen e=new EightQueen();
		e.printQueen();
	}

	public void printQueen(){
		int[] a= new int[NUM];
		for(int i=0;i<a.length;i++){
			a[i]=-1;
		}
		putQueen(a,0);
	}
	
	public int queenCount(){
		return count;
	}
	
	public void putQueen(int[] a,int line){
		if(line==NUM){
			for(int i=0;i<a.length;i++){
				System.out.print(a[i]+" ");
			}
			System.out.println();
			count++;
		}else{
			for(int height=0;height<NUM;height++){
				if(check(a,line,height)){
					a[line]=height;
					putQueen(a,++line);
					//miss this code at first coding
					line--;
				}
			}
		}
	}
	
	public boolean check(int[] a,int line,int height){
		for(int i=0;i<line;i++){
			if(a[i]==height){
				return false;
			}
			if(Math.abs((line-i))==Math.abs((height-a[i]))){
				return false;
			}
		}
		return true;
	}
}