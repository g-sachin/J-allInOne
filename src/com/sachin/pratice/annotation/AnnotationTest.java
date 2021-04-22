package com.sachin.pratice.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTest {

	public static void main(String[] args) {
		AnnotationImpl annRunner = new AnnotationImpl();
		Method[] methods = annRunner.getClass().getMethods();
		
		for(Method method : methods) {
			CanRun annos = method.getAnnotation(CanRun.class);
			if(annos != null) {
				try {
					method.invoke(annRunner);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
