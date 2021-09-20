import Card from "@/domains/card/Card";
import CardService from "@/domains/card/CardService";

export default class CardServiceImpl implements CardService {
  addCard(card: Card): void {}
  getCardsByGenre(genreId: string): Promise<Card[]> {
    return new Promise<Card[]>(resolve => {
      resolve([]);
    });
  }
}
