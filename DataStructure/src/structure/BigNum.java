package structure;

public class BigNum
{
    public static String add(String valueStr1,String valueStr2)
    {
        if(valueStr1==null || valueStr2==null || "".equals(valueStr1) || "".equals(valueStr2))
            return "ParamError";
        valueStr1=new StringBuilder(valueStr1).reverse().toString();
        valueStr2=new StringBuilder(valueStr2).reverse().toString();
        StringBuilder result= new StringBuilder();
        int i=0;
        int carry=0;
        while(i<valueStr1.length() || i<valueStr2.length())
        {
            int m;
            try{
                if(i>=valueStr2.length()) m=parse(valueStr1,i)+carry;
                else if(i>=valueStr1.length()) m=parse(valueStr2,i)+carry;
                else m=parse(valueStr1,i)+parse(valueStr2,i)+carry;
            }catch (NumberFormatException e)
            {
                return "ParamError";
            }
            carry=m/10;
            m%=10;
            result.append(m);
            i++;
        }
        if(carry==1) result.append(1);
        return result.reverse().toString();
    }
    private static Integer parse(String str,int i) throws NumberFormatException
    {
        return Integer.parseInt(str.substring(i,i+1));
    }
}
