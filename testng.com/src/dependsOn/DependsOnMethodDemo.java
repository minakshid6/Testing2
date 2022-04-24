package dependsOn;

import org.testng.annotations.Test;

public class DependsOnMethodDemo {
	
	// depend on method wait for execution of another method on which it is depend
	
	@Test
	  public void add() 
	  {
		  
		System.out.println("add");  
		  
	  }
	  @Test
	  public void sub() 
	  {
		  
		System.out.println("sub");  
		
		  
	  }
	  
	  @Test(dependsOnMethods = "sub")
	  public void mul() 
	  {
		  
		System.out.println("mul");  
		
		  
	  }
	  @Test
	  public void div() 
	  {
		  
		System.out.println("div");  
	  }	
	
	
	
	
	
  
}
