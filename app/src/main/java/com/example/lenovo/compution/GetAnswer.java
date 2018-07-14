package com.example.lenovo.compution;


public class GetAnswer {

    private String left;
    private String opertion;
    private String right;
    public GetAnswer(String a,String b,String c)
    {
        left=a;
        opertion=b;
        right=c;
	    	/*
	    	//10进制转2进制
	    	System.out.println(Integer.toBinaryString(Integer.valueOf(a)));
	    	//10进制转16进制
	    	System.out.println(Integer.toHexString((Integer.valueOf(a))));
	    	//2进制转10进制
	    	System.out.println(Integer.valueOf(a,2).toString());
	    	//2进制转16进制
	    	System.out.println(Integer.toHexString((Integer.valueOf(Integer.valueOf(a,2).toString()))));
	    	*/
    }
    public String Answer()
    {
        String result=null;
        double a;
        double b;

        if(left.contains("^")  || left.contains("log"))
        {
            if(left.contains("^"))
                a=getNumberWithIndex(left);
            else
                a=getNumberWithLog(left);
        }
        else
            a=Double.valueOf(left);
        if(right.contains("^")  || right.contains("log"))
        {
            if(right.contains("^"))
                b=getNumberWithIndex(right);
            else
                b=getNumberWithLog(right);
        }
        else
            b=Double.valueOf(right);
        switch( opertion.charAt(0) )
        {
            case '+':
                result=String.valueOf(a+b);
                break;
            case '-':
                result=String.valueOf(a-b);
                break;
            case '*':
                result=String.valueOf(a*b);
                break;
            case '/':
                result=String.valueOf(a/b);
                break;
            case '%':
                result=String.valueOf(a%b);
                break;
        }
        return result;
    }
    public double getNumberWithIndex(String str)
    {
        double a=Double.valueOf(str.substring(0,str.indexOf("^")));
        double b=Double.valueOf(str.substring(str.indexOf("^")+1));
        a=Math.pow(a, b);
        return a;
    }
    public double getNumberWithLog(String str)
    {
        double a=Double.valueOf(str.substring(3,str.length()));
        a=Math.log10(10);
        return (double)Math.round(a*100)/100;
    }
    public String toBinary(String a)
    {
        return Integer.toBinaryString(Integer.valueOf(a));
    }
}