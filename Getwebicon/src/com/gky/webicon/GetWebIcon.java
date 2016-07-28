package com.gky.webicon;

import java.net.MalformedURLException;
import java.net.URL;

public class GetWebIcon {

	public static void main(String[] args) throws MalformedURLException {
		
		String urlStr = "http://gank.io/2016/05/05";
		
		URL url = new URL(urlStr);
		
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
	}
}
