package com.tindeed;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class CreateErrandActivityFragment extends Fragment {

    private EditText errandTitle;
    private Button createErrandButton;

    public CreateErrandActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_errand, container, false);
        errandTitle = (EditText) view.findViewById(R.id.errandName);
        createErrandButton = (Button) view.findViewById(R.id.actuallyCreateErrand);

        createErrandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CreateErrandTask().execute(errandTitle.getText().toString());
            }
        });

        return view;
    }

    private class CreateErrandTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            //Do something with the errand title here
            return null;
        }

        @Override
        protected void onPostExecute(Void doNothing) {
            //Dismiss the loading dialog
            getActivity().finish();
        }
    }
}
