package com.example.laptopazvn.ontapphan2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    float fthamso1, fthamso2;
    String stoantu, xuatmanhinh = "";
    EditText edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] idButton = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
                R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btncham,
                R.id.btncong, R.id.btntru, R.id.btnnhan, R.id.btnchia, R.id.btnbang};

        edtText = findViewById(R.id.editTextHienThi);


        for (int id : idButton) {
            View v = findViewById(id);
            v.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btncong:
                stoantu = "+";
                ToanTu();
                //check
                //Log.d("ketqua", "Kiem tra tham so " + fthamso1);
                break;
            case R.id.btntru:
                stoantu = "-";
                ToanTu();
                break;
            case R.id.btnnhan:
                stoantu = "*";
                ToanTu();
                break;
            case R.id.btnchia:
                stoantu = "/";
                ToanTu();
                break;
            case R.id.btnbang:
                //stoantu = "=";
                float ketqua = 0;
                fthamso2 = Float.parseFloat(edtText.getText().toString());
                if (stoantu.equals("+")) {
                     ketqua = fthamso1 + fthamso2;
                    //Log.d("ketqua", "dapso:" + ketqua);
                }
                if (stoantu.equals("*")) {
                    ketqua = fthamso1 * fthamso2;
                    //Log.d("ketqua", "dapso:" + ketqua);
                }
                if (stoantu.equals("-")) {
                    ketqua = fthamso1 - fthamso2;
                    //Log.d("ketqua", "dapso:" + ketqua);
                }
                if (stoantu.equals("/")) {
                    ketqua = fthamso1 / fthamso2;
                    //Log.d("ketqua", "dapso:" + ketqua);
                }
                edtText.setText(String.valueOf(ketqua));
                fthamso1 = 0.0f;
                fthamso2 = 0.0f;
                xuatmanhinh = "0";
                break;

            default:
                if (xuatmanhinh.equals("0")) {
                    xuatmanhinh = "";
                }
                xuatmanhinh += ((Button) v).getText().toString();

                edtText.setText(xuatmanhinh);
        }
    }

    private void ToanTu() {
        fthamso1 = Float.parseFloat(edtText.getText().toString());
        xuatmanhinh = "0";
        edtText.setText("0");
    }
}
