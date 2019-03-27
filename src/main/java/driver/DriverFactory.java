package driver;

public class DriverFactory {

	public DriverManager getManager(String type){

        DriverManager driverManager = null;
        if(type.equals("Chrome")) {
        	driverManager = new ChromeBrowser();
        }
        return driverManager;

    }
	
}
