package com.organizacion.presentacion.ejercicio_05;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteCifrado {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("--Escriba una frase para enviarla al servidor ---");
        String mensaje = s1.nextLine();
        String mensajeCifrado = cifrarMensaje(mensaje);
        try (Socket peticion = new Socket("localhost", 5000);
             PrintWriter sSalida = new PrintWriter(peticion.getOutputStream(), true);) {
            System.out.println("Enviado ...." +mensajeCifrado);
            sSalida.println(mensajeCifrado);
            try (BufferedReader bf = new BufferedReader(new InputStreamReader(peticion.getInputStream()));) {
                System.out.println("Recibido ->" +bf.readLine());
            }
        } catch (UnknownHostException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static String cifrarMensaje(String mensaje) {
        StringBuilder cifrado = new StringBuilder();
        for (char c : mensaje.toCharArray()) {
            cifrado.append((char) (c + 3));
        }
        return cifrado.toString();
    }


}
