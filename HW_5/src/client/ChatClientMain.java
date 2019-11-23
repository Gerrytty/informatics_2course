package client;

import java.util.Scanner;

public class ChatClientMain {
    public static void main(String[] args) {
        
        String ip = "127.0.0.1";
        int port = 7000;
        ChatClient chatClient = new ChatClient();
        chatClient.startConnection(ip, port);
        Scanner sc = new Scanner(System.in);

        while (true) {
            String message = sc.nextLine();
            chatClient.sendMessage(message);
        }
    }
}