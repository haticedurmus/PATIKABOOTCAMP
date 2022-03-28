package book;

public class Book {
    public String bookName;
    public int pageCount;
    public String authorName;
    public int releaseDate;

    public Book(String bookName, int pageCount, String authorName, int releaseDate) {
        this.bookName = bookName;
        this.pageCount = pageCount;
        this.authorName = authorName;
        this.releaseDate = releaseDate;
    }

}
