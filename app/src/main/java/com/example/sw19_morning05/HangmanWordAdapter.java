package com.example.sw19_morning05;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HangmanWordAdapter extends ArrayAdapter<Pair<String, Boolean>> {
    private ArrayList<Pair<String, Boolean>> word_list;
    private Context context;

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
    public View getView(final int position, View list_view_item, ViewGroup parent) {
        Pair<String, Boolean> pair = getItem(position);
        ViewHolder view_holder;

        if (list_view_item == null) {

            view_holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            list_view_item = inflater.inflate(R.layout.list_item_hm_word, parent, false);

            view_holder.textv_hm_word = list_view_item.findViewById(R.id.textv_word_liw);
            view_holder.btn_delete = list_view_item.findViewById(R.id.imagev_word_liw);

            list_view_item.setTag(view_holder);

        } else {
            view_holder = (ViewHolder) list_view_item.getTag();
        }

        assert pair != null;
        view_holder.textv_hm_word.setText(pair.first);

        view_holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.imagev_word_liw:
                        Pair<String, Boolean> word = word_list.get(position);
                        if (word.second == true) {
                            Settings.removeHangmanWord(context, position);
                            remove(word_list.get(position));
                        } else {
                            Toast.makeText(
                                    context,
                                    context.getResources().getString(R.string.str_delete_warning_hw_ew),
                                    Toast.LENGTH_LONG
                            ).show();
                        }
                        break;
                }
            }
        });
        return list_view_item;
    }
}
