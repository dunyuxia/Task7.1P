package com.example.notesapp;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Database
{
	private final DatabaseReference databaseReference;

	Database()
	{
		databaseReference = FirebaseDatabase.getInstance().getReference();
	}

	public void readNotes(AllNotesActivity activity)
	{
		databaseReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>()
		{
			@Override
			public void onComplete(@NonNull Task<DataSnapshot> task)
			{
				if (!task.isSuccessful())
				{
					Log.e("firebase", "Error getting data", task.getException());
				}
				else
				{
					ArrayList<Note> notes = new ArrayList<>();

					String value = String.valueOf(task.getResult().getValue()).replace("{", "").replace("}", "");

					if (!value.equals("null"))
					{
						String[] items = value.split(", ");

						for (String item : items)
						{
							notes.add(new Note(item));
						}

						activity.onList(notes);
					}
				}
			}
		});
	}

	public void updateNote(Note note)
	{
		databaseReference.child(String.valueOf(note.getId())).setValue(note.getContent());
	}

	public void createNote(String content)
	{
		databaseReference.push().setValue(content);
	}

	public void deleteNote(String id)
	{
		databaseReference.child(id).removeValue();
	}
}