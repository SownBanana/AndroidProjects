package com.example.listitem.adapter;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.listitem.R;
import com.example.listitem.models.MailModel;

import java.util.List;

public class MailAdapter extends BaseAdapter {
    List<MailModel> items;

    public MailAdapter(List<MailModel> items) {
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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.mail = convertView.findViewById(R.id.mail);
            viewHolder.name = convertView.findViewById(R.id.name);
            viewHolder.nameAva = convertView.findViewById(R.id.nameAva);
            viewHolder.subject = convertView.findViewById(R.id.subject);
            viewHolder.content = convertView.findViewById(R.id.content);
            viewHolder.time = convertView.findViewById(R.id.time);
            viewHolder.favorite = convertView.findViewById(R.id.favorite);
            convertView.setTag(viewHolder);
        }
        else viewHolder = (ViewHolder) convertView.getTag();

        final MailModel item = items.get(position);
        viewHolder.name.setText(item.getName());
        viewHolder.nameAva.setText(Character.toString(item.getName().charAt(0)));
        viewHolder.subject.setText(item.getSubject());
        viewHolder.content.setText(item.getContent());
        viewHolder.time.setText(item.getTime());
        String colorAvaCode = String.format("#%06x", item.getRdColor());
        viewHolder.nameAva.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(colorAvaCode)));

        if(item.isRead()) {
            viewHolder.subject.setTextColor(Color.BLACK);
            viewHolder.subject.setAlpha(0.54f);
            viewHolder.subject.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        }
        else {
            viewHolder.subject.setTextColor(Color.parseColor("#2F2F2F"));
            viewHolder.subject.setAlpha(1f);
            viewHolder.subject.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        }
        TextView tmp = convertView.findViewById(R.id.search);
        System.out.println(viewHolder.subject.getTypeface().toString());
        if(item.isFavorite()) viewHolder.favorite.setImageResource(R.drawable.checked_star_black_35dp);
        else viewHolder.favorite.setImageResource(R.drawable.uncheck_star_35dp);
        viewHolder.mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!item.isRead()){
                    item.setRead(true);
                    notifyDataSetChanged();
                }
            }
        });
        viewHolder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setFavorite(!item.isFavorite());
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    class ViewHolder{
        RelativeLayout mail;
        TextView nameAva;
        TextView name;
        TextView subject;
        TextView content;
        TextView time;
        ImageView favorite;
    }
}
