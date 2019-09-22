package id.ac.itn.latihanintent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity {

    public static final String XTRA_NAME = "xtra_name";
    public static final String XTRA_AGE = "xtra_age";
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvHasil=findViewById(R.id.textView);
        String nama = getIntent().getStringExtra(XTRA_NAME);
        int umur = getIntent().getIntExtra(XTRA_AGE,0);
        tvHasil.setText("Nama: " + nama + "\nUmur: " + umur + " Tahun");
    }
}
