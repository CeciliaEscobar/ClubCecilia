package com.cecilia.pruebacecilia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ClubViewHolder> {

    private List<Club> clubs;
    private int selectedPosition = -1;

    private Context context;

    public ClubAdapter(List<Club> club, Context context) {
        this.clubs = clubs;
        this.context = context;
    }

    @Override
    public ClubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_item, parent, false);
        return new ClubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClubViewHolder holder, int position) {
        Club club = clubs.get(position);
        // Se configura los datos de los elementos de la lista
        holder.idTV.setText(String.valueOf(club.getId()));
        holder.nombreTV.setText(club.getName());
        holder.telefonoTV.setText(club.getPhone());
        holder.documentoTV.setText(club.getDocument());



        // Configura un OnClickListener en el ViewHolder
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Guarda el índice del elemento seleccionado
                setSelectedPosition(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return clubs.size();
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    class ClubViewHolder extends RecyclerView.ViewHolder {
        // Se declararan los elementos de la vista (Layout user_item.xml)
        TextView idTV, nombreTV, telefonoTV, documentoTV;

        public ClubViewHolder(View itemView) {
            super(itemView);
            idTV = itemView.findViewById(R.id.textItemId);
            nombreTV = itemView.findViewById(R.id.textItemNombre);
            telefonoTV = itemView.findViewById(R.id.textItemTelefono);
            documentoTV = itemView.findViewById(R.id.textItemDocumento);
        }
    }

}
