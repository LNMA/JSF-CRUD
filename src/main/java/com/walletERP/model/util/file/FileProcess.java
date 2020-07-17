package com.walletERP.model.util.file;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.*;

@Component()
@Scope("prototype")
public class FileProcess implements Serializable {
    private static final long serialVersionUID = 7472704082966962990L;

    public byte[] readAPicture(String path) throws IOException {
        byte[] bytes;
        InputStream in;
        File file = new File(path);

        if (file.exists()) {
            if (file.canExecute()) {
                if (file.canRead()) {
                    bytes = new byte[(int) file.length()];
                    in = new BufferedInputStream(new FileInputStream(path));
                    int i = 0;
                    while (in.available() != 0) {
                        bytes[i] = (byte) in.read();
                        i++;
                    }
                    in.close();
                } else {
                    throw new IOException("file can not Read.");
                }
            } else {
                throw new IOException("file can not execute.");
            }
        } else {
            throw new FileNotFoundException("file not found.");
        }
        return bytes;
    }

    public byte[] uploadDefaultImg() {
        byte[] bytes = null;
        try {
            //TODO change path to your path
            bytes = this.readAPicture("C:\\Users\\Oday Amr\\Documents\\IdeaProjects\\Wallet_ERP-Task\\src\\main\\resources\\img\\no-logo.png");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return bytes;
    }
}
