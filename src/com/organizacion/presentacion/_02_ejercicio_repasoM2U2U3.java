package com.organizacion.presentacion;

import java.io.*;
import java.util.Scanner;

public class _02_ejercicio_repasoM2U2U3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una cadena de texto:");
        String contenido = scanner.nextLine();

        try {
            FileWriter fs = new FileWriter("text_file.txt");
            fs.write(contenido);
            fs.flush();
           fs.close();
        } catch (IOException e) {
            e.getStackTrace();
        }

        //Lectura
        try {
            FileReader fe = new FileReader("text_file.txt");
            BufferedReader bufferLectura = new BufferedReader(fe);
            System.out.println(bufferLectura.readLine());
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }

    }

}
