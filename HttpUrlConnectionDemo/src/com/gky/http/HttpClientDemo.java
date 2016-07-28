package com.gky.http;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientDemo {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		
		// 创建HttpClient实例
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		// 创建HttpGet实例用于GET请求 
		HttpGet httpGet = new HttpGet("http://gank.io/api/data/Android/1/1");
		
		// 执行GET请求，并返回HttpResponse对象
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		
		// 获取响应状态码
		if(httpResponse.getStatusLine().getStatusCode() == 200){
			
			HttpEntity entity = httpResponse.getEntity();
			// 打印响应内容
			System.out.println(EntityUtils.toString(entity));
		}
		// 关闭响应连接
		httpResponse.close();
		
		// 关闭请求连接
		httpClient.close();
	
	}

}
