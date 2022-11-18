package com.example.vaibhav.iot;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final EditText editText_email;
        Button button_reset;
        TextView textView_back;
        final FirebaseAuth firebaseAuth;
        setContentView(R.layout.activity_forgot_password);
        editText_email = (EditText)findViewById(R.id.reset_email);
        button_reset = (Button)findViewById(R.id.reset_button);
        textView_back = (TextView)findViewById(R.id.textView_back);
        firebaseAuth = FirebaseAuth.getInstance();
        button_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editText_email.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(ForgotPasswordActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(ForgotPasswordActivity.this,"Password reset Instructions Sent",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ForgotPasswordActivity.this,LoginActivity.class));
                            finish();
                        }
                        else
                            Toast.makeText(ForgotPasswordActivity.this,"Try Again",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        textView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
