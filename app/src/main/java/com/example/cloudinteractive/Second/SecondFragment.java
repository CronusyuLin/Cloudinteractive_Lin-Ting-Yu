package com.example.cloudinteractive.Second;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.cloudinteractive.R;
import com.example.cloudinteractive.Second.Bean.SecondBean;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment implements SecondContract.View {

    private SecondPresenter presenter;
    private GridView gridView;
    private List<SecondBean> secondBeanList;
    private ListAdapter listAdapter;
    private ProgressDialog progressDialog;
    private GridLayoutManager gridLayoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);
        progressDialog = new ProgressDialog(getActivity());
        gridView = view.findViewById(R.id.gridView);


        secondBeanList = new ArrayList<>();

        gridLayoutManager = new GridLayoutManager(getActivity(), 4);

        presenter = new SecondPresenter(this);
        presenter.requestDataFromServer();


        return view;
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void setDataToRecycleView(List<SecondBean> secondBeanList) {
        secondBeanList.addAll(secondBeanList);
        listAdapter = new ListAdapter(secondBeanList, getActivity());
        gridView.setAdapter(listAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("id", String.valueOf(secondBeanList.get(position).getId()));
                bundle.putString("title",secondBeanList.get(position).getTitle());
                bundle.putString("thumbnailUrl",secondBeanList.get(position).getThumbnailUrl());
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_global_thirdFragment, bundle);
            }
        });
    }

    @Override
    public void onResponseFailure(Throwable t) {
        Log.d("ERROR:", t.getMessage());
        Toast.makeText(getActivity(), "Error in getting data!", Toast.LENGTH_LONG).show();
    }


}