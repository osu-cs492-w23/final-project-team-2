-if class com.example.eivom.data.MovieList
-keepnames class com.example.eivom.data.MovieList
-if class com.example.eivom.data.MovieList
-keep class com.example.eivom.data.MovieListJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
