package org.codehaus.groovy.control;

import com.google.common.io.CharStreams;
import lombok.SneakyThrows;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.FieldNode;
import org.codehaus.groovy.control.io.FileReaderSource;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CompilationUnitTest {
	public static CompilationUnit compilationUnit;
	public static CompilerConfiguration configuration = new CompilerConfiguration();
	
	static {
		compilationUnit = new CompilationUnit(configuration);
	}
	
	@Test
	@SneakyThrows
	public void test() {
		InputStream inputStream = new ClassPathResource("Definitions_groovy.txt").getInputStream();
		SourceUnit sourceUnit = SourceUnit.create("Definitions.groovy", CharStreams.toString(new InputStreamReader(inputStream)));
		compilationUnit.addSource(sourceUnit);
		compilationUnit.compile(6);
		ClassNode classNode = compilationUnit.getAST().getClass("Definitions");
		System.out.println();
	}
	
	@Test
	@SneakyThrows
	public void test1(){
		URI uri = new URI("inmemory://model/1");
		String scheme = uri.getScheme();
		System.out.println(uri.getPath());
	}
}
