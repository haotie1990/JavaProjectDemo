package com.gky.rxjava;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class RxJavaDeme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Observer<String> observer = new Subscriber<String>() {
//
//			@Override
//			public void onCompleted() {
//				// TODO Auto-generated method stub
//				System.out.println("onCompleted");
//			}
//
//			@Override
//			public void onError(Throwable e) {
//				// TODO Auto-generated method stub
//				System.out.println("onError");
//			}
//
//			@Override
//			public void onNext(String value) {
//				// TODO Auto-generated method stub
//				System.out.println("onNext:"+value);
//			}
//		};
		
//		Action1<String> onNext = new Action1<String>() {
//
//			@Override
//			public void call(String t) {
//				// TODO Auto-generated method stub
////				System.out.println("Observer"+Thread.currentThread().getName());
//				System.out.println(t);
//			}
//		};
		
//		Observable<String> observable = Observable.create(new OnSubscribe<String>() {
//
//			@Override
//			public void call(Subscriber<? super String> subscriber) {
//				// TODO Auto-generated method stub
//				System.out.println("Observable"+Thread.currentThread().getName());
//				
//				subscriber.onNext("hello world");
////				subscriber.onCompleted();
//			}
//		});
		
//		Subscription subscription = observable.subscribe(observer);
		
//		subscription.unsubscribe();
		
//		observable.subscribeOn(Schedulers.computation())
//				.observeOn(Schedulers.io())
//				.subscribe(onNext);
		
//		List<String> datas = new ArrayList<>();
//		datas.add("1");
//		datas.add("2");
//		datas.add("3");
//		datas.add("4");
//		datas.add("5");
//		
//		List<String> datas1 = new ArrayList<>();
//		datas1.add("6");
//		datas1.add("7");
//		datas1.add("8");
//		datas1.add("9");
//		datas1.add("10");
//		
//		List<List<String>> root = new ArrayList<>();
//		root.add(datas);
//		root.add(datas1);
		
//		Observable.from(root)
//			.flatMap(new Func1<List<String>, Observable<String>>() {
//
//				@Override
//				public Observable<String> call(List<String> t) {
//					// TODO Auto-generated method stub
//					System.out.println(t);
//					return Observable.from(t);
//				}
//			})
//			.subscribe(onNext);
		
//		Observable.create(new OnSubscribe<String>() {
//
//			@Override
//			public void call(Subscriber<? super String> t) {
//				// TODO Auto-generated method stub
//				t.onNext("token");
//			}
//		})
//		.flatMap(new Func1<String, Observable<String>>() {
//
//			@Override
//			public Observable<String> call(String t) {
//				// TODO Auto-generated method stub
//				return Observable.just(t);
//			}
//		}).subscribe(onNext);
		
		System.out.println("############################################");
//		Observable.create(new OnSubscribe<String>() {
//
//			@Override
//			public void call(Subscriber<? super String> t) {
//				// TODO Auto-generated method stub
//				System.out.println(Thread.currentThread().getName());
//				t.onNext("hello world.");
//				
//			}
//		})
//		.subscribeOn(Schedulers.io())
//		.doOnSubscribe(new Action0() {
//			
//			@Override
//			public void call() {
//				// TODO Auto-generated method stub
//				System.out.println(Thread.currentThread().getName());
//			}
//		})
//		.subscribeOn(Schedulers.newThread())
//		.map(new Func1<String, String>() {
//
//			@Override
//			public String call(String t) {
//				// TODO Auto-generated method stub
//				System.out.println(Thread.currentThread().getName());
//				return t.toUpperCase();
//			}
//		})
//		.observeOn(Schedulers.newThread())
//		.map(new Func1<String, String>() {
//
//			@Override
//			public String call(String t) {
//				// TODO Auto-generated method stub
//				System.out.println(Thread.currentThread().getName());
//				return t+"/"+t.toLowerCase();
//			}
//		})
//		.observeOn(Schedulers.newThread())
//		.map(new Func1<String, String>() {
//
//			@Override
//			public String call(String t) {
//				// TODO Auto-generated method stub
//				return t.toLowerCase();
//			}
//		})
//		.observeOn(Schedulers.newThread())
//		.subscribe(new Action1<String>() {
//
//			@Override
//			public void call(String t) {
//				// TODO Auto-generated method stub
//				System.out.println(Thread.currentThread().getName());
//				System.out.println(t);
//			}
//		},new Action1<Throwable>() {
//
//			@Override
//			public void call(Throwable t) {
//				// TODO Auto-generated method stub
//				System.out.println(t.getMessage());
//			}
//		});
		
		
	}

}
