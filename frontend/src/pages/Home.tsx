import { useEffect, useState } from "react";
import { getMovies } from "../services/api";
import { Movie } from "../types/Movie";
import MovieCard from "../components/MovieCard";

export default function Home() {
  const [movies, setMovies] = useState<Movie[]>([]);

  useEffect(() => {
    getMovies().then(setMovies);
  }, []);

  return (
    <div style={{ display: "flex", flexWrap: "wrap", gap: "16px", padding: "1rem" }}>
      {movies.map(movie => (
        <MovieCard key={movie.id} movie={movie} />
      ))}
    </div>
  );
}
