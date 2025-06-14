import axios from "axios";
import { Movie } from "../types/Movie";
import { Review } from "../types/Review";

const BASE_URL = "http://localhost:8080/api";

export const getMovies = async (): Promise<Movie[]> => {
  const res = await axios.get<Movie[]>(`${BASE_URL}/movies`);
  return res.data;
};

export const addReview = async (movieId: string, review: Review) => {
  const res = await axios.post(`${BASE_URL}/movies/${movieId}/reviews`, review);
  return res.data;
};
