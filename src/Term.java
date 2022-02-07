public class Term
{
        private int mExponent = 1, mCoefficient = 1;
        private char mBase = ' ';
        private String mPassedSubstring;
        private String substring = "";

        public Term(String substring)
        {
            mPassedSubstring = substring;
        }
        public void parseCoefficient(String substring)
        {
            String tempString = " ";
            for(int i = 0; i <substring.length(); i++)
            {
                tempString = tempString.concat(Character.toString(substring.charAt(i)));
            }
            if(!tempString.equals(" "))
            {
                mCoefficient = Integer.parseInt(tempString); //may have to replace " " "" here
            }
        }
        public void parseVariable(String substring)
        {
            String tempString = " ";
            for(int i = 0; i <substring.length(); i++)
            {
                tempString = tempString.concat(Character.toString(tempString.charAt(i)));
            }
            if(!tempString.equals(" "))
            {
                tempString = tempString.replace("^", "");
                mBase = tempString.replace(" ", "").charAt(0);
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
        public void parseSubstring() {
            mPassedSubstring = mPassedSubstring.replace(" ", "");
            int count = 0;

            //first coeff
            while (mPassedSubstring.charAt(count) >= 48 && mPassedSubstring.charAt(count) <= 57)
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
            while(mPassedSubstring.length() > 0 && (!(mPassedSubstring.charAt(count)>= 48) || !(mPassedSubstring.charAt(count) <= 57)))
            {
                //variable = variable.concat(Character.toString(mPassedSubstring.charAt(count)));
                count++;
            }
            if(count>0)
            {
                parseVariable(mPassedSubstring);
            }
            if(mPassedSubstring.indexOf('^') != -1)
            {
                mPassedSubstring = mPassedSubstring.substring(mPassedSubstring.indexOf('^'));
            }
            else
            {
                return;
            }
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
        public int getExponent()
        {
            return mExponent;
        }
        public int getCoefficient()
        {
            return mCoefficient;
        }
        public char getVariable()
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
        public String toString()
        {
            return ("This term: " + mCoefficient + mBase + mExponent+ "\nexponent = " + mExponent + ", coefficient = " + mCoefficient + ", variable = " + mBase);
        }

}
