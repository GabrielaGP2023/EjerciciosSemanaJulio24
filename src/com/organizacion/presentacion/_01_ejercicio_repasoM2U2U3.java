package com.organizacion.presentacion;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class _01_ejercicio_repasoM2U2U3 {
    public static void main(String[] args) {

        Scanner s1 = new Scanner(System.in);
        System.out.println("Introduce la ruta del directorio:");
        String rutaDirectorio = s1.nextLine();

        File directorio = new File(rutaDirectorio);

        // Crear directorio si no existe
        if (!directorio.exists()) {
            directorio.mkdirs();
            System.out.println("Directorio creado: " + directorio.getAbsolutePath());
        } else {
            System.out.println("El directorio ya existe: " + directorio.getAbsolutePath());
        }

        // Crear archivo example.txt dentro del directorio
        File file = new File(directorio, "ejemplo.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("Archivo creado: " + file.getAbsolutePath());
            } else {
                System.out.println("El archivo ya existe: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }

        // Verificar si es archivo o directorio
        if (file.isFile()) {
            System.out.println(file.getAbsolutePath() + " es un archivo.");
        } else if (file.isDirectory()) {
            System.out.println(file.getAbsolutePath() + " es un directorio.");
        }
    }
}