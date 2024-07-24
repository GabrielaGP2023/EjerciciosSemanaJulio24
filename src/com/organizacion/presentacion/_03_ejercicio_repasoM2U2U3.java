package com.organizacion.presentacion;

import java.io.*;
import java.util.Scanner;

public class _03_ejercicio_repasoM2U2U3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una cadena de texto:");
        String contenido = scanner.nextLine();
        byte[] arregloByte = contenido.getBytes();
        System.out.println(arregloByte);
        try {
            FileOutputStream fs = new FileOutputStream("byteFile.txt");
            DataOutputStream ds = new DataOutputStream(fs);
            ds.write(arregloByte);
            ds.flush();
            ds.close();
            fs.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
        try {
            FileInputStream fs = new FileInputStream("byteFile.txt");
            DataInputStream fe = new DataInputStream(fs);
            System.out.println(fe.read(arregloByte));
            System.out.println(arregloByte);
            String resultado = new String(arregloByte);
            System.out.println(resultado);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
