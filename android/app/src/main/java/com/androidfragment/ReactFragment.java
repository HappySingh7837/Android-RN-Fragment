package com.androidfragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;

public class ReactFragment extends Fragment {
    private ReactRootView reactRootView;
    private ReactInstanceManager reactInstanceManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        reactRootView = new ReactRootView(getActivity());
        reactInstanceManager = ((MainApplication)getActivity().getApplication()).getReactNativeHost().getReactInstanceManager();
        return  reactRootView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        reactRootView = new ReactRootView(context);
        reactInstanceManager = ((MainApplication)getActivity().getApplication()).getReactNativeHost().getReactInstanceManager();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       //reactRootView.startReactApplication('reactInstanceManager',"ReactNativeFragment",null);
        reactRootView.startReactApplication(reactInstanceManager,"AndroidFragment",null);
    }
}
