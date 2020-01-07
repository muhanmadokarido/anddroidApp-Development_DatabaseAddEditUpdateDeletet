package com.mk_kadish.mk1_sharedpreferences;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadSchoolsFragment extends Fragment {
private TextView textView;
    public ReadSchoolsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_read_schools, container, false);
        textView=view.findViewById(R.id.txtdisplay);
        readSchools();
        return view;
    }

    private void readSchools()
    {
        SchoolDbHelper schoolDbHelper=new SchoolDbHelper(getActivity());
        SQLiteDatabase database=schoolDbHelper.getReadableDatabase();

        Cursor cursor=schoolDbHelper.readSchool(database);
        String info="";

        while(cursor.moveToNext())
        {
            String id=Integer.toString(cursor.getInt(cursor.getColumnIndex(SchoolContract.SchoolEntry.school_id)));
            String name=cursor.getString(cursor.getColumnIndex(SchoolContract.SchoolEntry.school_name));
            info=info+"\n\n"+"School ID: "+id+"\n  School Name: "+name;;
        }
        textView.setText(info);
        schoolDbHelper.close();
    }

}
