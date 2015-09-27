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
public class ErrandsActivityFragment extends Fragment {

    private ListView errandsList;
    private Button createErrand;

    public ErrandsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_errands, container, false);
        errandsList = (ListView) view.findViewById(R.id.errandsList);
        createErrand = (Button) view.findViewById(R.id.createErrand);

        createErrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CreateErrandActivity.class);
                startActivity(intent);
            }
        });

        new RefreshErrandsListTask().execute();

        return view;
    }

    private class RefreshErrandsListTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            String[] list = {"errand 1", "errand 2"};
            return list;
        }

        @Override
        protected void onPostExecute(String[] result) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, result);
            errandsList.setAdapter(adapter);

        }
    }
}
