package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class AllNotesActivity extends AppCompatActivity
{
	private Database database;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_notes);

		database = new Database();
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		database.readNotes(this);
	}

	public void onList(ArrayList<Note> notes)
	{
		RecyclerView vRecyclerView = findViewById(R.id.recyclerView);
		LinearLayoutManager vLayoutManager = new LinearLayoutManager(this);
		vRecyclerView.setLayoutManager(vLayoutManager);
		vLayoutManager.setOrientation(RecyclerView.VERTICAL);
		vRecyclerView.setAdapter(new MyAdapter(notes, this));
		vRecyclerView.setItemAnimator(new DefaultItemAnimator());
	}

	public void onNote(Note note)
	{
		Intent intent = new Intent(this, NoteActivity.class);
		intent.putExtra("Note", note);
		startActivity(intent);
	}

	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
		startActivity(new Intent(this, MainActivity.class));
	}
}