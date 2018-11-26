package com.mezan.galleryview;

import android.Manifest;
import android.content.Intent;
import android.media.Image;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
        listView=(ListView)findViewById(R.id.lv);
        final ArrayList<File> myImage=FindImage(Environment.getExternalStorageDirectory());

        CustomAdapter adapter=new CustomAdapter(this,myImage);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent=new Intent(MainActivity.this,ImageShow.class);
                intent.putExtra("position",i);
                intent.putExtra("ImageList",myImage);
                startActivity(intent);
            }
        });

    }

    private ArrayList<File> FindImage(File root) {

        ArrayList<File> al=new ArrayList<>();
        File[]files=root.listFiles();
        for(File singleFile:files){
            if(singleFile.isDirectory() && !singleFile.isHidden()){
                al.addAll(FindImage(singleFile));
            }else {
                if(singleFile.getName().endsWith(".jpg")||singleFile.getName().endsWith(".gif")||singleFile.getName().endsWith(".png")){
                    al.add(singleFile);
                }
            }
        }
        return al;
    }
}
