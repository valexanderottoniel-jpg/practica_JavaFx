/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.productos.app;

import com.practica.productos.modelo.Producto;
import com.practica.productos.servicio.ProductoService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;  


public class Main extends Application {
    ProductoService servicio = new ProductoService();
    @Override
    public void start(Stage stage) {
    TextField campo = new TextField();
    Button boton = new Button("Mostrar");
    Label label = new Label();
    boton.setOnAction(e -> {
        servicio.agregar(new Producto(campo.getText()));
String texto = "";
for (Producto p : servicio.listar()) {
texto += p.getNombre() + "\n";
}
      try {
    Producto p = new Producto(campo.getText());
    label.setText(p.getNombre());
} catch (Exception ex) {
    label.setText(ex.getMessage());
}
    });
    VBox layout = new VBox(10, campo, boton, label);
    
    Scene scene = new Scene(layout, 300, 200);
    stage.setScene(scene);
    stage.show();
}
}
