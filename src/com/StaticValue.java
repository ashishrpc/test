package com;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.*;
        
   public class StaticValue {
      //private double d;
      public static final String i = "ashish";
      //String s = "testing";
        
      public static void main(String args[])
      {
         try {
            Class cls = Class.forName("com.StaticValue"); 
            Field fld = cls.getField("i");
            System.out.println("value : "+fld.get(fld.getName()));
            System.out.println("value : "+fld.get("i"));
            B b=null;
            b.funStatic();
            for(int i=0;i<100000000;i++){
            	StaticValue sv=new StaticValue();
            	Thread.sleep(500);
            }
            System.out.println("Done.....");
            /*for (int i  = 0; i < fieldlist.length; i++) {
               Field fld = fieldlist[i];
               System.out.println("name = " + fld.getName());
               System.out.println("decl class = " +
                           fld.getDeclaringClass());
               System.out.println("type = " + fld.getType());
               int mod = fld.getModifiers();
               System.out.println("modifiers = " + Modifier.toString(mod));
               System.out.println("value : "+fld.get(fld.getName()));
               System.out.println("-----");
            }*/
          }
          catch (Throwable e) {
             System.err.println(e);
          }
          /*try {
              Class cls = Class.forName("StaticValue");
              Field fld = cls.getField("d");
              StaticValue f2obj = new StaticValue();
              System.out.println("d = " + f2obj.d);
              fld.setDouble(f2obj, 12.34);
              System.out.println("d = " + f2obj.d);
           }
           catch (Throwable e) {
              System.err.println(e);
           }*/
       }
   }
   //overwrriding rules of access modifier, return type and throws checked-exception
   class A{
	   protected Object fun()throws IOException {
		   return null;
	   }
   }
   class B extends A{
	   @Override
	   public StaticBlock  fun()throws FileNotFoundException{
		   return null;
	   }
	   public static void funStatic(){
		   System.out.println("funStatic()");
		   /*
		    *B b=null;
            b.funStatic(); //working fine....//static method is bound at compile time and only type of variable is used for static binding not the value of object.
		    */
	   }
   }