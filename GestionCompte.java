class Compte {
    private int solde = 0;
    public void operationNulle(int somme) {
        solde += somme;
        System.out.print(" ajoute " + somme);
        solde -= somme;
        System.out.println(" retire " + somme);
    }
    public int getSolde() { return solde;}
}
class Operation extends Thread {
    private Compte compte;
    public Operation(String nom, Compte compte) {
        super(nom);    this.compte = compte;}
    public void run() {
        try { g();   f();}
        catch (InterruptedException e) { throw new RuntimeException(e);   }
    }
    public void f() throws InterruptedException {
        while (true) {
            synchronized (compte){
                compte.wait();
                int i = (int) (Math.random() * 10000);
                String nom = getName();
                System.out.print("\n Operation :"+nom);
                compte.operationNulle(i);
                int solde = compte.getSolde();
                if (solde != 0) {
                    System.out.println("\n Operation "+nom +":***** solde=" + solde);
                    System.exit(1);
                }
            }
        }}
    public void g(){
        while (true) {
            synchronized (compte){
                int i = (int) (Math.random() * 10000);
                String nom = getName();
                System.out.print("\n Operation :"+nom);
                compte.operationNulle(i);
                int solde = compte.getSolde();
                if (solde != 0) {
                    System.out.println("\n Operation "+nom +":***** solde=" + solde);
                    System.exit(1);
                }
                compte.notify();
            }
        }
    }

}
public class GestionCompte{
    public static void main(String[] args) {
        Compte compte = new Compte();
        Operation op1 = new Operation("A",compte);
        Operation op2 = new Operation("B",compte);
        op1.start();
        op2.start();
    }
}