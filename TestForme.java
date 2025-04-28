import java.util.*;
interface DbServices{
public void addDB();
public void deleteDB();
}
abstract class Forme{
int color;
Forme(int color){this.color = color;}
abstract float surf();
}
class Rect extends Forme implements DbServices{
float l, L;
float surf(){ return L*l;}
public Rect(float l, float L, int color){
super(color); this.l=l; this.L=L;
}
public void addDB(){
System.out.println("Ajout avec succes du" + "rect [color], long. [L] et largeur[l]");
}
public void deleteDB(){
System.out.println("supp avec succes du" + "du rectangle [color], long. [L] et largeur [l]");
}
}
class Cercle extends Forme implements DbServices{
float r;
float surf(){ return (float)(3.14*r*r);}
public Cercle(float r, int color){
super(color); this.r=r;
}
public void addDB(){
System.out.println("Ajout avec succes du" + "cercle [color], du rayon [r]");
}
public void deleteDB(){
System.out.println("supp avec succes du" + "du cercle [color],du rayon [r]");
}
}
public class TestForme {
public static void main(String []args){
// Forme x = new Form(); // ERR
//x.surf();
Vector<Forme> dessin = new Vector<Forme>();
dessin.add(new Rect(100,50,1));
dessin.add(new Cercle(10 ,3));
dessin.add(new Rect(70,20 ,4));
dessin.add(new Rect(100,50,1));
EEA2/grp2 :
Ahmed Slimendessin.add(new Cercle(15 ,7));
for (Forme F : dessin)
((DbServices)F).addDB();
}
}