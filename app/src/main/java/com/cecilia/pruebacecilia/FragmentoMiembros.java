package com.cecilia.pruebacecilia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragmentoMiembros extends Fragment {

    private ClubAdapter clubAdapter;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_miembros, container, false);

//        String url = "http://10.0.2.2:8098/api/getUsers";
        String url = "https://my-club-cecilia.onrender.com/api/getMembers"; // Reemplazar por la url desplegada en Render
        RequestQueue queue = Volley.newRequestQueue(getContext());

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<Club> clubs = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject userObject = response.getJSONObject(i);
                        Integer id = userObject.getInt("id");
                        String name = userObject.getString("name");
                        String phone = userObject.getString("phone");
                        String document = userObject.getString("document");

                        clubs.add(new Club(id, name, phone, document));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                clubAdapter = new ClubAdapter(clubs, getContext());
                RecyclerView recyclerView = view.findViewById(R.id.recyclerview);

                recyclerView.setAdapter(clubAdapter);

                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Error al listar los datos " + error, Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);

        return view;
    }
}