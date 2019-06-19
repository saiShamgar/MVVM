package com.sairaa.mvvm.Repositories;

import android.arch.lifecycle.MutableLiveData;

import com.sairaa.mvvm.Model.Image_List;

import java.util.ArrayList;

public class ImagesRepository {

    private static ImagesRepository instance;
    private ArrayList<Image_List> dataSet=new ArrayList<>();
    public static  ImagesRepository getInstance(){
        if (instance==null){
            instance=new ImagesRepository();
        }
        return instance;
    }

    public MutableLiveData<ArrayList<Image_List>> getImageList(){
        setImageList();
        MutableLiveData<ArrayList<Image_List>> data=new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }
    private void setImageList(){
        dataSet.clear();
        dataSet.add(new Image_List("https://3.bp.blogspot.com/-xN90DsNqc6w/WgnObjQG34I/AAAAAAAAlmU/927YYGM9Y9o-IhcZdc3XDlvn94WNzfuagCEwYBhgL/s1600/prabhas%2Bphotos%2B7.jpg","prabhas 1"));
        dataSet.add(new Image_List("http://1.bp.blogspot.com/--C-x0QqlXfY/UhBNU5SbrQI/AAAAAAAAox8/amGCDZ2m4uo/s1600/Prabhas+HD+Wallpapers+12.jpg","prabhas 2"));
        dataSet.add(new Image_List("http://2.bp.blogspot.com/-ThSnqv-BjjE/UhBNTgM8eGI/AAAAAAAAoxw/nYE3yaKjY68/s1600/Prabhas+HD+Wallpapers+1.jpg","prabhas 3"));
        dataSet.add(new Image_List("https://3.bp.blogspot.com/-xN90DsNqc6w/WgnObjQG34I/AAAAAAAAlmU/927YYGM9Y9o-IhcZdc3XDlvn94WNzfuagCEwYBhgL/s1600/prabhas%2Bphotos%2B7.jpg","prabhas 4"));
        dataSet.add(new Image_List("http://1.bp.blogspot.com/--C-x0QqlXfY/UhBNU5SbrQI/AAAAAAAAox8/amGCDZ2m4uo/s1600/Prabhas+HD+Wallpapers+12.jpg","prabhas 5"));
        dataSet.add(new Image_List("https://3.bp.blogspot.com/-xN90DsNqc6w/WgnObjQG34I/AAAAAAAAlmU/927YYGM9Y9o-IhcZdc3XDlvn94WNzfuagCEwYBhgL/s1600/prabhas%2Bphotos%2B7.jpg","prabhas 6"));
        dataSet.add(new Image_List("http://2.bp.blogspot.com/-ThSnqv-BjjE/UhBNTgM8eGI/AAAAAAAAoxw/nYE3yaKjY68/s1600/Prabhas+HD+Wallpapers+1.jpg","prabhas 7"));
        dataSet.add(new Image_List("https://3.bp.blogspot.com/-xN90DsNqc6w/WgnObjQG34I/AAAAAAAAlmU/927YYGM9Y9o-IhcZdc3XDlvn94WNzfuagCEwYBhgL/s1600/prabhas%2Bphotos%2B7.jpg","prabhas 8"));
    }
}
