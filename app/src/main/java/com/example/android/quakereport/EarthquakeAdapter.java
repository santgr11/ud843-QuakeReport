package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {


    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {

        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list, parent, false);
        }

        // Get the {@link Earthquake} object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView in the earthquake_list.xml layout with the ID list_magnitude
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.list_magnitude);
        // Get the version name from the current Earthquake object and
        // set this text on the name TextView
        magnitudeTextView.setText(String.valueOf(currentEarthquake.getMagnitude()));

        // Find the TextView in the earthquake_list.xml layout with the ID list_location
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.list_location);
        // Get the version number from the current Earthquake object and
        // set this text on the number TextView
        locationTextView.setText(currentEarthquake.getLocation());

        // Find the TextView in the earthquake_list.xml layout with the ID list_date
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.list_date);
        // Get the version number from the current Earthquake object and
        // set this text on the number TextView
        dateTextView.setText(currentEarthquake.getDate());



        // Return the whole list item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
