package cn.readsense.aac;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cn.readsense.aac.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.setUser(new User("icount"));


        binding.btn1.setText("点击");
        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.setUser(new User("icount2"));
            }
        });


    }

}
