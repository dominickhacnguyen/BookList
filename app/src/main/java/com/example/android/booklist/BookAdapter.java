package com.example.android.booklist;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

/**
 * An {@link BookAdapter} knows how to create a list item layout for each book
 * in the data source (a list of {@link Book} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class BookAdapter extends ArrayAdapter<Book> {

    /**
     * Constructs a new {@link BookAdapter}.
     *
     * @param context of the app
     * @param books is the list of books, which is the data source of the adapter
     */
    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
    }

    /**
     * Returns a list item view that displays information about the book at the given position
     * in the list of books.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_list_item, parent, false);
        }

        // Find the book at the given position in the list of books
        Book currentBook = getItem(position);

        // Find the TextView with view ID rating
        TextView ratingView = (TextView) listItemView.findViewById(R.id.rating);
        // Format the rating to show 1 decimal place
        String formattedRating = formatRating(currentBook.getRating());
        // Display the rating of the current book in that TextView
        ratingView.setText(formattedRating);

        // Set the proper background color on the rating circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable ratingCircle = (GradientDrawable) ratingView.getBackground();
        // Get the appropriate background color based on the current book rating
        int ratingColor = getRatingColor(currentBook.getRating());
        // Set the color on the rating circle
        ratingCircle.setColor(ratingColor);

        // Get the title string from the Book object
        String title = currentBook.getTitle();
        // Find the TextView with view ID title
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        // Display the title of the current book in that TextView
        titleView.setText(title);

        // Get the subtitle string from the Book object
        String subtitle = currentBook.getSubtitle();
        // Find the TextView with view ID subtitle
        TextView subtitleView = (TextView) listItemView.findViewById(R.id.subtitle);
        // Display the subtitle of the current book in that TextView
        subtitleView.setText(subtitle);

        // Get the author string from the Book object
        String author = currentBook.getAuthor();
        // Find the TextView with view ID authors
        TextView authorView = (TextView) listItemView.findViewById(R.id.authors);
        // Display the authors of the current book in that TextView
        authorView.setText(author);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    /**
     * Return the color for the rating circle based on the rating of the book.
     *
     * @param rating of the book
     */
    private int getRatingColor(double rating) {
        int ratingColorResourceId;
        int ratingFloor = (int) Math.floor(rating);
        switch (ratingFloor) {
            case 0:
            case 1:
                ratingColorResourceId = R.color.rating1;
                break;
            case 2:
                ratingColorResourceId = R.color.rating2;
                break;
            case 3:
                ratingColorResourceId = R.color.rating3;
                break;
            case 4:
                ratingColorResourceId = R.color.rating4;
                break;
            default:
                ratingColorResourceId = R.color.rating5;
                break;
        }

        return ContextCompat.getColor(getContext(), ratingColorResourceId);
    }

    /**
     * Return the formatted rating string showing 1 decimal place (i.e. "4.7")
     * from a decimal rating value.
     */
    private String formatRating(double rating) {
        DecimalFormat ratingFormat = new DecimalFormat("0.0");
        return ratingFormat.format(rating);
    }

}