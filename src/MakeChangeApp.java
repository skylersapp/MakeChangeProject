
//	---User Story #1---
//	The user is prompted asking for the price of the item.
//
//	---User Story #2---
//	The user is then prompted asking how much money was tendered by the customer.
//
//	---User Story #3---
//	Display an appropriate message if the customer provided too little money or the exact amount.
//
//	---User Story #4---
//	If the amount tendered is more than the cost of the item, display the number of bills 
//	and coins that should be given to the customer.
import java.text.DecimalFormat;
import java.util.Scanner;

public class MakeChangeApp {
	// FIELDS
	static double price = 0;
	static double paid = 0;
	static Scanner sc = new Scanner(System.in);
	static DecimalFormat df = new DecimalFormat("#.##");
	// METHODS

	public static void main(String[] args) { // Main method

		System.out.println("\nWelcome to the cash register!\n");
		priceAndPaid();
		exactOrLowAndChange();
		sc.close();
	}

	public static void priceAndPaid() {
		double denverTax = 1.08;

// 						This method is User Stories #1 and #2.

		System.out.print("Please enter the: \nPurchase price of the item: $");
		price = sc.nextDouble();
		price = price * denverTax;
		price = Double.parseDouble(df.format(price));

		if (price > 0) {
			System.out.printf("\t(Price after tax is $%.2f", +price);
			System.out.print(")");
			System.out.print("\n\nHow much are you paying? $");
			paid = sc.nextDouble();
			paid = Double.parseDouble(df.format(paid));
			System.out.printf("\n      Item price (after tax) is: $%.2f", +price);
			System.out.printf("\n\tAmount tendered:\t $%.2f", +paid);
		}
		if (price <= 0) {
			System.out.println("\nThink you're funny, do ya? Please leave the store.");
			System.exit(0);
		}
	}

	public static void exactOrLowAndChange() {
		double change = paid - price;
		double low = price - paid;
		double paidAgain = 0.0;

		paid = Double.parseDouble(df.format(paid));
		change = Double.parseDouble(df.format(change));
		low = Double.parseDouble(df.format(low));
		paidAgain = Double.parseDouble(df.format(paidAgain));

		while (paid != price) {

			if (paid > price || paidAgain > price) {
				System.out.printf("\n\nThank you for your payment!" + "\nYour change is:  \t\t $%.2f", +change);
				break;
//							User Story #3

			} else if (paid < price && paid > 0) {
				System.out.println("\n\nYou did not provide enough money... " + "\nYou underpaid by $" + low);
				System.out.println("\n\n\t   (Price plus 8.31% tax is $" + price + ")");
				System.out.print("\nNew amount: $");
				paidAgain = sc.nextDouble();
				paid = paidAgain;
				change = paidAgain - price;
				continue;
			}

			else if (paid < 0) {
				System.out.println("\nThink you're funny, do ya? Please leave the store.");
				System.exit(0);
			}

			System.out.println("\n\n\t\tThank you so much! Have a GREAT day!");
//			System.exit(0);
		}
		if (paid == price) {
			System.out.println("\n\nWe love exact change! \n\n\t\tThank you so much! Have a GREAT day!");
			System.exit(0);
		}

//										User Story #4

		double penny = .01;
		double nickel = .05;
		double dime = .1;
		double quarter = .25;
		double single = 1;
		double five = 5;
		double ten = 10;
		double twenty = 20;
		double bills20 = (int) Math.floor(change / twenty);
		double bills10 = (int) Math.floor((change - bills20 * twenty) / ten);
		double bills5 = (int) Math.floor((change - bills20 * twenty - bills10 * ten) / five);
		double bills1 = (int) Math.floor((change - bills20 * twenty - bills10 * ten - bills5 * five));
		double coinsOwed = change - bills20 * twenty - bills10 * ten - bills5 * five - bills1 * single;
		coinsOwed = Math.round(coinsOwed * 100.0) / 100.0;
//		System.out.println("\nCoins Owed: " + coinsOwed);
		double coins25 = (int) Math.floor(coinsOwed / quarter);
		coinsOwed = coinsOwed - coins25 * quarter;
		coinsOwed = Math.round(coinsOwed * 100.0) / 100.0;
//		System.out.println("\nCoins Owed: " + coinsOwed);
		double coins10 = (int) Math.floor((coinsOwed / dime));
		coinsOwed = coinsOwed - coins10 * dime;
		coinsOwed = Math.round(coinsOwed * 100.0) / 100.0;
//		System.out.println("\nCoins Owed: " + coinsOwed);
		double coins05 = (int) Math.floor((coinsOwed / nickel));
		coinsOwed = coinsOwed - coins05 * nickel;
		coinsOwed = Math.round(coinsOwed * 100.0) / 100.0;
//		System.out.println("\nCoins Owed: " + coinsOwed);

		double coins01 = (coinsOwed / penny);
		System.out.println("\n");
		if (bills20 > 0) {
			if (bills20 > 1) {
				System.out.print("Twenties: " + (int) bills20 + "\n");
			} else if (bills20 == 1) {
				System.out.print("Twenty: " + (int) bills20 + "\n");
			}
		}
		if (bills10 > 0) {
			if (bills10 > 1) {
				System.out.print("Tens: " + (int) bills10 + "\n");
			} else if (bills10 == 1) {
				System.out.print("Ten: " + (int) bills10 + "\n");
			}
		}
		if (bills5 > 0) {
			if (bills5 > 1) {
				System.out.print("Fives: " + (int) bills5 + "\n");
			} else if (bills5 == 1) {
				System.out.print("Five: " + (int) bills5 + "\n");
			}
		}
		if (bills1 > 0) {
			if (bills1 > 1) {
				System.out.print("Ones: " + (int) bills1 + "\n");
			} else if (bills1 == 1) {
				System.out.print("One: " + (int) bills1 + "\n");
			}
		}
		if (coins25 > 0) {
			if (coins25 > 1) {
				System.out.print("Quarters: " + (int) coins25 + "\n");
			} else if (coins25 == 1) {
				System.out.print("Quarter: " + (int) coins25 + "\n");
			}
		}
		if (coins10 > 0) {
			if (coins10 > 1) {
				System.out.print("Dimes: " + (int) coins10 + "\n");
			} else if (coins10 == 1) {
				System.out.print("Dime: " + (int) coins10 + "\n");
			}
		}
		if (coins05 > 0) {
			if (coins05 > 1) {
				System.out.print("Nickels: " + (int) coins05 + "\n");
			} else if (coins05 == 1) {
				System.out.println("Nickel: " + (int) coins05 + "\n");
			}
		}
		if (coins01 > 0) {
			if (coins01 > 1) {
				System.out.print("Pennies: " + (int) coins01 + "\n");
			} else if (coins01 == 1) {
				System.out.println("Penny: " + (int) coins01 + "\n");
			}
		}
	}
}
