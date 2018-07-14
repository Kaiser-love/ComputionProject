package com.example.lenovo.compution;

import java.io.*;
import java.util.*;
public class Compute
{
    String str;
    Stack<String> sta;
    String answer=null;
    public Compute(String a)
    {
        str=a;
        sta=new Stack<String>();
        dogetAnswer();
    }
    public void dogetAnswer()
    {

        int i;
        String temp = "";
        boolean flag=true;
        for (i = 0; i<str.length(); i++)
        {
            temp += str.charAt(i);
            if (str.charAt(i + 1) == ' ')
            {
                if(!(flag=oper(temp))) {
                    answer="false";
                    return;
                }
                i++;
                temp = "";
            }
        }
        System.out.println(sta.peek());
        answer=sta.peek();
        sta.pop();
    }
    public boolean oper(String a)
    {
        if (a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/")  || a.equals("%"))
        {
            if(sta.isEmpty())  return false;
            String b = sta.peek();
            sta.pop();
            if(sta.isEmpty())  return false;
            String b1 = sta.peek();
            sta.pop();
            GetAnswer k=new GetAnswer(b1,a,b);
            String result=k.Answer();
            sta.push(result);
        }
        else
            sta.push(a);
        return true;
    }
    public String getAnswer()
    {
        return answer;
    }
}

