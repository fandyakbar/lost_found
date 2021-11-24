package com.example.lost_found;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lost_found.adapter.BarangAdapter;
import com.example.lost_found.model.Barang;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements BarangAdapter.OnBarangHolderClickListener{
    RecyclerView rvListBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BarangAdapter adapter = new BarangAdapter();
        adapter.setListData(getBarang());
        adapter.setListener(this);

        rvListBarang = findViewById(R.id.rvListBarang);
        rvListBarang.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvListBarang.setLayoutManager(layoutManager);


        Intent mainIntent = getIntent();
        String data = mainIntent.getStringExtra("nama_user");

        Toast.makeText(this, "Selamat Datang "+ data, Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Barang> getBarang(){
        ArrayList<Barang> listBarang = new ArrayList<Barang>();
        String nama;
        String Lokasi;
        String Penemu;
        String Keterangan;
        listBarang.add(new Barang(
                nama = "Tumbler",
                Lokasi="PKM Unand",
                Penemu= "Budi",
                Keterangan= "Warna Hitam ada logo unand"));
        listBarang.add(new Barang(
                nama="Dompet",
                Lokasi="Sekitar MNI Unand",
                Penemu="Hasya",
                Keterangan="Warna Hitam, Ada sejumlah uang namun tidak ada kertu identitas"));
        listBarang.add(new Barang(
                nama="kalkulator",
                Lokasi="Gedung F",
                Penemu="Mayang",
                Keterangan="ada Logo FA"));
        listBarang.add(new Barang(
                nama="Mouse Gambing",
                Lokasi="Gedung H",
                Penemu="Tipa",
                Keterangan="Warna hitam"));
        listBarang.add(new Barang(
                nama="Kunci Motor",
                Lokasi="DPR",
                Penemu="Fandy",
                Keterangan="Gantungan Kunci Spongebob"));
        listBarang.add(new Barang(
                nama="Kacamata",
                Lokasi="PKM Unand",
                Penemu="Stphen",
                Keterangan="tangkai Warna Hitam"));
        listBarang.add(new Barang(
                nama="Earphone",
                Lokasi="MNI",
                Penemu="Budi",
                Keterangan="masih ada kotaknya"));
        listBarang.add(new Barang(
                nama="STNK Motor",
                Lokasi="PKM Unand",
                Penemu="Akbar",
                Keterangan="Motor Beat Hitam Plat XX 8989 YY"));
        listBarang.add(new Barang(
                nama="Kacamata",
                Lokasi="PKM Unand",
                Penemu="Stphen",
                Keterangan="tangkai Warna Hitam"));
        listBarang.add(new Barang(
                nama="Earphone",
                Lokasi="MNI",
                Penemu="Budi",
                Keterangan="masih ada kotaknya"));
        listBarang.add(new Barang(
                nama="STNK Motor",
                Lokasi="PKM Unand",
                Penemu="Akbar",
                Keterangan="Motor Beat Hitam Plat XX 8989 YY"));

        return listBarang;
    }

    @Override
    public void onClick(View v, Barang barang) {
        Intent detailBarangIntent = new Intent(this, com.example.lost_found.DetailbarangActivity.class);
        detailBarangIntent.putExtra("NAMA_BARANG", barang.nama);
        startActivity(detailBarangIntent);

    }
}
   
    