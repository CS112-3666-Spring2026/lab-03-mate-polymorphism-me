import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		CaffeinatedBeverage[] inventory = new CaffeinatedBeverage[10];
		Scanner keyboard = new Scanner(System.in);
		// Prompt user with options in a loop
		int choice, ounces, brewTemp, count = 0;
		String name;
		double price;

		do {
			System.out.println("1) Enter new Tea");
			System.out.println("2) Enter new Yerba Mate");
			System.out.println("3) Exit");
			System.out.print(">>");
			choice = keyboard.nextInt();
			keyboard.nextLine();

			switch (choice) {
				case 1: // Tea
					System.out.print("Enter name      : ");
					name = keyboard.nextLine();
					System.out.print("Enter ounces    : ");
					ounces = keyboard.nextInt();
					System.out.print("Enter price     $ ");
					price = keyboard.nextDouble();
					System.out.print("Enter brew temperature (in Celsius): ");
					brewTemp = keyboard.nextInt();
					keyboard.nextLine();

					// Create a Tea, put into array
					inventory[count] = new Tea(name, ounces, price, brewTemp);

					System.out.println("Your tea order has been added: " + inventory[count]);
					count++;
					break;

				case 2: //Yerba Mate
					if (count >= inventory.length) {
						System.out.println("Inventory is full.");
						break;
					}

					System.out.print("Enter name      : ");
					name = keyboard.nextLine();

					System.out.print("Enter ounces    : ");
					ounces = keyboard.nextInt();

					System.out.print("Enter price     $ ");
					price = keyboard.nextDouble();

					System.out.print("Enter brew temperature (in Celsius): ");
					brewTemp = keyboard.nextInt();
					keyboard.nextLine();

					inventory[count] = new YerbaMate(name, ounces, price, brewTemp, 0);

					System.out.println("Your Yerba Mate order has been added: " + inventory[count]);
					count++;
					break;

				case 3:
					System.out.println();
					System.out.println("Inventory:");

					for (int i = 0; i < count; i++) {
						System.out.println(inventory[i]);
					}

					System.out.println();

					YerbaMate highest = findHighestPricedYerbaMate(inventory);

					if (highest == null) {
						System.out.println("No Yerba Mate drinks were entered.");
					} else {
						System.out.println("Highest priced Yerba Mate:");
						System.out.println(highest);
					}

					System.out.printf(
							"Average price of all beverages: $%.2f%n",
							findAveragePrice(inventory));
					break;

				default:
					System.out.println("Invalid option. Please choose 1, 2, or 3.");
					break;

			}

			System.out.println();

		} while (choice != 3);

		keyboard.close();
	}
	
	public static double findAveragePrice(CaffeinatedBeverage[] inventory) {
        double total = 0.0;
        int count = 0;

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                total += inventory[i].getPrice();
                count++;
            }
        }

        if (count == 0) {
            return 0.0;
        }

        return total / count;
    }

	public static YerbaMate findHighestPricedYerbaMate(CaffeinatedBeverage[] inventory) {
        YerbaMate highest = null;

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] instanceof YerbaMate) {
                YerbaMate current = (YerbaMate) inventory[i];

                if (highest == null || current.getPrice() > highest.getPrice()) {
                    highest = current;
                }
            }
        }

        return highest;
    }
}