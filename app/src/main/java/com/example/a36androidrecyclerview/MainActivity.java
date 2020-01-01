package com.example.a36androidrecyclerview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView, recyclerView1;
    ArrayList<MonAn> arrayList, arrayList1;
    MonAnAdapter adapter, adapter1;
    EditText editText1;
    Button button1;
    int viTri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewMonan);
        recyclerView1 = findViewById(R.id.recyclerViewMonan1);
        recyclerView1.setHasFixedSize(true);
        recyclerView.setHasFixedSize(true);
        editText1 = findViewById(R.id.editTextNoiDung);
        button1 = findViewById(R.id.butTonCapNhat);

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager1 =new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(linearLayoutManager1);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.HORIZONTAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(recyclerView1.getContext(), DividerItemDecoration.HORIZONTAL);
        Drawable drawable1 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider);
        dividerItemDecoration1.setDrawable(drawable1);
        recyclerView1.addItemDecoration(dividerItemDecoration1);



        DividerItemDecoration dividerItemDecoration3 = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        Drawable drawable3 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider1);
        dividerItemDecoration3.setDrawable(drawable3);
        recyclerView.addItemDecoration(dividerItemDecoration3);

        DividerItemDecoration dividerItemDecoration2 = new DividerItemDecoration(recyclerView1.getContext(), DividerItemDecoration.VERTICAL);
        Drawable drawable2 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider1);
        dividerItemDecoration2.setDrawable(drawable2);
        recyclerView1.addItemDecoration(dividerItemDecoration2);





        arrayList = MonAn.mock();
        adapter = new MonAnAdapter(arrayList);
        arrayList1 = MonAn.mock();
        adapter1 = new MonAnAdapter(arrayList1);
        recyclerView.setAdapter(adapter);
        recyclerView1.setAdapter(adapter1);

        // xét sự kiện click có tác dụng gì
        adapter.setOnListener(new OnListener()
        {
            @Override
            public void onClick(int position)
            {
//                arrayList.remove(position);
//                adapter.notifyItemRemoved(position);
                // hoặc dùng adapter.notifyDataSetChanged();


                // đưa dữ liệu lên edittext
                editText1.setText(arrayList.get(position).getTenMonan());
                viTri =position;
                xacNhanXoa(position);
            }
        });
        adapter1.setOnListener(new OnListener()
        {
            @Override
            public void onClick(int position)
            {
                editText1.setText(arrayList1.get(position).getTenMonan());
                viTri =position;
                xacNhanXoa(position);
            }
        });
    }

    private void xacNhanXoa(final int position)
    {
        AlertDialog.Builder alertDiaLog = new AlertDialog.Builder(MainActivity.this);
        alertDiaLog.setTitle("Thông Báo!");
        alertDiaLog.setIcon(R.mipmap.ic_launcher);
        alertDiaLog.setMessage("Bạn Chắc Chắn Muốn Xóa");
        alertDiaLog.setPositiveButton("Có", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                arrayList.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });
        alertDiaLog.setNegativeButton("Không", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

            }
        });
        alertDiaLog.show();
    }
}
