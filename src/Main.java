import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try{
            FileIterator it = new FileIterator("file.txt");
            while(it.hasNext()){
                System.out.println(it.next());
            }
        }catch (FileNotFoundException e){
            System.out.println("файл не найден");
        }
    }
}