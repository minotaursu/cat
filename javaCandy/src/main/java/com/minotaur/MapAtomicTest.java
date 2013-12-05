package com.minotaur;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//HashMap ÊÇ²»¿¿Æ×µÄ
public class MapAtomicTest {
	
	public void doThreadMap(final Map<Integer,String> map) throws InterruptedException{
		ExecutorService es=Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++){
			es.execute(new Runnable(){
				@Override
				public void run() {
					for(int i=0;i<100;i++){
						map.put(i,UUID.randomUUID().toString());
					}
					System.out.println("begin=====>>>>");
				}
			});
			es.execute(new Runnable(){
				@Override
				public void run() {
					try {
						Thread.sleep(50L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					for(int i=99;i>-1;i--){
						map.remove(i);
					}
					System.out.println("end=====>>>>");
				}
			});
		}
		es.shutdown();
		while(es.awaitTermination(1L, TimeUnit.SECONDS)){
//			for(Entry<Integer,String> entry:map.entrySet()){
//				System.out.println(entry.getKey());
//			}
			System.out.println(map.size());
			return;
		}
	}
	
	public long testTime1(){
		HashMap<Integer,String>  map=new HashMap<Integer,String> ();
		Long begin=System.currentTimeMillis();
		for(int i=0;i<100000;i++){
			map.put(i, String.valueOf(i));
		}
		Long end=System.currentTimeMillis();
		return end-begin;
	}
	
	public long testTime2() throws InterruptedException{
//		dead lock		
//		final HashMap<Integer,String>  map=new HashMap<Integer,String> ();
		final ConcurrentHashMap<Integer,String>  map=new ConcurrentHashMap<Integer,String> ();
		Long begin=System.currentTimeMillis();
		ExecutorService es=Executors.newFixedThreadPool(10);
		for(int i=0;i<10;i++){
			es.execute(new Runnable(){
				@Override
				public void run() {
					for(int i=0;i<10000;i++){
						map.put(i, String.valueOf(i));
					}
				}
			});
		}
		es.shutdown();
		while(true){
			if(es.isTerminated()){
				Long end=System.currentTimeMillis();
				return end-begin;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		final HashMap<Integer,String>  map=new HashMap<Integer,String> ();
		final ConcurrentHashMap<Integer,String>  cmap=new ConcurrentHashMap<Integer,String> ();
		
		final MapAtomicTest sc=new MapAtomicTest();
		sc.doThreadMap(cmap);
		sc.doThreadMap(map);
		
		long time=0;
		final MapAtomicTest sc2=new MapAtomicTest();
		for(int i=0;i<10;i++){
			time+=sc2.testTime1();
		}
		System.out.println(time);
		for(int i=0;i<10;i++){
			time+=sc2.testTime2();
		}
		System.out.println(time);
	}
}
