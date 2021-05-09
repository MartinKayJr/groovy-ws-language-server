package org.codehaus.groovy.control;

import org.codehaus.groovy.control.io.FileReaderSource;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CompilationUnitTest {
	public static CompilationUnit compilationUnit;
	public static CompilerConfiguration configuration = new CompilerConfiguration();
	
	static {
		compilationUnit = new CompilationUnit(configuration);
	}
	
	@Test
	public void test() throws IOException {
		String file = "E:\\Workspace\\github\\groovy-language-server\\src\\test\\resources\\Definitions_groovy.txt";
		
		SourceUnit sourceUnit = SourceUnit.create("Definitions.groovy", new String(Files.readAllBytes(Paths.get(file))));
		compilationUnit.addSource(sourceUnit);
		compilationUnit.compile(6);
		System.out.println();
	}
}
