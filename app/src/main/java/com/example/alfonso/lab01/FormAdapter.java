package com.example.alfonso.lab01;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alfonso on 03-04-2018.
 */

public class FormAdapter extends ArrayAdapter<Form> {

    private ArrayList<Form> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView txtName;
        TextView txtDate;
        TextView txtCategory;
        TextView txtDescription;
    }

    public FormAdapter (ArrayList<Form> data, Context context) {
        super(context, R.layout.row_item, data);
        this.mContext = context;
        this.dataSet = data;
    }

    private int lastPosition = -1;

    public View getView(int position, View convertView, ViewGroup parent) {
        Form dataModel = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtDate = (TextView) convertView.findViewById(R.id.date);
            viewHolder.txtCategory = (TextView) convertView.findViewById(R.id.category);
            viewHolder.txtDescription = (TextView) convertView.findViewById(R.id.description);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtDate.setText(dataModel.getDate());
        viewHolder.txtCategory.setText(dataModel.getCategory());
        viewHolder.txtDescription.setText(dataModel.getDescription());

        return convertView;
    }
}
