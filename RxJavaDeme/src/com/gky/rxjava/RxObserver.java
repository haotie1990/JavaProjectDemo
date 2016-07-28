package com.gky.rxjava;

import rx.Observer;
import rx.Subscriber;

public class RxObserver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observer<String> observer = new Observer<String>() {

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNext(String t) {
				// TODO Auto-generated method stub
				
			}
		};
		
		Subscriber<String> subscriber = new Subscriber<String>() {

			@Override
			public void onStart() {
				// TODO Auto-generated method stub
				super.onStart();
			}
			
			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNext(String t) {
				// TODO Auto-generated method stub
				
			}
		};
		
		subscriber.unsubscribe();
	}

}
