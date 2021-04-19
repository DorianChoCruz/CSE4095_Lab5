package com.example.radio_foreground_service.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radio_foreground_service.R;
import com.example.radio_foreground_service.model.RadioStation;
import com.example.radio_foreground_service.model.RadioStations;
import com.example.radio_foreground_service.ui.radio.RadioFragment;
import com.squareup.picasso.Picasso;

public class RadioAdapter extends RecyclerView.Adapter<RadioAdapter.ViewHolder> {
    LayoutInflater inflater;
    RadioStations radioStations;

    public RadioAdapter(Context ctx, RadioStations radioStations){
        this.inflater= LayoutInflater.from(ctx);
        this.radioStations=radioStations;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.item_layout, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.radioName.setText(radioStations.radioStationsArray[position].getRadioName());
        Picasso.get().load(radioStations.radioStationsArray[position].getRadioImageLink()).into(holder.radioImage);

    }

    @Override
    public int getItemCount() {
        return radioStations.radioStationsArray.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView radioName;
        ImageView radioImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            radioName= itemView.findViewById(R.id.radioName);
            radioImage= itemView.findViewById(R.id.radioImage);
            itemView.setOnClickListener((this));
        }

        @Override
        public void onClick(View v) {
            RadioStation radioStation= RadioFragment.radioStations.radioStationsArray[getLayoutPosition()];
            RadioFragment.currRadio= radioStation;
            Navigation.findNavController(v).navigate(R.id.action_navigation_radio_to_navigation_player);
        }
    }
}
