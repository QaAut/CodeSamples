package dataProviders;

import org.testng.annotations.DataProvider;

public class DataProvider1 {
	@DataProvider(name="quantityBox")
	public Object [] [] getData() {
		return new Object [][] {
				{"2"},
				{"99"}
				
		};
	}

}
