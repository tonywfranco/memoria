package controller;

import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author Tony
 */
public class MemoriaController implements Initializable {

    @FXML
    private ImageView CartaUm;

    @FXML
    private ImageView CartaDois;

    @FXML
    private ImageView CartaTres;

    @FXML
    private ImageView CartaQuatro;

    @FXML
    private ImageView CartaCinco;

    @FXML
    private ImageView CartaSeis;

    @FXML
    private ImageView CartaSete;

    @FXML
    private ImageView CartaOito;

    @FXML
    private ImageView CartaNove;

    @FXML
    private ImageView CartaDez;

    @FXML
    private ImageView CartaOnze;

    @FXML
    private ImageView CartaDoze;

    @FXML
    private ImageView CartaTreze;

    @FXML
    private ImageView CartaCatorze;

    @FXML
    private ImageView CartaQuinze;

    @FXML
    private ImageView CartaDezesseis;

    @FXML
    private ImageView CartaDezessete;

    @FXML
    private ImageView CartaDezoito;

    @FXML
    private ImageView CartaDezenove;

    @FXML
    private ImageView CartaVinte;

    @FXML
    private ImageView CartaVinteUm;

    @FXML
    private ImageView CartaVinteDois;

    @FXML
    private ImageView CartaVinteTres;

    @FXML
    private ImageView CartaVinteQuatro;

    @FXML
    private ImageView ImgTony;

    @FXML
    private ImageView ImgElena;

    @FXML
    private ImageView ImgEmilia;

    @FXML
    private ImageView ImgDaisy;

    @FXML
    private ImageView ImgUrsula;

    @FXML
    private ImageView ImgNatalie;

    @FXML
    private ImageView ImgScarlet;

    @FXML
    private ImageView ImgGal;

    @FXML
    private ImageView ImgKate;

    @FXML
    private Button btJogar;

    @FXML
    private ImageView ImgBaralho;

    @FXML
    private ImageView imgParabens;

    @FXML
    private Text txMinutos;

    @FXML
    private Text txSegundos;

    @FXML
    private Button btRecom;

    @FXML
    private ImageView ImgAline;

    @FXML
    private ImageView ImgEliane;

    @FXML
    private ImageView ImgAloysio;

    @FXML
    private Text txTempo;

    @FXML
    private Text txHelp;

    @FXML
    public CheckBox cbFacil;

    @FXML
    private CheckBox cbMedio;

    @FXML
    private CheckBox cbDificil;

    @FXML
    private CheckBox cbHard;

    int c[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
        20, 21, 22, 23, 24};
    boolean f[] = {false, false, false, false, false, false, false, false, false,
        false, false, false, false, false, false, false, false, false, false,
        false, false, false, false, false};
    int k, b, cont, cont2, cont3, cont4;
    int comparaA, comparaB;
    int posA, posB;
    boolean jogando, relogio, difMed, difDif, difHard;
    int milisegundos, segundos, minutos;
    public Thread t;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        txTempo.setFont(Font.font("calibri", 27));
        txMinutos.setFont(Font.font("digital-7", 30));
        txSegundos.setFont(Font.font("digital-7", 30));
        btRecom.setDisable(true);
        cbFacil.setSelected(true);

        btJogar.setOnAction((event) -> {
            btJogar.setDisable(true);
            jogando = true;
            embaralhar();
            startRelogio();
            if (jogando) {
                btRecom.setDisable(false);
            } else {
                btRecom.setDisable(true);
            }
            cont3 = 0;
            cont4 = 0;
        });

        btRecom.setOnAction((event) -> {
            btJogar.setDisable(false);
            btJogar.requestFocus();
            jogando = false;
            embaralhar();
            btRecom.setDisable(true);
            stopRelogio();
            txMinutos.setText("00");
            txSegundos.setText("00");
            cont3 = 0;
            cont4 = 0;
        });

