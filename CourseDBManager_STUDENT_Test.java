

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManager_STUDENT_Test {
	CourseDBStructure stru, test;

	@Before
	public void setUp() throws Exception {
		stru = new CourseDBStructure(15);
		test = new CourseDBStructure("ForTesting", 15);
	}

	@After
	public void tearDown() throws Exception {
		stru = test = null;
	}
	
	/**
	 * To test the tableSize of the CourseDBStructure
	 */
	@Test
	public void testGetTableSize()
	{
		assertEquals(15, stru.getTableSize());
		assertEquals(15, test.getTableSize());		
	}
	
	/**
	 * Test the hashTable of the constructor
	 */
	@Test
	public void testHashTable()
	{
		assertEquals(15, stru.hashTable.length);
		CourseDBElement CDE = new CourseDBElement("CMSC204",52398,5,"RP500","Jah Morris"); 
		stru.add(CDE);
		LinkedList<CourseDBElement> list = stru.hashTable[CDE.hashCode()%stru.getTableSize()];
		assertEquals(52398, list.get(0).getCRN());
		test = new CourseDBStructure("ForTesting",15);
		assertEquals(15, test.hashTable.length);	
		test.add(CDE);
		list = test.hashTable[CDE.hashCode()%15];
		assertEquals(52398, list.get(0).getCRN());
	}
	
	@Test
	public void testGet()  {
		CourseDBElement CDE = new CourseDBElement("CMSC204",52398,5,"RP500","Jah Morris");  
		stru.add(CDE);
		try {
			stru.get(52398);
			assertEquals(CDE,stru.get(52398));
		}
		catch(IOException e) {
			assertTrue("Should throw an IOException",false);
		}
	}
} 
