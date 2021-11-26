package com.example.lost_found;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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

        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        rvListBarang.setLayoutManager(layoutManager);


        Intent mainIntent = getIntent();
        String data = mainIntent.getStringExtra("nama_user");

        Toast.makeText(this, "Selamat Datang "+ data, Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Barang> getBarang(){
        ArrayList<Barang> listBarang = new ArrayList<Barang>();
        String nama;
        String Kategori;
        String details = "Details";
        listBarang.add(new Barang(
                nama = "Tumbler",
                Kategori = "Lain-lain",
                details));
        listBarang.add(new Barang(
                nama = "Tas Converse",
                Kategori = "Tas",
                details));
        listBarang.add(new Barang(
                nama = "Laptop HP Envy",
                Kategori = "Elektronik",
                details));
        listBarang.add(new Barang(
                nama = "Tas 'False Pretense'",
                Kategori = "Tas",
                details));
        listBarang.add(new Barang(
                nama = "Kaos Merah Maroon",
                Kategori = "Pakaian",
                details));
        listBarang.add(new Barang(
                nama = "Converse Putih",
                Kategori = "Sepatu",
                details));
        listBarang.add(new Barang(
                nama = "Jam DW Coklat",
                Kategori = "Pakaian",
                details));
        listBarang.add(new Barang(
                nama = "iPhone 11 Pro",
                Kategori = "Elektronik",
                details));
        listBarang.add(new Barang(
                nama = "Jaket Hitam",
                Kategori = "Pakaian",
                details));
        listBarang.add(new Barang(
                nama = "Dompet Coklat",
                Kategori = "Pakaian",
                details));


        return listBarang;
    }

    @Override
    //on click pada list barang
    public void onClick(View v, Barang barang) {
        Intent detailBarangIntent = new Intent(this, com.example.lost_found.DetailbarangActivity.class);
        detailBarangIntent.putExtra("NAMA_BARANG", barang.nama);
        startActivity(detailBarangIntent);

    }

    //on click pada profile
    public void homeToProfile(View view){
        Intent profileIntent = new Intent(this, ProfileActivity.class);
        startActivity(profileIntent);
    }
}
   
    