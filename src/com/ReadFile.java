package com;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;






public class ReadFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//File file=new File("C:\\patient\\Julia Robert.txt"); 

		try {
			readFileThrowExecutorFramwork();
			//readFilesByThread();
			/*byte[] b = new byte[(int) file.length()];
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(b);
			String encoded = Base64.encodeBase64String(b);


			System.out.println(encoded);
			System.out.println("===============================");
			b=Base64.decodeBase64(encoded);
			for (int i = 0; i < b.length; i++) {
				System.out.print((char)b[i]);
			}*/

		} catch (Exception e) {
			System.out.println("IOException: " + e);
		}

	}
	
	public static void readFileThrowExecutorFramwork()throws IOException{
		ExecutorService executorService= Executors.newFixedThreadPool(15);
		//executorService.execute();
		Long startMs = System.currentTimeMillis();
		File file =new File("G:\\kmg\\desktop");
		File[] files=file.listFiles();
//		byte[] b =null;
//		FileInputStream fileInputStream=null;
		Map hm = new ConcurrentHashMap<String, byte[] >();
		Thread thread=null;
		for(File f:files){
			if(f.isFile() ){//&& f.getName().endsWith(".txt")
				System.out.println("===============Main============= "+f.getName());
				//thread=new Thread(new readFileRunable(f,hm));
				//executorService.execute(new readFileRunable(f,hm));
				//executorService.submit(new readFileRunable(f,hm));
				executorService.submit(new readFileCallable(f,hm));
			}
		}
		executorService.shutdown();
		System.out.println("time takent : "+ (System.currentTimeMillis()-startMs));
	}
	public static void readFilesByThread()throws IOException{
		//G:\kmg\desktop
		Long startMs = System.currentTimeMillis();
		File file =new File("G:\\kmg\\desktop");
		File[] files=file.listFiles();
//		byte[] b =null;
//		FileInputStream fileInputStream=null;
		Map hm = new ConcurrentHashMap<String, byte[] >();
		Thread thread=null;
		for(File f:files){
			if(f.isFile() ){//&& f.getName().endsWith(".txt")
				System.out.println("===============Main============= "+f.getName());
				//System.out.println(f.getName());
//				b = new byte[(int) f.length()];
//				fileInputStream = new FileInputStream(f);
//				fileInputStream.read(b);
//				System.out.println("======================================================================");
//				hm.put(f.getName(), b);
//				fileInputStream.close();
				thread=new Thread(new readFileRunable(f,hm));
				thread.start();
			}
		}
		System.out.println("time takent : "+ (System.currentTimeMillis()-startMs));
	}

}

class readFileRunable implements Runnable{
	File f;
	Map hm;
	public readFileRunable() {
		// TODO Auto-generated constructor stub
	}
	public readFileRunable(File file,Map hmData) {
		this.f=file;
		this.hm=hmData;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("===============Thread Start====================== "+f.getName());
		byte[] b =null;
		FileInputStream fileInputStream=null;
		try{
			b = new byte[(int) f.length()];
			fileInputStream = new FileInputStream(f);
			fileInputStream.read(b);
			hm.put(f.getName(), b);
			fileInputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		} 
		System.out.println("===============Thread Done====================== "+f.getName());
	}
	
}

class readFileCallable implements Callable{
	File f;
	Map hm;
	public readFileCallable() {
		// TODO Auto-generated constructor stub
	}
	public readFileCallable(File file,Map hmData) {
		this.f=file;
		this.hm=hmData;
	}
	@Override
	public Future call() {
		// TODO Auto-generated method stub
		System.out.println("===============Thread Start====================== "+f.getName());
		byte[] b =null;
		FileInputStream fileInputStream=null;
		try{
			b = new byte[(int) f.length()];
			fileInputStream = new FileInputStream(f);
			fileInputStream.read(b);
			hm.put(f.getName(), b);
			fileInputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		} 
		System.out.println("===============Thread Done====================== "+f.getName());
		return null;
	}
	
}