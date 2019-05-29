package com.example.sw19_morning05;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HangmanWordAdapter extends ArrayAdapter<Pair<String, Boolean>> {
    private ArrayList<Pair<String, Boolean>> word_list;
    Context context;

    private static class ViewHolder {
        TextView textv_hm_word;
        ImageView btn_delete;
    }

    public HangmanWordAdapter(ArrayList<Pair<String, Boolean>> data, Context context) {
        super(context, R.layout.list_item_hm_word, data);
        this.word_list = data;
        this.context = context;

    }

    @Override
    public View getView(int position, View listViewItem, ViewGroup parent) {
        Pair<String, Boolean> pair = getItem(position);
        ViewHolder viewHolder;

        if (listViewItem == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            listViewItem = inflater.inflate(R.layout.list_item_hm_word, parent, false);

            viewHolder.textv_hm_word = listViewItem.findViewById(R.id.textv_hm_word);
            viewHolder.btn_delete = (ImageView) listViewItem.findViewById(R.id.imagev_hm_word);

            listViewItem.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) listViewItem.getTag();
        }

        viewHolder.textv_hm_word.setText(pair.first);
        viewHolder.btn_delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int position=(Integer) v.getTag();
                Object object= getItem(position);
                Pair<String, Boolean> dataModel = (Pair<String, Boolean>) object;

                switch (v.getId())
                {
                    case R.id.imagev_hm_word:
                        Snackbar.make(v, "Hello world!", Snackbar.LENGTH_LONG)
                                .setAction("No action", null).show();
                        break;
                }
            }
        });

        return listViewItem;
    }

}
