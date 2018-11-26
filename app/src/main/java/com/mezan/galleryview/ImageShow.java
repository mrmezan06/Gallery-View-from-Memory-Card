package com.mezan.galleryview;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.io.File;
import java.util.ArrayList;

public class ImageShow extends AppCompatActivity {

    ArrayList<File> myImage;
    int position;
    Uri uri;
    ImageView imageView;
    Button Next,Prev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_show);
        Intent intent=getIntent();
        Bundle b=intent.getExtras();
        position=b.getInt("position");
        myImage=(ArrayList) b.getParcelableArrayList("ImageList");
        uri=Uri.parse(myImage.get(position).toString());
        imageView=(ImageView) findViewById(R.id.showImage);
        Next=(Button)findViewById(R.id.btnNext);
        Prev =(Button)findViewById(R.id.btnPrev);
        imageView.setImageURI(uri);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position+1>=myImage.size())
                    position=0;
                else{
                    position=position+1;
                }
                uri = Uri.parse(myImage.get(position).toString());
                imageView.setImageURI(uri);
            }
        });
        Prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position-1<0){
                    position=myImage.size()-1;
                }else {
                    position=position-1;
                }
                uri = Uri.parse(myImage.get(position).toString());
                imageView.setImageURI(uri);
            }
        });
    }
}
