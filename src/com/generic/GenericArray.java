package com.generic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GenericArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GanArrInter gn=new GanArr();
		List<Integer> lst=gn.magicalListGetter();
		lst.add(new Integer(101));
		System.out.println(lst);
		List<String> lstStr=gn.magicalListGetter();
		lstStr.add("aaa");
		System.out.println(lstStr);
	}

}
class GanArr<T> implements GanArrInter{
	public T[] getInfoArr(Class<T> tClass){
		//return (T)tClass.newInstance();
		T[] myArray=((T[]) Array.newInstance(tClass, 10));
		return myArray;
	}
	public List<T> magicalListGetter() {
	    return new ArrayList<T>();
	}
	
}
interface GanArrInter<T>{
	public List<T> magicalListGetter();
}
