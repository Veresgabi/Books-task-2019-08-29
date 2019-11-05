package hu.flowacademy;

public class Regeny extends Konyv implements rendelheto {

    public String contentSum;

    public Boolean dedikalASzerzo() {
        return true;
    }

    public Regeny(String author, String title, String contentSum) {
        super(author, title);
        this.contentSum = contentSum;
    }

    @Override
    public String toString() {
        return this.author + ": " + this.title + ". Tartalom: " + this.contentSum;
    }

    @Override
    public void rendel(int darab) {
        System.out.println("Rendelni kell " + darab + " db regenyt az alabbibol: " + this.toString());
    }
}

// 3.	Írd meg a következõ három konkrét osztályt:
// Regeny, mely a Konyv osztályból származik és a Rendelheto interfészt is implementálja. Az örökölteken túl egy tartalmi
// összefoglaló tárolására alkalmas adattaggal rendelkezik. A regényt a szerzõ dedikálja.
// Mindhárom osztálynak legyen paraméteres konstruktora az adattagok beállítására, valamint toString metódusa!

// A Rendelheto interfész rendel metódusát úgy kell megvalósítani, hogy a következõ üzenetet írja ki a képernyõre:
// Rendelni kell x regenyt az alabbibol: xy, a Regeny osztályban
// ahol x helyére a rendelendõ példányszám kerül, xy helyére a megvalósító osztály sztring reprezentációja.
