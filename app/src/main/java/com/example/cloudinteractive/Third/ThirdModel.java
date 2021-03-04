package com.example.cloudinteractive.Third;

import android.os.Bundle;

import java.util.ArrayList;

public class ThirdModel {

    ArrayList<String> getBundleData(Bundle bundle){
        ArrayList<String> dataList = new ArrayList();
        String id = bundle.getString("id");
        String title = bundle.getString("title");
        String thumbnailUrl = bundle.getString("thumbnailUrl");
        dataList.add(id);
        dataList.add(title);
        dataList.add(thumbnailUrl);

        return dataList;

    }

}
