import Genre from "@/domains/genre/Genre";
import GenreService from "@/domains/genre/GenreService";

export default class GenreServiceImpl implements GenreService {
  getAllGenre(): Promise<Genre[]> {
    return new Promise<Genre[]>(resolve => {
      resolve([]);
    });
  }
}
