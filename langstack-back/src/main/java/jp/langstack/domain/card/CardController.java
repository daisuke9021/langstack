package jp.langstack.domain.card;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.langstack.domain.genre.GenreEntity;
import jp.langstack.domain.genre.GenreService;
import jp.langstack.interfaces.request.CardRequest;
import jp.langstack.interfaces.response.CardResponse;
import jp.langstack.interfaces.response.InitResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("card")
@CrossOrigin
public class CardController {

    private final CardService cardService;
    private final GenreService genreService;

    @PostMapping("/add")
    public void addCard(@RequestBody CardRequest request) {
        // TODO：modelMapperとかつかう
        GenreEntity genre = new GenreEntity();
        genre.setId(request.getGenreId());
        genre.setName(request.getGenreName());
        CardEntity card = new CardEntity();
        card.setTitle(request.getTitle());
        card.setContent(request.getContent());
        card.setImageUrl(request.getImageDataUrl());
        card.setGenre(genre);
        cardService.addCard(card);
    }

    @GetMapping("/init")
    public InitResponse init() {
        return InitResponse.builder()
                .allCardCount(cardService.getAllCardCount())
                .allGenres(genreService.getAllGenres())
                .theLastFiveCards(cardService.getTheLastFiveCards())
                .theLastFiveDaysActivity(cardService.getTheLastFiveDaysActivity())
                .build();
    }

    @GetMapping("/recent-cards")
    public List<CardResponse> recentCards() {
        return cardService.getRecentCards();
    }

    @GetMapping("/{genreId}")
    public List<CardResponse> genreCards(@PathVariable String genreId) {
        return cardService.getCardsByGenre(genreId);
    }

    @GetMapping("/search")
    public List<CardResponse> search(@RequestParam(required = true) String keyword) {
        return cardService.search(keyword);
    }

}
