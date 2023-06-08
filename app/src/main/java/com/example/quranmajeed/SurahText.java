package com.example.quranmajeed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SurahText extends AppCompatActivity {
    QDH qdh;
    TextView surahText;
    QuranArabicText quranArabicText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surah_text);
        surahText = findViewById(R.id.textView);
        qdh = new QDH();
        quranArabicText = new QuranArabicText();
        String[] quranText = quranArabicText.QuranArabicText;
        int number = getIntent().getIntExtra("Number", 0);
//        int sura = 4;
//        int ayat = 10;
//        int suraCount = qdh.SSP[sura-1];
//        int getAyatIndex = suraCount + ayat - 1;
////        surahText.setText(Integer.toString(number));
//        Toast.makeText(this, quranArabicText.QuranArabicText[getAyatIndex], Toast.LENGTH_SHORT).show();

        int startIndex = qdh.getSurahStart(number);
        if(number != 113) {
            int nextSurahStartIndex = qdh.getSurahStart(number+1);
            nextSurahStartIndex--;
            String str = "";
            for(int i=startIndex-1; i<nextSurahStartIndex; i++) {
                str+=quranText[i];
                str+="\n";
            }
            surahText.setText(str);

        } else if(number == 113){
            int length = quranText.length;
            int lastIndex = length - 1;
            String str = "";
            for(int i=startIndex-1; i<=lastIndex; i++) {
                str+=quranText[i];
                str+="\n";
            }
            surahText.setText(str);
        }
    }
}