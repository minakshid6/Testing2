package enableanddisable;

import org.testng.annotations.Test;

public class EnableConcept {
	
//	when enable = true then it run that method (by default enable is true) bu when enable is false it skip that perticular method
	
	
	@Test
	  public void add() 
	  {
		  
		System.out.println("add");  
		  
	  }
	  @Test(enabled = false)// enabled = false means this method will not execute
	  public void sub() 
	  {
		  
		System.out.println("sub");  
		
		  
	  }
	  
	  @Test(enabled = true)
	  public void mul() 
	  {
		  
		System.out.println("mul");  
		
		  
	  }
	  @Test(enabled = false)// enabled = false means this method will not execute
	  public void div() 
	  {
		  
		System.out.println("div");  
	  }	
 
}
