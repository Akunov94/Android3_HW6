package com.example.android3_hw6.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;

import com.example.android3_hw6.R;
import com.example.android3_hw6.databinding.ActivityMainBinding;
import com.example.android3_hw6.domain.Math;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Math math = new Math();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        calc();
    }


    private void calc() {
        binding.btnAdd.setOnClickListener(v -> {
            String num1 = binding.etOper1.getText().toString();
            String num2 = binding.etOper2.getText().toString();
            if (num1.isEmpty() || num2.isEmpty()) {
                binding.etOper2.setError("Не должен быть пустым");
                binding.etOper1.setError("Не должен быть пустым");
            } else {
                int a = Integer.parseInt(num1);
                int b = Integer.parseInt(num2);
                binding.tvResult.setText(String.valueOf(math.add(a, b)));
            }
        });
        binding.btnMinus.setOnClickListener(v -> {
            String num1 = binding.etOper1.getText().toString();
            String num2 = binding.etOper2.getText().toString();
            if (num1.isEmpty() || num2.isEmpty()) {
                binding.etOper2.setError("Не должен быть пустым");
                binding.etOper1.setError("Не должен быть пустым");
            } else {
                int a = Integer.parseInt(num1);
                int b = Integer.parseInt(num2);
                binding.tvResult.setText(String.valueOf(math.minus(a, b)));
            }
        });
        binding.btnMultiplication.setOnClickListener(view -> {
            String num1 = binding.etOper1.getText().toString();
            String num2 = binding.etOper2.getText().toString();
            if (num1.isEmpty() || num2.isEmpty()) {
                binding.etOper2.setError("Не должен быть пустым");
                binding.etOper1.setError("Не должен быть пустым");
            } else {
                int a = Integer.parseInt(num1);
                int b = Integer.parseInt(num2);
                binding.tvResult.setText(String.valueOf(math.multiplication(a, b)));
            }
        });
        binding.btnDivision.setOnClickListener(view -> {
            String num1 = binding.etOper1.getText().toString();
            String num2 = binding.etOper2.getText().toString();
            validateSubtracting(num1,num2);
        });
//        binding.btnDivision.setOnClickListener(view -> {
//            String num1 = binding.etOper1.getText().toString();
//            String num2 = binding.etOper2.getText().toString();
//            if (num1.isEmpty() || num2.isEmpty()) {
//                binding.etOper2.setError("Не должен быть пустым");
//                binding.etOper1.setError("Не должен быть пустым");
//            } else {
//                int a = Integer.parseInt(num1);
//                int b = Integer.parseInt(num2);
//                binding.tvResult.setText(String.valueOf(math.division(a, b)));
//            }
//        });
    }

    public void validateSubtracting(String first, String second) {
        Integer num1;
        Integer num2;
        if (!first.isEmpty() && !second.isEmpty()) {
            if (TextUtils.isDigitsOnly(first) && TextUtils.isDigitsOnly(second)) {
                num1 = Integer.parseInt(first);
                num2 = Integer.parseInt(second);
                if (num1 > 0 && num2 > 0) {
                    binding.tvResult.setText(String.valueOf(math.subtractFunction(num1, num2)));
                } else binding.tvResult.setText("нельзя делить на 0");
            } else {
                binding.tvResult.setText("пожалуйста, введите цифру");
            }
        } else {
            binding.tvResult.setText("поле не может быть пустым");
        }
    }
}