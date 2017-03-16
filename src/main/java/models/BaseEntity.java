package models;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by Alisa on 3/16/2017.
 */
public abstract class BaseEntity {
    protected Logger logger = Logger.getLogger("MyLog");

    public BaseEntity(){
        try {
            FileHandler fh = new FileHandler("D:\\Facultate\\Semestrul 6\\Aop\\logs\\log.txt");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
