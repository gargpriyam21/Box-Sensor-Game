package com.example.neera.textboxsensorgame;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "SENSOR";

    public static int x;
    public static int y;
    SensorManager sensorManager;
    Sensor accelSensor;
    ImageView ivBox;
    SensorEventListener sensorEventListener;

    @Override
    protected void onResume() {
        sensorManager.registerListener(sensorEventListener, accelSensor, 1000 * 1000);
        super.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        sensorManager.unregisterListener(sensorEventListener);
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivBox = (ImageView) findViewById(R.id.ivBox);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        accelSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

                    x -= (float) sensorEvent.values[0];
                    y += (float) sensorEvent.values[1];

                    ivBox.setX(x);
                    ivBox.setY(y);
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

    }
}
