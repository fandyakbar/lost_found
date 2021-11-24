package com.example.lost_found.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lost_found.R;
import com.example.lost_found.model.Barang;

import java.util.ArrayList;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.BarangViewHolder> {


    ArrayList<Barang> listData = new ArrayList<>();

    public class BarangViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textNamaBarang, textLokasi, textPenemu, textKeterangan;



        public BarangViewHolder(@NonNull View itemView) {
            super(itemView);
            textNamaBarang = itemView.findViewById(R.id.textNamaBarang);
            textLokasi = itemView.findViewById(R.id.textLokasi);
            textPenemu = itemView.findViewById(R.id.textPenemu);
            textKeterangan = itemView.findViewById(R.id.textKeterangan);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(listener != null){
                listener.onClick(v, listData.get(getAdapterPosition()));
            }

        }
    }

    // Click Listener
    OnBarangHolderClickListener listener = null;

    public interface OnBarangHolderClickListener{

        void onClick(View v,  Barang barang);

    }

    public void setListener(OnBarangHolderClickListener listener) {
        this.listener = listener;
    }

    public void setListData(ArrayList<Barang> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override


    public BarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_barang, parent, false);
        return new BarangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BarangViewHolder holder, int position) {
        Barang barang = listData.get(position);
        holder.textNamaBarang.setText(barang.nama);
        holder.textKeterangan.setText(barang.Keterangan);
        holder.textPenemu.setText(barang.Penemu);
        holder.textLokasi.setText(barang.Lokasi);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


}
