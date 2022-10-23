# Schema for CSV 'databases'

### movie.csv

Stores all the movie records.

```
id: String
movieTitle: String
showingStatus: EnumShowingStatus
movieType: EnumMovieType
synopsis: String
director: String
case: Array[String] delimited by '|'
```

### review.csv

Store all reviews of all movies

```
movieID: String
id: String
username: String
strReview: String
usrRating: int
```

