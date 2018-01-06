package NeedForSpeed.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
    private BufferedReader console;

    public InputReader() {
        this.console = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine() throws IOException {
        return this.console.readLine();
    }
}
