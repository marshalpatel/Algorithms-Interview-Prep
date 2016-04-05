public class NumToString
{

    public static void main(String[] args)
    {
        System.out.println(numtoWord(10011));
    }

    public static String numtoWord(int num)
    {

        int count = 0;
        int place = 0;
       // int units = 0;
        String result = "";
        boolean unit_zero = false;
        boolean tens_zero = false;
        boolean hun_zero = false;

        while(num>0)
        {

            String u = "";
            String t = "";
            String h  = "";
            String chunk = "";
            place = 0;
            unit_zero = false;
            tens_zero = false;
            hun_zero = false;
            int units = 0;

            while(nplace < 3)
            {
                switch(place)
                {
                    case 0:
                    units = num%10;

                    if(units==0)
                        unit_zero = true;
                        u = getUnits(units);                      
                    break;

                    case 1:
                    int tens = num%10;

                    if(tens==0)
                        tens_zero = true;
                    
                    if(tens == 1)
                    {
                         t = getOneTens(num, units);
                         chunk = t + chunk;
                    }
                    else
                    {
                         t = getTens(tens);
                         chunk = t + u + chunk;
                    }
                    //get tens
                    break;

                    case 2:

                    int hunds = num%10;

                    if(hunds==0)
                        hun_zero = true;

                    h = getHundreds(hunds);
                    chunk =  h + chunk;
                    //get hundreds
                    break;
                }
                num = num/10;
                place ++;
                count ++;
            }

            if(!(unit_zero && tens_zero && hun_zero))
            {
                if(count >= 4 && count < 7)
                {
                    result = chunk + " thousand" + result;
                }

                else if(count >= 7 && count < 10)
                {
                    result = chunk + " million" + result;
                }

                else if(count >= 10 && count < 13)
                {
                    result = chunk + " billion" + result;
                }

                else
                {
                    result = chunk + result;
                }
            }
            

        }

        if(result.equals(""))
            result = "zero";

        return result;
    }



    private static String getUnits(int num)
    {
        switch(num)
        {

            case 0:
            return "";

            case 1:
            return " one";

            case 2:
            return " two";

            case 3:
            return " three";

            case 4:
            return " four";

            case 5:
            return " five";

            case 6:
            return " six";

            case 7:
            return " seven";

            case 8:
            return " eight";

            case 9:
            return " nine";

            default:
            return "";


        }
    }

    private static String getTens(int num)
    {
        switch(num)
        {
            
            case 0:
            return "";

            case 2:
            return " twenty";

            case 3:
            return " thirty";

            case 4:
            return " forty";

            case 5:
            return " fifty";

            case 6:
            return " sixty";

            case 7:
            return " seventy";

            case 8:
            return " eighty";

            case 9:
            return " ninety";

            default:
            return "";


        }
    }

    private static String getOneTens(int num, int units)
    {
        switch(units)
        {
            
            case 0:
            return " ten";

            case 1:
            return " eleven";

            case 2:
            return " twelve";

            case 3:
            return " thirteen";

            case 4:
            return "forteen";

            case 5:
            return " fifteen";

            case 6:
            return " sisxteen";

            case 7:
            return " seventeen";

            case 8: 
            return " eighteen";

            case 9:
            return " nineteen";

            default:
            return "";


        }
    }

    private static String getHundreds(int num)
    {
        switch(num)
        {

            case 0:
            return "";

            case 1:
            return " one hundred";

            case 2:
            return " two hundred";

            case 3:
            return " three hundred";

            case 4:
            return " four hundred";

            case 5:
            return " five hundred";

            case 6:
            return " six hundred";

            case 7:
            return " seven hundred";

            case 8:
            return " eight hundred";

            case 9:
            return " nine hundred";

            default:
            return "";


        }
    }


}