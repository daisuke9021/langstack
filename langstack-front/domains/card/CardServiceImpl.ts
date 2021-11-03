import axios from "~/infras/AxiosFactory";
import Card from "@/domains/card/Card";
import CardService from "@/domains/card/CardService";
import InitResponse from "@/domains/response/InitResponse";

export default class CardServiceImpl implements CardService {
  addCard(card: Card): void {}
  async init(): Promise<InitResponse> {
    return (await axios.get('/card/init')).data;
  }
  async search(keyword: string): Promise<Card[]> {
    return (await axios.get("/card/search?keyword=" + keyword)).data
  }
  async getRecentCards(): Promise<Card[]> {
    return (await axios.get("/card/recent-cards")).data;
  }
  async getCardsByGenre(genreId: string): Promise<Card[]> {
    return (await axios.get("/card/" + genreId)).data;
  }
}
