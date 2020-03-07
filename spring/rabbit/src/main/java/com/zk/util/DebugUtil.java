package com.zk.util;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import java.lang.reflect.Method;

public class DebugUtil {

	public static <T> T traceCall(Class clazz) {
		Enhancer enchaner = new Enhancer();
		//设置被代理的类
		enchaner.setSuperclass(clazz);
		//创建一个回调接口
		Callback interceptor = new MethodInterceptor() {

			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
					throws Throwable {
				String name = clazz.getName();
				String[] split = name.split("\\.");
				System.err.println( split[split.length-1] + "  ： " + method.getName());
//				System.err.println("原方法声明的类为 " + method.getDeclaringClass());
//				System.err.println("我是 " + (String) proxy.invokeSuper(obj, args));
//				System.err.println("我调用结束了");
				if("requiredViewClass".equals(method.getName())){
					Class<? extends FreeMarkerView> aClass = ((FreeMarkerView) traceCall(FreeMarkerView.class)).getClass();
					System.out.println("className:"+aClass.getName());
					return aClass;


				}
				return proxy.invokeSuper(obj, args);
			}
		};
		enchaner.setCallback(interceptor);
		return (T) (enchaner.create());
	}
}
