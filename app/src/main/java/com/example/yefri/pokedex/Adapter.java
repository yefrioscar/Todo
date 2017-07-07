package com.example.yefri.pokedex;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yefri on 07/07/2017.
 */

public class Adapter extends ArrayAdapter<Todo>{

    public Adapter(Context context, ArrayList<Todo> todos){
        super(context, 0, todos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list,parent,false);

        TextView estado, title;

        estado = (TextView) convertView.findViewById(R.id.tvEstado);
        title  = (TextView) convertView.findViewById(R.id.tvTitle);

        Todo todo = getItem(position);

        estado.setText(todo.getCompleted());
        title.setText(todo.getTitle());

        return convertView;
    }
}
