package com.minotaur;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//sync will lock another sync
public class SyncTest {

	public synchronized void  printA() throws InterruptedException{
		Thread.sleep(3000);
		System.out.println("sync MY A");
	}
	
	public synchronized void  printB(){
		System.out.println("sync MY B");
	}
	
	public void  printC() throws InterruptedException{
		Thread.sleep(3000);
		System.out.println("MY C");
	}
	
	public void  printD(){
		System.out.println("MY D");
	}
	
	public void doPrint(){
		ExecutorService es=Executors.newFixedThreadPool(10);
		for(int i=0;i<5;i++){
			es.execute(new Runnable(){
				@Override
				public void run() {
					try {
						printA();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			System.out.println("start A "+i+" end");
		}
		for(int i=0;i<5;i++){
			es.execute(new Runnable(){
				@Override
				public void run() {
					printB();
				}
			});
			System.out.println("start B "+i+" end");
		}
		es.shutdown();
		while(es.isTerminated()){
			return ;
		}
	}
	
	public void doPrintWithoutSync(){
		ExecutorService es=Executors.newFixedThreadPool(10);
		for(int i=0;i<5;i++){
			es.execute(new Runnable(){
				@Override
				public void run() {
					try {
						printC();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			System.out.println("start C "+i+" end");
		}
		for(int i=0;i<5;i++){
			es.execute(new Runnable(){
				@Override
				public void run() {
					printD();
				}
			});
			System.out.println("start D "+i+" end");
		}
		es.shutdown();
		while(es.isTerminated()){
			return ;
		}
	}
	public static void main(String[] args) throws InterruptedException {
		final SyncTest sync=new SyncTest();
		sync.doPrint();
		sync.doPrintWithoutSync();
	}
	
}
