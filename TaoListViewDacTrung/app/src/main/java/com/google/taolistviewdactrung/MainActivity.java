package com.google.taolistviewdactrung;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    AdapterDichVu adapter;
    ArrayList<DichVu> arrayList;
    Boolean kt=false;
    int j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        arrayList = new ArrayList<>();
        arrayList.add(new DichVu("Dịch Vụ giặc ủi quần áo ","Đơn Gíá: 20.000 VNĐ/1kg", R.drawable.giacui));
        arrayList.add(new DichVu("Dịch vụ xe đưa đón sân bay","Đơn Gíá: 18.000 VNĐ/ 1km", R.drawable.xeduadonsanbay));
        arrayList.add(new DichVu("Dịch vụ spa","Đơn Gíá: 200.000 VNĐ/ 1 combo", R.drawable.dichvuspa));
        arrayList.add(new DichVu("Dịch vụ hội họp, văn phòng","Đơn Gíá: 1.000.000 VNĐ/ 1 phòng", R.drawable.hoihop));
        arrayList.add(new DichVu("Sân golf và sân tennis","Đơn Gíá: 2OO.000 VNĐ/ 1 giờ", R.drawable.sangolf));
        arrayList.add(new DichVu("Casino ","Đơn Gíá: 50.000 VNĐ", R.drawable.casino));

        adapter = new AdapterDichVu(MainActivity.this,R.layout.activity_dichvu,arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DichVu.Detail.class);
                intent.putExtra("dulieu",arrayList.get(i).getTendichvu());
                if (kt!=true)
                    startActivity(intent);
                kt=false;;

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                kt=true;
                Xacnhanxoa(i);
                return false;
            }
        });
    }
    public void Xacnhanxoa(final int pos){
        AlertDialog.Builder alertDiaLog = new AlertDialog.Builder(MainActivity.this);
        alertDiaLog.setTitle("Thong bao");
        alertDiaLog.setIcon(R.mipmap.ic_launcher);
        alertDiaLog.setMessage("Ban co muon xoa");
        alertDiaLog.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayList.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });
        alertDiaLog.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDiaLog.show();

    }
}
