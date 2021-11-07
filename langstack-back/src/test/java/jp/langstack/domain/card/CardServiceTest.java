package jp.langstack.domain.card;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jp.langstack.interfaces.Activity;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CardServiceTest {
    
    @Autowired CardService cardService;

    @Test
    public void getTheLastFiveCards() {
        List<CardEntity> cards = cardService.getTheLastFiveCards();
        assertEquals(5, cards.size());
        cards.stream().forEach(c -> System.out.println("date：" + c.getPostDate() + ", id：" + c.getId()));
    }

    @Test
    public void getTheLastFiveDaysActivity() {
        Set<Activity> activities = cardService.getTheLastFiveDaysActivity();
        assertEquals(5, activities.size());
        activities.stream().forEach(a -> System.out.println("date：" + a.getPostDate() + ", cards：" + a.getCards()));
    }

    @Test
    public void getAllCardCount() {
        int count = cardService.getAllCardCount();
        assertEquals(23, count);
    }

    @Test
    public void search() {
        List<CardEntity> cards = cardService.search("aiueo");
        System.out.println("検索件数：" + cards.size());
        cards.stream().forEach(c -> {
            System.out.println("--------------------------");
            System.out.println("TITLE：" + c.getTitle());
            System.out.println("CONTENT：" + c.getContent());
            System.out.println("POST DATE：" + c.getPostDate());
        });
    }

    @Test
    public void getRecentCards() {
        List<CardEntity> cards = cardService.getRecentCards();
        System.out.println("検索件数：" + cards.size());
        cards.stream().forEach(c -> {
            System.out.println("--------------------------");
            System.out.println("TITLE：" + c.getTitle());
            System.out.println("POST DATE：" + c.getPostDate());
        });

    }
        

}
