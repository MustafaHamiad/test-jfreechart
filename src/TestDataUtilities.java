package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValue;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;
import java.lang.Comparable;



public class TestDataUtilities extends DataUtilities {
	
	private static final double EPSILON = 0.000000001;
	
	public TestDataUtilities(){
		
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
 
		
		
	}

	@After
	public void tearDown() throws Exception {
 
	}

	
	
	/**** 	CalculateColumnTotal  ****/
	/*Test Case 1*/
	@Test(expected=NullPointerException.class)
	public void testCalculateColumnTotalForDataNullAndColLowerZero() {
		// setup
		final Values2D valuesCalculateColumnTotal = null;
		// exercise	
		assertEquals(0, DataUtilities.calculateColumnTotal(valuesCalculateColumnTotal, -2), EPSILON);
		
			// tear-down: NONE in this test method
	}

	/*Test Case 2*/
	@Test
	public void testCalculateColumnTotalForDataNotNullAndColWithinRange() {	
		// setup
				final Values2D valuesCalculateColumnTotal;
				Mockery mockingContext = new Mockery();
				/*
				 *  data:
				 *  [1 2]
				 *  [1 2]
				 *  column: 1
				 */ 
				valuesCalculateColumnTotal = mockingContext.mock(Values2D.class); 
				mockingContext.checking(new Expectations() {
					{
						one(valuesCalculateColumnTotal).getRowCount(); 
						will(returnValue(2)); 
						one(valuesCalculateColumnTotal).getColumnCount();
						will(returnValue(2));
						one(valuesCalculateColumnTotal).getValue(0, 0); 
						will(returnValue(1)); 
						one(valuesCalculateColumnTotal).getValue(1, 0); 
						will(returnValue(1));
						one(valuesCalculateColumnTotal).getValue(0, 1); 
						will(returnValue(2));
						one(valuesCalculateColumnTotal).getValue(1, 1); 
						will(returnValue(2));
					} 
				});
				
		// exercise
		double result = DataUtilities.calculateColumnTotal(valuesCalculateColumnTotal, 1); // verify	
		assertEquals("msg: ", 4, result, EPSILON);
		
		// tear-down: NONE in this test method
	}
	
	
	/*Test Case 3*/
	@Test(expected=InvalidParameterException.class)
	public void testCalculateColumnTotalForDataNotNullAndColBiggerRange() {	
		// setup
				final Values2D valuesCalculateColumnTotal;
				Mockery mockingContext = new Mockery();
				/*
				 *  data:
				 *  [1]
				 *  column: -5
				 */ 
				valuesCalculateColumnTotal = mockingContext.mock(Values2D.class); 
				mockingContext.checking(new Expectations() {
					{
						one(valuesCalculateColumnTotal).getRowCount(); 
						will(returnValue(0)); 
						one(valuesCalculateColumnTotal).getColumnCount();
						will(returnValue(0)); 
						one(valuesCalculateColumnTotal).getValue(0, 1);
						will(returnValue(null));
					} 
				});
				
		// exercise
			 double result = DataUtilities.calculateColumnTotal(valuesCalculateColumnTotal, 3);
			 assertEquals(0,result , EPSILON);	
		
		// tear-down: NONE in this test method
	}
	
	
	/**** 	CalculateRowTotal  ****/
	/*Test Case 1*/
	@Test(expected=InvalidParameterException.class)
	public void testCalculateRowTotalForDataNotNullAndRowLowerZero() throws InvalidParameterException
	{	
		// setup
				final Values2D valuesCalculateRowTotal;
				Mockery mockingContext = new Mockery();
				/*
				 *  data:
				 *  not null
				 *  row: -2
				 */ 
				valuesCalculateRowTotal = mockingContext.mock(Values2D.class); 
				mockingContext.checking(new Expectations() {
					{
						one(valuesCalculateRowTotal).getRowCount(); 
						will(returnValue(1)); 
						one(valuesCalculateRowTotal).getColumnCount();
						will(returnValue(1));  
					} 
				});
				
		// exercise 
		assertEquals(0, DataUtilities.calculateRowTotal(valuesCalculateRowTotal, -2), EPSILON);			
		// tear-down: NONE in this test method
	}
	
