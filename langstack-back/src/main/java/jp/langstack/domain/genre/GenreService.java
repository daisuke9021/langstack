package jp.langstack.domain.genre;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepo;

    public List<GenreEntity> getAllGenres() {
        return StreamSupport.stream(genreRepo.findAll().spliterator(),false).collect(Collectors.toList());
    }
    
}
