package com.gky.rxjava;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RxScheduler {

	public static void main(String[] args) throws InterruptedException {
		
		Observable.create(new OnSubscribe<String>() {

				@Override
				public void call(Subscriber<? super String> subscriber) {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName()+":call");
					subscriber.onNext("hello world.");
					subscriber.onNext("hello rxjava.");
				}
			})
			.subscribeOn(Schedulers.computation())
			.observeOn(Schedulers.newThread())
			.map(new Func1<String, String>() {

				@Override
				public String call(String t) {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName());
					return t.toUpperCase();
				}
			})
			.observeOn(Schedulers.newThread())
			.subscribe(new Action1<String>() {

				@Override
				public void call(String t) {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName()+":"+t);
				}
			});
		
		Thread.sleep(60 * 1000);
	}
}
