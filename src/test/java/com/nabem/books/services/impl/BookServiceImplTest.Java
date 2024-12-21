package com.nabem.books.services.impl;

@ExtendWith(MockitoExtenstion.class)
public class BookServiceImplTest {

    @Mock
    private BookRepository bookrepository;

    @InjectMocks
    private BookServiceImpl underTest;

    @Test
    public void testThatBookIsSaved() {

        final Book book =  Book.builder()
        .isbn(isbn:"02345781")
        .author(author:"Virginia Woolf")
        .title(title:"The waves")
        .build();

        final BookEntity bookEntity =  BookEntity.builder()
        .isbn(isbn:"02345781")
        .author(author:"Virginia Woolf")
        .title(title:"The waves")
        .build();

        when(bookRepository.save(eq(bookEntity))).thenReturn(bookEntity);

        final Book result = underTest.create(book);
        assertEquals(book, result);

    }

}