package com.sd.kappan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.content.Intent.ACTION_CALL;

public class ChildHelpline extends AppCompatActivity {

    Button otherser;
    Button childaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_helpline);

        final MediaPlayer childhelp = MediaPlayer.create(ChildHelpline.this,R.raw.childrenhelpline);

        Button childaction = (Button) findViewById(R.id.childaction);
        childaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent child = new Intent(ACTION_CALL);
                child.setData(Uri.parse("tel:1098"));
                startActivity(child);
                childhelp.start();

                Toast.makeText(ChildHelpline.this,"Calling ChildHelpLine",Toast.LENGTH_LONG).show();
            }
        });

        Button otherser = (Button) findViewById(R.id.otherserv);
        otherser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oser = new Intent(ChildHelpline.this,Menu.class);
                startActivity(oser);
            }
        });
    }
}
