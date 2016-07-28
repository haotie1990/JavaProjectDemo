package com.gky.json;

import com.alibaba.fastjson.annotation.JSONField;

public class ResponseData<T> {
	
	@JSONField(name = "error")
	public boolean error;

	@JSONField(name = "results")
	public T results;

}
