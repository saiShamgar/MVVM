package com.sairaa.mvvm.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sairaa.mvvm.Model.Image_List;
import com.sairaa.mvvm.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RV_Adapter extends RecyclerView.Adapter<RV_Adapter.ViewHolder> {

    private Context context;
    private ArrayList<Image_List> arrayList;

    public RV_Adapter(Context context, ArrayList<Image_List> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cus_list_view,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context)
                .load(arrayList.get(i).getImage_url())
                .into(viewHolder.cir_image_view);
        viewHolder.txt_image_name.setText(arrayList.get(i).getImage_name());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView cir_image_view;
        private TextView txt_image_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cir_image_view=itemView.findViewById(R.id.cir_image_view);
            txt_image_name=itemView.findViewById(R.id.txt_image_name);

        }
    }
}
