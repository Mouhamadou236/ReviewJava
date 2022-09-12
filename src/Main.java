public class Main {
    public static void main(String[] args)  {
        File.maxInstanceOfFile(3);
        File firstFile = new File("Je suis le recto", "Et moi le verso");
        File secondFile = new File("Je suis le deuxième recto moi", "Et moi le deuxième verso");
        Envelope racine = new Envelope();
        Envelope envelope1 = new Envelope();
        envelope1.open();
        envelope1.addComponent(new File("1212", "12597"));
        envelope1.addComponent(new File("ZDFFD", "oouiyutty"));
        racine.open();
        racine.addComponent(envelope1);
        racine.addComponent(firstFile);
        racine.addComponent(secondFile);
        racine.read();



        // Si la feuille est une instance de la classe Feuille qui est instanciée en dehors de la méthode addFile
        //

    }
}
