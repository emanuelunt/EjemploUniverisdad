/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejemplouniverisdad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Hogar
 */
public class EjemploUniverisdad {

    public static void main(String[] args) throws SQLException {
        try {
            // Cargar driver de conexión
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost/registrodb", "root", "");

            String consulta = "INSERT INTO alumno (dni,apellido,nombre,fechaNacimiento,estado) "
                    + "VALUES (527445628,'Lopez','Juan','"+ LocalDate.of(2000,Month.AUGUST,29) +"',true);";
            PreparedStatement ps = conn.prepareStatement(consulta);
            
            if (ps.executeUpdate()>0) {
                System.out.printf("materia agregada correctamente");
            }

        } catch (ClassNotFoundException ex) {

            System.out.printf("Debes agregar los driver al proyecto!!" + ex.toString());
        } catch (SQLException ex) {
            System.out.printf(" Error de conexión!! " + ex.toString());
        }

    }
}
