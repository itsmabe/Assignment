package ibmassignment.me.com.ibmassignment.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ibmassignment.me.com.ibm_assignment.R;
import ibmassignment.me.com.ibm_assignment.databinding.ItemsLayoutBinding;
import ibmassignment.me.com.ibmassignment.model.Item;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.MyViewHolder> {

    private List<Item> itemList;
    private LayoutInflater layoutInflater;
    private ItemsAdapterListener listener;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ItemsLayoutBinding binding;

        public MyViewHolder(ItemsLayoutBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }

    public ItemsAdapter(List<Item> itemList, ItemsAdapterListener listener) {
        this.itemList = itemList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemsLayoutBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.items_layout, parent, false);
        return new MyViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.binding.setItem(itemList.get(position));
        holder.binding.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClicked(itemList.get(position));
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public interface ItemsAdapterListener {
        void onItemClicked(Item item);
    }
}
