package com.cecilia.pruebacecilia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class FragmentoHome extends Fragment {

    View view;
    Button botonHomeSuscribir;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        botonHomeSuscribir = (Button) view.findViewById(R.id.btniniciar);
        botonHomeSuscribir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Iniciando sesion", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}