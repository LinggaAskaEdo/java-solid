package com.solid;

/**
 * SOLID Principles
 * SOLID is an acronym for the first five object-oriented design (OOD)
 * principles by Robert C. Martin
 * 
 * S -
 * 0 -
 * L -
 * I -
 * D - Dependency Inversion Principle
 * High level moduls should not directly depend on low level modules, instead
 * they should depend on abstractions
 */

// Application Layer - low level modul
class MyMessenger {
    ProtocolHandler handler;

    MyMessenger(String protocol) {
        handler = ProtocolHandlerFactoy.getProtocolHandler(protocol);
    }

    public void send(String to, String message) {
        handler.sendMessage("message to -" + to + ", message - " + message);
    }
}

interface ProtocolHandler {
    void sendMessage(String message);
}

// Transport Layer
class TCPProtocolHandler implements ProtocolHandler {
    @Override
    public void sendMessage(String message) {
        System.out.println("TCPProtocolHandler sending message - " + message);
    }
}

class UDPProtocolHandler implements ProtocolHandler {
    @Override
    public void sendMessage(String message) {
        System.out.println("UDPProtocolHandler sending message - " + message);
    }
}

class ProtocolHandlerFactoy {
    public static ProtocolHandler getProtocolHandler(String protocol) {
        if ("TCP".equalsIgnoreCase(protocol)) {
            return new TCPProtocolHandler();
        }

        if ("UDP".equalsIgnoreCase(protocol)) {
            return new UDPProtocolHandler();
        }

        return null;
    }
}

public class DependencyInversionEx1 {
    public static void main(String[] args) {
        MyMessenger messenger = new MyMessenger("TCP");
        messenger.send("a", "SOLID is easy");
    }
}