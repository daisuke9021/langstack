import axios from "@/infras/AxiosFactory";
import Card from "@/domains/card/Card";
import CardService from "@/domains/card/CardService";
import InitResponse from "@/domains/response/InitResponse";

export default class CardServiceStub implements CardService {
  addCard(card: Card): void {}
  async init(): Promise<InitResponse> {
    return (await axios.get("/data/card/init.json")).data as InitResponse;
  }
  async search(keyword: string): Promise<Card[]> {
    return (await axios.get("/data/card/search.json")).data;
  }
  async getRecentCards(): Promise<Card[]> {
    return (await axios.get("/data/card/recent-cards.json")).data;
  }
  async getCardsByGenre(genreId: string): Promise<Card[]> {
    return (await axios.get("/data/card/" + genreId + ".json"))
      .data as Card[];
  }
}
