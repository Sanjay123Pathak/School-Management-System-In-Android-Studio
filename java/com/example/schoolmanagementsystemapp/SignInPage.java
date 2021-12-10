package com.example.schoolmanagementsystemapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignInPage extends AppCompatActivity {
CircleImageView circleImageView,galleryImage, cameraImage;
EditText name,email,password,dob,address;
RadioGroup rGrp;
RadioButton chooseGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);
        name=findViewById(R.id.sgInName);
        email=findViewById(R.id.sgInEmail);
        password=findViewById(R.id.sgInPassword);
        dob=findViewById(R.id.sgInDob);
        address=findViewById(R.id.sgInAddress);
        rGrp=findViewById(R.id.radioGroup);

    }



    //    ************************************************************
//    it lands us to navigation page
    public void signIn(View view) {
        FillSignInDetails();

    }
    public void FillSignInDetails(){
        String sName,sEmail,sPass,sDob,sAddress;
//        String emailPattern=  "^[_A-Za-z0-9-]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";
//        (sEmail.matches(emailPattern))
        int selectedGender;
        SignInDatabase signInDb= new SignInDatabase(this);
        selectedGender=rGrp.getCheckedRadioButtonId();
        chooseGender=findViewById(selectedGender);
        sName=name.getText().toString();
        sEmail=email.getText().toString();
        sPass=password.getText().toString();
        sDob=dob.getText().toString();
        sAddress=address.getText().toString();
        if (sName.isEmpty()|sEmail.isEmpty()|sPass.isEmpty()|sDob.isEmpty()|sAddress.isEmpty()){
            Toast.makeText(this, "Field should not be empty !..", Toast.LENGTH_SHORT).show();
        }
        else {
            signInDb.addToSignInTable(sName,sEmail,sPass,sDob,sAddress,chooseGender.getText().toString());
            Toast.makeText(this, "SingIn Successfully", Toast.LENGTH_SHORT).show();
            name.setText("");
            email.setText("");
            password.setText("");
            dob.setText("");
            address.setText("");
            Intent i = new Intent(SignInPage.this,NavigationDrawerPage.class);
            startActivity(i);
            finish();
        }
    }
//    it lands us to login page

    public void goToLoginPage(View view) {
        Intent i = new Intent(SignInPage.this,LoginPage.class);
        startActivity(i);
        finish();
    }

    public  void chooseImages(View v){
        circleImageView =findViewById(R.id.signInProfileImage);
        selectImages();
    }
//    **********************************************************
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
    cameraImage.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                new request code for camera image
//            takeImageFromCamera();
            alertDialog.cancel();
        }
    });

}

//    ***********************************************************


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
                    circleImageView.setImageURI(imageUri);

                }
                break;
//            case 2:
//                if (resultCode == RESULT_OK) {
//                    Bundle bundle = data.getExtras();
//                    Bitmap bitmap = (Bitmap) bundle.get("data");
//                    circleImageView.setImageBitmap(bitmap);
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