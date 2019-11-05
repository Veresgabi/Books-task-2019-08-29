package hu.flowacademy;

public abstract class Konyv {

    protected String author;
    protected String title;

    public abstract Boolean dedikalASzerzo();

    public Konyv (String author, String title) {
        this.author = author;
        this.title = title;
    }
}

// 2.	Írj egy absztrakt Konyv osztályt, melynek két protected adattagja a könyv szerzõje és címe, valamint tartalmaz egy
// absztrakt dedikalASzerzo metódust (melynek nincs paramétere, visszatérési típusa pedig boolean)!
