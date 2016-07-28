package com.gky.rxjava;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class Rxflatmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] names = {"jack", "marry", "job"};
		Observable.from(names)
			.concatMap(new Func1<String, Observable<String>>() {

				@Override
				public Observable<String> call(String t) {
					// TODO Auto-generated method stub
					return Observable.just(t);
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
