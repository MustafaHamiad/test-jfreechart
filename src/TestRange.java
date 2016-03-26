package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

import junit.framework.TestCase;

public class TestRange extends Range {

	public TestRange(){
		super(-1, 1);
	}
	/**
	 * 
	 */
	public Range exampleRange;
	
	public static final long serialVersionUID = 1L;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-1, 1);
	}

	@After
	public void tearDown() throws Exception {
	}
	 /** combine **/
	/* test case 1 */
	@Test
	public void testCombineNULLandNULL(){
		Range range1 = null;
		Range range2 = null;
		assertNull(Range.combine(range1, range2));
	}
	/* test case 2 */
	@Test
	public void testCombineNULLandNotNULL(){
		Range range1 = null;
		Range range2 = new Range(1,3);
		Range actual = Range.combine(range1, range2);
		assertEquals(range2, actual);
	}
	/* test case 3 */
	@Test
	public void testCombineNotNULLandNULL(){
		Range range2 = null;
		Range range1 = new Range(1,3);
		Range actual = Range.combine(range1, range2);
		assertEquals(range1, actual);
	}
	
	/** getLowerBound **/
	/* test case 1 */
	@Test
	public void testGetLowerBoundWithARange(){
		Range range2 = new Range(-1.9,3.8);
		double lowerBound = range2.getLowerBound();
		assertEquals(-1.9, lowerBound, .000000001d);
	}
	/* test case 2 */
	@Test
	public void testGetLowerBoundWithADotOnTheAxis(){
		Range range = new Range(4.6,4.6);
		double upperBound = range.getUpperBound();
		assertEquals(4.6, upperBound, .000000001d);
	}

	/** getUpperBound **/
	/* test case 1 */
	@Test
	public void testGetUpperBoundWithARange(){
		Range range = new Range(1.0,6.0);
		double upperBound = range.getUpperBound();
		assertEquals(6.0, upperBound, .000000001d);
	}
	/* test case 2 */
	@Test
	public void testGetUpperBoundWithADotOnTheAxis(){
		Range range = new Range(4.0,4.0);
		double upperBound = range.getUpperBound();
		assertEquals(4.0, upperBound, .000000001d);
	}
	
	/** intersects**/
	/* test case 1 */
	@Test
	public void testIntersectsFirstArgumentGreaterThanSecond(){
		Range range = new Range(2.0,6.0);
		assertFalse(range.intersects(4, 1));
	}
	
	/* test case 2 */
	@Test
	public void testIntersectsFirstArgumentSmallerThanSecond(){
		Range range = new Range(2.0,6.0);
		assertTrue(range.intersects(3, 4));
	}
	/* test case 3 */
	@Test
	public void testIntersectsFirstArgumentEqualsSecond(){
		Range range = new Range(2.0,6.0);
		assertTrue(range.intersects(5.0,5.0));
	}
	
	/** getCentralValue **/
	/* test case 1 */
	@Test
	public void testGetCentralValueWithARange(){
		Range range = new Range(-3.6,-1.6);
		double centralValue = range.getCentralValue();
		assertEquals(-2.6, centralValue, .000000001d);
	}
	/* test case 2 */
	@Test
	public void testGetCentralValueWithADotOnTheAxis(){
		Range range = new Range(-7.9,-7.9);
		double centralValue = range.getCentralValue();
		assertEquals(-7.9, centralValue, .000000001d);
	}
}
