package com.example.cloudinteractive.Third;

import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;

public class ThirdPresenter {
    ThirdModel model;
    ThirdView view;

    ThirdPresenter(ThirdModel model, ThirdView view){
        this.model = model;
        this.view = view;
    }

    void toSetThirdView(Bundle bundle){

        ArrayList<String> list = model.getBundleData(bundle);
        String id = list.get(0);
        String title = list.get(1);
        Uri url = Uri.parse(list.get(2));
        view.setThirdView(id, title, url);

    }

}
