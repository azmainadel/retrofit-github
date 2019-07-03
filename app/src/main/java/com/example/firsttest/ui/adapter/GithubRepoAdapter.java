package com.example.firsttest.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.firsttest.R;
import com.example.firsttest.api.model.GithubRepo;

import java.util.List;

public class GithubRepoAdapter extends ArrayAdapter<GithubRepo> {

    private Context context;
    private List<GithubRepo> githubRepoList;

    public GithubRepoAdapter(Context context, List<GithubRepo> githubRepoArrayList) {
        super(context, -1, githubRepoArrayList);
        this.context = context;
        this.githubRepoList = githubRepoArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.repo_layout, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.repo_name);
        textView.setText(githubRepoList.get(position).getName());

        return rowView;
    }
}
