package hu.flowacademy;

public class CD implements rendelheto{

    public String author;
    public String title;

    public CD(String author, String title) {
        this.author = author;
        this.title = title;
    }

    @Override
    public String toString() {
        return author + ": " + title;
    }

    @Override
    public void rendel(int darab) {
        System.out.println("Rendelni kell " + darab + " db CD-t az alabbibol: " + this.toString());
    }
}

// 3.	Írd meg a következõ három konkrét osztályt:
// 	CD, mely implementálja a Rendelheto interfészt, de (értelemszerûen) nem származik a Konyv osztályból. Egy CD tárolja az
// elõadó nevét és az album címét. Mindhárom osztálynak legyen paraméteres konstruktora az adattagok beállítására, valamint
// toString metódusa!

    // A Rendelheto interfész rendel metódusát úgy kell megvalósítani, hogy a következõ üzenetet írja ki a képernyõre:
        // Rendelni kell x CD-t az alabbibol: xy, a CD osztályban,
        // ahol x helyére a rendelendõ példányszám kerül, xy helyére a megvalósító osztály sztring reprezentációja.
