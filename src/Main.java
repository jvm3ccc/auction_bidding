public class Main {

    public static void main(String[] args) {
        String[] input = new String[]{"1","47","6a","17","kl","5","kl","10","kl","15","cs","28","kl","20","kl","25","hr","35","hr","40","hr","41","hl","42","hr","43","hr","44","hl","44","hl","49","hr","47"};
        //</editor-fold>
        //String[] input = new String[]{"1","0","nepper","15","hamster","24","philipp","30","mmautne","31","hamster","49","hamster","55","thebenil","57","fliegimandi","59","ev","61","philipp","64","philipp","65","ev","74","philipp","69","philipp","71","fliegimandi","78","hamster","78","mio","95","hamster","103","macquereauxpl","135"};


        int sofort = Integer.parseInt(input[1]);
        int aP = Integer.parseInt(input[0]);    // Aktueller Preis
        int hp = aP;                             // Hchstpreis
        String biet = null;                     // Aktueller Hoechstbieter
        String tempBiet = null;                 // Aktueller Bieter
        System.out.print("-," + aP + ",");


        for (int i = 2; i < input.length; i++){
            //if index is odd, bieter it is
            if (i % 2 == 0){
                if (biet == null){
                    biet = input[i];
                    tempBiet = biet;
                } else {
                    tempBiet = input[i];
                }
            } else {
                int current = Integer.parseInt(input[i]);   // Aktuelle Wert im Array

                if(biet.equals(tempBiet)) {
                    hp = current;
                    System.out.print(biet + "," + aP +",");
                    continue;
                }

                if (current > hp && biet == null){
                    hp = current;
                    biet = tempBiet;

                    System.out.println(biet + "," + aP +",");
                    continue;

                }

                if (current > hp){      // Ist Bieter hoeher als akuteller Preis
                    aP = ++hp;          // Erhoehe letzten aktuellen Preis um 1
                    if (sofort > 0 && sofort <= aP){
                        System.out.print(biet + "," + sofort +",");
                        break;
                    }
                    hp = current;       // neuer hoechstpreis = aktueller wert
                    biet = tempBiet;    // Setze neuen Hoechstbieter
                    System.out.print(biet + "," + aP +",");

                } else if (current == hp){
                    aP = hp;

                    if (sofort > 0 && sofort <= aP){
                        System.out.print(biet + "," + sofort +",");
                        break;
                    }
                    System.out.print(biet + "," + aP +",");

                } else {
                    aP = current+1;
                    System.out.print(biet + "," + aP+",");
                }
            }
        }

    //    System.out.println(biet + "," + aP);
    }


}
