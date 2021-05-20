package net.prominic.groovyls.util;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;

public class ScanUtil {
	public static ScanResult res;
	
	static {
		res = new ClassGraph().overrideClassLoaders(Thread.currentThread().getContextClassLoader())
		                      .enableClassInfo()
		                      .enableSystemJarsAndModules()
		                      .scan();
	}
}
