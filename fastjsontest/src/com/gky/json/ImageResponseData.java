package com.gky.json;

import com.alibaba.fastjson.annotation.JSONField;

public class ImageResponseData {
	
	@JSONField(name = "_id")
	public String id;
	
	@JSONField(name = "url")
	public String url;
	
	@JSONField(name = "who")
	public String title;
}
