package Project;

import java.io.*;
import java.util.*;

import static Project.MainMenu.customerMenu;

public class Customer implements Serializable, Proxy {
	private String Name, Address, emailid, Phoneno;
	private int id, Password;
	static ArrayList<Customer> CustomerList = new ArrayList<Customer>();
	static Scanner in = new Scanner(System.in);

	Customer(String Name, String Address, String emailid, String Phoneno, int id, int Password) {
		this.Name = Name;
		this.Address = Address;
		this.emailid = emailid;
		this.Phoneno = Phoneno;
		this.id = id;
		this.Password = Password;
	}

	static void Register() throws IOException {
		System.out.println("Enter Name: ");
		String name= String.valueOf(Singleton.GetInstance());
		name = in.next();
		System.out.println("Enter Address: ");
		String address = in.next();
		address = String.valueOf(Singleton.GetInstance());
		System.out.println("Enter emaild: ");
		String emailid=String.valueOf(Singleton.GetInstance());
		emailid = in.next();
		System.out.println("Enter PhoneNumbers: ");
		String phonenum = String.valueOf(Singleton.GetInstance());
		phonenum=in.next();
		System.out.println("Enter id (numbers only): ");
		int id = in.nextInt();
		System.out.println("Enter password (numbers only): ");
		int Password = in.nextInt();

		Customer New = new Customer(name, address, emailid, phonenum, id, Password);
		CustomerList.add(New);
		System.out.print("User Successfully Registered");
		afterlogin(New);
	}

	static void Login() throws IOException {
		System.out.println("Enter UserName id: ");
		int id = in.nextInt();
		System.out.println("Enter password: ");
		int Password = in.nextInt();

		for (Customer i : CustomerList) {
			if (i.id == id && i.Password == Password) {
				afterlogin(i);
			} else {
				System.out.println("User id and password does not match/exist");
				customerMenu();
			}
		}
	}

	static void afterlogin(Customer i) throws IOException {
		System.out.println("\nWelcome " + i.Name + "\nChoose option");
		System.out.println("\n1.Item Menu\n2.Manage Account\n3.Back");
		int choose2c = in.nextInt();

		switch (choose2c) {
		case 1:
			Item.itemMenu();
			break;
		case 2:
			Manage_Account(i.id);
			break;
		case 3:
			customerMenu();
			break;
		default:
			System.out.print("Invalid Choice\n");
		}
	}

	static void Manage_Account(int id) throws IOException {
		for (Customer i : CustomerList) {
			if (i.id == id) {
				Customer old = i;
				System.out.println(toString(i));
				System.out.println("MANAGE ACCOUNT\n1.Change Password\n2.Change Address\n3.Change Phoneno"
						+ "\n4.Change emailid\n5.Back");

				int choosec = in.nextInt();
				switch (choosec) {
				case 1:
					System.out.println("Enter old password: ");
					int oldp = in.nextInt();
					if (i.Password == oldp) {
						System.out.println("Enter new password: ");
						int Password = in.nextInt();
						Customer Newp = new Customer(i.Name, i.Address, i.emailid, i.Phoneno, i.id, Password);
						CustomerList.add(Newp);
						System.out.println("Password changed successfully");
					}
					break;
				case 2:
					System.out.println("Enter new Address: ");
					String Address = in.next();
					Customer Newa = new Customer(i.Name, Address, i.emailid, i.Phoneno, i.id, i.Password);
					CustomerList.add(Newa);
					System.out.println("Address changed successfully");
					break;
				case 3:
					System.out.println("Enter new Phone number: ");
					String Phoneno = in.next();
					Customer Newpn = new Customer(i.Name, i.Address, i.emailid, Phoneno, i.id, i.Password);
					CustomerList.add(Newpn);
					System.out.println("Phone No changed successfully");
					break;
				case 4:
					System.out.println("Enter emaild: ");
					String emailid = in.next();
					Customer Newe = new Customer(i.Name, i.Address, emailid, i.Phoneno, i.id, i.Password);
					CustomerList.add(Newe);
					System.out.println("emailid changed successfully");
					break;
				case 5:
					afterlogin(i);
					break;
				default:
					System.out.println("Invalid Option");
				}
				CustomerList.remove(old);
				afterlogin(i);
			}
		}
	}

	public static String toString(Customer i) {
		return "\nName: " + i.Name + "\nAddress: " + i.Address + "\nemailid: " + i.emailid + "\nPhoneno: " + i.Phoneno
				+ "\nid: " + i.id;
	}


	@Override
	public void display() {

	}
}
