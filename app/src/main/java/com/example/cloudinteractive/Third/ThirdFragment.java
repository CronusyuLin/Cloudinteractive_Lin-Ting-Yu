package com.example.cloudinteractive.Third;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cloudinteractive.R;
import com.squareup.picasso.Picasso;


public class ThirdFragment extends Fragment implements ThirdView{
    ThirdPresenter presenter;
    private final static String TAG = "ThirdFragment :";
    private ImageView imageView;
    private TextView textView_id;
    private TextView textView_title;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ThirdPresenter(new ThirdModel(),this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        imageView = view.findViewById(R.id.image_bigIV);
        textView_id = view.findViewById(R.id.id_big_tv);
        textView_title = view.findViewById(R.id.title_big_tv);

        Bundle bundle = getArguments();
        presenter.toSetThirdView(bundle);

        return view;
    }


    @Override
    public void setThirdView(String id, String title, Uri url) {
        Picasso.get().load(url).into(imageView);
        textView_id.setText(id);
        textView_title.setText(title);
    }
}