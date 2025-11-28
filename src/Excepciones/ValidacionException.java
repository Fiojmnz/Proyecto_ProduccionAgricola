/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author gipsy
 */
public class ValidacionException extends RuntimeException {
    public ValidacionException(String mensaje) {
        super("Los datos ingresados no cumplen con las validaciones requeridas");
    }
}