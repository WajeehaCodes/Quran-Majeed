package com.example.quranmajeed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchSurah extends AppCompatActivity {
    TextView txt1, txt2, txt3, txt4, txt5;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surah_search);

        txt1 = findViewById(R.id.parahno);
        txt2 = findViewById(R.id.ayatno);
        txt3 = findViewById(R.id.getParah);
        txt4 = findViewById(R.id.getAyat);
        txt5 = findViewById(R.id.showText);
        btn = findViewById(R.id.button4);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt3.getText().equals("") && txt4.getText().equals(""))
                {
                    txt3.setText("!!");
                }
                else if(txt3.getText() != "" && txt4.getText() == "")
                {
                    txt3.setText("!!!!!");
                }
                else
                {
                    int valP = Integer.parseInt(txt3.getText().toString());
                    int valA = Integer.parseInt(txt4.getText().toString())-1;
                    if (valP < 1 || valP > 30){
                    }
                    else {
                        QuranArabicText qat = new QuranArabicText();
                        int startP = new QDH().getParahStart(valP-1)-1 + valA;
                        if(valP == 30)
                        {
                            int limitEnd = 6348;

                            String AS = "";
                            for(int i = startP; i < limitEnd; i++)
                            {
                                AS += qat.QuranArabicText[i];
                            }
                            txt5.setText(AS);
                        }
                        else {
                            int countOfAyatsInParah = new QDH().getParahStart(valP)-new QDH().getParahStart(valP-1);

                            String AS = "";
                            for(int i = startP; i < startP+countOfAyatsInParah-valA; i++)
                            {
                                AS += qat.QuranArabicText[i] + " ";
                            }
                            txt5.setText(AS);
                        }
                    }
                }
            }
        });
    }
}