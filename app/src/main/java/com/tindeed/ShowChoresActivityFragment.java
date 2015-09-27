package com.tindeed;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ShowChoresActivityFragment extends Fragment {

    private ListView choresList;
    private Button createChore;

    public ShowChoresActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_chores, container, false);
        choresList = (ListView) view.findViewById(R.id.choresList);
        createChore = (Button) view.findViewById(R.id.createChore);
        createChore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CreateChoresActivityFragment.class);
                startActivity(intent);
            }
        });
        new GetChoresTask().execute();

        return view;
    }

    private class GetChoresTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            // grab info from bluemix
            String[] list = {"Chores 1", "Chores 2"};
            return list;
        }

        @Override
        protected void onPostExecute(String[] result) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, result);
            choresList.setAdapter(adapter);

        }
    }
}
