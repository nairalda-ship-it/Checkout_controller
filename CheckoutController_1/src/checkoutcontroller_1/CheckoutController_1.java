import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckoutController_1 extends Application { // create a  public class

    private TextField nameField      = new TextField(); //create a textfield for name
    private TextField adressField    = new TextField(); // create a texfield for address
    private ComboBox<String> paymentType = new ComboBox<>(); // for paymet type
    private Label feedback = new Label();   // receives feedbck 
    // start method 
    @Override
    public void start(Stage stage) {
        nameField.setPromptText("Name"); //
        adressField.setPromptText("Address"); // 
        paymentType.getItems().addAll("Cash", "Card"); //
        paymentType.setValue("Cash"); // 

        Button confirmBtn = new Button("Confirm"); // create a button to put confirm
        confirmBtn.setOnAction(e -> Confirm()); // 

        feedback.setStyle("-fx-text-fill: red"); // makes the errors to stand out

        VBox root = new VBox(10, nameField, adressField, paymentType, confirmBtn, feedback);
        root.setStyle("-fx-padding: 15;"); // enter the parameters that we want of how ui would look like

        stage.setScene(new Scene(root, 200, 120)); // parameters of the output box 
        stage.setTitle("Checkout"); // 
        stage.show();
    }
    // create a public void confirm
    public void Confirm() { // the if statement
        if (nameField.getText().trim().isEmpty() ||
            adressField.getText().trim().isEmpty() ||
            paymentType.getValue() == null) {

            feedback.setStyle("");
            feedback.setText("Please fill in all information.");
            return;
        }

        feedback.setStyle("-fx-text-fill:green;");
        feedback.setText("Order confirmed!");
    }
    // made a public static void 
    public static void main(String[] args) {
        launch(args);
    }
}
// close the part of this code
// Nairalda Meta