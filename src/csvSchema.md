# Schema for CSV 'databases'

### movie.csv

Stores all the movie records.

```
imdbID: String
movieTitle: String
showingStatus: enum
movieType: enum
synopsis: String
director: String
case: Array[String] delimited by '|'
```