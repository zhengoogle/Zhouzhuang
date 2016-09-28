package com.adolf.zhouzhuang.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.adolf.zhouzhuang.R;
import com.adolf.zhouzhuang.Spots;
import com.adolf.zhouzhuang.adapter.ViewPagerAdapter;
import com.adolf.zhouzhuang.databasehelper.SpotsDataBaseHelper;
import com.adolf.zhouzhuang.fragment.BaseFragment;
import com.adolf.zhouzhuang.fragment.CollectionFragment;
import com.adolf.zhouzhuang.fragment.GudieFragment;
import com.adolf.zhouzhuang.fragment.PersonalCenterFragment;
import com.adolf.zhouzhuang.fragment.MuseumFragment;
import com.adolf.zhouzhuang.fragment.StrategyFragment;
import com.adolf.zhouzhuang.interfaces.MainInterface;
import com.adolf.zhouzhuang.util.SharedPreferencesUtils;
import com.adolf.zhouzhuang.util.SoundBroadUtils;
import com.adolf.zhouzhuang.util.Utils;
import com.adolf.zhouzhuang.widget.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener,BaseFragment.OnFragmentInteractionListener {

    private TextView mMuseumTextView;
    private TextView mCollectionTextView;
    private TextView mNavigationTextView;
    private TextView mStrategyTextView;

    private CustomViewPager mCustomerViewPager;
    public static final String SPOTS_ID = "spot_id";
    private int spotId = 0;
    GudieFragment gudieFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        spiltTest();
    }
    private void initViews(){
        mMuseumTextView = (TextView) findViewById(R.id.tv_museum);
        mCollectionTextView = (TextView) findViewById(R.id.tv_collection);
        mNavigationTextView = (TextView) findViewById(R.id.tv_navigation);
        mStrategyTextView = (TextView) findViewById(R.id.tv_strategy);
        mMuseumTextView.setTypeface(Utils.getType(this,0));
        mCollectionTextView.setTypeface(Utils.getType(this,0));
        mNavigationTextView.setTypeface(Utils.getType(this,0));
        mStrategyTextView.setTypeface(Utils.getType(this,0));
        mCustomerViewPager = (CustomViewPager) findViewById(R.id.viewpager);

        mMuseumTextView.setOnClickListener(this);
        mCollectionTextView.setOnClickListener(this);
        mNavigationTextView.setOnClickListener(this);
        mStrategyTextView.setOnClickListener(this);

        initActionBar("",0,"周庄博物馆","",R.drawable.scan_selector);
        initViewPager();
    }

    private void initViewPager(){
        List<Fragment> fragmentArrayList = new ArrayList<>();
        MuseumFragment museumFragment = new MuseumFragment();
        CollectionFragment collectionFragment = new CollectionFragment();
         gudieFragment = new GudieFragment();
        PersonalCenterFragment personalCenterFragment = new PersonalCenterFragment();
        fragmentArrayList.add(museumFragment);
        fragmentArrayList.add(collectionFragment);
        fragmentArrayList.add(gudieFragment);
        fragmentArrayList.add(personalCenterFragment);
        mCustomerViewPager.setScrollble(false);
        mCustomerViewPager.setOffscreenPageLimit(3);
        mCustomerViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragmentArrayList));
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_museum:
                setBottomBarBackground(0);
                initActionBar("",0,"周庄博物馆","",R.drawable.scan_selector);
                break;
            case R.id.tv_collection:
                setBottomBarBackground(1);
                initActionBar("",0,"馆藏珍品","",R.drawable.scan_selector);
                break;
            case R.id.tv_navigation:
                setBottomBarBackground(2);
                initActionBar("",0,"周庄导览","",R.drawable.scan_selector);
                break;
            case R.id.tv_strategy:
                setBottomBarBackground(3);
                mLeftActionBar.setCompoundDrawables(null,null, null, null);
                break;
            case R.id.tv_left_actionbar:
              //  autoLoginLogic();
                break;
            case R.id.tv_rigth_actionbar:
                Intent intent2 = new Intent();
                intent2.setClass(MainActivity.this,QRCodeActivity.class);
                startActivity(intent2);
                break;
        }
    }

    public void autoLoginLogic(){
        boolean isAutoLogin = SharedPreferencesUtils.getBoolean(MainActivity.this,"AutoLogin",false);
        if (!isAutoLogin){
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        }else{
            startActivity(new Intent(MainActivity.this,PersonalCenterActivity.class));
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        if (TextUtils.equals(uri.toString(),"exhibit")){
            mCustomerViewPager.setCurrentItem(1);
        }
    }

    public void setBottomBarBackground(int selectedIndex){
        mCustomerViewPager.setCurrentItem(selectedIndex);
        Drawable museumDefault = getResources().getDrawable(R.mipmap.btn_menu01_default);
        Drawable museumFocus = getResources().getDrawable(R.mipmap.btn_menu01_focused);
        Drawable collectionDefault = getResources().getDrawable(R.mipmap.btn_menu02_default);
        Drawable collectionFocus = getResources().getDrawable(R.mipmap.btn_menu02_focused);
        Drawable guideDefault = getResources().getDrawable(R.mipmap.btn_menu03_default);
        Drawable guideFocus = getResources().getDrawable(R.mipmap.btn_menu03_focused);
        Drawable strategyDefault = getResources().getDrawable(R.mipmap.btn_menu04_default);
        Drawable strategyFocus = getResources().getDrawable(R.mipmap.btn_menu04_focused);
        String textColorDefault = "#8e8e99";
        String textColorFocus = "#333240";

        switch (selectedIndex){
            case 0:
                mMuseumTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(null,museumFocus,null, null);
                mCollectionTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(null,collectionDefault,null, null);
                mNavigationTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(null,guideDefault,null, null);
                mStrategyTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(null,strategyDefault,null, null);
                mMuseumTextView.setTextColor(Color.parseColor(textColorFocus));
                mCollectionTextView.setTextColor(Color.parseColor(textColorDefault));
                mNavigationTextView.setTextColor(Color.parseColor(textColorDefault));
                mStrategyTextView.setTextColor(Color.parseColor(textColorDefault));
                initActionBar("",0,"周庄博物馆","",R.drawable.scan_selector);
                break;
            case 1:
                mMuseumTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(null,museumDefault,null, null);
                mCollectionTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(null,collectionFocus,null, null);
                mNavigationTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(null,guideDefault,null, null);
                mStrategyTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(null,strategyDefault,null, null);
                mMuseumTextView.setTextColor(Color.parseColor(textColorDefault));
                mCollectionTextView.setTextColor(Color.parseColor(textColorFocus));
                mNavigationTextView.setTextColor(Color.parseColor(textColorDefault));
                mStrategyTextView.setTextColor(Color.parseColor(textColorDefault));
                initActionBar("",0,"馆藏珍品","",R.drawable.scan_selector);
                break;
            case 2:
                mMuseumTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(null,museumDefault,null, null);
                mCollectionTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(null,collectionDefault,null, null);
                mNavigationTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(null,guideFocus,null, null);
                mStrategyTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(null,strategyDefault,null, null);
                mMuseumTextView.setTextColor(Color.parseColor(textColorDefault));
                mCollectionTextView.setTextColor(Color.parseColor(textColorDefault));
                mNavigationTextView.setTextColor(Color.parseColor(textColorFocus));
                mStrategyTextView.setTextColor(Color.parseColor(textColorDefault));
                initActionBar("",0,"周庄导览","",R.drawable.scan_selector);
                break;
            case 3:
                mMuseumTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(null,museumDefault,null, null);
                mCollectionTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(null,collectionDefault,null, null);
                mNavigationTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(null,guideDefault,null, null);
                mStrategyTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(null,strategyFocus,null, null);
                mMuseumTextView.setTextColor(Color.parseColor(textColorDefault));
                mCollectionTextView.setTextColor(Color.parseColor(textColorDefault));
                mNavigationTextView.setTextColor(Color.parseColor(textColorDefault));
                mStrategyTextView.setTextColor(Color.parseColor(textColorFocus));
                initActionBar("",0,"个人中心","",R.drawable.scan_selector);
                break;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SoundBroadUtils.getInstance().stopSound();
    }


    public void setSpotId(int spotId) {
        mCustomerViewPager.setCurrentItem(2);
        setBottomBarBackground(2);
        initActionBar("",0,"周庄导览","",R.drawable.scan_selector);
        SpotsDataBaseHelper mSpotsDataBaseHelper = new SpotsDataBaseHelper(getSpotsDao());
        if(0!=spotId){
            Spots spots = mSpotsDataBaseHelper.getSpotsById(spotId);
            if (spots != null){
                gudieFragment.showBaiduInfoWindow(spots);
                gudieFragment.locationToCenter(Double.parseDouble(spots.getLat4show()),Double.parseDouble(spots.getLng4show()),false);
            }

        }
    }

    private void  spiltTest(){
        String so ="https://www.baidu.com/s?id=2";
        String s1 = so.substring(0, so.lastIndexOf("?")+1);
        String s2 = so.replaceAll(s1,"");
        String s3 =s2.substring(0,s2.lastIndexOf("=")+1);
        String s4 =s2.replace(s3,"");

        Log.i("wwwwwwwwwwww",s1);
        Log.i("wwwwwwwwwwww",s2);
        Log.i("wwwwwwwwwwww",s3);
        Log.i("wwwwwwwwwwww",s4);
    }

}
