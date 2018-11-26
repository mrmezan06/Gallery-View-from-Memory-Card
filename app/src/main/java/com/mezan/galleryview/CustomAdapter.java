package com.mezan.galleryview;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    ArrayList<File> ImageFiles;
    Context context;
    LayoutInflater inflater;
    CustomAdapter(Context context,ArrayList<File> ImageFiles){
        this.context=context;
        this.ImageFiles=ImageFiles;
    }
    @Override
    public int getCount() {
        return ImageFiles.size();
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
    public View getView(int i, View view, ViewGroup parent) {
        if(view==null){
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.sample,parent,false);
        }
        ImageView im=(ImageView)view.findViewById(R.id.img);
        im.setImageURI(Uri.parse(ImageFiles.get(i).toString()));

        return view;
    }
}
