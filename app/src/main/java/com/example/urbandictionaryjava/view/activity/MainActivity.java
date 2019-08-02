package com.example.urbandictionaryjava.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.urbandictionaryjava.R;
import com.example.urbandictionaryjava.databinding.ActivityMainBinding;
import com.example.urbandictionaryjava.model.datasource.urbanDictionary.UrbanDictionaryResponse;
import com.example.urbandictionaryjava.view.adapter.RecyclerviewAdapter;
import com.example.urbandictionaryjava.viewmodel.UrbanDictionaryViewModel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    UrbanDictionaryResponse dictionaryResponse;
    UrbanDictionaryResponse sortedResponse;
    UrbanDictionaryViewModel urbanDictionaryViewModel = new UrbanDictionaryViewModel();
    RecyclerView recyclerView;
    EditText etUserInput;
    TextView tvDefinedWord;
    ProgressBar progressBar;
    String userInput;
    ImageButton imageButton;
    int sortFlag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setViewmodel(urbanDictionaryViewModel);
        etUserInput = findViewById(R.id.etUserInput);
        tvDefinedWord = findViewById(R.id.tvDefinedWord);
        progressBar = findViewById(R.id.pgProgress);
        imageButton = findViewById(R.id.btnThumbSort);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSubmit:
                userInput = etUserInput.getText().toString();
                if (!userInput.isEmpty()) {
                    progressBar.setVisibility(View.VISIBLE);
                    tvDefinedWord.setText(userInput);
                    urbanDictionaryViewModel.getUrbanDictionaryData(userInput);
                    urbanDictionaryViewModel.urbanDictionaryResponseMutableLiveData
                            .observe(this, new Observer<UrbanDictionaryResponse>() {
                                @Override
                                public void onChanged(UrbanDictionaryResponse urbanDictionaryResponse) {
                                    setRecyclerView(urbanDictionaryResponse);
                                    dictionaryResponse = urbanDictionaryResponse;
                                    progressBar.setVisibility(View.GONE);
                                    imageButton.setVisibility(View.VISIBLE);

                                }
                            });
                    etUserInput.setBackgroundColor(Color.TRANSPARENT);

                }else {
                    etUserInput.setBackgroundColor(Color.RED);
                    Toast.makeText(this, "Error: Input Field is Empty!!",
                            Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnThumbSort:
                if (sortFlag == 0) {
                    sortedResponse = sortList(dictionaryResponse, sortFlag);
                    imageButton.setImageResource(R.drawable.ic_thumbs_down);
                    sortFlag = 1;
                }else if(sortFlag == 1){
                    sortedResponse = sortList(dictionaryResponse, sortFlag);
                    sortFlag = 0;
                    imageButton.setImageResource(R.drawable.ic_thumb_up);
                }
                setRecyclerView(sortedResponse);
                break;
        }
    }

    @BindingAdapter("bind:urbanDictionary")
    public static void initRecyclerView(RecyclerView recyclerView, UrbanDictionaryResponse urbanDictionaryResponse){}


    private void setRecyclerView(UrbanDictionaryResponse urbanDictionaryResponse){
        if (urbanDictionaryResponse != null){
            recyclerView = findViewById(R.id.rvDefinitions);
            RecyclerviewAdapter recyclerviewAdapter = new RecyclerviewAdapter(urbanDictionaryResponse);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setAdapter(recyclerviewAdapter);
            recyclerView.setLayoutManager(layoutManager);
        }
    }

    public UrbanDictionaryResponse sortList(UrbanDictionaryResponse urbanDictionaryResponse, int flag){
        UrbanDictionaryResponse temp = urbanDictionaryResponse;
        int minIndex;
        int length = urbanDictionaryResponse.getList().size();
        com.example.urbandictionaryjava.model.datasource.urbanDictionary.List tempList1, tempList2;
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;
            for (int j = i +1; j < length ; j++) {
                if ( sortFlag == 0) {
                    if (urbanDictionaryResponse.getList().get(j).getThumbsUp() >
                            urbanDictionaryResponse.getList().get(minIndex).getThumbsUp()) {

                        tempList1 =  urbanDictionaryResponse.getList().get(minIndex);
                        tempList2 =  urbanDictionaryResponse.getList().get(j);
                        temp.getList().set(j, tempList1);
                        temp.getList().set(minIndex, tempList2);

                    }
                }else if (sortFlag == 1){
                    if (urbanDictionaryResponse.getList().get(j).getThumbsDown() >
                            urbanDictionaryResponse.getList().get(minIndex).getThumbsDown()) {

                        tempList1 =  urbanDictionaryResponse.getList().get(minIndex);
                        tempList2 =  urbanDictionaryResponse.getList().get(j);
                        temp.getList().set(j, tempList1);
                        temp.getList().set(minIndex, tempList2);

                    }
                }

            }

        }

        return temp ;
    }
}
