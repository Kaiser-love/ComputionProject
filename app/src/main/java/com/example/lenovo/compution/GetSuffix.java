package com.example.lenovo.compution;
import java.util.*;
import java.io.*;

public class GetSuffix {
    Stack<String> sta;
    String arti[];
    String str, letter[];
    int num = 0;
    String result = "";
    public GetSuffix(String a)
    {
        str=a;
        arti=new String[4];
        letter=new String[100];
        sta= new Stack<String>();
        arti[0] = "-"; arti[1] = "+"; arti[2] = "*"; arti[3] = "/";
        change();//对输入进行切分存在letter数组中
        find();  //对切分后的letter进行处理得到后缀表达式存在result中
    }
    public void change()
    {
        int i;
        int  len = str.length(), j = 0;
        String temp = "";
        for (i = 0; i < len; i++)
            if (str.charAt(i) == '(' || str.charAt(i) == ')')
                letter[j++] =String.valueOf(str.charAt(i));
            else if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' ||str.charAt(i) == '/' || str.charAt(i)=='%')
            {
                letter[j++] = String.valueOf(str.charAt(i));
                temp = "";
            }
            else
            {
                temp += str.charAt(i);
                if(i+1==len){
                    letter[j++] = temp;
                    temp = "";
                    break;
                }
                if (str.charAt(i+1) <= '9' &&  str.charAt(i+1) >= '0'||str.charAt(i+1)=='.' ||str.charAt(i+1) == '^' || str.charAt(i+1)== 'l' ||str.charAt(i+1) == 'o' || str.charAt(i+1) == 'g')
                    continue;
                else
                {
                    letter[j++] = temp;
                    temp = "";
                }
            }
        num = j;
    }
    public int judge(String a)
    {
        String t = sta.peek();
        int i, k1 = -1, k2 = 1;
        if ((t.equals("+") && a.equals("-")) || (t.equals("-")&& a.equals("+")))   return 1;
        else
        {
            for (i = 0; i < 4; i++)
                if (arti[i].equals(t))   k1 = i;
                else if (arti[i].equals(a))  k2 = i;
            if (k1 >= k2)  return 1;
            else         return 0;
        }
    }
    public void find()
    {
        int i;
        String tem;
        for (i = 0; i < num; i++)
            if (letter[i] .equals("+") || letter[i].equals("-") || letter[i].equals("*") || letter[i].equals("/") || letter[i].equals("%"))
            {
                while (true)
                {
                    if (sta.size() == 0 || judge(letter[i]) == 0)
                    {
                        sta.push(letter[i]);
                        break;
                    }
                    else
                    {
                        tem = sta.peek();
                        sta.pop();
                        result += tem + ' ';
                    }
                }
            }
            else if (letter[i].equals("("))
                sta.push(letter[i]);
            else if (letter[i] .equals(")"))
            {

                while ( !(tem = sta.peek()).equals("(") )
                {
                    sta.pop();
                    result += tem + ' ';
                }
                if (sta.peek().equals("("))
                    sta.pop();

            }
            else
                result += letter[i] + ' ';
        while (!sta.isEmpty())
        {
            result += sta.peek() + ' ';
            sta.pop();
        }
       // Compute k=new Compute(result);
    }
    public String getResult()
    {
        return result;
    }
}



