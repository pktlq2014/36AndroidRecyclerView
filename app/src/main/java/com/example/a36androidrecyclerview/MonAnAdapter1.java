package com.example.a36androidrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MonAnAdapter1 extends RecyclerView.Adapter<MonAnAdapter1.MonAnViewHolder>
{
    public ArrayList<MonAn> arrayList;
    public OnListener onListener;

    public void setOnListener(OnListener onListener)
    {
        this.onListener = onListener;
    }

    public MonAnAdapter1(ArrayList<MonAn> arrayList)
    {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MonAnViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.item_monan, parent, false);
        return new MonAnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonAnViewHolder holder, int position)
    {
        MonAn monAn = arrayList.get(position);
        holder.imageView.setImageResource(monAn.getHinhAnh());
        holder.textView1.setText(monAn.getTenMonan());
        holder.textView2.setText(monAn.getDiaChi());
    }

    @Override
    public int getItemCount()
    {
        return arrayList != null ? arrayList.size() : 0;
    }

    public class MonAnViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView1, textView2;
        public MonAnViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewMonAn);
            textView1 = itemView.findViewById(R.id.textViewTenMonAn);
            textView2 = itemView.findViewById(R.id.textViewDiaChiMonAn);
            // sự kiện click
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    onListener.onClick(getLayoutPosition());
                }
            });
        }
    }
}
