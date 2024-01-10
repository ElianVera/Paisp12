package com.example.paisp1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdaptadorLugaresTuristico extends ArrayAdapter<lugarTuristico> {
    public AdaptadorLugaresTuristico(Context context, ArrayList<lugarTuristico> datos) {
        super(context, R.layout.litems, datos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.litems, null);

        TextView lblNombre = item.findViewById(R.id.lblNombre);
        lblNombre.setText(getItem(position).getNombre());

        TextView lblCapital = item.findViewById(R.id.lblcapital);
        lblCapital.setText(getItem(position).getCapital());

        ImageView imageView = item.findViewById(R.id.imgLogo);
        Glide.with(getContext())
                .load(getItem(position).getUrlLogo())
                .into(imageView);

        return item;
    }
}