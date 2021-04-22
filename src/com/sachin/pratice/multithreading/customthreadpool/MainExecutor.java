package com.sachin.pratice.multithreading.customthreadpool;

public class MainExecutor {

	public static void main(String[] args) {
		new MainExecutor().initThreadPool();
	}

	private void initThreadPool() {
		ThreadPool pool = new ThreadPool(5);
		for(int i=0 ; i<10 ; i++){
			Runnable r = new Task();
			pool.execute(new Thread(r));
		}
	}
}
