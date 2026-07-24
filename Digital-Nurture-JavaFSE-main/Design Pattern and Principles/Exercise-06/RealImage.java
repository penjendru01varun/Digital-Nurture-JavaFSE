public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk(filename);
    }

    private void loadFromDisk(String filename) {
        System.out.println("Loading image " + filename + " from remote server...");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}
