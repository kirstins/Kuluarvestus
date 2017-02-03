import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kirstin on 01/02/2017.
 */
public class Aken {
    Stage stage = new Stage();
    VBox vbox;
    Scene scene;
    Button button;
    TextField palk;
    TextField kululiik;
    TextField kulu;
    Label label1;
    Label label2;
    int sissetulek;
    String tekst;
    String tekst2;
    Kulud kulud = new Kulud();
    /*ArrayList <String> kululiigid = new ArrayList<>();
    ArrayList <String> kulusummad = new ArrayList <>();*/


    public Aken (){
        seadistaakaen ();
        sisestaPalk ();
        sisestaKulud ();
    }



    private void seadistaakaen() {
        vbox = new VBox();
        scene = new Scene(vbox, 500, 500);
        stage.setScene(scene);
        stage.show();

        palk = new TextField();
        palk.setPromptText("Sisesta palk");

        kululiik = new TextField();
        kululiik.setPromptText("Sisesta kululiik");

        kulu = new TextField();
        kulu.setPromptText("Sisesta kulu suurus");

        button = new Button("Salvesta kulu");

        label1 = new Label("Alles on kogu palk");

        label2 = new Label("Maksimaalne kulu ilmub siia");




        vbox.getChildren().addAll(palk, kululiik, kulu, button,label1, label2);

    }
    private void sisestaPalk() {
        palk.textProperty().addListener((observable, vanaVaartus, uusVaartus) -> {
            kulud.kustutaAndmed();
            label1.setText("Alles on kogu palk");
            label2.setText("Maksimaalne kulu ilmub siia");
            sissetulek = Integer.parseInt(uusVaartus);


    });
    }
        private void sisestaKulud() {

            button.setOnAction(event-> {

                        tekst = kululiik.getText();
                        tekst2 = kulu.getText();
                if (Integer.parseInt(tekst2)>sissetulek){
                    System.out.println("Kulu on suurem kui sissetulek!");
                }
                else if (Integer.parseInt(tekst2)<(sissetulek)- kulud.kuludkokku()){
                    kulud.lisaandmed(tekst, tekst2);
                   int rahaalles = sissetulek - kulud.kuludkokku();
                    String info = new String("Alles on "+rahaalles+" eurot");
                    String info2 = new String(kulud.maxKulu());
                    label1.setText(info);
                    kulud.maxKulu();
                    label2.setText(info2);

                }
                else{
                    VBox vbox2 = new VBox();
                    Scene scene2 = new Scene (vbox2, 500, 500);
                    stage.setScene(scene2);
                    stage.show();
                    Label label3=new Label();
                    Button button3= new Button("Jah, olen nõus!");
                    Button button4= new Button ("Ei ole nõus!");
                    vbox2.getChildren().addAll(label3, button3, button4);
                    label3.setText(" Kas sa oled valmis järgmisest kulust loobuma: "+kulud.randomKulu()+"?");
                    button3.setOnAction(event2->{
                        kulud.kustutaKulu();
                        stage.setScene(scene);
                        stage.show();
                        int rahaalles = sissetulek - kulud.kuludkokku();
                        String info = new String("Alles on "+rahaalles+" eurot");
                        String info2 = new String(kulud.maxKulu());
                        label1.setText(info);
                        kulud.maxKulu();
                        label2.setText(info2);

                    });

                    button4.setOnAction(event3->{
                        label3.setText(" Kas sa oled valmis järgmisest kulust loobuma: "+kulud.randomKulu()+"?");

                    });
                }
                kululiik.clear();
                kulu.clear();
               /* System.out.println(kululiigid.size());
                for (int i=0; i<kululiigid.size(); i++){
                    System.out.println(kululiigid.get(i));
                }
            });





        }

    private void loobuKulust() {*/


});

        }

}