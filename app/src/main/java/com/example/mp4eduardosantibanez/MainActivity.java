package com.example.mp4eduardosantibanez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


class ButtonAction{
    private float a;
    private float b;
    private String op;
    public void setarg1(float a){
        this.a=a;
    }
    public float getarg1(){
        return a;
    }
    public void setarg2(float b){
        this.b=b;
    }
    public void setop(String op){
        this.op=op;
    }
    public String getOp(){
        return op;
    }
    public float addition(float a,float b){
        return a+b;
    }
    public float subtraction(float a, float b){
        return a-b;
    }
    public float multiplication(float a, float b){
        return a*b;
    }
        }
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    ButtonAction test=new ButtonAction();
    public void b7(View view) {
        int numv =view.getId();
        TextView number=(TextView) findViewById(numv);
        TextView out=(TextView) findViewById(R.id.setText);
        out.append(number.getText());
    }
    public void operation(View view) {
        TextView out=(TextView) findViewById(R.id.setText);
        String s = out.getText().toString();
        Float a= Float.parseFloat(s);
        test.setarg1(a);
        String opcode=view.getResources().getResourceName(view.getId());
        String op=opcode.substring(opcode.lastIndexOf("/")+1);

        System.out.println(op);

        if(op.equals("numPlus")){
            System.out.println("pol");
            out.append("+");
            test.setop("+");
        }else if(op.equals("numSub")){
            out.append(("-"));
            test.setop("-");
        }else if(op.equals("numMul")){
            out.append("x");
            test.setop("x");
        }

    }
    public void sol(View view){
        TextView out=(TextView) findViewById(R.id.setText);
        String s = out.getText().toString();
        String a2=s.substring(s.lastIndexOf(test.getOp())+1);
        Float b= Float.parseFloat(a2);
        test.setarg2(b);
        float a=test.getarg1();
        String op=test.getOp();
        if(op.equals("+")){
            float res=test.addition(a,b);
            String solu= Float.toString(res);
            out.setText(solu);
        }else if(op.equals("-")){
            float res=test.subtraction(a,b);
            String solu= Float.toString(res);
            out.setText(solu);
        }else if(op.equals("x")){
            float res=test.multiplication(a,b);
            String solu= Float.toString(res);
            out.setText(solu);
        }

    }
    public void Del(View view){
        TextView out=(TextView) findViewById(R.id.setText);
        out.setText("");

    }
}
