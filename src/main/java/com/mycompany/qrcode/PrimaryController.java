/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.qrcode;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class PrimaryController implements Initializable {

    @FXML
    private TextField txtBox;
    @FXML
    private ImageView imgView;
    @FXML
    private Button button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void buttonClicked(MouseEvent event) {

        if (txtBox.getText().length() < 1) {
            return;
        }
        imgView.setCache(false);
        imgView.imageProperty().set(null);
        imgView.setImage(null);

        String file = "";
        try {
            file = createQR(txtBox.getText(), new File("qrcode.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        imgView.setImage(new Image(file));
    }

    public static String createQR(String url, File f) throws FileNotFoundException {
        ByteArrayOutputStream out = QRCode.from(url).to(ImageType.PNG).stream();
        try ( FileOutputStream fos = new FileOutputStream(f)) {
            fos.write(out.toByteArray());
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return f.getAbsolutePath();
    }
}
