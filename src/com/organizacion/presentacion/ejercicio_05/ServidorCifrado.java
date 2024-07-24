package com.organizacion.presentacion.ejercicio_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCifrado {
    public static void main(String[] args) {
        BufferedReader bf;
        PrintWriter sRespuesta;
        String respuesta = "", respuestaDescifrada="";
        try (ServerSocket servidor = new ServerSocket(5000);){
            while (true){
                System.out.println("En espera de peticiones ...");
                Socket s1 = servidor.accept();
                bf = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                respuesta = bf.readLine();
                respuestaDescifrada = descifrarMensaje(respuesta);
                System.out.println("Descifrada -> " + respuestaDescifrada);
                sRespuesta = new PrintWriter(s1.getOutputStream(),true);
                sRespuesta.println(respuestaDescifrada);
            }

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static String descifrarMensaje(String mensaje) {
        StringBuilder descifrado = new StringBuilder();
        for (char c : mensaje.toCharArray()) {
            descifrado.append((char) (c - 3));
        }
        return descifrado.toString();
    }
}

