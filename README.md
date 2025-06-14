# 🎬 Movie Tracker

A full-stack web app for browsing movies, viewing details, and posting reviews.  
Built with **Spring Boot + MongoDB** on the backend and **React + TypeScript** on the frontend.  
Integrated with the **TMDb API** for real movie data.

---

## 🗂 Project Structure
movie-tracker/
├── backend/ # Spring Boot (Java) + MongoDB
└── frontend/ # React + TypeScript

---

## 🚀 Features

- 🔍 Fetches real popular movies from [TMDb API](https://www.themoviedb.org/documentation/api)
- 📝 Add user reviews per movie
- 🧭 REST API built with Spring Boot
- 🌐 Frontend built with React + TypeScript
- 🗄 MongoDB for storing movie & review data

---

## 🧑‍💻 Getting Started

> Requires:
> - Java 17+
> - Node.js (18+ recommended)
> - MongoDB running locally on `mongodb://localhost:27017`
> - TMDb API Key (get one [here](https://www.themoviedb.org/settings/api))

---

### 🔧 1. Clone the Repository

```bash
git clone https://github.com/Jayukii/movie-tracker.git
cd movie-tracker
```

## Backend Setup (/backend)

```
cd backend
./mvnw spring-boot:run
```
Or if using Windows CMD:

```
cd backend
mvnw.cmd spring-boot:run
```

## Add TMDb API Key

Create or edit the file:
```
backend/src/main/resources/application.properties
```
Add:
```
tmdb.api.key=YOUR_TMDB_API_KEY_HERE
spring.data.mongodb.uri=mongodb://localhost:27017/movie_tracker
```

| Endpoint                             | Description                  |
| ------------------------------------ | ---------------------------- |
| `GET /api/movies`                    | List all movies              |
| `POST /api/movies/{movieId}/reviews` | Add a review                 |
| `GET /api/tmdb/import-popular`       | Fetch and import TMDb movies |


##  Frontend Setup (/frontend)
```
cd frontend
npm install
npm start
```
Frontend will run on:
🌐 http://localhost:3000

## Tech Stack

Backend:
Java 17
Spring Boot
MongoDB
TMDb API

Frontend:
React
TypeScript
Axios

🧠 Author
Built by @Jayukii

