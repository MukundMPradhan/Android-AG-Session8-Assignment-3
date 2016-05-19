package com.acadgild.session8.assignment3;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.speech.tts.Voice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button startButton;

    ProgressBar pb1, pb2, pb3, pb4;

    AsyncTaskPBar asyncTaskPBar1, asyncTaskPBar2, asyncTaskPBar3, asyncTaskPBar4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.button);
        pb1 = (ProgressBar) findViewById(R.id.pBar1);
        pb2 = (ProgressBar) findViewById(R.id.pBar2);
        pb3 = (ProgressBar) findViewById(R.id.pBar3);
        pb4 = (ProgressBar) findViewById(R.id.pBar4);

        startButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        asyncTaskPBar1 = new AsyncTaskPBar(pb1);
        // asyncTaskPBar1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        asyncTaskPBar1.execute();

        asyncTaskPBar2 = new AsyncTaskPBar(pb2);
        asyncTaskPBar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        //asyncTaskPBar2.execute();

        asyncTaskPBar3 = new AsyncTaskPBar(pb3);
        asyncTaskPBar3.execute();

        asyncTaskPBar4 = new AsyncTaskPBar(pb4);
        asyncTaskPBar4.execute();
       // asyncTaskPBar4.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);

    }

}

class AsyncTaskPBar extends AsyncTask<Void, Integer, Void> {
    ProgressBar myProgressBar;

    public AsyncTaskPBar(ProgressBar myProgressBar) {
        this.myProgressBar = myProgressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params) {
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(100);
                publishProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        myProgressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

    }


}
