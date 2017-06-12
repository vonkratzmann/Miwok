package com.example.android.miwok;

        import android.app.Activity;
        import android.support.v4.content.ContextCompat;
        import android.widget.ArrayAdapter;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.ArrayList;

/**
 * Created by vonkr on 9/06/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    // Resource Id for the color of the list of words
    private int mResourceColorID;

    public WordAdapter(Activity context, ArrayList<Word> words, int resourceColorId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mResourceColorID = resourceColorId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the Miwok translation
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_translation_text_view);
        // Get the Miwok translation from the current Word object and
        // set this text on the Miwok TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the default translation
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_translation_text_view);
        // Get the default translation from the current Word object and
        // set this text on the default TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout
        ImageView miwokImageView = (ImageView) listItemView.findViewById(R.id.miwok_image);

        if (currentWord.isImageLoaded()) {

            // Get the default translation from the current Word object and
            // set this text on the default TextView
            miwokImageView.setImageResource(currentWord.getImage());
            miwokImageView.setVisibility(View.VISIBLE);
        } else {
            miwokImageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the colour that the reource id maps to
        int color = ContextCompat.getColor(getContext(),mResourceColorID);
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and image)
        // so that it can be shown in the ListView
        return listItemView;
    }
}

