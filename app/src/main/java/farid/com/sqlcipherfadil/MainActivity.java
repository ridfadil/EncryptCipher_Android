package farid.com.sqlcipherfadil;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.sqlcipher.database.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {

    EditText txtNama;
    EditText txtNim;
    EditText txtAlamat;
    Button btnSubmit;
    DBHelper dbHelper;
    String nama, nim, alamat;
    boolean isSave;
    private static final int PERMISSION_APP = 124;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        SQLiteDatabase.loadLibs(this);
        checkPermission();
        dbHelper = new DBHelper(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = txtNama.getText().toString();
                nim = txtNim.getText().toString();
                alamat = txtAlamat.getText().toString();
                isSave = dbHelper.addParticipant(nama, nim, alamat);
                if (isSave) {
                    Toast.makeText(MainActivity.this, "Berhasil menyimpan data", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Gagal menyimpan data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @SuppressLint("InlinedApi")
    private void checkPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.INTERNET
                },
                PERMISSION_APP);
    }

    public void init(){
        txtNama = findViewById(R.id.txt_nama);
        txtNim = findViewById(R.id.txt_nim);
        txtAlamat = findViewById(R.id.txt_alamat);
        btnSubmit = findViewById(R.id.btn_submit);
    }
}
