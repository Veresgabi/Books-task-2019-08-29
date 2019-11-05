package hu.flowacademy;

public class Peldatar extends Konyv {

    public int numbersOfExercises;

    public Peldatar (String author, String title, int numberOfExercises) {
        super(author, title);
        this.numbersOfExercises = numberOfExercises;
    }

    @Override
    public String toString() {
        return author + ": " + title + ". A feladatok száma: " + this.numbersOfExercises;
    }

    @Override
    public Boolean dedikalASzerzo() {
        return false;
    }
}

// 3.	Írd meg a következõ három konkrét osztályt:
// 	Peldatar, mely a Konyv osztályból származik, de nem implementálja a Rendelheto interfészt. Az örökölteken kívül
// további adattagja a példatárban található feladatok száma. A példatárat a szerzõ nem dedikálja.
// Mindhárom osztálynak legyen paraméteres konstruktora az adattagok beállítására, valamint toString metódusa!
