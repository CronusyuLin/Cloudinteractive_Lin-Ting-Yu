package com.example.cloudinteractive.Second;

import com.example.cloudinteractive.Second.Bean.SecondBean;

import java.util.List;

public interface SecondContract {

    interface Model{

        interface OnFinishedListener{

            void onFinished(List<SecondBean> secondBeanList);
            void onFailure(Throwable t);
        }

        void getList(OnFinishedListener onFinishedListener);

    }

    interface View{

        void showProgress();
        void hideProgress();
        void setDataToRecycleView(List<SecondBean> secondBeanList);
        void onResponseFailure(Throwable t);

    }

    interface Presenter{

        void requestDataFromServer();

    }
}
