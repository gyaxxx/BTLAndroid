//package com.example.btlandroid;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.Dialog;
//import android.content.Intent;
//import android.database.Cursor;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.Button;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import com.example.btlandroid.adapter.AdapterTruyen;
//import com.example.btlandroid.database.databaseDocTruyen;
//import com.example.btlandroid.model.Truyen;
//
//import java.util.ArrayList;
//
//public class ManAdmin extends AppCompatActivity {
//    Button button;
//    ListView listView;
//    ArrayList<Truyen> truyenArrayList;
//    AdapterTruyen adapterTruyen;
//    databaseDocTruyen databaseDocTruyen;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_man_admin);
//
//        button = findViewById(R.id.btnThemTruyen);
//        listView = findViewById(R.id.listviewAdmin);
//        initList();
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ManAdmin.this, ManDangBai.class);
//                startActivity(intent);
//            }
//        });
//
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                DialogXoa(position);
//                return false;
//            }
//        });
//    }
//
//    private void initList() {
//        truyenArrayList = new ArrayList<>();
//        databaseDocTruyen = new databaseDocTruyen(this);
//        Cursor cursor = databaseDocTruyen.getData2();
//
//        while (cursor.moveToNext()) {
//            int id = cursor.getInt(0);
//            String tenTruyen = cursor.getString(1);
//            String noiDung = cursor.getString(2);
//            String anh = cursor.getString(3);
//            int id_tk = cursor.getInt(4);
//
//            truyenArrayList.add(new Truyen(id, tenTruyen, noiDung, anh, id_tk));
//
//            adapterTruyen = new AdapterTruyen(getApplicationContext(), truyenArrayList);
//            listView.setAdapter(adapterTruyen);
//        }
//
//        cursor.moveToFirst();
//        cursor.close();
//    }
//
//    private void DialogXoa(int position) {
//        Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.dialog);
//        dialog.setCanceledOnTouchOutside(false);
//
//        Button yesBtn = findViewById(R.id.btnyes);
//        Button noBtn = findViewById(R.id.btnno);
//
//        yesBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int idTruyen = truyenArrayList.get(position).getID();
//                databaseDocTruyen.Delete(idTruyen);
//
//                Intent intent = new Intent(ManAdmin.this, ManAdmin.class);
//                finish();
//                startActivity(intent);
//                Toast.makeText(ManAdmin.this, "Xóa truyện thành công!", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        noBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.cancel();
//            }
//        });
//
//        dialog.show();
//    }
//}