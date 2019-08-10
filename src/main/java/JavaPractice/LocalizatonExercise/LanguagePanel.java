package LocalizatonExercise;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 *
 * @author Hazar Gul Nazari
 */
public class LanguagePanel implements Initializable {
    
    private boolean isOpen = false;
    
    @FXML
    private AnchorPane helpPanel;
    
    @FXML
    private Text helpText;
    @FXML
    private Button signinButton;
    @FXML
    private Label email;
    @FXML
    private Label password;
    private ResourceBundle messages = ResourceBundle.getBundle("resources.MessagesBundle", Locale.getDefault());
    
    @FXML
    private void helpPage(ActionEvent event) throws IOException {
        if (isOpen) {
            helpPanel.setVisible(false);
            isOpen = false;
        } else {
            helpPanel.setVisible(true);
            isOpen = true;
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //changeText(Locale.US);
        helpPanel.setVisible(false);
    }
    
    @FXML
    private void arabic(ActionEvent event) throws IOException {
        changeText(new Locale("ar", "SA"));
    }
    
    @FXML
    private void english(ActionEvent event) throws IOException {
        changeText(Locale.US);
    }
    
    @FXML
    private void french(ActionEvent event) throws IOException {
        changeText(Locale.FRANCE);        
    }
    
    @FXML
    private void russian(ActionEvent event) throws IOException {
        changeText(new Locale("ru", "RU"));
    }
    
    @FXML
    private void signin(ActionEvent event) throws IOException {
        
    }
    
    private void changeText(Locale locale){
        messages = ResourceBundle.getBundle("resources.MessagesBundle", locale);
        helpText.setText(messages.getString("helpText"));
        email.setText(messages.getString("email"));
        password.setText(messages.getString("password"));
        signinButton.setText(messages.getString("login"));
    }
}
