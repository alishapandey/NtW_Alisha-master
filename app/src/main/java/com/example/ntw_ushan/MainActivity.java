package com.example.ntw_ushan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etNumber, etWords;
    Button btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNumber= findViewById(R.id.etNumber);
        etWords= findViewById(R.id.etWords);
        btnConvert= findViewById(R.id.btnConvert);

        final String[] numnames={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven",
                "Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        final String[] tensname={"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};


        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int num;
                num= Integer.parseInt(etNumber.getText().toString());


                if (num<20){
                    etWords.setText(numnames[num]);
                }
                else if ((num/10)<10){
                    int a,b;
                    a= num/10;
                    b= num%10;

                    etWords.setText(tensname[a]+numnames[b]);

                }
                else if ((num/10)>10){
                    int aa,bb,cc;
                    String hundreds,tens,ones;
                    aa=num/100;
                    num = num%100;
                    bb=num/10;
                    cc=num%10;

                    hundreds= numnames[aa]+" Hundred and ";
                    tens= tensname[bb];
                    ones= numnames[cc];
                    etWords.setText(hundreds+tens+ones);
                }

            }
        });
    }
}
