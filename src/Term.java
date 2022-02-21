public class Term
{
    private int mExponent = 1, mCoefficient = 1;
    private char mBase = ' ';
    private String mPassedSubstring;
    //private String substring = "";

    public Term(String substring)
    {
        mPassedSubstring = substring;
    }
    public void parseCoefficient(String substring)
    {
        String tempString = " ";
        for(int i = 0; i < substring.length(); i++)
        {
            tempString = tempString.concat(Character.toString(substring.charAt(i)));
        }
        if(!tempString.equals(" "))
        {
            tempString = tempString.replace(" ", "");
            mCoefficient = Integer.parseInt(tempString);
        }
    }
    public void parseVariable(String substring)
    {
        String tempString = " ";
        for(int i = 0; i <substring.length(); i++)
        {
            tempString = tempString.concat(Character.toString(substring.charAt(i)));
        }
        if(!tempString.equals(" "))
        {
            tempString = tempString.replace("^", "");
            tempString = tempString.replace(" ", "");
            if(!tempString.equals(""))
            {
                mBase = tempString.charAt(0);
            }

        }
    }
    public void parseExponent(String substring)
    {
        String tempString = " ";
        for(int i = 0; i < substring.length(); i++)
        {
            tempString = tempString.concat(Character.toString(mPassedSubstring.charAt(i)));
        }
        if(tempString.equals(" "))
        {
            mExponent = 1;
        }
        else
        {
            mExponent = Integer.parseInt(tempString.replace(" ", ""));
        }
    }
    public void parseSubstring()
    {
        mPassedSubstring = mPassedSubstring.replace(" ", "");
        int count = 0;

        //first coeff
        String tempString = mPassedSubstring;
        if(mPassedSubstring.indexOf('^') != -1)
        {
            tempString = mPassedSubstring.substring(0, mPassedSubstring.indexOf('^'));
        }
        while(tempString.charAt(count) >= 48 && tempString.charAt(count) <= 57)
        {
            count++;
        }
        if(count>0)
        {
            String passedCoeffString = mPassedSubstring.substring(0, count);
            parseCoefficient(passedCoeffString);
            mPassedSubstring = mPassedSubstring.substring(count);
        }

        //next check for variable
        count=0;

        for(int i = 0; i < mPassedSubstring.length(); i++)
        {
            while(!(mPassedSubstring.charAt(i)>= 48) || !(mPassedSubstring.charAt(i) <= 57) && (!(count == mPassedSubstring.length())))
            {
                count++;
            }
        }
        if(count>0)
        {
            parseVariable(mPassedSubstring);
        }
        if(mPassedSubstring.indexOf('^') != -1)
        {
            mPassedSubstring = mPassedSubstring.substring(mPassedSubstring.indexOf('^'));
            count=0;
            int length = mPassedSubstring.length();
            while(length>0)
            {
                count++;
                length--;
            }
            if(count>0)
            {
                mPassedSubstring = mPassedSubstring.replace("^", "");
                parseExponent(mPassedSubstring);
            }
        }
        else
        {
            mExponent = 1;
        }

    }
    public int getExponent()
    {
        return mExponent;
    }
    public int getCoefficient()
    {
        return mCoefficient;
    }
    public char getBase()
    {
        return mBase;
    }
    public void setExponent(int exponent)
    {
        mExponent = exponent;
    }
    public void setCoefficient(int coefficient)
    {
        mExponent = coefficient;
    }
    public void setBase(char base)
    {
        mBase = base;
    }
    public void printTerm()
    {
        //System.out.println("coefficient: " + mCoefficient + " variable: " + mBase + " exponent: " + mExponent);

        if(mCoefficient == 1 && mExponent == 1)
        {
            System.out.print(mBase);
        }
        else if(mCoefficient == 1)
        {
            System.out.print(mBase + "^" + mExponent);
        }
        else if(mBase == 0)
        {
            System.out.print(mCoefficient + "");
        }
        else if(mExponent == 1)
        {
            System.out.print(mCoefficient + Character.toString(mBase));
        }
        else
        {
            System.out.print(mCoefficient + Character.toString(mBase) + "^" + mExponent);
        }

    }
}
