/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uygulama;

import javafx.scene.control.TextField;

/**
 *
 * @author asus-pc
 */
public class VigenereCipher  {
    
    static char[] alphabet={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    //Uygulama uygulama= new Uygulama();
    
    public  void encrypt(TextField message, TextField key, TextField result) {

        message = message;
        String encryptedMessage = "";
        String tmp = "";
        
        StringBuilder builder = new StringBuilder(message.getText().length() + key.getText().length() -1);
        while (builder.length() < message.getText().length()){
            builder.append(key.getText());
            builder.append(message.getText());
        }
        builder.setLength(message.getText().length());
        String keyStream = builder.toString();
        int keyLength = keyStream.length();

        int num;
        for (int i = 0; i < message.getText().length(); i++) {
            if(message.getText().charAt(i) == ' '){
                encryptedMessage+=' ';
            }else {
                num = ((message.getText().charAt(i) - 'A') + (keyStream.charAt(i % (keyLength)) - 'A')) % alphabet.length;
                if (num <= -1) {
                    num = alphabet.length + num;
                }
                encryptedMessage += (char) (num + 'A');
            }
        }
   
        result.setText(encryptedMessage);
        System.out.println("Encrypt Message is :"+ encryptedMessage);
    }



    public static void decrypt(TextField encryptedMessage, TextField key,  TextField result) {

        encryptedMessage = encryptedMessage;
        String decryptedMessage = "";
        String tmp = "";
        StringBuilder builder = new StringBuilder(encryptedMessage.getText().length() + key.getText().length()-1);
        while (builder.length() < encryptedMessage.getText().length()){
            builder.append(key.getText());
            //builder.append(encryptedMessage.getText());
        }
        builder.setLength(encryptedMessage.getText().length());
        String keyStream = builder.toString();
        int keyLength = keyStream.length();
        for (int i = 0; i< encryptedMessage.getText().length(); i++) {
            tmp += keyStream.charAt(i % (keyLength));
        }
        //key = "";

        int num;
        for (int i = 0; i < encryptedMessage.getText().length(); i++) {

            if (encryptedMessage.getText().charAt(i) == ' ') {
                //charAt stringi parcalayıp karakterleri arraye atar aslında dizi[i] ile aynı mantık

                decryptedMessage += ' ';
            } else {
                num = ((encryptedMessage.getText().charAt(i) - 'A') - (keyStream.charAt(i) - 'A')) % alphabet.length;
                if (num <= -1) {
                    num = alphabet.length + num;
                }
                decryptedMessage += (char) (num + 'A');
            }
        }
         result.setText(decryptedMessage);
        System.out.println("Decrypt Message is :"+decryptedMessage);
    }

   
    
}
