package com.sairaa.mvvm.ViewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.sairaa.mvvm.Model.Image_List;
import com.sairaa.mvvm.Repositories.ImagesRepository;
import java.util.ArrayList;


public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Image_List>> imagesList;
    private ImagesRepository repository;
    private MutableLiveData<Boolean> isupdating=new MutableLiveData<>();
    public LiveData<ArrayList<Image_List>> getImages(){
        return imagesList;
    }
    public LiveData<Boolean> getIsUpdating  (){
        return isupdating;
    }

    public void init(){
        if (imagesList!=null){
            return;
        }
        repository=ImagesRepository.getInstance();
        imagesList=repository.getImageList();



    }

    public void getNewList(final Image_List image_list){
        isupdating.setValue(true);

        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                ArrayList<Image_List> currentList=imagesList.getValue();
                currentList.add(image_list);
                imagesList.postValue(currentList);
                isupdating.postValue(false);
            }
        }.execute();

    }
}
