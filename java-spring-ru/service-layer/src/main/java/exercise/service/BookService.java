package exercise.service;

import exercise.model.Book;
import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> findAll() {
        var books = bookRepository.findAll();

        List<BookDTO> booksDto = books.stream()
                .map(bookMapper::map)
                .toList();

        return booksDto;
    }

    public BookDTO findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id=" + id + " not found!"));

        BookDTO bookDto = bookMapper.map(book);

        return bookDto;
    }

    public BookDTO create(BookCreateDTO dto) {
        Book book = bookMapper.map(dto);
        bookRepository.save(book);

        BookDTO bookDto = bookMapper.map(book);

        return bookDto;
    }

    public BookDTO update(BookUpdateDTO dto, Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id=" + id + " not found!"));

        bookMapper.update(dto, book);
        bookRepository.save(book);

        BookDTO bookDto = bookMapper.map(book);

        return bookDto;
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    // END
}
