//package at.spengergasse.graphene_POS_T;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.ButtonType;
//import javafx.stage.Stage;
//
//
//
//public class Main extends Application
//{
//    public void start(Stage primaryStage)
//    {
//        try
//        {
//            RootBorderPane root = new RootBorderPane();
//            Scene scene = new Scene(root, 1600, 900);
//            primaryStage.setTitle("Graphene");
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        }
//        catch (Exception e)
//        {
//            showAlert(AlertType.ERROR, e.getMessage());
//        }
//    }
//    public static void showAlert(AlertType alertType, String message)
//    {
//        Alert alert = new Alert(alertType, message, ButtonType.OK);
//        alert.setTitle("Hinweis");
//        alert.setHeaderText(null);  // nice to have
//        alert.showAndWait();  //...andWait ... modality
//    }
//    public static void main(String[] args)
//    {
//        launch(args);
//    }
//}
