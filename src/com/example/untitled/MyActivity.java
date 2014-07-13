package com.example.untitled;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.VideoView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final VideoView mediaView = (VideoView)findViewById(R.id.videoView);
        final EditText URLText = (EditText)findViewById(R.id.URLText);

        //set up media controller in order to have control of video
        final MediaController mediaControl = new MediaController(this);

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get text from EditText
                String mediaURL = URLText.getText().toString() ;
                //debug display URL information in log
                Log.i("URLText:",mediaURL);
                //parse url
                Uri vidUri = Uri.parse(mediaURL);
                mediaControl.setAnchorView(mediaView);

                mediaView.setVideoURI(vidUri);
                mediaView.setMediaController(mediaControl);
                mediaView.start();
            }
        });
    }
}
