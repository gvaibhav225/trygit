package assign11;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class verifytest {

	testcase t;
	
	@BeforeEach
	public void setUp() {
		t=new testcase();
	}

	@Test
	public void v(){
		boolean result=t.verifylaptop(new laptop(1,"hp","4gbram"));
		Assert.assertTrue(result);
	}
	
	@Test
	public void v1(){
		boolean result=t.verifylaptop(new laptop(1,"lenovo","4gbram"));
		Assert.assertFalse(result);
	}
	
	
}
