package com.google.taolistviewdactrung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterDichVu extends BaseAdapter {
    private Context context;
    private int layout;
    private List<DichVu> arraylist;

    public AdapterDichVu(Context context, int layout, List<DichVu> arraylist) {
        this.context = context;
        this.layout = layout;
        this.arraylist = arraylist;
    }


    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflaler = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflaler.inflate(layout,null);
        DichVu monAn=arraylist.get(position);
        TextView textV1= convertView.findViewById(R.id.name);
        TextView textV2= convertView.findViewById(R.id.motadichvu);
        ImageView imageV= convertView.findViewById(R.id.imageHinh);

        textV1.setText(monAn.getTendichvu());
        textV2.setText(monAn.getMotadichvu());
        imageV.setImageResource(monAn.getHinh());

        return convertView;
    }
}
