package com.our.bluetoothaddapetdemmo1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
   private BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();

    }
    @SuppressLint("MissingPermission")
    public void onClick(View view){
        if (view.getId()== R.id.btnon){
            Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent,1);
            Toast.makeText(getApplicationContext(),"Bluetooth is ON successully",Toast.LENGTH_LONG).show();
        }
        else if(view.getId()== R.id.btnoff){

            bluetoothAdapter.disable();
            Toast.makeText(getApplicationContext(),"Bluetooth is OFF successully",Toast.LENGTH_LONG).show();

        }
        else if(view.getId()== R.id.btnvisible){
            Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            startActivityForResult(intent,1);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}