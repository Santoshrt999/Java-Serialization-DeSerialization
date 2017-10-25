/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serilizatuion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Santosh Ravi Teja
 */
public class Serilizatuion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Website w = new Website();
        w.setName("Santosh");
        w.setPurpose("good things");
        w.setRank(9);
        w.setSsn(345678);

        String filename = "random.txt";

        String abspath = System.getProperty("user.dir"); //defining parth abspath = system.getPropety(filename
        String fullpath = abspath + File.separator + filename;
        System.out.println(fullpath);

//        FileWriter fw = new FileWriter(abspath);
//        BufferedWriter bw = new BufferedWriter(fw); //try block using with resources.. 
        try (FileOutputStream fos = new FileOutputStream(fullpath);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(w);
            oos.flush();
            System.out.println(w);
        } catch (IOException IO) {
            IO.getStackTrace();

        }

    }

}

class Website implements Serializable { //use the keyword implements serializable.. so this is how the data gets secured.

    private String name;

    private int rank;
    private String purpose;
    private transient int ssn;//use transient keyword to hide the data (So, a person's social security cannot be deserialized.

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "Website{" + "name=" + name + ", rank=" + rank + ", purpose=" + purpose + ", ssn=" + ssn + '}';
    }

}
