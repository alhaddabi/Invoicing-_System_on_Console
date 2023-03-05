package InvoicingPackage;

import java.util.Scanner;

public class Main {
	private static int menuCount = 0;
	
	public static void main(String[] args) throws Exception {
		
		

		mathods mathod = new mathods();
		boolean i = true;
		Scanner sr = new Scanner(System.in);

		System.out.println("====================  Invoicing System  =========================");
		while (i) {
			menuCount++;
			System.out.println("1- Shop Settings");
			System.out.println("2- Manage Shop Items");
			System.out.println("3- EXIT");
			int switch1 = sr.nextInt();

			if (switch1 == 1) {
				boolean manu1 = true;
				while (manu1) {
					System.out.println("1. Load Data");
					System.out.println("2. Set Shop Name");
					System.out.println("3. Back");
					System.out.println("add invoice");
					int choose = sr.nextInt();
					switch (choose) {
					case 1:
						int count = 1;
						System.out.println("======================= Invoices " + count
								+ "==========================================");
						mathod.printCustomerName();
						mathod.print();
						mathod.printShopDetails();
						count++;
						break;

					case 2:
						mathod.AddshopDetails();
						break;

					case 3:
						manu1 = false;
						
					case 4:
			          mathod.addInvoice();
						break;
					}


				}
			}

			else if (switch1 == 2) {
				boolean manu2 = true;
				while (manu2) {
					System.out.println("1. Add Items");
					System.out.println("2. Delete Items");
					System.out.println("3. Change Item Price");
					System.out.println("4. Report: All Invoices");
					System.out.println("5. Report: Statistics)");
					System.out.println("6. Program Statistics (Print each Main Menu Item with how many number selected).");
					System.out.println("7. Go Back");
					int choose1 = sr.nextInt();
					switch (choose1) {
					case 1:
						System.out.println("=====FIRST Enter the customer details=====");
						mathod.ADDcustomer();
						mathod.AddItem();
						break;
					case 2:
						mathod.deleteItems();
						break;

					case 3:
						mathod.changeitemprice();
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
						System.out.println("menu count for main menu is "+menuCount+" time");
						break;

					case 7:
						manu2 = false;
						break;

					}
				}
			}
			else if (switch1 == 3)
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

		sr.close();
	}

}
