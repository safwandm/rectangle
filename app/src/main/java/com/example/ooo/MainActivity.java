package com.example.ooo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtpanjang;
    EditText edtlebar;
    EditText edttinggi;
    Button btnhitung;
    TextView tvhasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtpanjang = findViewById(R.id.edt_panjang);
        edtlebar = findViewById(R.id.edt_lebar);
        edttinggi = findViewById(R.id.edt_tinggi);
        btnhitung = findViewById(R.id.btn_hitung);
        tvhasil = findViewById(R.id.tv_hasil);

        btnhitung.setOnClickListener(this);
    }

    @Override
    public void onClick(View V) {
        if (V.getId() == R.id.btn_hitung) {
            String inputpanjang = edtpanjang.getText().toString().trim();
            String inputlebar = edtlebar.getText().toString().trim();
            String inputtinggi = edttinggi.getText().toString().trim();

            boolean isemptyfields = false;
            boolean isinvalidDouble = false;

            if (TextUtils.isEmpty(inputpanjang)) {
                isemptyfields = true;
                edtpanjang.setError("data_tidak_boleh_kosong");
            }

            if (TextUtils.isEmpty(inputlebar)) {
                isemptyfields = true;
                edtlebar.setError("data_tidak_boleh_kosong");
            }

            if (TextUtils.isEmpty(inputtinggi)) {
                isemptyfields = true;
                edttinggi.setError("data_tidak_boleh_kosong");
            }

            Double panjang = toDouble(inputpanjang);
            Double lebar = toDouble(inputlebar);
            Double tinggi = toDouble(inputtinggi);

            if (panjang == null) {
                isinvalidDouble = true;
                edtpanjang.setError("angka_harus_berupa_nomor_yang_valid");
            }

            if (lebar == null) {
                isinvalidDouble = true;
                edtlebar.setError("angka_harus_berupa_nomor_yang_valid");
            }

            if (tinggi == null) {
                isinvalidDouble = true;
                edttinggi.setError("angka_harus_berupa_nomor_yang_valid");
            }

            if (!isemptyfields && !isinvalidDouble) {
                Double volume = panjang * lebar * tinggi;

                tvhasil.setText(String.valueOf(volume));


            }


        }


        }

    private Double toDouble(String inputpanjang) {
        try {
            return Double.valueOf(inputpanjang);
        }catch (NumberFormatException e){
            return null;
        }

    }
}