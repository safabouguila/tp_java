import java.util.Vector;
// Interface pour les objets empruntables
interface Empruntable {
void emprunter();
void retourner();
void listerEmprunts();
}
interface Dbservices{
public void addDB();
public void deletDB();
}
// Classe abstraite Ouvrage
abstract class Ouvrage {
protected String titre;
public Ouvrage(String titre) {
this.titre = titre;
}
public abstract void afficherInfo();
}
// Sous-classe Livre
class Livre extends Ouvrage implements Empruntable,Dbservices {
private String auteur;
private int nbPages;
public Livre(String titre, String auteur, int nbPages) {
super(titre);
this.auteur = auteur;
this.nbPages = nbPages;
}@Override
public void afficherInfo() {
System.out.println("Livre : " + titre + ", Auteur : " + auteur + ", Pages : " + nbPages);
}
@Override
public void emprunter() {
System.out.println("Le livre '" + titre + "' a été emprunté.");
}
@Override
public void retourner() {
System.out.println("Le livre '" + titre + "' a été retourné.");
}
@Override
public void listerEmprunts() {
System.out.println("Livre emprunté : " + titre);
}
public void addDB(){
System.out.println("Ajout Le livre " + titre);
}
public void deletDB(){
System.out.println("supp Le livre " + titre);
}
}
// Sous-classe Magazine
class Magazine extends Ouvrage implements Empruntable,Dbservices {
private int numero;
public Magazine(String titre, int numero) {
super(titre);
this.numero = numero;
}
@Override
public void afficherInfo() {
System.out.println("Magazine : " + titre + ", Numéro : " + numero);
}
@Override
public void emprunter() {
System.out.println("Le magazine '" + titre + "' a été emprunté.");
}
@Override
public void retourner() {
System.out.println("Le magazine '" + titre + "' a été retourné.");
}
@Override
public void listerEmprunts() {
System.out.println("Magazine emprunté : " + titre);
}
public void addDB(){
System.out.println("Ajout Le livre " + titre);
}
public void deletDB(){System.out.println("supp Le livre " + titre);
}
}
// Programme principal
public class Main {
public static void main(String[] args) {
Vector<Empruntable> bib = new Vector<>();
bib.add(new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 96));
bib.add(new Magazine("Science & Vie", 123));
for (Empruntable e : bib) {
e.emprunter();
}
for (Empruntable e : bib) {
e.listerEmprunts();
}
for (Empruntable e : bib) {
((Dbservices)e).addDB();
}
}
}