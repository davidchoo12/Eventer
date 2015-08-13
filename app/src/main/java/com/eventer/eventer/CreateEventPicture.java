/**
 * Create New Event, Add Picture screen
 */
package com.eventer.eventer;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;

public class CreateEventPicture extends AppCompatActivity {
    public static final int PICK_IMAGE = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_event_picture);


        ImageButton galleryBtn = (ImageButton) findViewById(R.id.gallery_button);
        galleryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");

                Intent chooserIntent = Intent.createChooser(pickIntent, "Select Image");

                startActivityForResult(chooserIntent, PICK_IMAGE);
            }
        });
        ((Button)findViewById(R.id.next_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CreateEventInvMembers.class);
                startActivity(i);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                //Display an error
                return;
            }
            try {
                Context context = getApplicationContext();
                InputStream is = context.getContentResolver().openInputStream(data.getData());
                Bitmap bm = BitmapFactory.decodeStream(is);
                ((ImageView)findViewById(R.id.add_event_img_ph)).setImageBitmap(bm);
                (findViewById(R.id.next_btn)).setVisibility(View.VISIBLE);
                (findViewById(R.id.image_selector_buttons)).setVisibility(View.INVISIBLE);
            } catch(Exception e) {
                Toast.makeText(this, "Image not found", Toast.LENGTH_SHORT);
            }
        }
    }
}
