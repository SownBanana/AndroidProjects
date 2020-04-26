package com.example.listitem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.listitem.adapter.MailAdapter;
import com.example.listitem.models.MailModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<MailModel> items;
    EditText editFill;
    ImageButton favoriteBtn;
    ListView listView;
    TextView errorText;

    boolean isFavorMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        errorText = findViewById(R.id.error_mss);
        editFill = findViewById(R.id.search);
        favoriteBtn = findViewById(R.id.favorFill);

        items = new ArrayList<>();
        items.add(new MailModel("SownBanana", "Test Mail", "Lorem ipsum dolor sit amet, consectetur" +
                " adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna al.",
                "11:20 PM"));
        items.add(new MailModel("Phạm Sơn", "Bài tập về nhà tuần 8", "Lorem ipsum dolor sit amet, consectetur" +
                " adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna al.",
                "9:25 PM"));
        items.add(new MailModel("Work Mail", "Work Assigment", "Lorem ipsum dolor sit amet, consectetur" +
                " adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna al.",
                "8:30 PM", true, true));
        items.add(new MailModel("SownBanana", "Test Mail2", "Lorem ipsum dolor sit amet, consectetur" +
                " adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna al.",
                "4:20 PM", true, true));
        items.add(new MailModel("SownBanana", "Test Mail3", "Lorem ipsum dolor sit amet, consectetur" +
                " adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna al.",
                "4:20 PM"));
        items.add(new MailModel("SownBanana", "Test Mail4", "Lorem ipsum dolor sit amet, consectetur" +
                " adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna al.",
                "4:20 PM", true, false));
        items.add(new MailModel("SownBanana", "Test Mail5", "Lorem ipsum dolor sit amet, consectetur" +
                " adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna al.",
                "4:20 PM"));
        items.add(new MailModel("SownBanana", "Test Mail6", "Lorem ipsum dolor sit amet, consectetur" +
                " adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna al.",
                "4:20 PM", false, true));
        items.add(new MailModel("SownBanana", "Test Mail7", "Lorem ipsum dolor sit amet, consectetur" +
                " adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna al.",
                "4:20 PM", true, true));
        items.add(new MailModel("SownBanana", "Test Mail8", "Lorem ipsum dolor sit amet, consectetur" +
                " adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna al.",
                "4:20 PM", true, true));
        items.add(new MailModel("SownBanana", "Test Mail9", "Lorem ipsum dolor sit amet, consectetur" +
                " adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna al.",
                "4:20 PM"));

        final MailAdapter adapter = new MailAdapter(items);
        listView = findViewById(R.id.list_mail);
        setMyAdapter(adapter, "You don't have any eMail!");


        //Nút favorite
        favoriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isFavorMode){   //Chế độ favorite
                    isFavorMode = true;
                    MailAdapter favorAdapt = new MailAdapter(getFavorList());
                    setMyAdapter(favorAdapt, "Your favorite mail list is empty!");
                    favoriteBtn.setImageResource(R.drawable.checked_star_black_35dp);
                }else{              //Chế độ thường
                    isFavorMode = false;
                    setMyAdapter(adapter, "You don't have any eMail!");
                    favoriteBtn.setImageResource(R.drawable.uncheck_star_35dp);
                }
            }
        });

        //Tìm kiếm
        editFill.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!(editFill.getText().length() < 3)){
                    MailAdapter fillAdapt = new MailAdapter(getFillterMail());
                    setMyAdapter(fillAdapt, "No eMail matched your search!");
                }
                else{
                    setMyAdapter(adapter, "You don't have any eMail!");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    //Lấy danh sách email yêu thích
    public List<MailModel> getFavorList(){
        List<MailModel> favorItems = new ArrayList<>();
        for (MailModel item : items){
            if(item.isFavorite()) favorItems.add(item);
        }
        return favorItems;
    }
    //Lấy danh sách email chứa key
    public List<MailModel> getFillterMail(){
        List<MailModel> fillItems = new ArrayList<>();
        String fillText = editFill.getText().toString().toLowerCase();
        for (MailModel item : items){
            if(item.getName().toLowerCase().contains(fillText)) fillItems.add(item);
            else if(item.getSubject().toLowerCase().contains(fillText)) fillItems.add(item);
            else if(item.getContent().toLowerCase().contains(fillText)) fillItems.add(item);
        }
        return fillItems;
    }

    //Set apater kèm thông báo nếu rỗng
    public boolean setMyAdapter(BaseAdapter adapter, String errorMess){
        listView.setAdapter(adapter);
        if(!adapter.isEmpty()) {
            errorText.setVisibility(View.GONE);
            return true;
        }
        else{
            errorText.setText(errorMess);
            errorText.setVisibility(View.VISIBLE);
            return false;
        }
    }
}
