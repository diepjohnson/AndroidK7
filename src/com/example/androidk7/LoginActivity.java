package com.example.androidk7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	Button btnLogin;
	EditText edtEmail, edtPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edtEmail = (EditText) findViewById(R.id.edtEmail);
		edtPassword = (EditText) findViewById(R.id.edtPassword);
		btnLogin = (Button) findViewById(R.id.btnLogin);
		final Toast toast1 = Toast.makeText(this, "Chưa nhập Email hoặc email chưa đúng",
				Toast.LENGTH_SHORT);
		final Toast toast2 = Toast.makeText(this, "Bạn chưa nhập password",
				Toast.LENGTH_SHORT);
		btnLogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (!isValidEmail(edtEmail.getText().toString())) {
					toast1.show();
					edtEmail.requestFocus();
				}
				else 
				if ("".equals(edtPassword.getText().toString())) {
						toast2.show();
						edtPassword.requestFocus();
					} else {
						Intent intent = new Intent(LoginActivity.this,
								ContactBackupActivity.class);
						startActivity(intent);
					}

			}
		});
	}

	public final static boolean isValidEmail(CharSequence email) {
		if (email == null) {
			return false;
		} else {
			return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
					.matches();
		}
	}

}
