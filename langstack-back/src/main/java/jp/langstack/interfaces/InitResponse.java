package jp.langstack.interfaces;

import java.util.List;

import jp.langstack.domain.card.CardEntity;
import jp.langstack.domain.genre.GenreEntity;
import lombok.Data;

@Data
public class InitResponse {
 
    // postDateが最新5つのカード(CardService)
    private List<CardEntity> theLastFiveCards;
    // 今日から5日前までの投稿履歴(CardService)
    private List<Activity> theLastFiveDaysActivity;
    // OK GenreService
    private List<GenreEntity> allGenres;
    // CardService
    private int allCardCount;

}
