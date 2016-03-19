package org.jfree.data.test;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import junit.framework.TestCase;
import java.lang.AssertionError;

public class TestDataUtilities extends TestCase {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	protected void setUp() throws Exception {
 
		
		
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	
	
	/**** 	CalculateColumnTotal  ****/
	
	
	/*Test Case 1*/
	@Test(expected=InvalidParameterException.class)
	public void testCalculateColumnTotalForDataNullAndColLowerZero() {
		// setup 
				/*
				 *  data:
				 *  NULL
				 *  column: -5
				 */  
				
		// exercise 
		try{
			double result = DataUtilities.calculateColumnTotal(null, -5); // verify
			assertNull("null data and col<0 should throw Invalid parameter exception: ", result);
		}catch(InvalidParameterException i){
			
		}
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
		assertEquals("msg: ", 4.0, result);
		
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
				 *  [1 2]
				 *  [1 2]
				 *  column: -5
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
		try{
			double result = DataUtilities.calculateColumnTotal(valuesCalculateColumnTotal, 2); // verify
			assertEquals(0.0, result, .000000001d);
		}catch(InvalidParameterException e){
			
		}
		
		
		
		// tear-down: NONE in this test method
	}
	
	
	/**** 	CalculateRowTotal  ****/
	
	/*Test Case 1*/
	@Test(expected=InvalidParameterException.class)
	public void testCalculateRowTotalForDataNotNullAndColWithinRange() {	
		// setup
				final Values2D valuesCalculateRowTotal;
				Mockery mockingContext = new Mockery();
				/*
				 *  data:
				 *  [1 2]
				 *  [1 2]
				 *  column: 1
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
				try{
					double result = DataUtilities.calculateRowTotal(valuesCalculateRowTotal, -2); // verify
					assertNull("not null data and row<0 should throw Invalid parameter exception: ",result);
				}catch(InvalidParameterException e){
					
				}
		// tear-down: NONE in this test method
	}
	
	 
	 

}
