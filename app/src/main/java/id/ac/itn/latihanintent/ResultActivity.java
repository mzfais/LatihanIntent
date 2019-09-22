package id.ac.itn.latihanintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {

    public static final String RESULT_NUMBER = "100";
    public static final int RESULT_CODE = 110;
    EditText etAngka;
    Button btnKirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        etAngka=findViewById(R.id.editText);
        btnKirim=findViewById(R.id.button);
        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(RESULT_NUMBER,Integer.parseInt(etAngka.getText().toString()));
                setResult(RESULT_CODE,resultIntent);
                finish();
            }
        });
    }
}
