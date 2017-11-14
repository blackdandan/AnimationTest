package com.example.blackdandan.animationtest;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

/**
 * description :
 * Created by blackdandan on 2017/11/14.
 */

public class DrawableGridViewAdapter extends BaseAdapter{
    private Context context;
    private List<String > mFileList ;
    private boolean editMode = false;
    public DrawableGridViewAdapter(Context context, List<String > fileList){
        if (fileList == null){
            throw new IllegalArgumentException("fileList can not be null");
        }
        this.mFileList = fileList;
        this.context = context;
    }
    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    @Override
    public int getCount() {
        return mFileList.size();
    }

    @Override
    public Object getItem(int position) {
        return mFileList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = null;
        ViewHolder viewHolder = null;
        DebugUtil.print("getView");
        if (convertView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.grid_item_drawable,null);
            viewHolder = new ViewHolder(position);
            viewHolder.deleteImg = (ImageView) itemView.findViewById(R.id.img_delete);
            viewHolder.deleteImg.setOnClickListener(viewHolder);
            viewHolder.imageView = (ImageView) itemView.findViewById(R.id.img_drawable);
            itemView.setTag(viewHolder);
        }else {
            itemView = convertView;
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.position = position;
        }
        viewHolder.imageView.setImageBitmap(BitmapFactory.decodeFile(mFileList.get(position)));
        if (editMode){
            viewHolder.deleteImg.setVisibility(View.VISIBLE);
        }else {
            viewHolder.deleteImg.setVisibility(View.GONE);
        }
        if (position == mFileList.size()-1){
            if (!itemView.hasOnClickListeners())
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editMode = true;
                    notifyDataSetChanged();
                }
            });
        }
        return itemView;
    }
    public class ViewHolder implements View.OnClickListener{
        ViewHolder(final int position){
            this.position = position;
        }
        public int position;
        public ImageView imageView;
        public ImageView deleteImg;

        @Override
        public void onClick(View v) {
            mFileList.remove(position);
            notifyDataSetChanged();
        }
    }
}
