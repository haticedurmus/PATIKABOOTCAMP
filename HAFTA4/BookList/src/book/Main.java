package book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // write your code here
        List<Book> books = new ArrayList<>();

        //10 tane book tuttuğumuz bir arrayList
        books.add(new Book("aaaaaa", 100, "a", 1911));
        books.add(new Book("bbbbbb", 28, "b", 1922));
        books.add(new Book("cccccc", 300, "c", 1933));
        books.add(new Book("dddddd", 44, "d", 1944));
        books.add(new Book("eeeeee", 55, "e", 1955));
        books.add(new Book("Dorian Gray'in Portresi", 252, "Oscar Wilde", 1890));
        books.add(new Book("Yer Altından Notlar", 150, "Dostoyevski", 1864));
        books.add(new Book("Sefiller", 533, "Victor Hugo", 1862));
        books.add(new Book("Momo", 290, "Michael Ende", 1973));
        books.add(new Book("Semerkant", 310, "Amin Maalouf", 1988));
        //books arrayListindeki kitap ve yazarların tutlduğu bir Map
        Map<String, String> booksAndAuthors = new HashMap<>();
        books.stream().forEach(book -> booksAndAuthors.put(book.bookName, book.authorName));
        System.out.println(booksAndAuthors.get("Sefiller"));

        //books arrayListindeki sayfa sayısı 100'den fazla olan kitapların tutuladuğu yeni bir liste
        List<Book> newBooks = new ArrayList<>();
        books.stream().filter(book -> book.pageCount > 100).forEach(book -> newBooks.add(book));
        System.out.println(newBooks.size());
    }
}
