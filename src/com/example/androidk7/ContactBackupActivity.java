package com.example.androidk7;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;

public class ContactBackupActivity extends Activity {
	CheckBox cbChooseAll;
	Button btnBackUp;
	ListView lvContact;
	String[] names = { "Liberty Tuấn", "Bill Gates", "Steve Jobs",
			"Warren Buffett" };
	String[] phones = { "01652006360", "0946890936", "0856524344", "0439361466" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_backup);
		lvContact = (ListView) findViewById(R.id.lvContact);
		CustomList adapter = new CustomList(ContactBackupActivity.this, names,
				phones);
		lvContact.setAdapter(adapter);
		cbChooseAll = (CheckBox) findViewById(R.id.cbChooseAll);
		cbChooseAll.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				for (int i = 0; i < lvContact.getCount(); i++) {

					if ((CheckBox) lvContact.getChildAt(i).findViewById(
							R.id.cbChoose) != null) {

						CheckBox cbChoose = (CheckBox) lvContact.getChildAt(i)
								.findViewById(R.id.cbChoose);
						if (cbChooseAll.isChecked())
							cbChoose.setChecked(true);
						else
							cbChoose.setChecked(false);

					}
				}
			}
		});

		btnBackUp = (Button) findViewById(R.id.btnBackup);
		final Builder dialog = new AlertDialog.Builder(this)
				.setTitle("Thông báo")
				.setMessage("Completed!")
				.setPositiveButton("OK ",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
							}
						});
		btnBackUp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dialog.show();
			}
		});

	}
}
