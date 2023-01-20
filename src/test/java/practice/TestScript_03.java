package practice;

import org.testng.annotations.Test;

public class TestScript_03 {
	
	@Test(groups = {"regression"})
	public void script05() {
		System.out.println("script05");
	}
    
	@Test(groups = {"smoke"})
	public void script06() {
		System.out.println("script06");
	}

	
}
