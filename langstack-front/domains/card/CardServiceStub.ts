import axiosModule from "@/infras/AxiosFactory";

import Card from "@/domains/card/Card";
import CardService from "@/domains/card/CardService";

export default class CardServiceStub implements CardService {
  addCard(card: Card): void {}
  async getCardsByGenre(genreId: string): Promise<Card[]> {
    return (await axiosModule.get("/data/card/" + genreId + ".json"))
      .data as Card[];
  }
}
