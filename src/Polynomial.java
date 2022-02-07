import java.util.ArrayList;
public class Polynomial
{
    private String passedPoly;

    ArrayList<Term> polynomialTerms = new ArrayList<>();
    public Polynomial(String polynomial)
    {
        passedPoly = polynomial.replaceAll("\\s", "");

    }
    public void parseTerms()
    {
        for(int i = 0; i < passedPoly.length(); i++)
        {
            if(passedPoly.charAt(i) == '-' ||passedPoly.charAt(i) == '+')
            {
                String substring = passedPoly.substring(0, i);
                passedPoly = passedPoly.substring(i+1);//removes the term from the polynomial
                Term newTerm = new Term(substring);
                newTerm.parseSubstring();
                substring = "";
                polynomialTerms.add(newTerm);
            }
            else if((passedPoly.length()-1) == i)
            {
                Term newTerm = new Term(passedPoly);
                newTerm.parseSubstring();
                polynomialTerms.add(newTerm);
            }
        }
    }
    public ArrayList<Term> getTerms()
    {
        return polynomialTerms;
    }
    public void printTerms()
    {
        for (Term polynomialTerm : polynomialTerms)
        {
            System.out.println(polynomialTerm.toString());
        }
    }
}