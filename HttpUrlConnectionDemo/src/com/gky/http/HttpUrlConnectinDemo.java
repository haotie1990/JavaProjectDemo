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
		
		// �������ӳ�ʱ
		httpConnection.setConnectTimeout(5000);
		// ���ö���ʱ
		httpConnection.setReadTimeout(5000);
		
		// �������󷽷���Ĭ��GET����
		httpConnection.setRequestMethod("GET");
		
		// �����Ƿ���HttpURLConnection�����Ĭ��Ϊfalse�������ҪOutputStream
		// ��������д���ݣ���Ҫ��Ϊtrue
		httpConnection.setDoOutput(false);
		
		// �Ƿ��HttpURLConnection�������ݣ�Ĭ��Ϊtrue�������ҪInputStream����Ӧ
		// ���ض�ȡ���ݣ��������Ϊfalse
		httpConnection.setDoInput(true);
		
		// �Ƿ���������
		httpConnection.setUseCaches(true);
		
		// ���ж�Http��������ò���������connect����֮ǰ���
		// ��ʱ������URL��������Դ������
		httpConnection.connect();

		// ��ȡ��Ӧ״̬�룬�������Ȼ����getInputStream����������HTTP���󵽷�������
		// �����ʱ����Ϊ����������connect�����������ӣ���˿��Բ�����������connet����
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
