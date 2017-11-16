package com.tuner.navi.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    private EditText edUserName;
    private EditText edPassWord;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUserName = findViewById(R.id.ed_name);
        edPassWord = findViewById(R.id.ed_pass);
        checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                getSharedPreferences("flash", MODE_PRIVATE)
                        .edit()
                        .putBoolean("Remember", b)
                        .apply();
            }
        });
        boolean checkbox = getSharedPreferences("flash", MODE_PRIVATE)
                .getBoolean("Remember", false);
        if (checkbox)
        {
            String userid = getSharedPreferences("flash", MODE_PRIVATE)
                    .getString("username", null);
            edUserName.setText(userid);
            checkBox.setChecked(checkbox);
        }
        else
        {
            getSharedPreferences("flash", MODE_PRIVATE)
                    .edit()
                    .putString("username", null)
                    .apply();
        }
    }

    public void login(View view)
    {
        String username = edUserName.getText().toString();
        String password = edPassWord.getText().toString();
        if (username.equals("william") && password.equals("8888"))
        {
            getIntent().putExtra("username", username);
            getSharedPreferences("flash", MODE_PRIVATE)
                    .edit()
                    .putString("username", username)
                    .apply();
            setResult(RESULT_OK, getIntent());
            finish();
        }
    }
    public void quit(View view)
    {
        finish();
    }
}
