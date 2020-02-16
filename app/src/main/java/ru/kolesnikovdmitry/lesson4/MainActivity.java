package ru.kolesnikovdmitry.lesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickMainActivity(View view) {
        switch (view.getId()) {
            case R.id.buttonUsualToastLong:
                Toast toastLong = Toast.makeText(getApplicationContext(), "long", Toast.LENGTH_LONG);
                toastLong.show();
                break;
            case R.id.buttonUsualToastShort:
                Toast toastShort = Toast.makeText(getApplicationContext(), "short", Toast.LENGTH_SHORT);
                toastShort.show();
                break;
            case R.id.buttonCenterToast:
                Toast toastCenter = Toast.makeText(getApplicationContext(), "center", Toast.LENGTH_SHORT);
                toastCenter.setGravity(Gravity.CENTER, 0, 0);
                toastCenter.show();
                break;
            case R.id.buttonWithPictureToast:
                Toast toastWithPicture = Toast.makeText(getApplicationContext(), "lol kek", Toast.LENGTH_SHORT);
                toastWithPicture.setGravity(Gravity.CENTER, 0, 0);
                LinearLayout toastContainer =(LinearLayout) toastWithPicture.getView();
                ImageView imageViewToastWithPicture = new ImageView(getApplicationContext());
                TextView textViewToast              = new TextView(getApplicationContext());
                imageViewToastWithPicture.setImageResource(R.drawable.cat);
                textViewToast.setText("hjhjkhjkljhkhjhkjhkjhjkhkjhjkhkjhjkhkjhkjhkjhhkjhkjh");
                textViewToast.setGravity(Gravity.CENTER);
                toastContainer.addView(imageViewToastWithPicture, 1000, 500);
                toastContainer.addView(textViewToast, 1000, ViewGroup.LayoutParams.WRAP_CONTENT);
                toastWithPicture.show();
                break;
            case R.id.buttonWithPictureToastTransparent:
                Toast toastWithPictureTransparent = Toast.makeText(getApplicationContext(), "Picture", Toast.LENGTH_SHORT);
                toastWithPictureTransparent.setGravity(Gravity.CENTER, 0, 0);
                LinearLayout toastContainerTransparent         =(LinearLayout) toastWithPictureTransparent.getView();
                ImageView imageViewToastWithPictureTransparent = new ImageView(getApplicationContext());
                imageViewToastWithPictureTransparent.setImageResource(R.drawable.cat);
                toastContainerTransparent.addView(imageViewToastWithPictureTransparent, 1000, 500);
                toastContainerTransparent.setBackgroundColor(Color.TRANSPARENT);    //прозрачный тост
                toastWithPictureTransparent.show();
                break;
            case R.id.buttonOwnToast:
                Toast toastOwn = new Toast(getApplicationContext());
                toastOwn.setDuration(Toast.LENGTH_SHORT);
                toastOwn.setGravity(Gravity.CENTER, 0, 100);
                LayoutInflater layoutInflater = getLayoutInflater();
                View lay = layoutInflater.inflate(R.layout.toast_lay_1, (ViewGroup) findViewById(R.id.LinearLayoutToast1));
                toastOwn.setView(lay);
                toastOwn.show();
                break;
            default:
                break;
        }
    }
}
