import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

class FileIterator implements Iterator<String>,AutoCloseable {

    private String path;
    private final BufferedReader reader;

    private IOException lastException;


    public FileIterator(String path) throws FileNotFoundException {
        this.path = path;
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }
    public IOException ioException() {
        return lastException;
    }
    @Override
    public void close() throws IOException {
        reader.close();
    }
    @Override
    public boolean hasNext() {
        boolean hasNext = false;
        try {
            hasNext = reader.ready();
        } catch (IOException e) {
            lastException = e;
        }
        return hasNext;
    }

    @Override
    public String next() throws NoSuchElementException {

        try {
            if(hasNext()){
                return reader.readLine();
            }
            throw new NoSuchElementException();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
