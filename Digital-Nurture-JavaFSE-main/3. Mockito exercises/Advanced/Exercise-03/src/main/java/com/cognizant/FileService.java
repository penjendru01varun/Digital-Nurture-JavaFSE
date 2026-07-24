package com.cognizant;
public class FileService {
    private FileReader fileReader;
    private FileWriter fileWriter;
    public FileService(FileReader fileReader, FileWriter fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
    }
    public String processFile() {
        String data = fileReader.read();
        String processed = "Processed " + data;
        fileWriter.write(processed);
        return processed;
    }
}