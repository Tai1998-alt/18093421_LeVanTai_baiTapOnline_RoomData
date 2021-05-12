package com.example.LeVanTai_18093421_Roomdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolderView> {
    private List<User> list;
    public void setData(List<User> list)
    {
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview,parent,false);
        return new MyHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderView holder, int position) {

        User user = list.get(position);
        holder.txtUserName.setText(user.getName());
        holder.txtAddress.setText(user.getAddress());
    }

    @Override
    public int getItemCount() {
        if (list!=null)
            return list.size();
        return 0;
    }

    public class MyHolderView extends RecyclerView.ViewHolder {
        TextView txtUserName,txtAddress;
        public MyHolderView(@NonNull View itemView) {
            super(itemView);
            txtUserName = itemView.findViewById(R.id.txtUserName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
        }
    }
}
