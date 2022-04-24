package priorityconcept;

import org.testng.annotations.Test;

public class ZeroNegativeAndPositive {

	@Test(priority = 0)
	  public void add() 
	  {
		  
		System.out.println("add");  
		  
	  }
	  @Test(priority = -3)
	  public void sub() 
	  {
		  
		System.out.println("sub");  
		
		  
	  }
	  
	  @Test(priority = 2)
	  public void mul() 
	  {
		  
		System.out.println("mul");  
		
		  
	  }
	  @Test(priority = 4)
	  public void div() 
	  {
		  
		System.out.println("div");  
	  }	
	
}
