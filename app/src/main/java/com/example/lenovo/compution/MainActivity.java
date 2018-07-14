package com.example.lenovo.compution;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText content;
    private StringBuffer str=new StringBuffer();
    private boolean need=false;
    private boolean log_index_need=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init()
    {
        content=findViewById(R.id.content);
        findViewById(R.id.btn_clear).setOnClickListener(this);
        findViewById(R.id.btn_clear_one).setOnClickListener(this);
        findViewById(R.id.btn_btd).setOnClickListener(this);
        findViewById(R.id.btn_bth).setOnClickListener(this);
        findViewById(R.id.btn_dtb).setOnClickListener(this);
        findViewById(R.id.btn_dth).setOnClickListener(this);
        findViewById(R.id.btn_mod).setOnClickListener(this);
        findViewById(R.id.btn_sub).setOnClickListener(this);
        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_multi).setOnClickListener(this);
        findViewById(R.id.btn_divide).setOnClickListener(this);
        findViewById(R.id.btn_point).setOnClickListener(this);
        findViewById(R.id.btn_equal).setOnClickListener(this);
        findViewById(R.id.btn_log).setOnClickListener(this);
        findViewById(R.id.btn_left).setOnClickListener(this);
        findViewById(R.id.btn_right).setOnClickListener(this);
        findViewById(R.id.btn_index).setOnClickListener(this);
        findViewById(R.id.btn_0).setOnClickListener(this);
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
        findViewById(R.id.btn_4).setOnClickListener(this);
        findViewById(R.id.btn_5).setOnClickListener(this);
        findViewById(R.id.btn_6).setOnClickListener(this);
        findViewById(R.id.btn_7).setOnClickListener(this);
        findViewById(R.id.btn_8).setOnClickListener(this);
        findViewById(R.id.btn_9).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        boolean flag=false;
        switch(v.getId())
        {
            case R.id.btn_clear:
                content.setText("0");
                content.setSelection(1);
                str=new StringBuffer("");
                flag=true;
                break;
            case R.id.btn_clear_one:
                str=new StringBuffer(str.toString().substring(0,str.length()-1));
                break;
            case R.id.btn_equal:
                //函数处理
                if(need) {
                    Toast.makeText(this,"正在进行四则运算",Toast.LENGTH_SHORT).show();
                    GetSuffix Mygetsuffix = new GetSuffix(str.toString());
                    //得到后缀表达式
                    String suffix = Mygetsuffix.getResult();
                    //由后缀表达式获得结果
                    Compute Mycompute = new Compute(suffix);
                    String answer = Mycompute.getAnswer();
                    content.setText(answer);
                    content.setSelection(answer.length());
                    flag = true;
                    need=false;
                    log_index_need=false;
                    break;
                }
                if(log_index_need && str.toString().contains("^"))
                {
                    Toast.makeText(this,"正在乘方运算",Toast.LENGTH_SHORT).show();
                    int a=Integer.valueOf(str.substring(0,str.indexOf("^")));
                    double b=Double.valueOf(str.substring(str.indexOf("^")+1));
                    a=(int) Math.pow(a, b);
                    content.setText(String.valueOf(a));
                    content.setSelection(String.valueOf(a).length());
                    flag = true;
                    need=false;
                    log_index_need=false;
                    break;
                }
                if(log_index_need && str.toString().contains("log") && str.toString().charAt(0)=='l')
                {
                    Toast.makeText(this,"正在进行LOG运算",Toast.LENGTH_SHORT).show();
                    double a=Double.valueOf(str.substring(3,str.length()));
                    a=Math.log10(10);
                    System.out.println(a);
                    content.setText( String.valueOf((double)Math.round(a*100)/100 ));
                    content.setSelection(str.length());
                    flag = true;
                    need=false;
                    log_index_need=false;
                    break;
                }
                need=false;
                log_index_need=false;
                break;
            case R.id.btn_add:
                str.append("+");
                need=true;
                break;
            case R.id.btn_sub:
                str.append("-");
                need=true;
                break;
            case R.id.btn_multi:
                str.append("*");
                need=true;
                break;
            case R.id.btn_divide:
                str.append("/");
                need=true;
                break;
            case R.id.btn_mod:
                str.append("%");
                need=true;
                break;

            case R.id.btn_left:
                str.append("(");
                break;
            case R.id.btn_right:
                str.append(")");
                break;
            case R.id.btn_log:
                str.append("log");
                log_index_need=true;
                break;

            case R.id.btn_index:
                str.append("^");
                log_index_need=true;
                break;

            case R.id.btn_0:
                str.append("0");
                break;
            case R.id.btn_1:
                str.append("1");
                break;
            case R.id.btn_2:
                str.append("2");
                break;
            case R.id.btn_3:
                str.append("3");
                break;
            case R.id.btn_4:
                str.append("4");
                break;
            case R.id.btn_5:
                str.append("5");
                break;
            case R.id.btn_6:
                str.append("6");
                break;
            case R.id.btn_7:
                str.append("7");
                break;
            case R.id.btn_8:
                str.append("8");
                break;
            case R.id.btn_9:
                str.append("9");
                break;
            case R.id.btn_point:
                str.append(".");
                break;

            case R.id.btn_btd:
                Toast.makeText(this,"二进制转十进制",Toast.LENGTH_SHORT).show();
                if(str.toString().contains("2") || str.toString().contains("3")  || str.toString().contains("4")
                        || str.toString().contains("5")
                        || str.toString().contains("6")
                        || str.toString().contains("7")
                        || str.toString().contains("8")
                        || str.toString().contains("9") || str.toString().contains("^") || str.toString().contains("log") ) {
                    flag = true;
                    content.setText("false");
                    content.setSelection(5);
                    break;
                }
                String temp=String.valueOf(Integer.valueOf(str.toString(),2));
                content.setText(temp);
                content.setSelection(temp.length());
                flag=true;
                break;
            case R.id.btn_bth:
                Toast.makeText(this,"二进制转十六进制",Toast.LENGTH_SHORT).show();
                if(str.toString().contains("2") || str.toString().contains("3")  || str.toString().contains("4")
                        || str.toString().contains("5")
                        || str.toString().contains("6")
                        || str.toString().contains("7")
                        || str.toString().contains("8")
                        || str.toString().contains("9") || str.toString().contains("^") || str.toString().contains("log")) {
                    flag = true;
                    content.setText("false");
                    content.setSelection(5);
                    break;
                }
                temp=String.valueOf(Integer.toHexString((Integer.valueOf(str.toString(),2))));
                content.setText(temp);
                content.setSelection(temp.length());
                flag=true;
                break;
            case R.id.btn_dtb:
                Toast.makeText(this,"十进制转二进制",Toast.LENGTH_SHORT).show();
                temp=String.valueOf(Integer.toBinaryString(Integer.valueOf(str.toString())));
                content.setText(temp);
                content.setSelection(temp.length());
                flag=true;
                break;
            case R.id.btn_dth:
                Toast.makeText(this,"十进制转十六进制",Toast.LENGTH_SHORT).show();
                temp=String.valueOf(Integer.toHexString((Integer.valueOf(str.toString()))));
                content.setText(temp);
                content.setSelection(temp.length());
                flag=true;
                break;
        }
        if(!flag) {
            content.setText(str);
            content.setSelection(str.length());
        }
    }
}
