package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    Button buttonAnagram;
    Button buttonPalindrom;
    EditText editTextPierwszeSlowo;
    EditText editTextDrugieSlowo;
    TextView textViewWynik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        buttonAnagram = findViewById(R.id.buttonAnagram);
        buttonPalindrom = findViewById(R.id.buttonPalindrom);
        textViewWynik = findViewById(R.id.textViewWynik);
        editTextDrugieSlowo = findViewById(R.id.editTextSlowo2);
        editTextPierwszeSlowo = findViewById(R.id.editTextSlowo1);
        buttonPalindrom.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String slowo = editTextPierwszeSlowo.getText().toString();
                        boolean czyJestPalindromem = czyPalindrom(slowo);
                        if(czyJestPalindromem){
                            textViewWynik.setText("tak jest palindromem");
                        }else{
                            textViewWynik.setText("nie jest palindromem");
                        }
                    }
                }
        );
        buttonAnagram.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String slowo1 = editTextPierwszeSlowo.getText().toString();
                        String slowo2 = editTextDrugieSlowo.getText().toString();
                        boolean czySaAnagramem = czySaAnagramem(slowo1,slowo2);
                        if(czySaAnagramem){
                            textViewWynik.setText("tak sa angramem");
                        }else{
                            textViewWynik.setText("nie sa anagramem");
                        }
                    }
                }
        );

    }
    private boolean czyPalindrom(String slowo){
        boolean czyJestPalindromem = true;
        int j = slowo.length() - 1;
        for (int i = 0; i< slowo.length()/2;i++){
            if(slowo.charAt(i) != slowo.charAt(j)) {
               czyJestPalindromem=false;
               break;
            }
            j--;
        }
        return czyJestPalindromem;
    }

    private boolean czySaAnagramem(String slowo1, String slowo2){
        boolean czySaAnagramami = true;
        if(slowo1.length() != slowo2.length()){
            czySaAnagramami = false;
            return czySaAnagramami;
        }
        ArrayList<String> lista = new ArrayList<>();
        ArrayList<String> lista2 = new ArrayList<>();
        for(int i = 0;i<slowo1.length();i++){
            lista.add(String.valueOf(slowo1.charAt(i)));
            lista2.add(String.valueOf(slowo2.charAt(i)));
        }
        Collections.sort(lista2);
        Collections.sort(lista);
        for (int i = 0; i < lista.size(); i++) {
            Toast.makeText(this, lista.get(i) + " " + lista2.get(i), Toast.LENGTH_SHORT).show();
            String znak1 = lista.get(i);
            String znak2 = lista2.get(i);
            if(!znak2.equals(znak1)){
                czySaAnagramami=false;
                return czySaAnagramami;
            }
        }
        return czySaAnagramami;
    }
}