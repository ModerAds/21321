package Project;

import java.io.IOException;
import java.util.*;

import static Project.Customer.Login;
import static Project.Customer.Register;

public class MainMenu {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("----ONLINE SHOPPING SYSTEM----");
		System.out.println("Choose whether you are an Admin or a Customer");
		System.out.println("1.Admin \n2.Customer \n3.Exit ");
		int choice = in.nextInt();

		switch (choice) {
		case 1:
			adminMenu();
			break;
		case 2:
			customerMenu();
			break;
		case 3:
			System.out.println("Exiting from program..\nThankyou for using this shopping system!");
			System.exit(0);
		default:
			System.out.print("Invalid Choice\n");
		}
	}
	public static void adminMenu() throws IOException {

		System.out.println("1.Register \n2.Admin Login \n3.Back ");
		int choosemaina = in.nextInt();
		switch (choosemaina) {
			case 1:
				Administrator.Register();
				break;
			case 2:
				Administrator.Login();
				break;
			case 3:
				MainMenu.main(null);
				break;
			default:
				System.out.print("Invalid Choice\n");
		}
	}
	static void afterloginadmin(Administrator i) throws IOException {
		System.out.println("\nWelcome " + i.AdminName + "\nChoose option");
		System.out.println("1.Manage Account(Admin)\n2.Item Menu\n3.Back");
		int choosea = in.nextInt();

		switch (choosea) {
			case 1:
				Administrator.Manage_Account(i.adminid);
				break;
			case 2:
				ItemAdmin.itemAdminMenu();
				break;
			case 3:
				adminMenu();
				break;
			default:
				System.out.println("Invalid choice");
		}
	}
	public static void customerMenu() throws IOException {
		System.out.println("1.Register \n2.Login \n3.View Items\n4.Back ");
		int choosemainc = in.nextInt();
		switch (choosemainc) {
			case 1:
				Register();
				break;
			case 2:
				Login();
				break;
			case 3:
				Item.ViewOnly();
			case 4:
				MainMenu.main(null);
				break;
			default:
				System.out.print("Invalid Choice\n");
		}
	}
}