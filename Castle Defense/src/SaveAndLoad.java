import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SaveAndLoad {

    public SaveAndLoad() {
    }
    int load(String path) throws FileNotFoundException {
        int no = 0;
        File f = new File(path);
        Scanner scn = new Scanner(f);
        if (scn.hasNext()) {
            String line = scn.nextLine();
            try {
                no = Integer.parseInt(line);
            } catch (Exception ignored) {
            }
        }
        scn.close();
        return no;
    }
}
