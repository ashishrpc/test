package com.serializeDemo;

import java.io.Serializable;

public class NoneSerializable {
	private String data;
	transient private String data2;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getData2() {
		return data2;
	}
	public void setData2(String data2) {
		this.data2 = data2;
	}
	
	@Override
	public String toString(){
		return "NoneSerializable:: data: "+data+" data2: "+data2;
	}
}
