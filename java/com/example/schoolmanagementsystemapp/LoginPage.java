package com.example.schoolmanagementsystemapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoginPage extends AppCompatActivity {
    CircleImageView galleryImage, cameraImage, defaultImage;
    EditText eName,eRegNo,ePassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        eName=findViewById(R.id.nameFld);
        eRegNo=findViewById(R.id.regFld);
        ePassword=findViewById(R.id.passwordFld);
    }


// after 1 sec it lands to Navigation page
    public void login(View view) {
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(LoginPage.this, NavigationDrawerPage.class);
                startActivity(i);
                finish();
//                checkLogin();
            }
        }, 1000);
    }
    // checking the details filled or not
    public void checkLogin(){
        String nFld;
        String regFld;
        String passFld;
        // accessing the login database
        LoginSQLiteDatabase loginDb= new LoginSQLiteDatabase(this);
        nFld=eName.getText().toString().toString();
        regFld=eRegNo.getText().toString();
        passFld=ePassword.getText().toString();
        //checking whether filled or empty or not
//        nFld.matches("^[a-zA-z]*")
        if (nFld.isEmpty()|nFld.length()==0 |regFld.isEmpty()|passFld.isEmpty() |passFld.length()<8 ){
            Toast.makeText(this,"Please Fill Valid the Details",Toast.LENGTH_SHORT).show();
        }
        else{
//            String rowDetails=loginDb.addToLoginTable(nFld,regFld,passFld);
//            Toast.makeText(LoginPage.this, rowDetails + " "+" Login Successfully !", Toast.LENGTH_SHORT).show();
//            eName.setText("");
//            eRegNo.setText("");
//            ePassword.setText("");
            Intent i = new Intent(LoginPage.this, NavigationDrawerPage.class);
            startActivity(i);
            finish();
        }
    }
// got to sign activity
    public void goToSingPage(View view) {
        Toast.makeText(LoginPage.this, "You Can SingIn Here !", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(LoginPage.this, SignInPage.class);
        startActivity(i);
        finish();
    }

// click listener on  profileImage
    public void loginInImage(View view) {
        defaultImage = findViewById(R.id.chooseProfileImage);
        selectImages();
    }

    public void selectImages() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Choose the Image ...");

        View dialogView = getLayoutInflater().inflate(R.layout.select_camera_gallery_image, null);
//        referencing images of custom layout of image
        galleryImage = dialogView.findViewById(R.id.selectImageFromGallery);
        cameraImage = dialogView.findViewById(R.id.selectImageFromCamera);
        builder.setView(dialogView);
        builder.setCancelable(false);
//        showing the dialog with camera and gallery image
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        //        click listener on gallery and camera image
        galleryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectGalleryImage();
                alertDialog.cancel();

            }
        });
        //        click listener on gallery and camera image
        cameraImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                new request code for camera image
//                takeImageFromCamera();
                alertDialog.cancel();
            }
        });

    }
//method to select image from gallery
    public void selectGalleryImage() {
        Intent intent1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent1, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Uri imageUri = data.getData();
                    defaultImage.setImageURI(imageUri);

                }
                break;
//            case 2:
//                if (resultCode == RESULT_OK) {
//                    Bundle bundle = data.getExtras();
//                    Bitmap bitmap = (Bitmap) bundle.get("data");
//                    defaultImage.setImageBitmap(bitmap);
//                }
//                break;
            default:
        }
    }

//    public void takeImageFromCamera() {
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//
//            startActivityForResult(intent, 2);
//        }


//    }

}