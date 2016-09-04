package com.adolf.zhouzhuang.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.adolf.zhouzhuang.R;
import com.adolf.zhouzhuang.Spots;
import com.adolf.zhouzhuang.databasehelper.SpotsDataBaseHelper;
import com.adolf.zhouzhuang.resBody.SpotsResponse;
import com.adolf.zhouzhuang.util.SdCardUtil;
import com.adolf.zhouzhuang.util.ServiceAddress;

import java.util.List;

import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import cn.finalteam.okhttpfinal.HttpRequest;

public class LaunchActivity extends BaseActivity {
//    private ProgressDialog dialog;
    private SpotsDataBaseHelper mSpotsDataBaseHelper;
    public ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laynch);
        mSpotsDataBaseHelper = new SpotsDataBaseHelper(getSpotsDao());
        initFileDir();
        getAllSpots();
//        dialog = new ProgressDialog(this);
//
//        dialog.setIndeterminate(true);
//        dialog.show();
//        dialog.setContentView(R.layout.item_progressdialog);
        pageChange();
    }

    private void pageChange() {
        Handler handler = new Handler();
        handler.postDelayed(new SplashHandler(),3000);

    }

    class SplashHandler implements Runnable {
        public void run() {
//            dialog.dismiss();
            startActivity(new Intent(LaunchActivity.this, MainActivity.class));
            LaunchActivity.this.finish();
        }
    }

    public void getAllSpots(){
        HttpRequest.get(ServiceAddress.ALL_SPOTS, new BaseHttpRequestCallback<SpotsResponse>(){

            @Override
            protected void onSuccess(SpotsResponse spotsResponse) {
                super.onSuccess(spotsResponse);
                List<Spots> spotsList = spotsResponse.getData();
                mSpotsDataBaseHelper.insertAllSpotsList(spotsList);
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
            }
        });
    }

    public void initFileDir(){
        if(SdCardUtil.checkSdCard()==true){
            SdCardUtil.createFileDir(SdCardUtil.FILEDIR);
            SdCardUtil.createFileDir(SdCardUtil.FILEDIR+"/"+SdCardUtil.FILEAUDIO);
        }else{
            System.out.println("创建文件夹失败SD卡不可用");
        }

    }
}