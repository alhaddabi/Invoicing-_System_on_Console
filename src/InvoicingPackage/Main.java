package InvoicingPackage;

import java.util.Scanner;

public class Main {
	private static int menuCount = 0;
	
	public static void main(String[] args) throws Exception {
		
		

		mathods mathod = new mathods();
		boolean i = true;
		Scanner sr = new Scanner(System.in);
		
		
		 String user = "sa";
		 String pass = "root";
		 boolean passwordCondation = true ;
		 while (passwordCondation)
		 {
		 System.out.println("Enter username");
		 String username = sr.next();
		 System.out.println("Enter password");
		 String password = sr.next();

		 if (username.equals(user) && password.equals(pass))
		 {
			 passwordCondation = false ;
		 }
		 else if (username != (user) && password != (pass)) 
		 {
		 System.out.println("worng username and password ");
		 
		 }


		 }
		 boolean hasPerformedAction = false;


		System.out.println("====================  Invoicing System  =========================");
		while (i) {
			menuCount++;
			System.out.println("1- Shop Settings");
			System.out.println("2- Manage Shop Items");
			System.out.println("3- creating the table in the dataBase");
			System.out.println("4. Get all the dataBase information ");
			System.out.println("5. Find the Invoice ");
			System.out.println("6- EXIT");
			int switch1 = sr.nextInt();

			if (switch1 == 1) {
				boolean manu1 = true;
				while (manu1) {
					System.out.println("1. Load Data");
					System.out.println("2. Set Shop Name");
					System.out.println("3. add invoice header");
					System.out.println("4. Back");
					int choose = sr.nextInt();
					switch (choose) {
					case 1:
//						int count = 1;
//						System.out.println("======================= Invoices " + count
//								+ "==========================================");
//						mathod.printInvoicingHeader();
//						mathod.printCustomerName();
//						mathod.print();
//						mathod.printShopDetails();
						mathod.loadDataFormInvoiceItems();
						mathod.loadDAataFromInvoice();
//						count++;
						break;

					case 2:
						mathod.AddshopDetails();
						break;
					case 3:
			          mathod.invoiceheardr();
						break;
					case 4:
						manu1 = false;
					}


				}
			}

			else if (switch1 == 2) {
				boolean manu2 = true;
				while (manu2) {
					System.out.println("1. Add Items & customer");
					System.out.println("2. Delete Items or customer");
					System.out.println("3. update Item Price  or Customer Phone number");
					System.out.println("4. Report: All Invoices");
					System.out.println("5. Report: Statistics)");
					System.out.println("6. addInvoiceItems");
					System.out.println("7. Go Back");
					int choose1 = sr.nextInt();
					switch (choose1) {
					case 1:
						System.out.println("=====FIRST Enter the customer details=====");
						mathod.ADDcustomer();
						mathod.addInvoice();
						break;
					case 2:
						boolean deleteCondation = true ;
						while(deleteCondation)
						{
						System.out.println("Select what you want to delete");
						System.out.println("1. Delete Items");
						System.out.println("2. Delete Customer");
						System.out.println("3. Back");
						int chosee = sr.nextInt();
						if(chosee == 1)
						{
						mathod.deletDataBaseItems();
						}
						else if (chosee == 2)
						{
					    mathod.deletDataBaseCustomer();
						}
						else if (chosee == 3)
						{
							deleteCondation = false ;
						}
						}
					break;
					
					
					case 3:
						boolean updateCondation = true ;
						while (updateCondation)
						{
						System.out.println("Select what you want to update");
						System.out.println("1. update the price");
						System.out.println("2. update the customer phone number");
						System.out.println("3. Back");
						int newUpdate = sr.nextInt();
						if (newUpdate == 1)
						{
						mathod.updateDataBsePrice();
						}
						else if (newUpdate == 2)
						{
							mathod.updateDataBseCustomerPhone();
						}
						else if (newUpdate == 3)
						{
							updateCondation = false ;
						}
						}
						break;

					case 4:
						mathod.countInvoice();

						for (Customer a : mathod.customerList) {
							System.out.println("customer name is : " + a.getCustomerFullName());
						}
						for (invoice a : mathod.InvoicList) {
							System.out.println("the invoice date is :" + a.getInvoicDate() + "/1/2023");
						}
						mathod.totalsales();
						mathod.countItems();
						break;

					case 5:
						mathod.ReportStatistics();
					
						break;
	
					case 6:
						mathod.addInvoiceItems();
						break;

					case 7:
						manu2 = false;
						break;

					}
				}
			}
			
			else if(switch1 == 3)
			{
				
		          if (switch1 == 3 && !hasPerformedAction) { // perform action only if user input is 1 and action has not been performed already
		        	  mathod.createTables();
			          System.out.println("Performing action...");
			          hasPerformedAction = true; // set flag to true to indicate that action has been performed
			        } 
		          else 
			        {
			            System.out.println("Action cannot be performed again.");
			        }	
				
				break;
			}
			
			else if (switch1 == 4)
			{
                System.out.println("==================== Customer =========================================");				
				mathod.printCustomerDataBase();
				System.out.println("==================== Invoice =========================================");	
				mathod.printinvoiceDataBase();
				System.out.println("==================== Items =========================================");	
				mathod.printInvoiceItems();
				System.out.println("==================== Invoice Header =========================================");
				mathod.printInvoiceHeader();
				break;
			}
			
			else if (switch1 == 5)
			{
				mathod.findInvoice();
				break;
			}

		else if (switch1 == 6)
		{
		System.out.println("Are you sure you want to exit?  yes / no");
		String exitt = sr.next();
		if (exitt.equals("yes")) {
			i = false;
			System.out.println("thanks!!!!!!! ");
		} else {
			
		}

	}

		}
	}
}

	


