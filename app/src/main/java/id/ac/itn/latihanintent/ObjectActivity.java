package id.ac.itn.latihanintent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ObjectActivity extends AppCompatActivity {

    public static final String XTRA_MHS = "mhs";
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvHasil=findViewById(R.id.textView);

        // Parcelable adalah suatu interface yang memungkinkan kita melakukan pengiriman objek dari suatu Activity ke Activity lain
        Mahasiswa mhs = getIntent().getParcelableExtra(XTRA_MHS);
        tvHasil.setText("NIM: "+mhs.getNim() + "\nNama: "
                + mhs.getNama() + "\nProdi: "
                + mhs.getProdi() + "\nFakultas:" + mhs.getFakultas());
    }
}
