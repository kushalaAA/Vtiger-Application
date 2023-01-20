
package practice;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {
	
	@Test
	public void Sample_01()
	{
		System.out.println("---TestScript1---");
		System.out.println("---TestScript2---");
		assertEquals("A", "B", "Script is Failed");
		System.out.println("---TestScript3---");
		System.out.println("---TestScript4---");
	}
	
	@Test
	public void Sample_02()
	{
		System.out.println("---TestScript5---");
		System.out.println("---TestScript6---");
		assertNotEquals("A", "B", "Script is Pass");
		System.out.println("---TestScript7---");
		System.out.println("---TestScript8---");
	}
	
	@Test
	public void Sample_03()
	{
		String a="testyantra";
		String b="qspider";
		assertTrue(a.equals(b));
		System.out.println("---Failed---");		
	}
	
	@Test
	public void Sample_04()
	{
		String a=null;
		assertNotNull(a);
		System.out.println("---Failed---");		
	}
	
	@Test
	public void Sample_05()
	{
		System.out.println("---test a---");	
		SoftAssert sa = new SoftAssert();
		sa.assertNotEquals("X", "Y");
		System.out.println("---Passed---");
	}
	@Test
	public void Sample_06()
	{
		System.out.println("---test 10---");
		SoftAssert sa = new SoftAssert();
		String s="shweta";
		String s1="chetan";
		assertTrue(s.contains(s1),"Test Script is failed");
		System.out.println("---Failed---");
	}

}
