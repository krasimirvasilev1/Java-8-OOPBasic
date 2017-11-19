package ThirdExersiceInheritance.OnlineRadioDatabase;


public class Song {
    private String artist;
    private String song;
    private int minutes;
    private int seconds;

    public Song(String artist, String song, String minutes , String seconds) {
        setArtist(artist);
        setSong(song);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public String getArtist() {
        return artist;
    }

    private void setArtist(String artist) {
        if(artist.length() >= 3 && artist.length() <= 20){
            this.artist = artist;
        }
        else{
            throw new IllegalArgumentException("Artist name should be between 3 and 20 symbols.");
        }
    }

    public String getSong() {
        return song;
    }

    private void setSong(String song) {
        if (song.length() >= 3 && song.length() <= 30){
            this.song = song;
        }
        else{
            throw new IllegalArgumentException("Song name should be between 3 and 30 symbols.");
        }
    }

    public int getMinutes() {
        return minutes;
    }

    private void setMinutes(String minutes) {
        for (int i = 0; i < minutes.length(); i++) {
            if (!Character.isDigit(minutes.charAt(i))){
                throw new IllegalArgumentException("Invalid song length exception");
            }
        }
        int minutesAsInt = Integer.parseInt(minutes);
        if (minutesAsInt < 0 || minutesAsInt > 14){
            throw new IllegalArgumentException("Song minutes should be between 0 and 14.");
        }
            this.minutes = minutesAsInt;
    }

    private void setSeconds(String seconds) {
        for (int i = 0; i < seconds.length(); i++) {
            if (!Character.isDigit(seconds.charAt(i))) {
                throw new IllegalArgumentException("Invalid song length exception");
            }
        }
        int secondsAsInt = Integer.parseInt(seconds);
        if (secondsAsInt < 0 || secondsAsInt > 59) {
            throw new IllegalArgumentException("Song seconds should be between 0 and 59.");
        }
            this.seconds = secondsAsInt;
        }

    public int getSeconds() {
        return seconds;
    }
}
