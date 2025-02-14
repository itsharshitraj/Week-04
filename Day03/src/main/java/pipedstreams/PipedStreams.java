package pipedstreams;

import java.io.*;

public class PipedStreams {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // Connect streams

            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            writer.start();
            reader.start();
        } catch (IOException e) {
            System.out.println("Pipe Connection Error: " + e.getMessage());
        }
    }
}

class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from Writer Thread!";
            System.out.println("Writer: Writing data...");

            pos.write(message.getBytes()); // Convert string to bytes
            pos.flush();
            pos.close();

            System.out.println("Writer: Data written successfully.");
        } catch (IOException e) {
            System.out.println("Writer Error: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            System.out.println("Reader: Waiting for data...");

            byte[] buffer = new byte[1024];
            int bytesRead = pis.read(buffer); // Read data

            if (bytesRead > 0) {
                String receivedMessage = new String(buffer, 0, bytesRead);
                System.out.println("Reader: Received - " + receivedMessage);
            }

            pis.close();
        } catch (IOException e) {
            System.out.println("Reader Error: " + e.getMessage());
        }
    }
}
