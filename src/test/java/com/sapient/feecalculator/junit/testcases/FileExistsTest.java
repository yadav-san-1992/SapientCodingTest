package com.sapient.feecalculator.junit.testcases;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class FileExistsTest {

	 @Test
	    public void testReadFileWithClassLoader(){
	        ClassLoader classLoader = this.getClass().getClassLoader();
	        File file = new File(classLoader.getResource("sampleData.txt").getFile());
	        assertTrue(file.exists());
	 
	    }
}
