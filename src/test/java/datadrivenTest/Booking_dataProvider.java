package datadrivenTest;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Booking_dataProvider {
	
	
	@DataProvider(name="tokenCreate")
	public String [][] createBookingToken() throws IOException  
	{
		
		String path=System.getProperty("user.dir")+"/src/test/java/datadrivenTest/bookingdata.xlsx";
		
     	int rownum=XLUtils.getRowCount(path,"Sheet2");
     	int colcount=XLUtils.getCellCount(path, "Sheet2",1);
     	
     	String tokendata[][]=new String[rownum][colcount];
     	
     	
     	
     	for(int i = 1; i<=rownum; i++)
     	{
     		for(int j=0; j<colcount; j++) {
     		
     			tokendata[i-1][j]=XLUtils.getCellData(path,"Sheet2",i,j);
     		}
     	}
     	
		
		
	     return(tokendata);

}
	@DataProvider(name="bookingcreatedata")
	public String [][] createBooking() throws IOException  
	{
		
		String path=System.getProperty("user.dir")+"/src/test/java/datadrivenTest/bookingdata.xlsx";
		
     	int rownum=XLUtils.getRowCount(path,"Sheet1");
     	int colcount=XLUtils.getCellCount(path, "Sheet1",1);
     	
     	String bookingdata[][]=new String[rownum][colcount];
     	
     	
     	
     	for(int i = 1; i<=rownum; i++)
     	{
     		for(int j=0; j<colcount; j++) {
     		
     			bookingdata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
     		}
     	}
     	
		
		//String bookingdata[][]= {{"vinay","sharma","210","true","2020-05-29","2020-06-20","breakfast"},{"mayank","sharma","200","true","2020-05-30","2020-06-21","breakfast"}};
	     return(bookingdata);
	     
	}

	@DataProvider(name="getBookingusername")
	public String [][] getbooking_username() throws IOException  
	{
		
		String path=System.getProperty("user.dir")+"/src/test/java/datadrivenTest/bookingdata.xlsx";
		
     	int rownum=XLUtils.getRowCount(path,"Sheet3");
     	int colcount=XLUtils.getCellCount(path, "Sheet3",1);
     	
     	String booking_data[][]=new String[rownum][colcount];
     	
     	
     	
     	for(int i = 1; i<=rownum; i++)
     	{
     		for(int j=0; j<colcount; j++) {
     		
     			booking_data[i-1][j]=XLUtils.getCellData(path,"Sheet3",i,j);
     		}
}
     	return(booking_data);
	}
	
	@DataProvider(name="getbookingId")
	public String [][] getbooking_Id() throws IOException  
	{
		
		String path=System.getProperty("user.dir")+"/src/test/java/datadrivenTest/bookingdata.xlsx";
		
     	int rownum=XLUtils.getRowCount(path,"bookingId");
     	int colcount=XLUtils.getCellCount(path, "bookingId",1);
     	
     	String booking_data[][]=new String[rownum][colcount];
     	
     	
     	
     	for(int i = 1; i<=rownum; i++)
     	{
     		for(int j=0; j<colcount; j++) {
     		
     			booking_data[i-1][j]=XLUtils.getCellData(path,"bookingId",i,j);
     		}
}
     	return(booking_data);
}
	@DataProvider(name="updateBooking")
	public String [][] booking_Update() throws IOException  
	{
		
		String path=System.getProperty("user.dir")+"/src/test/java/datadrivenTest/bookingdata.xlsx";
		
     	int rownum=XLUtils.getRowCount(path,"updateBooking");
     	int colcount=XLUtils.getCellCount(path,"updateBooking",1);
     	
     	String booking_data[][]=new String[rownum][colcount];
     	
     	
     	
     	for(int i = 1; i<=rownum; i++)
     	{
     		for(int j=0; j<colcount; j++) {
     		
     			booking_data[i-1][j]=XLUtils.getCellData(path,"updateBooking",i,j);
     		}
}
     	return(booking_data);
}
	@DataProvider(name="partialUpdateBooking")
	public String [][] partial_bookingUpdate() throws IOException  
	{
		
		String path=System.getProperty("user.dir")+"/src/test/java/datadrivenTest/bookingdata.xlsx";
		
     	int rownum=XLUtils.getRowCount(path,"partialBooking");
     	int colcount=XLUtils.getCellCount(path,"partialBooking",1);
     	
     	String booking_data[][]=new String[rownum][colcount];
     	
     	
     	
     	for(int i = 1; i<=rownum; i++)
     	{
     		for(int j=0; j<colcount; j++) {
     		
     			booking_data[i-1][j]=XLUtils.getCellData(path,"partialBooking",i,j);
     		}
}
     	return(booking_data);
}
}
	


