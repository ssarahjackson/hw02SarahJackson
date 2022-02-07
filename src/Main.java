import java.util.Scanner;
class Main
{
    public static void Main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String polynomial;
        System.out.println("Please enter the polynomial: ");
        polynomial = keyboard.nextLine();
        Polynomial userPoly = new Polynomial(polynomial);
        userPoly.parseTerms();
        userPoly.printTerms();
        keyboard.close();
    }
}