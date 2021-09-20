import Card from "@/domains/card/Card";

export default interface CardService {
  addCard(card: Card): void;
  getCardsByGenre(genreId: string): Promise<Card[]>;
}
