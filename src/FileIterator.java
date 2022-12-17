import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

class FileIterator implements Iterator<String> {

    private String path;
    private BufferedReader reader;

    public FileIterator(String path) throws FileNotFoundException {
        this.path = path;
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = false;
        try {
            hasNext = reader.ready();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return hasNext;
    }

    @Override
    public String next() throws NoSuchElementException {
        if (!hasNext()) {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            throw new NoSuchElementException("NoSuchElementException");
        }
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
};
