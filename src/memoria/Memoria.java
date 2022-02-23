package memoria;

import controller.MemoriaController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Tony
 */
public class Memoria extends Application {

    private static Stage stage;
    private Scene scene;
    MemoriaController controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Font.loadFont(getClass().getResourceAsStream("/fontes/digital-7.ttf"), 80);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Memoria.fxml"));
            Parent painel = loader.load();
            scene = new Scene(painel);
            stage.setScene(scene);
            stage.setMaximized(false);//janela inteira
            stage.setTitle("Elena Memorizadora 1.0");
            stage.setResizable(false);
            stage.show();

            controller = loader.getController();
            scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
                if (event.getCode() == KeyCode.H) {
                    controller.mensagemAutoria();
                }
            });
            stage.setOnCloseRequest((event) -> {
                try {
                    controller.t.stop();
                    controller.t.interrupt();
                    controller.t.isInterrupted();
                } catch (Exception e) {
                }
            });
        } catch (IOException e) {
        }

    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Memoria.stage = stage;
    }
}
