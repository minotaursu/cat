package com.minotaur;

public class SimpleParser {

	// regular expression [* .]
	public boolean simpleMatch(String regx,String str){
		if(regx.length()==0){
			return false;
		}else if(regx.length()==1){
			if(regx.equals("*")){
				return true;
			}else if(regx.equals(".")&&str.length()==1){
				return true;
			}else if(regx.equals(str)){
				return true;
			}else{
				return false;
			}
		}else{
			char beginx=regx.charAt(0);
			char begin=str.charAt(0);
			if(beginx=='.'){
				return simpleMatch(regx.substring(1),str.substring(1));
			}else if(beginx==begin){
				return simpleMatch(regx.substring(1),str.substring(1));
			}else if(beginx=='*'){
				for(int i=0;i<str.length();i++){
					if(simpleMatch(regx.substring(1),str.substring(i))){
						return true;
					}
				}
				return false;
			}else{
				return false;
			}
		}
	}
}
