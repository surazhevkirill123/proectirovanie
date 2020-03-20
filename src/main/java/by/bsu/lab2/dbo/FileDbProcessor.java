package by.bsu.lab2.dbo;

import by.bsu.lab2.bisiness.Tour;

import java.io.*;

public class FileDbProcessor {
    private File dir = new File("./data");

    public FileDbProcessor() {
        if(!dir.exists()) {
            dir.mkdir();
        }
    }

    public void create(Tour tour) throws Exception {
        File file = new File(dir.getAbsolutePath() + "/" + tour.getId());

        if(file.exists()) {
            throw new Exception("File already exists!");
        }

        file.createNewFile();

        write(tour, file);
    }

    public Tour readById(String id) throws Exception {
        File file = new File(dir.getAbsolutePath() + "/" + id);

        if(!file.exists()) {
            throw new Exception("File doesn't exists!");
        }

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Tour tour = (Tour) objectInputStream.readObject();

        objectInputStream.close();
        fileInputStream.close();

        return tour;
    }

    public Tour[] readAll() throws Exception {
        File[] files = dir.listFiles();

        Tour[] tours = new Tour[files.length];

        for (int i = 0; i < files.length; i++) {
            tours[i] = readById(files[i].getName());
        }

        return tours;
    }

    public void update(Tour tour) throws Exception {
        File file = new File(dir.getAbsolutePath() + "/" + tour.getId());

        if(!file.exists()) {
            throw new Exception("File doesn't exists!");
        }

        write(tour, file);
    }

    public void delete(Tour tour) throws Exception {
        File file = new File(dir.getAbsolutePath() + "/" + tour.getId());

        if(!file.exists()) {
            throw new Exception("File doesn't exists!");
        }

        file.delete();
    }

    private void write(Tour tour, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(tour);

        objectOutputStream.close();
        fileOutputStream.close();
    }
}
