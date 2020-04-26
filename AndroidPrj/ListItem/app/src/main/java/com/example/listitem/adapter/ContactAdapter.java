package com.example.listitem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listitem.R;
import com.example.listitem.models.ContactModel;

import java.util.List;

public class ContactAdapter extends BaseAdapter {

    List<ContactModel> items;

    public ContactAdapter(List<ContactModel> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent,false );
            viewHolder = new ViewHolder();
 /*           viewHolder.imageView = convertView.findViewById(R.id.imgV);
            viewHolder.textView = convertView.findViewById(R.id.textV);*/
            viewHolder.checkBox = convertView.findViewById(R.id.checkbox);
            convertView.setTag(viewHolder);
        }
        else viewHolder = (ViewHolder)convertView.getTag();

/*        ImageView imageView = convertView.findViewById(R.id.imgV);
        TextView textView = convertView.findViewById(R.id.textV);
        CheckBox checkbox = convertView.findViewById(R.id.checkbox);*/

        final ContactModel contactModel = items.get(position);
        viewHolder.textView.setText(contactModel.getName());
        viewHolder.imageView.setImageResource(contactModel.getAvatarRs());
        viewHolder.checkBox.setChecked(contactModel.isSelected());

        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactModel.setSelected(!contactModel.isSelected());
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
    class ViewHolder {
        TextView textView;
        ImageView imageView;
        CheckBox checkBox;
    }
}
