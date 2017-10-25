/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serilizatuion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Santosh ravi teja
 */
public class Deserialization {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here

        String filename = "santosh.txt";

        String abspath = System.getProperty("user.dir"); //defining parth abspath = system.getPropety(filename
        String fullpath = abspath + File.separator + filename;
        System.out.println(fullpath);

        Website w = new Website();
        try (FileInputStream fos = new FileInputStream(fullpath);
                ObjectInputStream oos = new ObjectInputStream(fos)) {
            w = (Website) oos.readObject();//typecast to Website object.

            System.out.println(w);
        } catch (IOException IO) {
            IO.getStackTrace();

        }

    }

}
