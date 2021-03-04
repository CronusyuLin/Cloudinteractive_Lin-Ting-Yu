package com.example.cloudinteractive.First;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cloudinteractive.R;

public class FirstFragment extends Fragment implements FirstView {

    FirstPresenter presenter;
    Button btnRequest;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new FirstPresenter(new FirstModel(), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        btnRequest = view.findViewById(R.id.btn_Request);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goSecond();
            }
        });

        return view;
    }

    @Override
    public void toSecond() {
        View view = getView();
        NavController navController = Navigation.findNavController(view);
        navController.navigate(R.id.action_global_secondFragment);
    }
}