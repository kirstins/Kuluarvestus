import java.util.*;

/**
 * Created by kirstin on 01/02/2017.
 */
public class Kulud {

    ArrayList <String> kululiigid = new ArrayList<>();
    ArrayList <String> kulusummad = new ArrayList<>();
    Random random = new Random();
    String max="maksimaalne väärtus";
    String randomkulu = "valimata";




   public void lisaandmed (String tekst, String tekst2) {
        kululiigid.add(tekst);
        kulusummad.add(tekst2);
       int summa=0;

       for (int i=0; i<kululiigid.size(); i++){
           System.out.println(kululiigid.get(i)+ ": " +(kulusummad.get(i)));
           summa += Integer.parseInt(kulusummad.get(i));
           System.out.println(summa);

         //  for (int j=0; j<kulusummad.size(); j++){
              // System.out.println(kulusummad.get(j));

            //  int  suurus = kulusummad.size();
            //  System.out.println(suurus);
       }

    }

   public int kuludkokku (){
       int sum= 0;

       for (int i=0; i<kululiigid.size(); i++){
           sum += Integer.parseInt(kulusummad.get(i));

       }
       System.out.println(sum);
        return sum;
    }


    public String maxKulu (){
        int max1= Integer.MIN_VALUE;
        for (int i=0; i<kulusummad.size(); i++){
            int tempVariable= Integer.parseInt(kulusummad.get(i));
            String temptempVariable =kululiigid.get(i);
            if(tempVariable>max1){
                max1=tempVariable;
                String max2 = new String(temptempVariable);
              max =new String("Suurim kulu on "+max2+", mis ulatus "+max1+" euroni.");

            }

        }
        return max;
    }
   public String randomKulu(){
       String randomkululiik=kululiigid.get(random.nextInt(kululiigid.size()));
       randomkulu=randomkululiik;
       return randomkululiik;

   }

   public void kustutaKulu(){
       int summa=0;
       System.out.println(randomkulu);
       for (int i=0; i<kulusummad.size(); i++){
           if(kululiigid.get(i).equals(randomkulu)){
               kululiigid.remove(i);
               kulusummad.remove(i);

           }

       }

   }

   public  void kustutaAndmed(){
           kululiigid.clear();
           kulusummad.clear();
       }
   }


