package com.meizhuo.wephone.camerademo;

import android.content.Context;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by ASUS on 2016/4/30.
 */
public class adapter extends BaseAdapter {
    List<String> path=new ArrayList<>();
    Context context;
    private LayoutInflater minflater;
    public adapter(List<String> path,Context context) {
        this.path=path;
        this.context=context;
        minflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return path.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder viewholder=null;
        if (convertView==null){
            viewholder=new Viewholder();
            convertView=minflater.inflate(R.layout.item,null);
            viewholder.imageView= (ImageView) convertView.findViewById(R.id.item);
            convertView.setTag(viewholder);
        }else {
            viewholder= (Viewholder) convertView.getTag();
        }
        viewholder.imageView.setImageURI(Uri.parse(path.get(position)));
        ViewGroup.LayoutParams params=viewholder.imageView.getLayoutParams();
        DisplayMetrics displayMetrics=context.getResources().getDisplayMetrics();
        params.height=displayMetrics.heightPixels/3;
        params.width=displayMetrics.widthPixels/3;
        viewholder.imageView.setLayoutParams(params);
        return convertView;
    }
    private class Viewholder{
        ImageView imageView;
    }
}
