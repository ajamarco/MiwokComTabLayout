package com.example.jamarco.miwokcomtabs;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jamarco on 8/16/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int activityColor;


    public WordAdapter(Activity context, ArrayList<Word> words, int itemColor){
        super(context,0,words);
        activityColor = itemColor;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the Default word
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.textView_Default);
        // Get the English word from the current Word object and
        // set this text on the name defaultTextView
        defaultTextView.setText(currentWord.getDefaultWord());

        // Find the TextView in the list_item.xml layout with the miwok word
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.textView_Miwok);
        // Get the miwok word from the current Word object and
        // set this text on the number TextView
        miwokTextView.setText(currentWord.getMiwokWord());

        // Find the imageview in the list_item.xml layout
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.imageView_icon);

        if (currentWord.hasImage()){
            //get the image for the corresponding word and
            //sets it to the corresponding imageview
            iconView.setImageResource(currentWord.getResourceImageID());
            iconView.setVisibility(View.VISIBLE);

        }
        else {
            iconView.setVisibility(View.GONE);
            LinearLayout layoutImage = (LinearLayout) listItemView.findViewById(R.id.layout_image);
            layoutImage.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.layout_Words);
        int color = ContextCompat.getColor(getContext(),activityColor);
        textContainer.setBackgroundColor(color);
        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
