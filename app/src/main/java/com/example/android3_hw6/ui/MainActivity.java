package com.example.android3_hw6.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;

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
        init();
        validateSubtracting(binding.etOper1.getText().toString(), binding.etOper2.getText().toString());
    }

    private void init() {
        binding.btnAdd.setOnClickListener(v -> {
            int oper1 = Integer.parseInt(binding.etOper1.getText().toString());
            int oper2 = Integer.parseInt(binding.etOper2.getText().toString());
            binding.tvResult.setText(String.valueOf(math.add(oper1, oper2)));
        });

        binding.btnMinus.setOnClickListener(v -> {
            int oper1 = Integer.parseInt(binding.etOper1.getText().toString());
            int oper2 = Integer.parseInt(binding.etOper2.getText().toString());
            binding.tvResult.setText(String.valueOf(math.minus(oper1, oper2)));
        });
        binding.btnMultiplication.setOnClickListener(view -> {
            int oper1 = Integer.parseInt(binding.etOper1.getText().toString());
            int oper2 = Integer.parseInt(binding.etOper2.getText().toString());
            binding.tvResult.setText(String.valueOf(math.multiplication(oper1, oper2)));
        });
        binding.btnDivision.setOnClickListener(view -> {
            int oper1 = Integer.parseInt(binding.etOper1.getText().toString());
            int oper2 = Integer.parseInt(binding.etOper2.getText().toString());
            binding.tvResult.setText(String.valueOf(math.division(oper1, oper2)));
        });
    }

    public void validateSubtracting(String first, String second) {
        Integer num1;
        Integer num2;
        if (!first.isEmpty() && !second.isEmpty()) {
            if (TextUtils.isDigitsOnly(first) && TextUtils.isDigitsOnly(second)) {
                num1 = Integer.parseInt(first);
                num2 = Integer.parseInt(second);
                if (num1 > 0 && num2 > 0)
                    binding.tvResult.setText(String.valueOf(math.subtractFunction(num1, num2)));
                else binding.tvResult.setText("нельзя делить на 0");
            } else {
                binding.tvResult.setText("пожалуйста, предоставьте действительный ввод");
            }
        } else {
            binding.tvResult.setText("поле не может быть пустым");
        }
    }
}