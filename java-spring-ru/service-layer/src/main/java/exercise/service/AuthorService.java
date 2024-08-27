package exercise.service;

import exercise.model.Author;
import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public List<AuthorDTO> findAll() {
        var authors = authorRepository.findAll();

        List<AuthorDTO> authorsDto = authors.stream()
                .map(authorMapper::map)
                .toList();

        return authorsDto;
    }

    public AuthorDTO findById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id=" + id + " not found!"));

        AuthorDTO authorDto = authorMapper.map(author);

        return authorDto;
    }

    public AuthorDTO create(AuthorCreateDTO dto) {
       Author author = authorMapper.map(dto);
       authorRepository.save(author);

        AuthorDTO authorDto = authorMapper.map(author);

        return authorDto;
    }

    public AuthorDTO update(AuthorUpdateDTO dto, Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id=" + id + " not found!"));

        authorMapper.update(dto, author);
        authorRepository.save(author);

        AuthorDTO authorDto = authorMapper.map(author);

        return authorDto;
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    // END
}
