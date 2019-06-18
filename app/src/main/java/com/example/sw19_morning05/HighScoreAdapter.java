package com.example.sw19_morning05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HighScoreAdapter extends ArrayAdapter<HighScore> {

    private static class ViewHolder {
        TextView textv_date;
        TextView textv_user;
        TextView textv_value;
    }

    public HighScoreAdapter(ArrayList<HighScore> data, Context context) {
        super(context, R.layout.list_item_highscore, data);
    }

    @Override
    public View getView(int position, View list_view_item, ViewGroup parent) {
        HighScore hs = getItem(position);
        ViewHolder view_holder;

        if (list_view_item == null) {
            view_holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            list_view_item = inflater.inflate(R.layout.list_item_highscore, parent, false);

            view_holder.textv_date = list_view_item.findViewById(R.id.textv_date_lih);
            view_holder.textv_user = list_view_item.findViewById(R.id.textv_user_lih);
            view_holder.textv_value = list_view_item.findViewById(R.id.textv_value_lih);

            list_view_item.setTag(view_holder);

        } else {
            view_holder = (ViewHolder) list_view_item.getTag();
        }
        view_holder.textv_date.setText(hs.getDate().toString());
        view_holder.textv_user.setText(hs.getUser());
        view_holder.textv_value.setText(String.valueOf(hs.getHighScore()));

        return list_view_item;
    }
}
