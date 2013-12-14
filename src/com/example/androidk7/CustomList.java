package com.example.androidk7;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {
	private final Activity context;
	private static String[] names;
	private static String[] phones;
	public CustomList(Activity context, String[] names, String[] phones) {
		super(context, R.layout.contact, names);
		this.context = context;
		this.names = names;
		this.phones = phones;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.contact, null, true);
		TextView tvFullName = (TextView) rowView.findViewById(R.id.tvFullName);
		TextView tvPhoneNumber = (TextView) rowView
				.findViewById(R.id.tvPhoneNumber);
		tvFullName.setText(names[position]);
		tvPhoneNumber.setText(phones[position]);
		return rowView;		
	}
}