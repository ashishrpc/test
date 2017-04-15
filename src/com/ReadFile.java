package com;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
//import org.apache.commons.codec.binary.Base64;





public class ReadFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("C:\\patient\\Julia Robert.txt"); 

		try {
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


}