        abrirCarta(CartaUm, 1);
        abrirCarta(CartaDois, 2);
        abrirCarta(CartaTres, 3);
        abrirCarta(CartaQuatro, 4);
        abrirCarta(CartaCinco, 5);
        abrirCarta(CartaSeis, 6);
        abrirCarta(CartaSete, 7);
        abrirCarta(CartaOito, 8);
        abrirCarta(CartaNove, 9);
        abrirCarta(CartaDez, 10);
        abrirCarta(CartaOnze, 11);
        abrirCarta(CartaDoze, 12);
        abrirCarta(CartaTreze, 13);
        abrirCarta(CartaCatorze, 14);
        abrirCarta(CartaQuinze, 15);
        abrirCarta(CartaDezesseis, 16);
        abrirCarta(CartaDezessete, 17);
        abrirCarta(CartaDezoito, 18);
        abrirCarta(CartaDezenove, 19);
        abrirCarta(CartaVinte, 20);
        abrirCarta(CartaVinteUm, 21);
        abrirCarta(CartaVinteDois, 22);
        abrirCarta(CartaVinteTres, 23);
        abrirCarta(CartaVinteQuatro, 24);

        txHelp.setOnMouseClicked((event) -> {
            mensagemAutoria();
        });

        cbFacil.setOnAction((event) -> {
            cbMedio.setSelected(false);
            cbDificil.setSelected(false);
            btJogar.requestFocus();
            difMed = false;
            difDif = false;
            difHard = false;
        });

        cbMedio.setOnAction((event) -> {
            cbFacil.setSelected(false);
            cbDificil.setSelected(false);
            cbHard.setSelected(false);
            btJogar.requestFocus();
            difDif = false;
            difHard = false;
            difMed = true;
        });

        cbDificil.setOnAction((event) -> {
            cbFacil.setSelected(false);
            cbMedio.setSelected(false);
            cbHard.setSelected(false);
            btJogar.requestFocus();
            difMed = false;
            difHard = false;
            difDif = true;
        });

        cbHard.setOnAction((event) -> {
            cbFacil.setSelected(false);
            cbMedio.setSelected(false);
            cbDificil.setSelected(false);
            btJogar.requestFocus();
            difMed = false;
            difDif = false;
            difHard = true;
        });

