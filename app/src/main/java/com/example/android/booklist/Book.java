package com.example.android.booklist;

/**
 * An {@link Book} object contains information related to a single book.
 */
public class Book {

    /** Title of the book */
    private String mTitle;

    /** Subtitle of the book */
    private String mSubtitle;

    /** Authors of the book */
    private String mAuthors;

    /** Rating of the book */
    private double mRating;

    /** Website URL of the book */
    private String mUrl;

    /**
     * Constructs a new {@link Book} object.
     *
     * @param title is the title of the book
     * @param subtitle is the subtitle of the book
     * @param authors are the authors of the book
     * @param rating is the rating out of 5 for the book
     * @param url is the website URL to find more details about the book
     */
    public Book(String title, String subtitle, String authors, double rating, String url) {
        mTitle = title;
        mSubtitle = subtitle;
        mAuthors = authors;
        mRating = rating;
        mUrl = url;
    }

    /**
     * Returns the authors of the book.
     */
    public String getAuthor() {
        return mAuthors;
    }

    /**
     * Returns the title of the book.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the title of the book.
     */
    public String getSubtitle() {
        return mSubtitle;
    }

    /**
     * Returns the rating of the book.
     */
    public double getRating() {
        return mRating;
    }

    /**
     * Returns the website URL to find more information about the book.
     */
    public String getUrl() {
        return mUrl;
    }
}
