package Project;

import java.io.*;
import java.util.*;

import static Project.MainMenu.adminMenu;
import static Project.MainMenu.afterloginadmin;

public class Administrator implements Serializable, Proxy {
	String AdminName;
	private String adminemailid;
	int adminid;
	private int AdminPassword;

	static ArrayList<Administrator> AdministratorList = new ArrayList<Administrator>();
	static Scanner in = new Scanner(System.in);

	Administrator(String AdminName, String adminemailid, int AdminPassword, int adminid) 
	{
		this.AdminName = AdminName;
		this.adminemailid = adminemailid;
		this.AdminPassword = AdminPassword;
		this.adminid = adminid;
	}

	static void Register() throws IOException {
		System.out.println("Enter Name: ");
		String AdminName = in.next();
		System.out.println("Enter emaild: ");
		String adminemailid = in.next();
		System.out.println("Enter password (numbers only): ");
		int AdminPassword = in.nextInt();
		System.out.println("Enter admin id (numbers only): ");
		int adminid = in.nextInt();

		Administrator New = new Administrator(AdminName, adminemailid, AdminPassword, adminid);
		System.out.print("Admin Successfully Registered");
		afterloginadmin(New);
	}

	static void Login() throws IOException {
		System.out.println("Enter Admin id: ");
		int adminid = in.nextInt();
		System.out.println("Enter password: ");
		int AdminPassword = in.nextInt();

		for (Administrator i : AdministratorList) {
			if (i.adminid == adminid && i.AdminPassword == AdminPassword) {
				afterloginadmin(i);
			} else {
				System.out.println("Admin id and password does not match/exist");
				adminMenu();
			}
		}
	}



	public static String toString(Administrator i) {
		return "\nName: " + i.AdminName + "\nemailid: " + i.adminemailid + "\nid: " + i.adminid;
	}

	static void Manage_Account(int id) throws IOException {
		for (Administrator i : AdministratorList) {
			if (i.adminid == id) {
				Administrator old = i;
				System.out.println(toString(i));
				System.out.println("MANAGE ACCOUNT\n1.Change password\n2.Change emailid\n3.Back");

				int choicea = in.nextInt();
				switch (choicea) {
				case 1:
					System.out.println("Enter old password: ");
					int oldp = in.nextInt();
					if (i.AdminPassword == oldp) {
						System.out.println("Enter new password: ");
						int AdminPassword = in.nextInt();
						Administrator Newp = new Administrator(i.AdminName, i.adminemailid, AdminPassword, i.adminid);
						AdministratorList.add(Newp);
						System.out.println("Password changed successfully");
					}
					break;
				case 2:
					System.out.println("Enter emaild: ");
					String adminemailid = in.next();
					Administrator Newe = new Administrator(i.AdminName, adminemailid, i.AdminPassword, i.adminid);
					AdministratorList.add(Newe);
					System.out.println("emailid changed successfully");
					break;
				case 3:
					afterloginadmin(i);
					break;
				default:
					System.out.println("Invalid Option");
				}
				AdministratorList.remove(old);

				afterloginadmin(i);
			}
		}
	}


	@Override
	public void display() {

	}
}