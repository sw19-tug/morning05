package com.example.sw19_morning05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HighScoreAdapter extends ArrayAdapter<HighScore> {
    private ArrayList<HighScore> highscore_list;
    Context context;

    private static class ViewHolder {
        TextView textv_date;
        TextView textv_user;
        TextView textv_value;
    }

    public HighScoreAdapter(ArrayList<HighScore> data, Context context) {
        super(context, R.layout.list_item_highscore, data);
        this.highscore_list = data;
        this.context = context;

    }

    @Override
    public View getView(int position, View listViewItem, ViewGroup parent) {

        HighScore hs = getItem(position);
        ViewHolder viewHolder;

        if (listViewItem == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            listViewItem = inflater.inflate(R.layout.list_item_highscore, parent, false);

            viewHolder.textv_date = listViewItem.findViewById(R.id.textv_highscore_date);
            viewHolder.textv_user = listViewItem.findViewById(R.id.textv_highscore_user);
            viewHolder.textv_value = listViewItem.findViewById(R.id.textv_highscore_value);

            listViewItem.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) listViewItem.getTag();
        }

        viewHolder.textv_date.setText(hs.getDate().toString());
        viewHolder.textv_user.setText(hs.getUser());
        viewHolder.textv_value.setText(String.valueOf(hs.getHighScore()));

        return listViewItem;
    }

}
