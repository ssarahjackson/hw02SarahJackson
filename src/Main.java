import java.util.Scanner;
class Main
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String polynomial;
        System.out.println("Enter polynomial: ");
        polynomial = keyboard.nextLine();
        Polynomial userPoly = new Polynomial(polynomial);
        userPoly.parseTerms();
        userPoly.printTerms();
        keyboard.close();
    }
}
