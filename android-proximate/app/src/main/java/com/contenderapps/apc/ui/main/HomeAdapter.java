package com.contenderapps.apc.ui.main;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import butterknife.ButterKnife;
import com.contenderapps.apc.R;

/**
 * @author Adam Szewera
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private static final String TAG = HomeAdapter.class.getSimpleName();

    private Context mContext;

    private List<String> mData;

    private OnItemClickListener mListener;

    private ColorMatrixColorFilter mColorFilter;






    public HomeAdapter(OnItemClickListener listener, Context context) {
        mListener = listener;
        mData = new ArrayList<>();
        mContext = context;

        ColorMatrix mGrayScaleColorMatrix;
        mGrayScaleColorMatrix = new ColorMatrix();
        mGrayScaleColorMatrix.setSaturation(0);
        mColorFilter = new ColorMatrixColorFilter(mGrayScaleColorMatrix);

    }


    public void setData(@NonNull List<String> data) {
        mData = data;
        Log.d(TAG, "setData: size: " + data.size());
        notifyDataSetChanged();
    }





    ////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                           RecyclerView.Adapter methods
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_drawing_item, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String s = mData.get(position);
        holder.render(s);
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }





    ////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                  ViewHolder
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public class ViewHolder extends RecyclerView.ViewHolder {

        private Context mContext;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }


        public void render(String s) {
            // todo; add text

        }

    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                  OnItemClickListener
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public interface OnItemClickListener {
        void onItemClick(int index);
    }




}




