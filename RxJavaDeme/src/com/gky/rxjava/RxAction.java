package com.gky.rxjava;

import javax.print.DocFlavor.STRING;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

public class RxAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Action1<String> onNext = new Action1<String>() {

			@Override
			public void call(String t) {
				// TODO Auto-generated method stub
				
			}
		};
		
		Action1<Throwable> onError = new Action1<Throwable>() {

			@Override
			public void call(Throwable t) {
				// TODO Auto-generated method stub
				
			}
		};
		
		Action0 onCompleted = new Action0() {
			
			@Override
			public void call() {
				// TODO Auto-generated method stub
				
			}
		};
		
		Observable.just("hello").subscribe(onNext);
		
		Observable.just("hello").subscribe(onNext, onError);
		
		Observable.just("hello").subscribe(onNext, onError, onCompleted);
	}

}
