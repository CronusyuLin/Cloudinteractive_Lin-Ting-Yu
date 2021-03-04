package com.example.cloudinteractive.Second;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cloudinteractive.R;
import com.example.cloudinteractive.Second.Bean.SecondBean;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private List<SecondBean> secondBeanList;
    private Context context;
    private LayoutInflater layoutInflater;

    public ListAdapter(List<SecondBean> secondBeanList, Context context) {
        this.secondBeanList = secondBeanList;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return secondBeanList.size();
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null){
            view = layoutInflater.inflate(R.layout.item_list,viewGroup,false);
        }
        ImageView imageView = view.findViewById(R.id.image_IV);
        TextView tv_id = view.findViewById(R.id.id_tv);
        TextView tv_title = view.findViewById(R.id.title_tv);

        tv_id.setText(String.valueOf(secondBeanList.get(position).getId()));
        tv_title.setText(String.valueOf(secondBeanList.get(position).getTitle()));
        Picasso.get().load(secondBeanList.get(position).getThumbnailUrl()).into(imageView);
        return view;
    }

}
