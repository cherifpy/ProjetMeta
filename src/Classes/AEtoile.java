package Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AEtoile {

    private ETaquin debut;
    private ETaquin fin;

    public ETaquin getDebut() {return debut;}
    public void setDebut(ETaquin debut) {this.debut = debut;}

    public ETaquin getFin() {return fin;}
    public void setFin(ETaquin fin) {this.fin = fin;}

    AEtoile(ETaquin debut,ETaquin fin){
        this.debut = debut;
        this.fin = fin;

    }


    public ArrayList<Integer> Resolution(){


        ArrayList closes = new <ETaquin>ArrayList();
        ArrayList opens = new <ETaquin>ArrayList();

        ETaquin inter = null;
        ArrayList <Integer>regle_ = new ArrayList<Integer>();

        if(this.debut.getTab() == this.fin.getTab()){
            System.out.println("Le but est deja attient aucun mouvement a faire!");
            return new ArrayList<Integer>();

        }else{
            closes.add(this.debut);

            while(true) {

                if(closes.isEmpty()){
                    return null;
                }
                inter = (ETaquin) closes.remove(0);
                opens.add(inter);
                if(Arrays.deepEquals(inter.getTab(),this.fin.getTab())){
                    System.out.println("\nEtat but:");
                    inter.PrintTaquin();
                    break;
                }
                regle_ = inter.getRegles_App();
                for(int r: regle_) {
                    Boolean trouver = false;
                    ETaquin new_ = new ETaquin(inter, r);
                    int i = 0;
                    while ((!trouver) && (i < opens.size())) {
                        ETaquin elem = (ETaquin) opens.get(i);
                        if (Arrays.deepEquals(elem.getTab(), new_.getTab())) {
                            trouver = true;
                        }
                        i++;
                    }
                    if (!trouver) {
                        closes.add(new_);
                    }
                }
                Collections.sort(closes, new ComparatorTaquin(fin));
            }
        }

        return inter.getRegles();

    }

}
