package com.hanchai.tictactoe_game;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by Hanchai on 09-May-18.
 */

public class Server {
    private static final int serverPort = 2222;
    MainActivity mainActivity;

    public Server(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        ServerWorker serverWorker = new ServerWorker();
        serverWorker.start();
    }

    private class ServerWorker extends Thread{
        int count = 0;
        @Override
        public void run(){

            try{
                ServerSocket serverSocket = new ServerSocket(serverPort);
                while (true){
                    final Socket clientSocket = serverSocket.accept();
                    count++;
                    mainActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                           /* mainActivity.txtMonitor.append("Client#"+ count
                                    + clientSocket.getInetAddress()+":"
                                    +clientSocket.getPort()+"\n");*/
                        }
                    });
                    ServerCommunication comm = new ServerCommunication(clientSocket);
                    comm.start();
                }
            }catch (IOException e){

            }
        }
    }

    private class ServerCommunication extends Thread{
        Socket clientSocket;
        public ServerCommunication(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run(){
           /* try {
                DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
                DataInputStream input = new DataInputStream(clientSocket.getInputStream());
                final String msg = input.readUTF();
                output.writeUTF("ACK 250");

                mainActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String msgs[] = msg.split(" ");
                        if(msgs[0].equals("MSG")){
                            String datas[] = msgs[1].split(",");
                            if(datas[2].equals("x")){
                                mainActivity.btn.setImageResource(R.drawable.x);
                            }else if(datas[2].equals("o")){
                                mainActivity.btn.setImageResource(R.drawable.o);
                            }else{
                                mainActivity.btn.setImageResource(R.drawable.z);
                            }
                        }
                    }
                });

            }catch (IOException e){

            }*/

        }
    }

    public int getPort(){
        return serverPort;
    }

    public String getIpAddress(){
        String ip = "";
        try{
            Enumeration<NetworkInterface> netInt = NetworkInterface.getNetworkInterfaces();
            while(netInt.hasMoreElements()){
                NetworkInterface networkInterface = netInt.nextElement();
                Enumeration<InetAddress> enumInetAddress = networkInterface.getInetAddresses();
                while(enumInetAddress.hasMoreElements()){
                    InetAddress inetAddress = enumInetAddress.nextElement();
                    if(inetAddress.isSiteLocalAddress()){
                        ip += "My IP  Address : " + inetAddress.getHostAddress();
                    }
                }
            }

        }catch (SocketException e){

        }
        return ip;
    }
}
