package com.technokratos.generator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TaskDataGenerator {

    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            System.out.println("Usage: java TaskDataGenerator <count> <file> <format>");
            System.out.println("Example: java TaskDataGenerator 3 tasks.xml xml");
            return;
        }

        int count = Integer.parseInt(args[0]);
        String fileName = args[1];
        String format = args[2];

        if (!format.equalsIgnoreCase("xml")) {
            System.out.println("Only xml format is supported");
            return;
        }

        generateXml(count, fileName);
    }

    private static void generateXml(int count, String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<tasks>\n");

            for (int i = 0; i < count; i++) {
                writer.write("    <task>\n");
                writer.write("        <title>" + generateRandomText("Тестовое задание ") + "</title>\n");
                writer.write("        <description>" + generateRandomText("Описание ") + "</description>\n");
                writer.write("        <answer>" + generateRandomText("Ответ ") + "</answer>\n");
                writer.write("    </task>\n");
            }

            writer.write("</tasks>\n");
        }
    }

    private static String generateRandomText(String prefix) {
        Random random = new Random();
        return prefix + random.nextInt(100000);
    }
}