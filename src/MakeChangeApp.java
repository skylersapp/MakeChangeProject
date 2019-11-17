
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
//	static double denverTax = 1.0831;
//	static double total = price * denverTax;
//	static double change = 0;

	static Scanner sc = new Scanner(System.in);

	// METHODS

	public static void main(String[] args) {

		System.out.println("\nWelcome to the cash register!\n");
		priceAndPaid();
		exactOrLow();
	}

	public static void priceAndPaid() {
		double denverTax = 1.08;
//		double total = price * denverTax;
// 						This method is User Stories #1 and #2.

		System.out.print("Please enter the: \nPurchase price of the item: $");
		price = sc.nextDouble();
//		price = price * denverTax;
		DecimalFormat df = new DecimalFormat("#.##");
		price = Double.parseDouble(df.format(price));
		System.out.println("\t(Price after tax is $" +price+ ")");
//		System.out.print(")");
		System.out.print("\nHow much are you paying? $");
		paid = sc.nextDouble();
		System.out.println("\n      Item price (after tax) is: $" +price);
		System.out.println("\n\tAmount tendered:\t $" +paid);
	}

	public static void exactOrLow() {
//		double denverTax = 1.0831;
//		double total = price * denverTax;
		double change = paid - price;
		double low = price - paid;
		double paidAgain = 0;

		while (paid != price) {
			if (paid > price) {
				System.out.println("\n\nThank you for your payment!" + "\nYour change is:  \t\t $" +change);
				break;
			} else if (paid < price) {
				System.out.println(
						"\n\nYou did not provide enough money... " + "\nPlease provide at least another: $" +low);
				System.out.println("\n\n\t   (Price plus 8.31% tax was $" +price+ ")");
//				System.out.print(")");
				System.out.print("\nNew amount: $");
				paidAgain = sc.nextDouble();
				paid = paidAgain;
				if (paidAgain > price) {
					change = paidAgain - price;
					// System.out.printf("\n\nThank you for your payment!" + "\nYour change
					// is:\t\t\t$%.2f", +change);
				} else {
					low = (price - paidAgain);
				}
			} else if (paidAgain == price) {
				System.out.println("\n\nWe love exact change! \n\n\t\tThank you so much! Have a GREAT day!");
				System.exit(0);
			}
		}
		while (paid == price) {
			System.out.println("\n\nWe love exact change! \n\n\t\tThank you so much! Have a GREAT day!");
			System.exit(0);
		}
		System.out.println("\n\n\t\tThank you so much! Have a GREAT day!");
		System.out.println("\nTHE END");
		System.exit(0);
	}
	
	public static void denominations() {
		double PENNIES = .01;
		double NICKELS = .05;
		double DIMES = .1;
		double QUARTERS = .25;
		double DOLLARS = 1;
		double FIVES = 5;
		double TENS = 10;
		double TWENTIES = 20;
	}
}
