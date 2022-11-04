# Schema for CSV 'databases'

## movie.csv

Stores all the movie records.

``` null
id: String
movieTitle: String
showingStatus: EnumShowingStatus
movieType: EnumMovieType
synopsis: String
director: String
case: Array[String] delimited by '|'
```

## showtime.csv

Contains all showtimes (historical and upcoming).

```null

showtimeID: String
movieID: String
cinemaID: String
time: String
```

## review.csv

Store all reviews of all movies

``` null
movieID: String
id: String
username: String
strReview: String
usrRating: int
```

## staffUser.csv

Contains clear text login information of staff.

```null
id: String
name: String
password: String

```
