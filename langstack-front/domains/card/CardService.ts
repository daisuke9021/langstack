import Card from "@/domains/card/Card";
import CardAddForm from "@/domains/card/CardAddForm";
import InitResponse from "@/domains/response/InitResponse";

export default interface CardService {
  addCard(card: CardAddForm): void;
  init(): Promise<InitResponse>;
  search(keyword: string): Promise<Card[]>;
  getRecentCards(): Promise<Card[]>;
  getCardsByGenre(genreId: string): Promise<Card[]>;
}
