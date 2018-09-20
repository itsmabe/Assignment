package ibmassignment.me.com.ibmassignment.view.ui;


import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import ibmassignment.me.com.ibm_assignment.R;
import ibmassignment.me.com.ibm_assignment.databinding.FragmentHomeBinding;


public class WelcomeFragment extends Fragment {

    public WelcomeFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentHomeBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        View view = binding.getRoot();
        ImageView bg = binding.bg;
        Bitmap bitmap = BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.blur_bg);
//        Blurry.with(getActivity())
//                .async()
//                .from(bitmap)
//                .into(bg);

        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        ((MainActivity) getActivity()).getDrawerLayout().setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Home");
    }

}
