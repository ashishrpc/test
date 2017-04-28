package com;

public class ReturnThrowTryCatchFinally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(returnStr());
	}
	
	public static String returnStr(){
        // either return or throw exception, always finally block return or throw( due to abrupt / abruptly) 
        try{
            //return "inside try";
            throw new Exception("custum ");
        }catch(Exception e){
          //return "inside catch";
            throw new Exception("custum ");
        }finally{//compile time error: finally block does not complete normally
            return "inside finally";
            //throw new Exception("custum ");
        }
        //return "inside method";
    }
}
