package com.gky.rxjava;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Scheduler.Worker;
import rx.Single;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observables.AsyncOnSubscribe;
import rx.schedulers.Schedulers;

public class Subject {
	
	public static void main(String[] args) {
		
		
		Observable.create(new AsyncOnSubscribe<String, String>() {

			@Override
			protected String generateState() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			protected String next(String state, long requested,
					Observer<Observable<? extends String>> observer) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		rx.subjects.Subject.create(new OnSubscribe<String>() {

			@Override
			public void call(Subscriber<? super String> t) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Worker worker = Schedulers.newThread().createWorker();
		worker.schedule(new Action0() {
			
			@Override
			public void call() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName()+":call");
			}
		});
		worker.schedulePeriodically(new Action0() {
			
			@Override
			public void call() {
				// TODO Auto-generated method stub:
				System.out.println(Thread.currentThread().getName()+":call");
			}
		}, 0, 50, TimeUnit.MILLISECONDS);
		System.out.println(worker.isUnsubscribed());
		worker.unsubscribe();
	}
}
