package com.gky.rxjava;

import rx.Observable;
import rx.functions.Action1;

public class Rxmerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable.merge(
				Observable.just(1,3,5,7,9),
				Observable.just(2,4,6,8,10))
				.subscribe(new Action1<Integer>() {

					@Override
					public void call(Integer t) {
						// TODO Auto-generated method stub
						System.out.println(t);
					}
				});
	}

}
