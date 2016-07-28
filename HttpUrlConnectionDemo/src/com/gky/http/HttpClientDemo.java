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
		
		// ����HttpClientʵ��
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		// ����HttpGetʵ������GET���� 
		HttpGet httpGet = new HttpGet("http://gank.io/api/data/Android/1/1");
		
		// ִ��GET���󣬲�����HttpResponse����
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		
		// ��ȡ��Ӧ״̬��
		if(httpResponse.getStatusLine().getStatusCode() == 200){
			
			HttpEntity entity = httpResponse.getEntity();
			// ��ӡ��Ӧ����
			System.out.println(EntityUtils.toString(entity));
		}
		// �ر���Ӧ����
		httpResponse.close();
		
		// �ر���������
		httpClient.close();
	
	}

}
