package com.sachin.pratice.annotation;

public class AnnotationImpl {

	@CanRun
	public void method1() {
		System.out.println("METHOD-1 is runnable with annotation");
	}
	
    public void method2() {
    	System.out.println("METHOD-2 wihtout annotation");
	}
    
    @CanRun
    public void method3() {
    	System.out.println("METHOD-3 is runnable with annotation");
	}
    
    @CanRun
    public void method4() {
    	System.out.println("METHOD-4 is runnable with annotation");
	}
    
    public void method5() {
    	System.out.println("METHOD-5 wihtout annotation");
	}
}
