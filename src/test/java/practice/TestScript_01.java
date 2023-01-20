package practice;

import org.testng.annotations.Test;

public class TestScript_01 {
	
	@Test(groups = {"simple2"})
	public void script01() {
		System.out.println("script01");
	}
    
	@Test(groups = {"smoke","regression"})
	public void script02() {
		System.out.println("script02");
	}
}
