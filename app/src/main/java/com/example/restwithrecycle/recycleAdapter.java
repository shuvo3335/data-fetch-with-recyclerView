package com.example.restwithrecycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;

public class recycleAdapter extends RecyclerView.Adapter<recycleAdapter.MyviewHolder> {
    List<imageList>imageLists;
    Context context;

    public recycleAdapter(List<imageList> imageLists, Context context) {
        this.imageLists = imageLists;
        this.context = context;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_layout,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        imageList imageList1=imageLists.get(position);
        holder.textView.setText(imageList1.getName());

        Picasso.get()
                .load(imageList1.getImageurl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imageLists.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageID);
            textView = itemView.findViewById(R.id.textID);

        }
    }
}
