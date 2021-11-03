import Genre from "@/domains/genre/Genre";

export default class Card {
  constructor(
    public index: number = 0,
    public title: string = "",
    public content: string = "",
    public imageUrl: string = "",
    public postDate: string = "",
    public genre: Genre = new Genre()
  ) {}
}
