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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

   
    ProductoService servicio = new ProductoService();

    @Override
    public void start(Stage stage) {
        
        TextField campo = new TextField();
        Button boton = new Button("Agregar");
        TextArea area = new TextArea();
        area.setEditable(false); 

        boton.setOnAction(e -> {
            try {
                
                servicio.agregar(new Producto(campo.getText()));
                
               
                String textoAcumulado = "";
                for (Producto p : servicio.listar()) {
                    textoAcumulado += p.getNombre() + "\n";
                }
                
                area.setText(textoAcumulado);
                campo.clear(); 
                
            } catch (Exception ex) {

                area.setText("Error: " + ex.getMessage());
            }
        });

        VBox layout = new VBox(10, campo, boton, area);
        
        Scene scene = new Scene(layout, 350, 400);
        stage.setTitle("CRUD de Productos - UMG");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
