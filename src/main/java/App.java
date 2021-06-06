import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Kieran Jimenez
 */
/*
 *           "Self-Checkout" output
 *Enter the price of item 1: 25
 *Enter the quantity of item 1: 2
 *Enter the price of item 2: 10
 *Enter the quantity of item 2: 1
 *Enter the price of item 3: 4
 *Enter the quantity of item 3: 1
 *Subtotal: $64.00
 *Tax: $3.52
 *Total: $67.52
 */
public class App
{
    static Scanner in = new Scanner(System.in);
    static double taxRate = 0.055;

    public static void main(String[] args)
    {
        App myApp = new App();

        double firstItem = myApp.processItem(1);
        double secondItem = myApp.processItem(2);
        double thirdItem = myApp.processItem(3);

        myApp.calcTax(firstItem, secondItem, thirdItem, myApp);
    }

    private void calcTax(double first, double second, double third, App myApp)
    {
        double subtotal = first + second + third;
        double tax = subtotal * taxRate;
        double total = subtotal + tax;

        String subtotalLine = String.format("Subtotal: $%.2f", subtotal);
        String taxLine = String.format("Tax: $%.2f", tax);
        String totalLine = String.format("Total: $%.2f", total);

        myApp.output(subtotalLine, taxLine,totalLine);
    }
    private double processItem(int itemNum)
    {
        System.out.printf("Enter the price of item %d: ", itemNum);
        double price = in.nextDouble();
        System.out.printf("Enter the quantity of item %d: ", itemNum);
        int quantity = in.nextInt();

        return price * quantity;
    }

    private void output(String sub, String tax, String total)
    {
        System.out.println(sub);
        System.out.println(tax);
        System.out.println(total);
    }
}