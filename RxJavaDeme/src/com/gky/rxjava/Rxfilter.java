package com.gky.rxjava;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class Rxfilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
			.filter(new Func1<Integer, Boolean>() {

				@Override
				public Boolean call(Integer t) {
					// TODO Auto-generated method stub
					return t%2 == 0;
				}
			})
			.subscribe(new Action1<Integer>() {

				@Override
				public void call(Integer t) {
					// TODO Auto-generated method stub
					System.out.println(t);
				}
			});
			
	}

}
