package Project;
import java.io.*;
import java.util.*;

import static Project.MainMenu.adminMenu;

public class ItemAdmin extends Item {
	static Item item=new Item();
	ItemAdmin(String ItemName, String ItemGroup, int Itemid, float ItemPrice) {
		super(ItemName, ItemGroup, Itemid, ItemPrice);
	}

	static void ViewItem(int Itemid) throws IOException {
		for (Item i : Item.ItemList) {
			if (i.getItemid() == Itemid) {
				System.out.println("\nid: " + i.getItemid() + "\nName: " + i.getItemName() + "\nGroup: "
						+ i.getItemGroup() + "\nPrice: " + i.getItemPrice());
				ItemAdmin.itemAdminMenu();
			} else {
				System.out.println("Invalid id..No such Item");
			}
		}
	}
	
	static void AddItem() throws IOException {
		System.out.println("Enter Item Name: ");
		String Name = in.next();
		System.out.println("Enter Item Group: ");
		String Group = in.next();
		System.out.println("Enter Item id: ");
		int id = in.nextInt();
		System.out.println("Enter Item Price: ");
		float Price = in.nextFloat();

		Item New = new Item(Name, Group, id, Price);
		ItemList.add(New);
		Set<Item> set=new LinkedHashSet<>(ItemList);
		System.out.print("Item added.");

		ItemAdmin.itemAdminMenu();
	}

	static void EditItem(int id) throws IOException {
		for (Item i : ItemList) {
			if (i.getItemid() == id) {
				Item old = i;
				System.out.println(toString(i));
				System.out.println("1.Change price\n2.Back");

				int choicei = in.nextInt();
				switch (choicei) {
				case 1:
					System.out.println("Enter updated price: ");
					float ItemPrice = in.nextFloat();
					Item Newe = new Item(i.getItemName(), i.getItemGroup(), i.getItemid(), ItemPrice);
					ItemList.add(Newe);
					ItemList.remove(old);
					System.out.println("Price changed successfully");
					break;
				case 2:
					ItemAdmin.itemAdminMenu();
					break;
				default:
					System.out.println("Invalid Option");
				}
				ItemAdmin.itemAdminMenu();
			}
		}
	}

	public static void itemAdminMenu() throws IOException {

		System.out.println("\n1.View all Items\n2.View selected item\n3.Edit Item\n4.Add Item\n5.Back");
		int choosea2 = in.nextInt();
		switch (choosea2) {
		case 1:
			item.ViewAll();
			break;
		case 2:
			System.out.println("Enter id of item to be viewed");
			int itemid = in.nextInt();
			ItemAdmin.ViewItem(itemid);
			break;
		case 3:
			System.out.println("Enter id of item to be edited");
			int itemid2 = in.nextInt();
			ItemAdmin.EditItem(itemid2);
			break;
		case 4:
			ItemAdmin.AddItem();
			break;
		case 5:
			adminMenu();
			break;
		default:
			System.out.println("Invalid Choice");
		}
	}
}