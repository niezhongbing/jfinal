package com.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class MethodIntercept implements Interceptor {

	public void intercept(Invocation inv) {
		// TODO Auto-generated method stub
		System.out.println("MethodIntercept........");
		inv.invoke();
	}

}
