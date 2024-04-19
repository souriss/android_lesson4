package ru.mirea.lednevadd.looper;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;

import ru.mirea.lednevadd.looper.databinding.ActivityMainBinding;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MyLooper MyLooper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Handler mainThreadHandler =	new	Handler(Looper.getMainLooper())	{
            @Override
            public void handleMessage(Message msg){
                Log.d(MainActivity.class.getSimpleName(), "Task execute. This	is	result:	" +	msg.getData().getString("result"));
            }
        };
        MyLooper =	new MyLooper(mainThreadHandler);
        MyLooper.start();


        binding.editTextMirea.setText("Мой номер по списку №13");
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message	msg	=	Message.obtain();
                Bundle	bundle	= new Bundle();
                bundle.putString("KEY",	binding.age.getText().toString() + " лет/год(а). Профессия: " + binding.work.getText().toString());
                msg.setData(bundle);
                MyLooper.mHandler.sendMessage(msg);
            }
        });
    }
}