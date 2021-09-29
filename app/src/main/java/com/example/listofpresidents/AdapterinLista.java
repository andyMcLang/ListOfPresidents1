package com.example.listofpresidents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapterinLista extends ArrayAdapter<Kayttaja> {

    public AdapterinLista(Context context, ArrayList<Kayttaja> kayttajaArrayList) {
        super(context,R.layout.list_item,kayttajaArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Kayttaja kayttaja = getItem(position);

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent, false);

        }

        TextView sukuNimi = convertView.findViewById(R.id.presidentinNimi);

        sukuNimi.setText(kayttaja.kokoNimet);

        return convertView;
    }
}