        btJogar.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (btJogar.isDisabled()) {
                    cbFacil.setDisable(true);
                    cbMedio.setDisable(true);
                    cbDificil.setDisable(true);
                    cbHard.setDisable(true);
                }
                if (btRecom.isDisabled()) {
                    cbFacil.setDisable(false);
                    cbMedio.setDisable(false);
                    cbDificil.setDisable(false);
                    cbHard.setDisable(false);
                }
            }
        });

        btRecom.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (btRecom.isDisabled()) {
                    cbFacil.setDisable(false);
                    cbMedio.setDisable(false);
                    cbDificil.setDisable(false);
                    cbHard.setDisable(false);
                }
            }
        });

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    private void abrirCarta(ImageView image, int a) {
        image.setOnMouseClicked((event) -> {
            if (jogando) {
                if (cont == 2) {
                    //
                } else {
                    k = a;
                    apresentaPersCarta(k);
                    verificaCartasAbertas();
                }
            } else {
                //
            }
        });
    }

    private void embaralhar() {
        if (btJogar.getText().equals("Jogar Novamente!")) {
            btJogar.setText("Jogar!");
        }
        imgParabens.setVisible(false);
        desfazEfeitos(CartaUm);
        desfazEfeitos(CartaDois);
        desfazEfeitos(CartaTres);
        desfazEfeitos(CartaQuatro);
        desfazEfeitos(CartaCinco);
        desfazEfeitos(CartaSeis);
        desfazEfeitos(CartaSete);
        desfazEfeitos(CartaOito);
        desfazEfeitos(CartaNove);
        desfazEfeitos(CartaDez);
        desfazEfeitos(CartaOnze);
        desfazEfeitos(CartaDoze);
        desfazEfeitos(CartaTreze);
        desfazEfeitos(CartaCatorze);
        desfazEfeitos(CartaQuinze);
        desfazEfeitos(CartaDezesseis);
        desfazEfeitos(CartaDezessete);
        desfazEfeitos(CartaDezoito);
        desfazEfeitos(CartaDezenove);
        desfazEfeitos(CartaVinte);
        desfazEfeitos(CartaVinteUm);
        desfazEfeitos(CartaVinteDois);
        desfazEfeitos(CartaVinteTres);
        desfazEfeitos(CartaVinteQuatro);
        CartaUm.setImage(ImgBaralho.getImage());
        CartaDois.setImage(ImgBaralho.getImage());
        CartaTres.setImage(ImgBaralho.getImage());
        CartaQuatro.setImage(ImgBaralho.getImage());
        CartaCinco.setImage(ImgBaralho.getImage());
        CartaSeis.setImage(ImgBaralho.getImage());
        CartaSete.setImage(ImgBaralho.getImage());
        CartaOito.setImage(ImgBaralho.getImage());
        CartaNove.setImage(ImgBaralho.getImage());
        CartaDez.setImage(ImgBaralho.getImage());
        CartaOnze.setImage(ImgBaralho.getImage());
        CartaDoze.setImage(ImgBaralho.getImage());
        CartaTreze.setImage(ImgBaralho.getImage());
        CartaCatorze.setImage(ImgBaralho.getImage());
        CartaQuinze.setImage(ImgBaralho.getImage());
        CartaDezesseis.setImage(ImgBaralho.getImage());
        CartaDezessete.setImage(ImgBaralho.getImage());
        CartaDezoito.setImage(ImgBaralho.getImage());
        CartaDezenove.setImage(ImgBaralho.getImage());
        CartaVinte.setImage(ImgBaralho.getImage());
        CartaVinteUm.setImage(ImgBaralho.getImage());
        CartaVinteDois.setImage(ImgBaralho.getImage());
        CartaVinteTres.setImage(ImgBaralho.getImage());
        CartaVinteQuatro.setImage(ImgBaralho.getImage());
        sortear();
        cont = 0;
        comparaA = 0;
        comparaB = 0;
        posA = 0;
        posB = 0;
        for (int i = 0; i < f.length; i++) {
            f[i] = false;
        }
    }

    private void sortear() {
        desordenarCartas(c);
    }

    public void aumentarDificuldade() {
        int contaTrue = 0;

        for (int i = 0; i < f.length; i++) {
            if (f[i] == true) {
                contaTrue = contaTrue + 1;
            }
        }

        int d[] = new int[f.length - contaTrue];

        for (int i = 0; i < f.length; i++) {
            if (f[i] == false) {
                for (int j = cont2; j < d.length; j++) {
                    d[j] = c[i];
                    cont2 = cont2 + 1;
                    break;
                }
            }
        }
        cont2 = 0;

        desordenarCartas(d);

        for (int i = 0; i < f.length; i++) {
            if (f[i] == false) {
                for (int j = cont2; j < d.length; j++) {
                    c[i] = d[j];
                    cont2 = cont2 + 1;
                    break;
                }
            }
        }
        cont2 = 0;
    }

    private void desordenarCartas(int[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    private void apresentaPersCarta(int k) {
        for (int i = k - 1; i < k; i++) {
            b = c[i];
            f[i] = true;

            cont = cont + 1;
            if (posA == 0) {
                posA = i + 1;
            } else {
                posB = i + 1;
            }
            if (comparaA == 0) {
                comparaA = b;
            } else {
                comparaB = b;
            }

            ImageView imageview = null;

            if (b == 1 || b == 3) {
                imageview = ImgTony;
            } else if (b == 2 || b == 4) {
                imageview = ImgElena;
            } else if (b == 5 || b == 6) {
                imageview = ImgAline;
            } else if (b == 7 || b == 8) {
                imageview = ImgEliane;
            } else if (b == 9 || b == 10) {
                imageview = ImgAloysio;
            } else if (b == 11 || b == 12) {
                imageview = ImgEmilia;
            } else if (b == 13 || b == 14) {
                imageview = ImgKate;
            } else if (b == 15 || b == 16) {
                imageview = ImgScarlet;
            } else if (b == 17 || b == 18) {
                imageview = ImgDaisy;
            } else if (b == 19 || b == 20) {
                imageview = ImgUrsula;
            } else if (b == 21 || b == 22) {
                imageview = ImgNatalie;
            } else if (b == 23 || b == 24) {
                imageview = ImgGal;
            }

            if (k == 1) {
                CartaUm.setImage(imageview.getImage());
            } else if (k == 2) {
                CartaDois.setImage(imageview.getImage());
            } else if (k == 3) {
                CartaTres.setImage(imageview.getImage());
            } else if (k == 4) {
                CartaQuatro.setImage(imageview.getImage());
            } else if (k == 5) {
                CartaCinco.setImage(imageview.getImage());
            } else if (k == 6) {
                CartaSeis.setImage(imageview.getImage());
            } else if (k == 7) {
                CartaSete.setImage(imageview.getImage());
            } else if (k == 8) {
                CartaOito.setImage(imageview.getImage());
            } else if (k == 9) {
                CartaNove.setImage(imageview.getImage());
            } else if (k == 10) {
                CartaDez.setImage(imageview.getImage());
            } else if (k == 11) {
                CartaOnze.setImage(imageview.getImage());
            } else if (k == 12) {
                CartaDoze.setImage(imageview.getImage());
            } else if (k == 13) {
                CartaTreze.setImage(imageview.getImage());
            } else if (k == 14) {
                CartaCatorze.setImage(imageview.getImage());
            } else if (k == 15) {
                CartaQuinze.setImage(imageview.getImage());
            } else if (k == 16) {
                CartaDezesseis.setImage(imageview.getImage());
            } else if (k == 17) {
                CartaDezessete.setImage(imageview.getImage());
            } else if (k == 18) {
                CartaDezoito.setImage(imageview.getImage());
            } else if (k == 19) {
                CartaDezenove.setImage(imageview.getImage());
            } else if (k == 20) {
                CartaVinte.setImage(imageview.getImage());
            } else if (k == 21) {
                CartaVinteUm.setImage(imageview.getImage());
            } else if (k == 22) {
                CartaVinteDois.setImage(imageview.getImage());
            } else if (k == 23) {
                CartaVinteTres.setImage(imageview.getImage());
            } else if (k == 24) {
                CartaVinteQuatro.setImage(imageview.getImage());
            }
        }
    }

    private void verificaCartasAbertas() {
        if (cont == 2) {
            for (int i = 0; i < f.length; i++) {
                if (f[0] == false) {
                    CartaUm.setImage(ImgBaralho.getImage());
                }
                if (f[1] == false) {
                    CartaDois.setImage(ImgBaralho.getImage());
                }
                if (f[2] == false) {
                    CartaTres.setImage(ImgBaralho.getImage());
                }
                if (f[3] == false) {
                    CartaQuatro.setImage(ImgBaralho.getImage());
                }
                if (f[4] == false) {
                    CartaCinco.setImage(ImgBaralho.getImage());
                }
                if (f[5] == false) {
                    CartaSeis.setImage(ImgBaralho.getImage());
                }
                if (f[6] == false) {
                    CartaSete.setImage(ImgBaralho.getImage());
                }
                if (f[7] == false) {
                    CartaOito.setImage(ImgBaralho.getImage());
                }
                if (f[8] == false) {
                    CartaNove.setImage(ImgBaralho.getImage());
                }
                if (f[9] == false) {
                    CartaDez.setImage(ImgBaralho.getImage());
                }
                if (f[10] == false) {
                    CartaOnze.setImage(ImgBaralho.getImage());
                }
                if (f[11] == false) {
                    CartaDoze.setImage(ImgBaralho.getImage());
                }
                if (f[12] == false) {
                    CartaTreze.setImage(ImgBaralho.getImage());
                }
                if (f[13] == false) {
                    CartaCatorze.setImage(ImgBaralho.getImage());
                }
                if (f[14] == false) {
                    CartaQuinze.setImage(ImgBaralho.getImage());
                }
                if (f[15] == false) {
                    CartaDezesseis.setImage(ImgBaralho.getImage());
                }
                if (f[16] == false) {
                    CartaDezessete.setImage(ImgBaralho.getImage());
                }
                if (f[17] == false) {
                    CartaDezoito.setImage(ImgBaralho.getImage());
                }
                if (f[18] == false) {
                    CartaDezenove.setImage(ImgBaralho.getImage());
                }
                if (f[19] == false) {
                    CartaVinte.setImage(ImgBaralho.getImage());
                }
                if (f[20] == false) {
                    CartaVinteUm.setImage(ImgBaralho.getImage());
                }
                if (f[21] == false) {
                    CartaVinteDois.setImage(ImgBaralho.getImage());
                }
                if (f[22] == false) {
                    CartaVinteTres.setImage(ImgBaralho.getImage());
                }
                if (f[23] == false) {
                    CartaVinteQuatro.setImage(ImgBaralho.getImage());
                }
            }
            //1- Tony
            //2- Elena
            //3- Tony
            //4- Elena
            //5- Aline
            //6- Aline
            //7- Eliane
            //8- Eliane
            //9- Aloysio
            //10- Aloysio
            //11- Emilia
            //12- Emilia
            //13- Kate
            //14- Kate
            //15- Scarlet
            //16- Scarlet
            //17- Daisy
            //18- Daisy
            //19- Ursula
            //20- Ursula
            //21- Natalie
            //22- Natalie
            //23- Gal
            //24- Gal
            if ((comparaA == 1 && comparaB == 3) || (comparaA == 3 && comparaB == 1) || (comparaA == 2 && comparaB == 4) || (comparaA == 4 && comparaB == 2)
                    || (comparaA == 5 && comparaB == 6) || (comparaA == 6 && comparaB == 5) || (comparaA == 7 && comparaB == 8) || (comparaA == 8 && comparaB == 7)
                    || (comparaA == 9 && comparaB == 10) || (comparaA == 10 && comparaB == 9) || (comparaA == 11 && comparaB == 12) || (comparaA == 12 && comparaB == 11)
                    || (comparaA == 13 && comparaB == 14) || (comparaA == 14 && comparaB == 13) || (comparaA == 15 && comparaB == 16) || (comparaA == 16 && comparaB == 15)
                    || (comparaA == 17 && comparaB == 18) || (comparaA == 18 && comparaB == 17) || (comparaA == 19 && comparaB == 20) || (comparaA == 20 && comparaB == 19)
                    || (comparaA == 21 && comparaB == 22) || (comparaA == 22 && comparaB == 21) || (comparaA == 23 && comparaB == 24) || (comparaA == 24 && comparaB == 23)) {

                switch (posA) {
                    case 1:
                        efeitos(CartaUm);
                        break;
                    case 2:
                        efeitos(CartaDois);
                        break;
                    case 3:
                        efeitos(CartaTres);
                        break;
                    case 4:
                        efeitos(CartaQuatro);
                        break;
                    case 5:
                        efeitos(CartaCinco);
                        break;
                    case 6:
                        efeitos(CartaSeis);
                        break;
                    case 7:
                        efeitos(CartaSete);
                        break;
                    case 8:
                        efeitos(CartaOito);
                        break;
                    case 9:
                        efeitos(CartaNove);
                        break;
                    case 10:
                        efeitos(CartaDez);
                        break;
                    case 11:
                        efeitos(CartaOnze);
                        break;
                    case 12:
                        efeitos(CartaDoze);
                        break;
                    case 13:
                        efeitos(CartaTreze);
                        break;
                    case 14:
                        efeitos(CartaCatorze);
                        break;
                    case 15:
                        efeitos(CartaQuinze);
                        break;
                    case 16:
                        efeitos(CartaDezesseis);
                        break;
                    case 17:
                        efeitos(CartaDezessete);
                        break;
                    case 18:
                        efeitos(CartaDezoito);
                        break;
                    case 19:
                        efeitos(CartaDezenove);
                        break;
                    case 20:
                        efeitos(CartaVinte);
                        break;
                    case 21:
                        efeitos(CartaVinteUm);
                        break;
                    case 22:
                        efeitos(CartaVinteDois);
                        break;
                    case 23:
                        efeitos(CartaVinteTres);
                        break;
                    case 24:
                        efeitos(CartaVinteQuatro);
                        break;
                    default:
                        break;
                }
                switch (posB) {
                    case 1:
                        efeitos(CartaUm);
                        break;
                    case 2:
                        efeitos(CartaDois);
                        break;
                    case 3:
                        efeitos(CartaTres);
                        break;
                    case 4:
                        efeitos(CartaQuatro);
                        break;
                    case 5:
                        efeitos(CartaCinco);
                        break;
                    case 6:
                        efeitos(CartaSeis);
                        break;
                    case 7:
                        efeitos(CartaSete);
                        break;
                    case 8:
                        efeitos(CartaOito);
                        break;
                    case 9:
                        efeitos(CartaNove);
                        break;
                    case 10:
                        efeitos(CartaDez);
                        break;
                    case 11:
                        efeitos(CartaOnze);
                        break;
                    case 12:
                        efeitos(CartaDoze);
                        break;
                    case 13:
                        efeitos(CartaTreze);
                        break;
                    case 14:
                        efeitos(CartaCatorze);
                        break;
                    case 15:
                        efeitos(CartaQuinze);
                        break;
                    case 16:
                        efeitos(CartaDezesseis);
                        break;
                    case 17:
                        efeitos(CartaDezessete);
                        break;
                    case 18:
                        efeitos(CartaDezoito);
                        break;
                    case 19:
                        efeitos(CartaDezenove);
                        break;
                    case 20:
                        efeitos(CartaVinte);
                        break;
                    case 21:
                        efeitos(CartaVinteUm);
                        break;
                    case 22:
                        efeitos(CartaVinteDois);
                        break;
                    case 23:
                        efeitos(CartaVinteTres);
                        break;
                    case 24:
                        efeitos(CartaVinteQuatro);
                        break;
                    default:
                        break;
                }
                cont = 0;
                comparaA = 0;
                comparaB = 0;
                posA = 0;
                posB = 0;
                cont3 = cont3 + 1;
                if ((cbMedio.isSelected()) && (cont3 == (c.length / 2))) {
                    aumentarDificuldade();
                }
                if ((cbDificil.isSelected()) && (cont3 % 2 == 0)) {
                    aumentarDificuldade();
                }
            } else {

                switch (posA) {
                    case 1:
                        efeitos2(CartaUm);
                        break;
                    case 2:
                        efeitos2(CartaDois);
                        break;
                    case 3:
                        efeitos2(CartaTres);
                        break;
                    case 4:
                        efeitos2(CartaQuatro);
                        break;
                    case 5:
                        efeitos2(CartaCinco);
                        break;
                    case 6:
                        efeitos2(CartaSeis);
                        break;
                    case 7:
                        efeitos2(CartaSete);
                        break;
                    case 8:
                        efeitos2(CartaOito);
                        break;
                    case 9:
                        efeitos2(CartaNove);
                        break;
                    case 10:
                        efeitos2(CartaDez);
                        break;
                    case 11:
                        efeitos2(CartaOnze);
                        break;
                    case 12:
                        efeitos2(CartaDoze);
                        break;
                    case 13:
                        efeitos2(CartaTreze);
                        break;
                    case 14:
                        efeitos2(CartaCatorze);
                        break;
                    case 15:
                        efeitos2(CartaQuinze);
                        break;
                    case 16:
                        efeitos2(CartaDezesseis);
                        break;
                    case 17:
                        efeitos2(CartaDezessete);
                        break;
                    case 18:
                        efeitos2(CartaDezoito);
                        break;
                    case 19:
                        efeitos2(CartaDezenove);
                        break;
                    case 20:
                        efeitos2(CartaVinte);
                        break;
                    case 21:
                        efeitos2(CartaVinteUm);
                        break;
                    case 22:
                        efeitos2(CartaVinteDois);
                        break;
                    case 23:
                        efeitos2(CartaVinteTres);
                        break;
                    case 24:
                        efeitos2(CartaVinteQuatro);
                        break;
                    default:
                        break;
                }
                switch (posB) {
                    case 1:
                        efeitos2(CartaUm);
                        break;
                    case 2:
                        efeitos2(CartaDois);
                        break;
                    case 3:
                        efeitos2(CartaTres);
                        break;
                    case 4:
                        efeitos2(CartaQuatro);
                        break;
                    case 5:
                        efeitos2(CartaCinco);
                        break;
                    case 6:
                        efeitos2(CartaSeis);
                        break;
                    case 7:
                        efeitos2(CartaSete);
                        break;
                    case 8:
                        efeitos2(CartaOito);
                        break;
                    case 9:
                        efeitos2(CartaNove);
                        break;
                    case 10:
                        efeitos2(CartaDez);
                        break;
                    case 11:
                        efeitos2(CartaOnze);
                        break;
                    case 12:
                        efeitos2(CartaDoze);
                        break;
                    case 13:
                        efeitos2(CartaTreze);
                        break;
                    case 14:
                        efeitos2(CartaCatorze);
                        break;
                    case 15:
                        efeitos2(CartaQuinze);
                        break;
                    case 16:
                        efeitos2(CartaDezesseis);
                        break;
                    case 17:
                        efeitos2(CartaDezessete);
                        break;
                    case 18:
                        efeitos2(CartaDezoito);
                        break;
                    case 19:
                        efeitos2(CartaDezenove);
                        break;
                    case 20:
                        efeitos2(CartaVinte);
                        break;
                    case 21:
                        efeitos2(CartaVinteUm);
                        break;
                    case 22:
                        efeitos2(CartaVinteDois);
                        break;
                    case 23:
                        efeitos2(CartaVinteTres);
                        break;
                    case 24:
                        efeitos2(CartaVinteQuatro);
                        break;
                    default:
                        break;
                }
                for (int i = 0; i < c.length; i++) {
                    if (posA == i + 1) {
                        f[i] = false;
                    }
                    if (posB == i + 1) {
                        f[i] = false;
                    }
                }
                cont = 0;
                comparaA = 0;
                comparaB = 0;
                posA = 0;
                posB = 0;
                cont4 = cont4 + 1;
                if ((cbHard.isSelected()) && (cont4 % 3 == 0)) {
                    aumentarDificuldade();
                }
            }
        }
    }

    private void efeitos(ImageView imageview) {
        PauseTransition pause = new PauseTransition(Duration.seconds(1.0));
        imageview.setFitWidth(115);
        imageview.setFitHeight(155);
        pause.setOnFinished(evt -> {
            jogando = true;
            imageview.setVisible(false);
        });
        pause.play();
        jogando = false;
        terminouJogo();
    }

    private void efeitos2(ImageView imageview) {
        imageview.setFitWidth(115);
        imageview.setFitHeight(155);
        PauseTransition pause = new PauseTransition(Duration.seconds(1.0));
        pause.setOnFinished(evt -> {
            jogando = true;
            imageview.setImage(ImgBaralho.getImage());
            desfazEfeitos(imageview);
        });
        pause.play();
        jogando = false;
    }

    private void desfazEfeitos(ImageView imageview) {
        imageview.setFitWidth(100);
        imageview.setFitHeight(150);
        imageview.setVisible(true);
    }

    private void terminouJogo() {
        int tudoTrue = 0;
        for (int i = 0; i < f.length; i++) {
            if (f[i] == true) {
                tudoTrue = tudoTrue + 1;
            }
        }
        if (tudoTrue == f.length) {
            PauseTransition pause = new PauseTransition(Duration.seconds(1.4));
            pause.setOnFinished(evt -> {
                imgParabens.setVisible(true);
                btJogar.setDisable(false);
                btJogar.setText("Jogar Novamente!");
                btRecom.setDisable(true);
                stopRelogio();
            });
            pause.play();
            jogando = false;
        }
    }

    private void startRelogio() {
        relogio = true;
        minutos = 0;
        segundos = 0;
        milisegundos = 0;

        t = new Thread() {
            @Override
            public void run() {
                for (;;) {
                    if (relogio == true) {
                        try {
                            sleep(1);
//                            if (milisegundos > 599) {
                            if (milisegundos > 999) {
                                milisegundos = 0;
                                segundos++;
                            }
                            if (segundos > 59) {
                                segundos = 00;
                                minutos++;
                            }
                            if (minutos > 59) {
                                minutos = 00;
                            }

                            milisegundos++;

                            if (segundos < 10) {
                                txSegundos.setText(String.valueOf("0" + segundos));
                            } else {
                                txSegundos.setText(String.valueOf(segundos));
                            }
                            if (minutos < 10) {
                                txMinutos.setText(String.valueOf("0" + minutos));
                            } else {
                                txMinutos.setText(String.valueOf(minutos));
                            }
                        } catch (Exception e) {
                        }
                    } else {
                        break;
                    }
                }
            }
        };
        t.start();
    }

    private void stopRelogio() {
        relogio = false;
    }

    public void mensagemAutoria() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setHeaderText("Elena Memorizadora 1.0");
        alert.setContentText("Trata-se de um jogo de memória simples, com família"
                + "\n" + "e grandes atrizes, para a sobrinha amada treinar sua"
                + "\n" + "capacidade de memorização.\n"
                + "\n" + "Enviar dúvidas/erros/sugestões para o e-mail: 'tonywillyfranco@hotmail.com'.\n"
                + "\n" + "Programado por Tony Franco em Abril-Maio/2020.\n");
        alert.getDialogPane().setPrefSize(400, 340);
        alert.showAndWait();
    }
}