	/*Test Case 2*/
	@Test
	public void testCalculateRowTotalForDataNotNullAndRowWithinRange() {	
		// setup
				final Values2D valuesCalculateRowTotal;
				Mockery mockingContext = new Mockery();
				/*
				 *  data:
				 *  [1 2]
				 *  [1 2]
				 *  row: 1
				 */ 
				valuesCalculateRowTotal = mockingContext.mock(Values2D.class); 
				mockingContext.checking(new Expectations() {
					{
						one(valuesCalculateRowTotal).getRowCount(); 
						will(returnValue(2)); 
						one(valuesCalculateRowTotal).getColumnCount();
						will(returnValue(2));
						one(valuesCalculateRowTotal).getValue(0, 0); 
						will(returnValue(1)); 
						one(valuesCalculateRowTotal).getValue(1, 0); 
						will(returnValue(1));
						one(valuesCalculateRowTotal).getValue(0, 1); 
						will(returnValue(2));
						one(valuesCalculateRowTotal).getValue(1, 1); 
						will(returnValue(2));
					} 
				});
				
		// exercise 
		assertEquals(3, DataUtilities.calculateRowTotal(valuesCalculateRowTotal, 1), EPSILON);		
		// tear-down: NONE in this test method
	}
	
	/*Test Case 3*/
	@Test(expected=InvalidParameterException.class)
	public void testCalculateRowTotalForDataNotNullAndRowBiggerRange() {	
		// setup
				final Values2D valuesCalculateRowTotal;
				Mockery mockingContext = new Mockery();
				/*
				 *  data:
				 *  [1]
				 *  column: -5
				 */ 
				valuesCalculateRowTotal = mockingContext.mock(Values2D.class); 
				mockingContext.checking(new Expectations() {
					{
						one(valuesCalculateRowTotal).getRowCount(); 
						will(returnValue(0)); 
						one(valuesCalculateRowTotal).getColumnCount();
						will(returnValue(0));  
					} 
				});
				
		// exercise
			 double result = DataUtilities.calculateRowTotal(valuesCalculateRowTotal, 3);
			 assertEquals(0,result , EPSILON);	
		
		// tear-down: NONE in this test method
	}

	
	/**** 	CreateNumberArray  ****/
	/*Test Case 1*/
	@Test
	public void testCreateNumberArrayValid(){
		double[] data = {1.4, 2.2, 1.0};
		Number[] actual = DataUtilities.createNumberArray(data);
		Number[] expected = {1.4, 2.2, 1.0};
		assertArrayEquals(expected, actual);
	}
	
	/*Test Case 2*/
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArrayInvalid(){
		double[] data = null;
		Number[] expected = null;
		Number[] actual = DataUtilities.createNumberArray(data);
		
		assertArrayEquals(expected, actual);
	}
	
	/**** 	CreateNumberArray2D  ****/
	/*Test Case 1*/
	@Test
	public void testCreateNumberArray2DValid(){
		double[][] data = {{1.2, 1.2}};
		Number[][] actual = DataUtilities.createNumberArray2D(data);
		Number[][] expected = {{1.2, 1.2}};
		assertArrayEquals(expected, actual);
	}
	
	/*Test Case 2*/
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArray2DInvalid(){
		double[][] input = null;
		Number[][] expected = null;
		Number[][] actual = DataUtilities.createNumberArray2D(input);
		assertArrayEquals(expected, actual);
	}
	
	/**** 	getCumulativePercentages  ****/
	/*Test Case 1*/
	@Test
	public void testGetCumulativePercentagesValid(){
	//setup
		/*
		 * data :
		 *  KEY	VALUE
		 *   0	  5
		 *   1	  9
		 */
		//for actual data
		final KeyedValues data;
		Mockery mockingContext = new Mockery();
		data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				
				one(data).getItemCount();
				will(returnValue(2));
				oneOf(data).getValue(0);
				will(returnValue(5));
				oneOf(data).getValue(1);
				will(returnValue(9));	 
			} 
		});
		
		
		//for expected data
		final KeyedValues expected;
		Mockery mockingContext2 = new Mockery();
		expected = mockingContext2.mock(KeyedValues.class);
		mockingContext2.checking(new Expectations() {
			{ 
				one(expected).getItemCount();
				will(returnValue(2));
				oneOf(expected).getValue(0);
				will(returnValue(0.3125));
				oneOf(expected).getValue(1);
				will(returnValue(0.875));
			} 
		});

	// exercise
		KeyedValues actual = DataUtilities.getCumulativePercentages(data);
		assertSame(expected, actual);	
	}
	 
	/*Test Case 1*/
	@Test(expected= InvalidParameterException.class)
	public void testGetCumulativePercentagesInvalid(){
		KeyedValues expected = null; 
		KeyedValues actual = DataUtilities.getCumulativePercentages(null);
		
	}
}
