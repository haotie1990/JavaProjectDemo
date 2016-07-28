package com.gky.json;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;

public class FastJsonTest {
	
	public static void main(String[] args) throws IOException{
		String path = "E:\\WorkProject\\MyProject\\fastjsontest\\data\\testdata.txt";
		//String outPath = "E:\\WorkProject\\MyProject\\fastjsontest\\data\\path.txt";
		FileChannel channel = new FileInputStream(path).getChannel();
		MappedByteBuffer buffer = channel.map(MapMode.READ_ONLY, 0, channel.size());
		Charset charset = Charset.forName("UTF-8");
		CharsetDecoder decoder = charset.newDecoder();
		String jsonData = decoder.decode(buffer).toString();
		channel.close();
		
		System.out.println(System.currentTimeMillis());
		ResponseData<List<ImageResponseData>> responseData = JSON.parseObject(jsonData, 
				new TypeReference<ResponseData<List<ImageResponseData>>>(){});
		System.out.println(System.currentTimeMillis());
		if(responseData != null){
			for (ImageResponseData imageResponseData : responseData.results) {
				System.out.println(imageResponseData.id+">"+imageResponseData.title+":"+imageResponseData.url);
			}
		}
//		ResponseData<List<ImageResponseData>> responseData = new ResponseData<>();
//		ResponseData<List<String>> result = JSON.parseObject(jsonData, responseData.getClass());
//		
//		List<ImageResponseData> imgDatas = JSON.parseObject(result.results.toString(), new TypeReference<List<ImageResponseData>>(){});
//		
//		for (ImageResponseData imageResponseData : imgDatas) {
//			System.out.println(imageResponseData.title+":"+imageResponseData.url);
//		}
//		System.out.println(jsonData);
//		CharsetEncoder encoder = charset.newEncoder();
//		byte[] bts = outPath.getBytes(charset);
//		ByteBuffer outBuffer = ByteBuffer.allocate(bts.length);
//		outBuffer.put(bts);
//		System.out.println(outBuffer.position());
//		System.out.println(outBuffer.limit());
//		System.out.println(outBuffer.capacity());
//		outBuffer.flip();
//		System.out.println(outBuffer.position());
//		System.out.println(outBuffer.limit());
//		System.out.println(outBuffer.capacity());
//		FileChannel outChannel = new FileOutputStream(outPath).getChannel();
//		outChannel.write(outBuffer);
//		outChannel.close();
		
	}

}
