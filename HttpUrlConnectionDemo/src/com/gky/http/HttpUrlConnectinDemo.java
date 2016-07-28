package com.gky.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpUrlConnectinDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		URL url = new URL("http://gank.io/api/data/Android/1/1");
		HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
		
		// 设置连接超时
		httpConnection.setConnectTimeout(5000);
		// 设置读超时
		httpConnection.setReadTimeout(5000);
		
		// 设置请求方法，默认GET方法
		httpConnection.setRequestMethod("GET");
		
		// 设置是否向HttpURLConnection输出，默认为false，如果需要OutputStream
		// 想请求体写数据，需要设为true
		httpConnection.setDoOutput(false);
		
		// 是否从HttpURLConnection读入数据，默认为true，如果不要InputStream从响应
		// 体重读取数据，则可以设为false
		httpConnection.setDoInput(true);
		
		// 是否启动缓存
		httpConnection.setUseCaches(true);
		
		// 所有对Http请求的设置操作必须在connect方法之前完成
		// 此时建立与URL所引用资源的连接
		httpConnection.connect();

		// 获取响应状态码，这里首先会调用getInputStream方法来发送HTTP请求到服务器，
		// 如果此时连接为建立则会调用connect方法建立连接，因此可以不调用上述的connet方法
		if(httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
		
			Map<String, List<String>> headers = httpConnection.getHeaderFields();
			Iterator it = headers.entrySet().iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
			
			StringBuilder strResponse = new StringBuilder();
			byte[] buffer = new byte[1024];
			InputStream in = httpConnection.getInputStream();
			while(in.read(buffer) != -1){
				strResponse.append(new String(buffer));
			}
			in.close();
			System.out.println(strResponse);
		}
		
		httpConnection.disconnect();
		
	}

}
