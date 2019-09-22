package id.ac.itn.latihanintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPindah,btnPindahData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPindah = findViewById(R.id.btnPindah);
        btnPindahData = findViewById(R.id.btnPindahData);
        btnPindah.setOnClickListener(this);
        btnPindahData.setOnClickListener(this);
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
                dataIntent.putExtra(Main3Activity.XTRA_NAME,"Ahmad Faisol");
                dataIntent.putExtra(Main3Activity.XTRA_AGE,35);
                startActivity(dataIntent);
                break;
        }
    }
}
