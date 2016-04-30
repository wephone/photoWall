package com.meizhuo.wephone.camerademo;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.GridView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    List<String> imagepath=new ArrayList<>();
    List<String> parentFile=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView= (GridView) findViewById(R.id.wall);
        ContentResolver resolver=getContentResolver();
        Cursor cursor=resolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,null,null,null,null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        for (int i = 0; i <cursor.getCount() ; i++) {
            int index=cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            imagepath.add(cursor.getString(index));
            cursor.moveToNext();
        }
//        if (cursor != null) {
//            cursor.moveToLast();
//        }
//        for (int i = 0; i <cursor.getCount() ; i++) {
//            int index=cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//            imagepath.add(cursor.getString(index));
//            cursor.moveToPrevious();
//        } //直接内存溢出？
        cursor.close();
        adapter madapter=new adapter(imagepath,this);
        gridView.setAdapter(madapter);
    }

}
