package org.jfree.data.test;

import org.jfree.data.Range;
import org.junit.*;

import junit.framework.TestCase;

public class TestRange extends TestCase {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	protected void setUp() throws Exception {
		exampleRange = new Range(-1, 1);
	}

	@After
	protected void tearDown() throws Exception {
	}

	
	@Test
	public void testCentralValueShouldBeZero(){ 
		assertEquals("The central value of -1 and 1 should be zero.", 0, exampleRange.getCentralValue(), .000000001d);
	}
	
	 
	
	private Range exampleRange;
	
}
