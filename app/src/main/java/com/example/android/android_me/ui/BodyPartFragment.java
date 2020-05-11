package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";

    private static final String TAG = "BodyPartFragment";

    public List<Integer> mImageids;
    public int mListIndex;

    public BodyPartFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        if(savedInstanceState != null){
            mImageids = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        View rootView = inflater.inflate(R.layout.fragment_body_part,container,false);

        final ImageView imageView =(ImageView) rootView.findViewById(R.id.body_part_image_view);

        if (mImageids != null){
            imageView.setImageResource(mImageids.get(mListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListIndex < mImageids.size()-1){
                        mListIndex++;
                    }else{
                        mListIndex = 0;
                    }

                    imageView.setImageResource(mImageids.get(mListIndex));
                }
            });
        }else{
            Log.v(TAG,"This fragment has null list of image id's");
        }

        return rootView;

    }
    public void setImageids(List<Integer> imageids){
        mImageids = imageids;
    }

    public void setListIndex(int index){
        mListIndex = index;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageids);
        outState.putInt(LIST_INDEX, mListIndex);
    }
}
