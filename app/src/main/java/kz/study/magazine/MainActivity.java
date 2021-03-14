package kz.study.magazine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.contentcapture.ContentCaptureContext;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tandaupan,baspa;
    RadioButton gumanitarlyk,jaratylystanu,bank,kolma_kol;
    CheckBox meken_jai,surprise;
    Button jiberu;
    String tolem, jetkizu, bagyttar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tandaupan = findViewById(R.id.tandaupan);
        baspa = findViewById(R.id.baspa);

        gumanitarlyk = findViewById(R.id.gumanitarlyk);
        jaratylystanu = findViewById(R.id.jaratylystanu);
        bank = findViewById(R.id.bank);
        kolma_kol = findViewById(R.id.kolma_kol);

        meken_jai = findViewById(R.id.meken_jai);
        surprise = findViewById(R.id.surprise);

        jiberu = findViewById(R.id.jiberu);

        registerForContextMenu(tandaupan);
        registerForContextMenu(baspa);

        jiberu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bank.isChecked()){
                    tolem = "Банк карточкасы арқылы";
                } else if(kolma_kol.isChecked()){
                    tolem = "Қолма қол арқылы";
                }

                if(gumanitarlyk.isChecked()){
                    bagyttar = "Гуманитарлық";
                } else if(jaratylystanu.isChecked()){
                    bagyttar = "Жаратылыстану";
                }

                if(meken_jai.isChecked()){
                    jetkizu = "Мекен-жайға жеткізу";
                }
                if(surprise.isChecked()){
                    jetkizu = "Сыйлық ретінде";
                }
                String result = "Таңдау пән: " + tandaupan.getText()+ "\n"+
                        "Баспа түрі: " + baspa.getText()+"\n"+
                        "Төлем түрі: " + tolem+"\n"+
                        "Оқу бағыты: " + bagyttar+"\n"+
                        "Жеткізу түрі: " + jetkizu;
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
       if(v == tandaupan) {
           MenuInflater menuInflater = getMenuInflater();
           menuInflater.inflate(R.menu.oku_menu, menu);
       }
       if(v==baspa) {
           MenuInflater menuInflater = getMenuInflater();
           menuInflater.inflate(R.menu.baspa, menu);
       }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override

    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.fizika:
                tandaupan.setText("физика-математика");
                break;
            case R.id.biology:
                tandaupan.setText("биология-химия");
                break;
            case R.id.english:
                tandaupan.setText("ағылшын тілі-дүние жүзі тарихы");
                break;
            case R.id.kazakh:
                tandaupan.setText("қазақ тілі-қазақ әдебиеті");
                break;
            case R.id.shyn:
                baspa.setText("Шың");
                break;
            case R.id.talapker:
                baspa.setText("Талапкер");
                break;
            case R.id.sanzhar:
                baspa.setText("Санжар");
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_setting:
                Toast.makeText(this, "Setting menu basildi", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_save:
                Toast.makeText(this, "Save menu basildi", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_cut:
                Toast.makeText(this, "Cut menu basildi", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_exit:
                Toast.makeText(this, "Exit menu basildi", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}