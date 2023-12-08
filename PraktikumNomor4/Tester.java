/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PraktikumNomor4;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Tester {

    public static void main(String[] args) {
        String sDir = "src/PraktikumNomor4/";
        String sSourceCode = "Matriks.java";
        String sInput = "input.txt";
        String sOutput = "output.txt";
        try {
            String input = Files.readString(Path.of(sDir + sInput));
            String output = Files.readString(Path.of(sDir + sOutput));
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.directory(new File(sDir));
            processBuilder.command("cmd.exe", "/c", "java " + sSourceCode);
            processBuilder.redirectInput(new File(sDir + sInput));
            Process process = processBuilder.start();
            process.waitFor();
            String outputTesting = ExtractOutput(process);
            String errorTesting = ExtractError(process);
            if (errorTesting.length() > 0) {
                System.out.println("RESULT : ");
                System.out.println("------------------------");
                System.out.println(" PROGRAM ERROR ");
                System.out.println("------------------------");
                System.out.println("WRONG ANSWER");
            } else {
                if (output.trim().equals(outputTesting.trim())) {
                    System.out.println("RESULT : ");
                    System.out.println("PROGRAM BERHASIL");
                    System.out.println("--------------------------");
                    System.out.println(outputTesting);
                    System.out.println("--------------------------");
                    System.out.println("CORRECT");
                } else {
                    System.out.println("RESULT : ");
                    System.out.println("-----------------------------");
                    System.out.println("Program Berhasil");
                    System.out.println(outputTesting);
                    System.out.println("");
                    System.out.println("-----------------------------");
                    System.err.println("TIDAK VALID: Ou");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String ExtractOutput(Process process) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        String teks = sb.toString();
        Path file = Files.writeString(Path.of("src/PraktikumNomor4/output.txt"), sb);
        return teks;
    }

    static String ExtractError(Process process) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        return sb.toString();
    }
}
