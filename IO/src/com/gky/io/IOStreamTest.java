package com.gky.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class IOStreamTest {
	public static void main(String[] args) throws IOException {
		
		String str = "112233我爱我的国家aabbcc";
		String str1 = new String(str.getBytes(),Charset.forName("utf-8"));
		for (char ch : str.toCharArray()) {
			System.out.println((int)ch);
		}
		
		
		/*URL url = new URL("http://www.szse.cn/UpFiles/largepdf/20150319145802.pdf");
		InputStream inputStream = url.openStream();*/
		/*URLConnection urlConnection = url.openConnection();
		HttpURLConnection httpClietn = (HttpURLConnection) urlConnection;
		httpClietn.setDoOutput(true);
		httpClietn.setDoInput(true);
		httpClietn.setUseCaches(false);
		httpClietn.setRequestMethod("GET");
		InputStream inputStream = httpClietn.getInputStream();
		FileOutputStream fileOutputStream = new FileOutputStream("E:\\DownLoad\\20150319145802.pdf");
		byte[] buffer = new byte[2048];
		while(inputStream.read(buffer) > 0){
			fileOutputStream.write(buffer);
		}
		System.out.println("DownLoad");*/
		/*FileOutputStream fileOutputStream = new FileOutputStream("E:\\DownLoad\\20150319145802.pdf");
		byte[] buffer = new byte[2048];
		int hasRead = 0;
		while((hasRead = inputStream.read(buffer)) > 0){
			fileOutputStream.write(buffer, 0, hasRead);
		}
		System.out.println("DownLoad");
		inputStream.close();
		fileOutputStream.close();*/
		
		
		
		
		
		
		/*FileInputStream in = new FileInputStream("E:\\DownLoad\\sheng.pdf");
		FileOutputStream out = new FileOutputStream("E:\\DownLoad\\sheng1.pdf");
		byte[] buffer = new byte[1024];
		while(in.read(buffer) > 0){
			out.write(buffer);
		}*/
	}

}
