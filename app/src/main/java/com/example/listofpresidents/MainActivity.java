package com.example.listofpresidents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listofpresidents.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    public static final String EXTRA_MESSAGE = "com.example.listofpresidents.MESSAGE";

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] kokoNimet = {"Stahlberg, Kaarlo Juho", "Relander, Lauri Kristian", "Svinhufvud, Pehr, Evind", "Kallio, Kyosti", "Ryti, Risto Heikki", "Mannerheim, Carl Gustav", "Paasikivi, Juho Kusti", "Kekkonen, Urho Kaleva", "Koivisto, Mauno Henrik", "Ahtisaari, Martti Oiva", "Halonen, Tarja Kaarina", "Niinistö, Sauli Väinämö"};
        String[] viranAloitusVuosi = {"1919", "1925", "1931", "1937", "1940", "1944", "1946", "1956", "1982", "1994", "2000", "2012" };
        String[] viranLopetusVuosi = {"1925", "1931", "1937", "1940", "1944", "1946", "1956", "1982", "1994", "2000", "2012", "2024" };
        String[] lempiNimi = {"Eka presidentti", "Reissulasse", "Ukko-Pekka", "Neljäs presidentti", "Nuorena Kustu Kalliokangas", "Marski", "Äkäinen ukko", "Pelimies", "Manu", "Mahtisaari", "Eka naispressa", "Owner of Lennu, the First Dog"};

        ArrayList<Kayttaja> kayttajaArrayList = new ArrayList<>();

        for(int i = 0;i< kokoNimet.length;i++){

            Kayttaja kayttaja = new Kayttaja(kokoNimet[i], viranAloitusVuosi[i], viranLopetusVuosi[i], lempiNimi[i]);
            kayttajaArrayList.add(kayttaja);

        }

        AdapterinLista listAdapter = new AdapterinLista(MainActivity.this, kayttajaArrayList);

        binding.listaaPresidentit.setAdapter(listAdapter);
        binding.listaaPresidentit.setClickable(true);
        binding.listaaPresidentit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)  {

                Intent i = new Intent(MainActivity.this, KayttajaAktiiviteetti.class);
                i.putExtra("",kokoNimet[position]);
                i.putExtra("",viranAloitusVuosi[position]);
                i.putExtra("",viranLopetusVuosi[position]);
                i.putExtra("",lempiNimi[position]);
                TextView editText = (TextView) findViewById(R.id.presidentinNimi);

                String message = editText.getText().toString();

                i.putExtra(EXTRA_MESSAGE, message);
                startActivity(i);

            }
        });


    }
}