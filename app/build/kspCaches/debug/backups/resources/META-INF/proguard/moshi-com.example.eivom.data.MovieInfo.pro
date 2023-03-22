-if class com.example.eivom.data.MovieInfo
-keepnames class com.example.eivom.data.MovieInfo
-if class com.example.eivom.data.MovieInfo
-keep class com.example.eivom.data.MovieInfoJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
