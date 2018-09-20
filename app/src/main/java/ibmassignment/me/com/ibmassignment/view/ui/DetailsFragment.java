package ibmassignment.me.com.ibmassignment.view.ui;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import ibmassignment.me.com.ibm_assignment.R;
import ibmassignment.me.com.ibm_assignment.databinding.FragmentDetailsBinding;
import ibmassignment.me.com.ibmassignment.model.Item;


public class DetailsFragment extends Fragment {

    private Item item;

    public DetailsFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentDetailsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false);
        View view = binding.getRoot();
        item = (Item) getArguments().getSerializable("item");
        binding.setDetail(item);

        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Product Details");
    }

}
