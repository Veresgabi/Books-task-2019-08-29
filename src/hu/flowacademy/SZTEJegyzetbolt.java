package hu.flowacademy;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SZTEJegyzetbolt {
    private static List<CD> cds = new ArrayList<>();
    private static List<Konyv> books = new ArrayList<>();

    public static void rendelesFelvesz(String rendeles) {
        List<Object> allType = new ArrayList<>();
        try {
            allType = Files.lines(Paths.get(rendeles)).map(s -> {
                String[] arr = s.split(";");
                switch (arr[0]) {
                    case "regeny": return new Regeny(arr[1], arr[2], arr[3]);      // Ha a sor a megadott String-ekkel kezdődik,
                    case "cd": return new CD(arr[1], arr[2]);                      // a metódus annak megfelelő objektumot hozzon létre
                    case "peldatar": return new Peldatar(arr[1], arr[2], Integer.parseInt(arr[3]));
                    default: throw new InvalidOrderError("A beolvasott fájlban érvénytelen termékmegnevezés található: " + "\"" + arr[0] + "\"");
                }
            }).collect(Collectors.toList());
        } catch (InvalidOrderError f) {
            System.out.println(f);
        } catch (Exception e) {
            System.out.println("A beolvasott fájl nem található vagy nem megfelelő paramétereket tartalmaz!");
        }
        for (int i = 0; i < allType.size(); i++) {
            if (allType.get(i) instanceof Konyv) {      // Ha a Konyv osztályhoz tartozik az objektum, hozzáadjuk a 'books' listához
                books.add((Konyv)allType.get(i));
            } if (allType.get(i) instanceof CD) {       // Ha a CD osztályhoz tartozik az objektum, hozzáadjuk a 'cds' listához
                cds.add((CD)allType.get(i));
            }
        }
        if (books.isEmpty() == false) {
            System.out.println(books);
        }
        if (cds.isEmpty() == false) {
            System.out.println(cds);
        }
    }


    public static void rendel() {
        List<CD> cds2 = new ArrayList<>();
        List<Regeny> regeny = new ArrayList<>();
        for (int i = 0; i < cds.size(); i++) {
            try {
                if (cds.get(i).getClass().getMethod("rendel", int.class) != null) {
                    cds2.add(cds.get(i));           // Ha van "rendel()" metódusa, hozzáadjuk a 'cds2' listához
                };                              // A getMethod() metódusnál kötelező ennek a kivételnek a lekezelése
            } catch (NoSuchMethodException e) {
                // System.out.println("Az alábbi Osztály objektumában nem található a rendel metódus.");
                e.printStackTrace();
            }
        }
        for (int i = 0; i < cds2.size(); i++) {
            int random = (int)(Math.random() * 50 + 1);
            cds2.get(i).rendel(random);         // A 'cds2' objektumaira meghívjuk a 'rendel()' metódust, random számokkal
        }
        for (int i = 0; i < books.size(); i++) {
                try {
                    if (books.get(i).getClass().getMethod("rendel", int.class) != null) {
                        regeny.add((Regeny)books.get(i));   // Ha van "rendel()" metódusa, hozzáadjuk a 'regeny' listához
                    };                                 // A getMethod() metódusnál kötelező ennek a kivételnek a lekezelése
                } catch (NoSuchMethodException e) {
                    // System.out.println("Az alábbi Osztály objektumában nem található a rendel metódus.");
                    e.printStackTrace();
                }
        }
        for (int i = 0; i < regeny.size(); i++) {
            int random = (int)(Math.random() * 50 + 1);
            regeny.get(i).rendel(random);           // A 'regeny' objektumaira meghívjuk a 'rendel()' metódust, random számokkal
        }
    }


    public static void main(String[] args) {
        rendelesFelvesz("order.csv");
        rendel();
    }
}

// 4.	Írj futtatható osztályt (pl. SZTEJegyzetbolt), melyben a következõket kell megvalósítani:
        // - Az osztálynak legyen két tárolója, CD-k és könyvek számára.
        // - Egy rendelesFelvesz statikus metódus, melynek paramétere egy fájl elérési útvonala, visszatérési típusa pedig void.
            // Feladata, hogy a fájlból beolvasott sorokat feldolgozza, és létrehozzon belõlük Peldatar, CD vagy Konyv példányokat,
            // amiket hozzáad a megfelelõ tárolóhoz.
        // - Egy rendel statikus metódus, ami a tárolón lévõ összes objektumra meghívja ezek rendel metódusát, ha van nekik.
        // Minden esetleges kivételt (fõleg FileNotFoundException és IOException) kezelj le vagy kivétel specifikációval, vagy
        // try blokkban!
        // (A metódus végén ne felejtsd el lezárni a beolvasásra használt stream-et!)
        // A bemeneti fájl a következõképpen néz ki: (A sorok feldolgozásánál ügyelj arra, hogy az egyes sorokban lévõ információk
        // pontosvesszõvel vannak elválasztva!)

    // regeny;Gárdonyi Géza;Egri Csillagok;Háború a törökök ellen
        // cd;Limp Bizkit;Significant Other
        // regeny;Robert Charles Wilson;Porges;Ez a rovid tartalom...
        // peldatar;Szabo Tamas;Kalkulus II. peldatar;100
        // cd;Rod Stewart;Soulbook

        // 	A main-ben hívd meg a rendelesFelvesz metódust.