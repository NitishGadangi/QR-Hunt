package com.nitish.qrhuntorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class qrgenerated extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    TextView tv_hashed,tv_clue;
    ImageView img_qr;
    String rawInfo;
    String hash_str,str_clue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_qrgenerated);

        tv_hashed=findViewById(R.id.tv_hashed);
        img_qr=findViewById(R.id.img_qr);
        tv_clue=findViewById(R.id.tv_clue);

        Intent intent=getIntent();

        rawInfo=intent.getStringExtra("RAW_INFO");
        str_clue=intent.getStringExtra("CLUE");

        hash_str=AES.encrypt(rawInfo);
        tv_hashed.setText(rawInfo+hash_str);
        tv_clue.setText(str_clue);

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(hash_str, BarcodeFormat.QR_CODE,300,300);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            img_qr.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }
}
