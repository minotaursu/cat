package com.minotaur;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//volatile is invalid
public class SubAtomicTest {
	
	//synchronized
	private int mount=0;
	
	//volatile
	private volatile int count=0;
	
	//atomic
	private AtomicInteger timer=new AtomicInteger(0);
	
	//lock
	private int limit=0;
	private Lock lock=new ReentrantLock(false);
	
	public synchronized int addMount(){
		return mount++;
	}
	public int addTimer(){
		return timer.getAndIncrement();
	}
	public int addCount(){
		return count++;
	}
	
	public int addLimit(){
		try{
			lock.lock();
			limit++;
		}finally{
			lock.unlock();
		}
		return limit;
	}
	
	public int getTimer(){
		return timer.get();
	}
	
	public int getCount() {
		return count;
	}

	public int getMount() {
		return mount;
	}

	public int getlimit() {
		return limit;
	}
	
	public void print(){
		System.out.println("timer: "+this.getTimer());
		System.out.println("count: "+this.getCount());
		System.out.println("mount: "+this.getMount());
		System.out.println("limit: "+this.getlimit());
	}
	
	public static void main(String[] args) throws InterruptedException {
		final SubAtomicTest sc=new SubAtomicTest();
		ExecutorService es=Executors.newCachedThreadPool();
		for(int i=0;i<10000;i++){
			es.execute(new Runnable(){
				@Override
				public void run() {
					sc.addTimer();
					sc.addCount();
					sc.addMount();
					sc.addLimit();
				}
			});
		}
		es.shutdown();
		while(es.awaitTermination(1L, TimeUnit.SECONDS)){
			sc.print();
			return;
		}
	}
}
