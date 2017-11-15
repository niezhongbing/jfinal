package com.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class Ainterceptor implements Interceptor {

	public void intercept(Invocation inv) {
		System.out.println("Ainterceptor...");
		inv.invoke();
	}

}
