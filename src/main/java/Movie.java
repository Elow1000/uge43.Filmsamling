public class Movie
{
//TODO: Gemmer filmens oplysninger
private String titel;
private String instruktoer;
private int udgivelsesaar;


// TODO: Opretter en film med titel, instruktør og år
public Movie(String titel, String instruktoer, int udgivelsesaar)
{
    this.titel = titel;
    this.instruktoer = instruktoer;
    this.udgivelsesaar = udgivelsesaar;

}

// TODO: Henter filmens titel
public String getTitel(){
    return titel;
}

// TODO: Henter filmens instruktør
public String getInstruktoer(){
    return instruktoer;
}

// TODO: Henter filmens udgivelsesår
public int getUdgivelsesaar(){
    return udgivelsesaar;

}

}
