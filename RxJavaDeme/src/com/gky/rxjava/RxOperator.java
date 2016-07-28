package com.gky.rxjava;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action;
import rx.functions.Action1;
import rx.functions.Func1;

public class RxOperator {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Integer[] arrInt = {1,2,3,4,5};
		
		System.out.println("###################filter####################");
		Observable.from(arrInt)
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
		System.out.println("#######################################");

		System.out.println("###################map####################");
		Observable.from(arrInt)
			.map(new Func1<Integer, Integer>() {

				@Override
				public Integer call(Integer t) {
					// TODO Auto-generated method stub
					return t*2;
				}
			})
			.subscribe(new Action1<Integer>() {

				@Override
				public void call(Integer t) {
					// TODO Auto-generated method stub
					System.out.println(t);
				}
			});
		
		System.out.println("#######################################");
		
		System.out.println("###################handle error####################");
		Observable.from(arrInt)
			.map(new Func1<Integer, Integer>() {

				@Override
				public Integer call(Integer t) {
					// TODO Auto-generated method stub
					if(t > 3)
						throw new IllegalArgumentException("Unknown exception value > 3");
					return t*2;
				}
			})
			.subscribe(new Action1<Integer>() {

				@Override
				public void call(Integer t) {
					// TODO Auto-generated method stub
					System.out.println(t);
				}
			},
			new Action1<Throwable>() {

				@Override
				public void call(Throwable t) {
					// TODO Auto-generated method stub
					System.out.println(t);
				}
			});
		
		System.out.println("#######################################");
		
		System.out.println("##################interval#####################");
		System.out.println(System.currentTimeMillis());
		Observable.interval(500, TimeUnit.MILLISECONDS)
			.subscribe(new Subscriber<Long>() {

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onError(Throwable e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onNext(Long t) {
					// TODO Auto-generated method stub
					System.out.println(System.currentTimeMillis());
				}
			});
		System.out.println("#######################################");
		
		Observable.timer(500, TimeUnit.MILLISECONDS).subscribe(new Action1<Long>(){

			@Override
			public void call(Long t) {
				// TODO Auto-generated method stub
				
			}});
		Thread.sleep(1000);
	}

}
