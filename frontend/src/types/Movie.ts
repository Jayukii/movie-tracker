import { Review } from "./Review";

export interface Movie {
  id: string;
  title: string;
  description: string;
  genres: string[];
  posterUrl: string;
  averageRating: number;
  reviews?: Review[];
}