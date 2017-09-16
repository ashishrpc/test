package com.test;

public class ReverseMultipleDelimeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final String str="My, Name. is Ashish_";
		String out="";// "yM, emaN. si hsihsA_"
		String strin="";
		char chara;
		for(int i=0;i<str.length();i++){
			chara=str.charAt(i);
			if(chara=='.' || chara==',' || chara==' ' || chara=='_' ){
				strin=strin+chara;
				out=out+strin;
				strin="";
			}else{
				strin=chara+strin;
			}
		}
		System.out.println(out);		
	}

}
