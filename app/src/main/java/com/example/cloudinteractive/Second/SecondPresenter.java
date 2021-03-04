package com.example.cloudinteractive.Second;


import com.example.cloudinteractive.Second.Bean.SecondBean;

import java.util.List;

public class SecondPresenter implements SecondContract.Presenter ,SecondContract.Model.OnFinishedListener{

    private SecondContract.View view;
    private SecondContract.Model model;

    public SecondPresenter(SecondContract.View view) {
        this.view = view;
        model = new SecondModel();
    }

    @Override
    public void requestDataFromServer() {

        if (view != null){
            view.showProgress();
        }
        model.getList(this);
    }



    @Override
    public void onFinished(List<SecondBean> secondBeanList) {
        view.setDataToRecycleView(secondBeanList);
        if (view != null){
            view.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        view.onResponseFailure(t);
        if (view != null){
            view.hideProgress();
        }
    }


}
