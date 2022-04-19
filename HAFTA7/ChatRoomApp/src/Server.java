import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {

    private ArrayList<ConnectionHandler> connections;
    private ArrayList<String> users=new ArrayList<>();
    private ServerSocket server;
    private boolean flag;
    private ExecutorService pool;

    public Server() {
        this.connections = new ArrayList<>();
        flag = false;
    }

    @Override
    public void run() {
        try {
            server = new ServerSocket(8888);
            pool = Executors.newCachedThreadPool();
            while (!flag) {
                Socket client = server.accept();
                ConnectionHandler handler = new ConnectionHandler(client);
                connections.add(handler);
                pool.execute(handler);
            }
        } catch (Exception e) {
            shutdown();
        }
    }

    public void broadcast(String message) {
        for (ConnectionHandler ch : connections) {
            ch.sendMessage(message);
        }

    }

    public void shutdown() {
        try {
            flag = true;
            pool.shutdown();
            if (!server.isClosed()) {
                server.close();
            }
            for (ConnectionHandler ch : connections) {
                ch.shutdown();
            }
        } catch (IOException e) {
            //ignore
        }

    }
    private void listAllUser() {
        for(String s : users){
            broadcast(s);
        }
    }

    class ConnectionHandler implements Runnable {

        private Socket client;
        private BufferedReader in;
        private PrintWriter out;
        private String clientName;

        public ConnectionHandler(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(client.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out.println("Please enter the name:");
                clientName = in.readLine();
                users.add(clientName);
                System.out.println(clientName + " connected!");
                broadcast(clientName + " joined the chat!");

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.startsWith("/quit")) {
                        broadcast(clientName + " left the chat!");
                        shutdown();
                    } else if (message.startsWith("/list")) {
                        listAllUser();
                    } else {
                        broadcast(clientName + ": " + message);
                    }
                }
            } catch (Exception e) {
                shutdown();
            }
        }

        public void sendMessage(String message) {
            out.println(message);
        }

        public void shutdown() {
            try {
                in.close();
                out.close();
                if (!client.isClosed()) {
                    client.close();
                }
            } catch (IOException e) {
                //ignore
            }
        }
    }


    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }
}
