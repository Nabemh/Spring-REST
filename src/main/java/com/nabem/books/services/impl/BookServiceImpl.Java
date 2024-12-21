import com.nabem.books.services.BookService;

import com.nabem.books.services.BookService;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(final Book book) {
        final BookEntity bookEntity = bookToBookEntity(book);
        final BookEntity savedBookEntity = bookRepository.save(bookEntity);
      return bookRepository.save(book)
    }

    private BookEntity bookToBookEntity(Book book) {
        return BookEntity.builder()
            .isbn (book.getIsbn())
            .title(book.getTitle())
            .author(book.getAuthor())
            .build();
    }

    private Book bookEntityToBook(BookEntity bookEntity) {
        return Book.builder()
            .isbn (book.getIsbn())
            .title(book.getTitle())
            .author(book.getAuthor())
            .build();
    }
    
}