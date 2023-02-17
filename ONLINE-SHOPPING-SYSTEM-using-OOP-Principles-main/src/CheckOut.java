package Project;

import java.io.*;
import java.util.*;

public class CheckOut {

	private static String city, region,  district, housenum ,phonenum;

	static Scanner in = new Scanner(System.in);

	static void Details() throws IOException {
		System.out.println("The delivery details for your order: ");
		System.out.println("Enter City Address: ");
		city = in.next();
		System.out.println("Enter Region: ");
		region = in.next();
		System.out.println("Enter District:");
		district = in.next();
		System.out.println("Enter House number:");
		housenum = in.next();
		System.out.println("Enter Phone Number: ");
		phonenum = in.next();

	}

	public static void checkOut() throws IOException {

		System.out.println("--Mode of Payment--" + "\n" + "Choose the option:" + "\n" + "1. Debit /Credit /ATM cards"
				+ "\n" + "2. Cash on Delivery (COD)" + "\n" + "3.Back");

		int choice = in.nextInt();
		switch (choice) {
		// Cards
		case 1:
			CheckOut.Details();
			System.out.print("Enter the name of the card holder:");
			String cardName = in.next();
			System.out.print("Enter the card number:");
			long cardNo = in.nextLong();
			System.out.println("Enter CVV (the three digit number printed on the back of the card):");
			int cvv = in.nextInt();
			System.out.print("Enter the expiry DD/MM/YYYY");
			int expDate = in.nextInt();
			System.out.println("Verify you delivery details");
			System.out.println(city+"\n"+region+"\n"+district+"\n"+housenum+"\n"+phonenum+"\n");
			System.out.println("1. To continue payment" + "\n" + "2. To stop payment" + "\n");
			int cardchoice = in.nextInt();
			if (cardchoice == 1) {
				System.out.println("-----------Your order is success----------");
				System.out.println("Exiting from program..\nThankyou for using this shopping system!");
				System.exit(0);
			} else {
				System.out.println("-----------Your order is cancelled-----------");
				ShoppingCart.PrintInvoice();
			}
			break;

		// Cash on Delivery
		case 2:
			CheckOut.Details();
			System.out.println("Verify you delivery details");
			System.out.println(city+"\n"+region+"\n"+district+"\n"+housenum+"\n"+phonenum+"\n");
			System.out.println("\n" + "1. To continue the COD" + "\n" + "2. To stop the COD" + "\n");
			int codchoice = in.nextInt();
			if (codchoice == 1) {
				System.out.println("-----------Your order is success----------");
				System.out.println("Exiting from program..\nThankyou for using this shopping system!");
				System.exit(0);

			} else {
				System.out.println("-----------Your order is cancelled-----------");
				ShoppingCart.PrintInvoice();
			}
			break;

		case 3:
			ShoppingCart.PrintInvoice();
			break;
		}
	}
}