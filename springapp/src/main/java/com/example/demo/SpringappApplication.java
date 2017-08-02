package com.example.demo;

import com.example.demo.integration.MyEndpoit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@ServletComponentScan
@EnableAspectJAutoProxy
public class SpringappApplication implements ApplicationRunner {

	@Autowired
	private MyEndpoit myEndpoit;

	public static void main(String[] args) {
		SpringApplication.run(SpringappApplication.class, args);
	}

	@Autowired
	private AsyncTest asyncTest;

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		System.out.println(myEndpoit.hello());
		int a = 100;
		ListenableFuture<String> test = asyncTest.test();
		test.addCallback(new ListenableFutureCallback<String>() {
			@Override
			public void onFailure(Throwable throwable) {
				System.out.println("ERROR : " + throwable.getMessage());
			}

			@Override
			public void onSuccess(String s) {
				System.out.println("SUCCESS " + " " + s);
			}
		});
		CompletableFuture<String> stringCompletableFuture = asyncTest.testCompletable();
		System.out.println("devam ediyorum");
		if (stringCompletableFuture.isDone()){
			String s = stringCompletableFuture.get();
			System.out.println("Sonuc 1 : " + s);
		}
		System.out.println("devam ediyorum 2");
		String s1 = stringCompletableFuture.get();
		System.out.println("Sonuc 2 : " + s1);

	}
}
