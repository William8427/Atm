package com.tuner.navi.atm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final int LOGIN = 88;
    private static final String TAG = MainActivity.class.getSimpleName();
    private Intent intent;
    int[] icons = {R.drawable.func_balance,
            R.drawable.func_history,
            R.drawable.func_news,
            R.drawable.func_finance,
            R.drawable.func_exit};
    private String[] func;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, loginActivity.class);
        startActivityForResult(intent, LOGIN);
        func = getResources().getStringArray(R.array.fnuction);
        GridView gridView = findViewById(R.id.gridview);
        iconAdapter iconAdapter = new iconAdapter();
        gridView.setAdapter(iconAdapter);
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long itemId) {
        switch ((int) itemId)
        {
            case R.drawable.func_balance:
                break;
            case R.drawable.func_history:
                break;
            case R.drawable.func_news:
                break;
            case R.drawable.func_finance:
                startActivity(new Intent(this, FinanceActivity.class));
                break;
            case R.drawable.func_exit:
                finish();
                break;
        }
    }

    class iconAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return func.length;
        }

        @Override
        public Object getItem(int position) { return func[position]; }

        @Override
        public long getItemId(int position) { return icons[position]; }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            View row = view;
            if (row == null)
            {
                row = getLayoutInflater().inflate(R.layout.icon, null);
                ImageView imageView = row.findViewById(R.id.iv_icon);
                TextView textView = row.findViewById(R.id.tv_title);
                imageView.setImageResource(icons[position]);
                textView.setText(func[position]);
            }
            return row;
        }
    }
}
