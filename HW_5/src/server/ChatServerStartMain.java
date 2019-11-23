package server;

import some_classes.ConnectionToDataBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class ChatServerStartMain {
    public static void main(String[] args) {

        MultiClientServer multiClientServer = new MultiClientServer();
        multiClientServer.start(7000);
    }
}