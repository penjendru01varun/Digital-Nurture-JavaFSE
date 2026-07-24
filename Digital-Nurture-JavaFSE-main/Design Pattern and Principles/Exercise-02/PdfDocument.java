public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document.");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF Document.");
    }
}
