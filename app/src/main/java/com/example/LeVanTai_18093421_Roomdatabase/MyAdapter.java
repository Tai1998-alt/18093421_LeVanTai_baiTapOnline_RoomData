package com.example.LeVanTai_18093421_Roomdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolderView>{
    private List<User> list;
    private DeleteAndUpdate deleteAndUpdate;
    public MyAdapter (DeleteAndUpdate deleteAndUpdate)
    {
        this.deleteAndUpdate = deleteAndUpdate;
    }
    public void setData(List<User> list)
    {
        this.list = list;
        notifyDataSetChanged();
    }

   public interface DeleteAndUpdate
    {
        public void DeleteUser(User user);
        public void UpdateUser(User user);
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

        final User user = list.get(position);
        holder.txtName.setText(user.getName());
        holder.imageEdit.setImageResource(user.getImgEdit());
        holder.imageDelete.setImageResource(user.getImgDelete());
        holder.imageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAndUpdate.DeleteUser(user);
            }
        });
        holder.imageEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAndUpdate.UpdateUser(user);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list!=null)
            return list.size();
        return 0;
    }

    public class MyHolderView extends RecyclerView.ViewHolder {
        TextView txtName;
        ImageView imageEdit, imageDelete;
        public MyHolderView(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            imageEdit = itemView.findViewById(R.id.imageEdit);
            imageDelete = itemView.findViewById(R.id.imageDelete);
        }
    }
}
