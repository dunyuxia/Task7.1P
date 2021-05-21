package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateNoteActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_note);
	}

	public void onSave(View view)
	{
		EditText note = findViewById(R.id.note);

		Database database = new Database();
		database.createNote(note.getText().toString());

		startActivity(new Intent(this, AllNotesActivity.class));
	}

	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
		startActivity(new Intent(this, MainActivity.class));
	}
}