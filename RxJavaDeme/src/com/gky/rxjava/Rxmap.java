package com.gky.rxjava;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class Rxmap {

	public static void main(String[] args) {
		
		Observable.just("hello world.")
			.map(new Func1<String, String>() {

				@Override
				public String call(String t) {
					// TODO Auto-generated method stub
					return t.toUpperCase();
				}
			})
			.subscribe(new Action1<String>() {

				@Override
				public void call(String t) {
					// TODO Auto-generated method stub
					System.out.println(t);
				}
			});
	}
}
