package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NoteActivity extends AppCompatActivity
{
	private Note note;
	private Database db;
	private EditText contentET;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note);

		db = new Database();
		contentET = findViewById(R.id.note);

		Intent intent = getIntent();

		if (intent != null)
		{
			note = (Note) intent.getSerializableExtra("Note");
			contentET.setText(note.getContent());
		}
	}

	public void onUpdate(View view)
	{
		note.setContent(contentET.getText().toString());
		db.updateNote(note);
		startActivity(new Intent(this, AllNotesActivity.class));
	}

	public void onDelete(View view)
	{
		db.deleteNote(note.getId());
		startActivity(new Intent(this, AllNotesActivity.class));
	}
}