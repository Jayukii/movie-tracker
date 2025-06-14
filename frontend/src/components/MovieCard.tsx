import { Movie } from "../types/Movie";

interface Props {
  movie: Movie;
}

export default function MovieCard({ movie }: Props) {
  return (
    <div style={{ border: "1px solid #ccc", padding: "1rem", width: "250px" }}>
      <h3>{movie.title}</h3>
      <img
        src={movie.posterUrl}
        alt={movie.title}
        style={{ width: "100%", height: "375px", objectFit: "cover" }}
      />
      <p>{movie.description?.slice(0, 100)}...</p>
      <p><strong>Rating:</strong> {movie.averageRating.toFixed(1)} / 10</p>
    </div>
  );
}
