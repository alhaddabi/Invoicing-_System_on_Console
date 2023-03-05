package InvoicingPackage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class mathods {
	
	
	transient Scanner sr = new Scanner(System.in);
	ArrayList<Shop> shopList = new ArrayList<Shop>();
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	ArrayList<Items> itemList = new ArrayList<Items>();
	ArrayList<invoice> InvoicList = new ArrayList<invoice>();

	//////////////////////////////////////////////SHOP/////////////////////////////////////////////////////////////////////////////////////
	public void AddshopDetails()
	     {
		boolean t1 = false;
		do {
			t1 = false ;
		try // for handing the exception 
		{
		Shop temShop = new Shop();
		System.out.println("Enter the shop name ");
		String shopName = sr.next();
		temShop.setShopName(shopName);
		System.out.println("Enter the shop ID ");
		int shopId = sr.nextInt();
		temShop.setShopId(shopId);
	
		shopList.add(temShop);
		}
		 catch (InputMismatchException w) { // for handing the try and showing the given pritn insted of showing an error excpation
				System.out.println("who comes the ID could be a String!!!!!! please focuse and repet ");
				System.out.println("========= repeat shop name & ID =================");
				t1 = true;
				sr.nextLine(); // with out the sc.nextLine() there will be an infinty loop going 
			}
	      }while(t1); //  we have to do (do - while) to make the condation happen
		
		}
	
	public void printShopDetails()
	{
		for (Shop a : shopList)
		{
		System.out.println("the shop name is : "+a.getShopName()+"======");
		}
	
	}

	
	
	////////////////////////////////////////////////////ITEMS//////////////////////////////////////////////////////////////////////////////////
	

	public void AddItem() {
	   	Items temitem = new Items();
	    System.out.println("Enter the invoice ID  ");
	    String itemnam = sr.next();
	    temitem.setItemaName(itemnam);
	    System.out.println("Enter the items price");
	    double price = sr.nextDouble();
	    temitem.setUnitPrice(price);
	    System.out.println("please Enter the number of iteams");
	    int itemnumber = sr.nextInt();
	    temitem.setNumbverOfItems(itemnumber);
  //  System.out.println("item ID is automaticlyy generated based on the indext ");
	    int itemId = itemList.size();
	    temitem.setIteamId(itemId);
	    itemList.add(temitem);
	    try
	    {
	    	BufferedWriter writer = new BufferedWriter(new FileWriter("item_output2.txt"));
	    	for(Items a : itemList)
			{
				writer.write("the Customer name is : "+a.getItemaName()+"======\n");
				writer.write("the item price is :    "+a.getItemsPrice()+"======\n");
				writer.write("the item number is :   "+a.getNumbverOfItems()+"======\n");
				writer.write("the item ID is :       "+a.getIteamId()+"======\n");
			}
	    	writer.close();
	    }catch (IOException o) {		
			o.printStackTrace();
			
		}
	}
	    //////////////////////////////////////////////
	    
	    public void addInvoiceItems()
	    {
	    	invoice invoi = new invoice();
	    	System.out.println("Enter the invoice Id");
	    	int invoiceItemsId = sr.nextInt();
	    	System.out.println("Enter the invoice ID");
	    	int invoiceID = sr.nextInt();
	    	System.out.println("Enter the items ID");
	    	int itemsID = sr.nextInt();
	    	System.out.println("Enter the item Name ");
	    	String itemName = sr.next();
	    	System.out.println("Enter the unit price ");
	    	double unitPrice = sr.nextDouble();
	    	
	    	
	    	
	    	
		    
		    String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=invoice;" + "encrypt=true;"
					+ "trustServerCertificate=true";
			String user = "sa";
			String pass = "root";
			
			
			Connection con = null;
			
			try {
				Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				DriverManager.registerDriver(driver);
				con = DriverManager.getConnection(url, user, pass);
				Statement st = con.createStatement();
			
		    String sql = "INSERT INTO InvoiceItems (Invoice_Id,Item_Id,Item_Name,UnitPrice,Quantity,Qty_Amount)"+
		            "VALUES ("+"1, 1,"+ itemnam+","+price+","+itemnumber+","+itemId+ ")";
		    System.out.println(sql);

			Integer m = st.executeUpdate(sql);
			if (m >= 1) {
				System.out.println("inserted successfully : " + sql);
			} else {
				System.out.println("insertion failed");
			}
			String sql1 = "Select * from Employee_Type";
			ResultSet resultSet = st.executeQuery(sql1);
		    
			con.close();
			} catch (Exception ex) {
				System.err.println(ex);
			}
			 
			}
		
	    	
	

	

	
	
	public void printCustomerName() 
	{
		for(Customer a : customerList)
		{
			System.out.println("the customer name is : "+a.getCustomerFullName());
		}
	}
	
	
		
	public void print()
	{
		for(Items a : itemList)
		{
			System.out.println("the item price is :    "+a.getItemsPrice()+"======");
			System.out.println("the item number is :   "+a.getNumbverOfItems()+"======");
			System.out.println("the item ID is :       "+a.getIteamId()+"======");
		}
	}
	
	public void deleteItems()
	{
		System.out.println("Enter the id number to remove");
		int indextnumber = sr.nextInt();
		itemList.get(indextnumber);// get or set . arrayList is always based on the indext number (what every number you type i'll consider as indext )
		itemList.remove(indextnumber);
		System.out.println("the item removed");
	}
	
	public void changeitemprice()
	{
		System.out.println("Enter the ID number to iteam you want to change ");
		int induxtnumber = sr.nextInt();
		Items tempItem = new Items();
		tempItem=itemList.get(induxtnumber);
		System.out.println("Enter the new price ");
		tempItem.setItemsPrice(sr.nextInt());
		itemList.set(induxtnumber, tempItem);
		System.out.println("the item have been chanced ");
	}
	
	public void countItems()
	{
		int totalItems = 0 ;
		for(Items a : itemList)
		{
			totalItems = totalItems + a.getNumbverOfItems();
			
		}
		System.out.println("The total Items is : "+totalItems);
	}
	
	public void totalsales() 
	{
		double totalPrice = 0;
		for(Items a : itemList)
		{
			totalPrice = totalPrice + a.getItemsPrice();
			
		}
		System.out.println("The total price is : "+totalPrice);
	}
	
	public void countInvoice()
	{
		int invoice = 1;
		for(Items a : itemList)
		{
			invoice = invoice + a.getIteamId();
			
		}
		System.out.println("The total invoice number is : "+invoice);
	}
	
	

	//////////////////////////////////////////////CUSTOMER///////////////////////////////////////////////////////////////////////////////////////
	
	public void ADDcustomer()
	{
		Customer customer = new Customer();
		System.out.println("Enter the customer name");
		String customerName = sr.next();
		customer.setCustomerFullName(customerName);
		System.out.println("Enter the custoemr Phone number  ");
		int customerPhomeNumber = sr.nextInt();
		customer.setCustomerPhoneNumber(customerPhomeNumber);
		customerList.add(customer);
		
		
		  String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=invoice;" + "encrypt=true;"
					+ "trustServerCertificate=true";
			String user = "sa";
			String pass = "root";
			
			
			Connection con = null;
			
			try {
				Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				DriverManager.registerDriver(driver);
				con = DriverManager.getConnection(url, user, pass);
				Statement st = con.createStatement();
			
		    String sql = "INSERT INTO Customers (Customer_Full_Name,Customer_Phone_Number)"
		
		            +"VALUES ('"+customerName+"','"+customerPhomeNumber+"')";
		    System.out.println(sql);

			Integer m = st.executeUpdate(sql);
			if (m >= 1) {
				System.out.println("inserted successfully : " + sql);
			} else {
				System.out.println("insertion failed");
			}
			String sql1 = "Select * from Employee_Type";
			ResultSet resultSet = st.executeQuery(sql1);
		    
			con.close();
			} catch (Exception ex) {
				System.err.println(ex);
			}
			 
			}
////////////////////////////////////////////////////////////////////////////////INVOICE////////////////////////////////////////////////////////////////////////////////////////////
	public void addInvoice()
	{		
		System.out.println("Enter the invoice id ");
		int invoiceId = sr.nextInt();
		System.out.println("Enter the customer ID ");
		int customerId = sr.nextInt();
		System.out.println("enter the invoice Date");
		String invoiceDate = sr.next();
		System.out.println("Enter number of Items");
		int itemsNumber = sr.nextInt();
		System.out.println("Enter the total amount");
		double totalAmount = sr.nextDouble();
		System.out.println("Enter the paid amount ");
		double paidAmount = sr.nextDouble();
		System.out.println("Enter the total balance");
		double totalbalance = sr.nextDouble();
		
		
		

		  String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=invoice;" + "encrypt=true;"
					+ "trustServerCertificate=true";
			String user = "sa";
			String pass = "root";
			
			
			Connection con = null;
			
			try {
				Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				DriverManager.registerDriver(driver);
				con = DriverManager.getConnection(url, user, pass);
				Statement st = con.createStatement();
			
		    String sql = "INSERT INTO Invoices (Invoice_Id,Customer_Id,Invoice_Date,Number_Of_Items,total_Amount,paid_Amount,totkal_Balance)"
		
		  +"VALUES ("+invoiceId+","+customerId+",'"+invoiceDate+"',"+itemsNumber + "," +totalAmount+","+ paidAmount+","+totalbalance+")";
		    System.out.println(sql);

			Integer m = st.executeUpdate(sql);
			if (m >= 1) {
				System.out.println("inserted successfully : " + sql);
			} else {
				System.out.println("insertion failed");
			}
			String sql1 = "Select * from Employee_Type";
			ResultSet resultSet = st.executeQuery(sql1);
		    
			con.close();
			} catch (Exception ex) {
				System.err.println(ex);
			}

	}
	
	

	
	public void printcustomer()
	{
		for(Customer a : customerList)
		{
			System.out.println("customer full name is : "+a.getCustomerFullName());
			System.out.println("customer phone is     : "+a.getCustomerPhoneNumber());

		}
	}
	
	/////////////////////////////////////////////////////////////////////InvoicingSystem///////////////////////////////////////////////////////////
	public void invoiceDate()
	{
		for(invoice a : InvoicList)
		{
			System.out.println("invoice date is "+a.getInvoicDate()+"/1/2023");
		}
	
	}
	
	public void ReportStatistics()
	{
			countItems();
			countInvoice();
	}
	
	
	
	public void allInvoices()
	{
		countInvoice();
		invoiceDate();
		for(Customer a : customerList)
		{
		System.out.println("Custoemr name is : "+a.getCustomerFullName());
		}
		countItems();
		totalsales();
	}
	
}
