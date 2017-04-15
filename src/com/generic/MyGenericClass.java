package com.generic;

public class MyGenericClass<T, V> {
	T t;	
	V v;
	public V getV() {
		return v;
	}
	public void setV(V v) {
		this.v = v;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public T sum( T tt, T vv){
		T myT=tt ;
		return myT;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
