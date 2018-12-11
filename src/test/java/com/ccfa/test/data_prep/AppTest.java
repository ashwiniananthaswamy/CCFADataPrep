package com.ccfa.test.data_prep;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import com.ccfa.test.common.*;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rig Test :-)
	 */
	public void testApp() {
		assertTrue(true);
		awshelper helper = new awshelper();
		helper.ListS3Object();
		SpreadsheetData test = new SpreadsheetData();
		test.GetData("src/test/resources/DataPrepTest.xlsx");
		System.out.println("This test method should be run _______________________________________");
		
	}
	
}

