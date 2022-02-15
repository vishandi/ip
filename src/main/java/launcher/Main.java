package launcher;

import java.io.IOException;

import duke.Duke;
import duke.DukeException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {

    private Duke duke = new Duke("./data/", "TaskList.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setTitle("Hendri the Butler");
            stage.setScene(scene);
            duke.initialize();
            fxmlLoader.<MainWindow>getController().setDuke(duke);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DukeException e) {
            e.printStackTrace();
        }
    }
}
