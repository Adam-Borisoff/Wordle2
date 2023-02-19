//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WordReader {
    public WordReader() {
    }

    public String WordReader(int lettercount) {
        String filePath = "src/main/java/wordlist";
        ArrayList<String> wordlist = new ArrayList();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String line;
            try {
                while((line = br.readLine()) != null) {
                    if (line.length() == lettercount) {
                        wordlist.add(line);
                    }
                }
            } catch (Throwable var8) {
                try {
                    br.close();
                } catch (Throwable var7) {
                    var8.addSuppressed(var7);
                }

                throw var8;
            }

            br.close();
        } catch (IOException var9) {
            var9.printStackTrace();
        }

        Random random = new Random();
        int randomIndex = random.nextInt(wordlist.size());
        String randomWord = (String)wordlist.get(randomIndex);
        System.out.println(randomWord);
        return randomWord;
    }
}
