package com.company.company;
public class Book implements Comparable<Book>{
    private String bookName;
    private int pageCount;
    private String authorName;
    private int releaseDate;

    public Book(String bookName, int pageCount, String authorName, int releaseDate) {
        this.bookName = bookName;
        this.pageCount = pageCount;
        this.authorName = authorName;
        this.releaseDate = releaseDate;
    }

    public String getBookName() {
        return bookName;
    }

    public int getPageCount() {
        return pageCount;
    }
 
    //Kitapları isimlerine göre sıralar
    @Override
    public int compareTo(Book o) {
        return this.getBookName().compareTo(o.getBookName());
    }
    
}


