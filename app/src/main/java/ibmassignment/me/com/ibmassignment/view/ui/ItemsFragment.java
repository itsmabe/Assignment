package ibmassignment.me.com.ibmassignment.view.ui;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ibmassignment.me.com.ibm_assignment.R;
import ibmassignment.me.com.ibm_assignment.databinding.FragmentItemsBinding;
import ibmassignment.me.com.ibmassignment.model.Item;
import ibmassignment.me.com.ibmassignment.view.adapter.ItemsAdapter;
import ibmassignment.me.com.ibmassignment.viewmodel.ItemViewModel;


public class ItemsFragment extends Fragment implements ItemsAdapter.ItemsAdapterListener {

    private RecyclerView recyclerView;
    private List<Item> items;
    private ItemsAdapter mAdapter;
    private FragmentItemsBinding binding;

    public ItemsFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ItemViewModel itemsViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        items = itemsViewModel.getProductList(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_items, container, false);

        initRecyclerView();

        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        ((MainActivity) getActivity()).getDrawerLayout().setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Product List");
    }

    private void initRecyclerView() {
        if (!items.isEmpty()) {
            recyclerView = binding.rv;
            LinearLayoutManager llm = new LinearLayoutManager(getActivity());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(llm);
            recyclerView.setHasFixedSize(true);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            mAdapter = new ItemsAdapter(items, this);
            recyclerView.setAdapter(mAdapter);
        }
    }

    @Override
    public void onItemClicked(Item item) {
        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("item", item);
        detailsFragment.setArguments(bundle);
        getFragmentManager().beginTransaction()
                .setCustomAnimations(R.animator.anim_slide_in_left, R.animator.anim_slide_out_right,
                        R.animator.anim_slide_out_left, R.animator.anim_slide_in_right)
                .replace(R.id.content_frame, detailsFragment).addToBackStack(null).commit();
    }
}
