package net.prominic.groovyls.util;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;

public class ScanUtil {
	
	private ScanUtil() {
		res = new ClassGraph().overrideClassLoaders(Thread.currentThread().getContextClassLoader())
		                      .enableClassInfo()
		                      .enableAnnotationInfo()
		                      .enableSystemJarsAndModules()
		                      .scan();
	}
	private static class SingleTonHolder{
		private static final ScanUtil INSTANCE=new ScanUtil();
	}
	private final ScanResult res;
	
	public ScanResult getRes() {
		return res;
	}
	
	public static ScanUtil getInstance() {
		return SingleTonHolder.INSTANCE;
	}
}
