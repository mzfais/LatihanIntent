package id.ac.itn.latihanintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE = 100;
    private Button btnPindah, btnPindahData, btnPindahObject, btnDial,btnResult;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPindah = findViewById(R.id.btnPindah);
        btnPindahData = findViewById(R.id.btnPindahData);
        btnPindahObject = findViewById(R.id.btnPindahObject);
        btnDial = findViewById(R.id.btnDial);
        btnResult = findViewById(R.id.btnPindahResult);
        btnPindah.setOnClickListener(this);
        btnPindahData.setOnClickListener(this);
        btnPindahObject.setOnClickListener(this);
        btnDial.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        tvHasil=findViewById(R.id.tvHasil);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPindah:
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.btnPindahData:
                Intent dataIntent = new Intent(MainActivity.this, Main3Activity.class);
                dataIntent.putExtra(Main3Activity.XTRA_NAME, "Ahmad Faisol");
                dataIntent.putExtra(Main3Activity.XTRA_AGE, 35);
                startActivity(dataIntent);
                break;
            case R.id.btnPindahObject:
                Mahasiswa mhs = new Mahasiswa();
                mhs.setNim("1718001");
                mhs.setNama("Ahmad Muzakki Syah");
                mhs.setFakultas("Fakultas Teknologi Industri");
                mhs.setProdi("Teknik Informatika S1");

                Intent objectIntent = new Intent(MainActivity.this, ObjectActivity.class);

                // kirim objek yang sudah parcelable
                objectIntent.putExtra(ObjectActivity.XTRA_MHS, mhs);
                startActivity(objectIntent);
                break;
            case R.id.btnDial:
                String noHp = "082213077772";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + noHp));
                startActivity(dialPhoneIntent);

                /*
                Variabel ACTION_DIAL menentukan intent filter dari aplikasi-aplikasi yang bisa
                menangani action tersebut. Di sini aplikasi yang memiliki kemampuan untuk komunikasi
                akan muncul pada opsi pilihan, sebagaimana ditampilkan ke pengguna.
                Selain ACTION_DIAL, di Android sudah tersedia berbagai action yang tinggal didefinisikan
                sewaktu menciptakan obyek Intent untuk mengakomodir berbagai tujuan.
                cek link: https://developer.android.com/reference/android/content/Intent.html
                https://developer.android.com/guide/components/intents-common.html
                 */

                break;
            case R.id.btnPindahResult:
                Intent resultIntent = new Intent(MainActivity.this, ResultActivity.class);
                startActivityForResult(resultIntent, REQUEST_CODE);
                break;
                // cek link https://developer.android.com/training/basics/intents/result.html
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == ResultActivity.RESULT_CODE) {
                int resultNumber = data.getIntExtra(ResultActivity.RESULT_NUMBER, 0);
                tvHasil.setText(String.format("Hasil : %s", resultNumber));
            }
        }
    }
}
