package com.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by sujitagarwal on 25/03/17.
 */
public class ParentChildMain {

    public static void main(String[] args) {
        try{
           /*Child child=new Child();
            System.out.println("start serialization");
            serialize(child,"dat.txt");
            System.out.println("deserialized ");
            deserialize("dat.txt");
            System.out.println("******************************");
            */

            ChildSerialize childSerialize=new ChildSerialize();
            childSerialize.setName("sujit agarwal");
            System.out.println("Write hashcode="+childSerialize.hashCode());
            System.out.println("serializing the child");
            serialize(childSerialize,"dat.txt");
            System.out.println("deserialized the child ");
            ChildSerialize ss=(ChildSerialize)deserialize("dat.txt");
            System.out.println("Name=="+ss.getName());
            System.out.println(ss.equals(childSerialize));
        }
        catch (Exception e)
        {

        }

    }

    public static Object deserialize(String fileName) throws Exception,
            ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        System.out.println("Read Hashcode="+obj.hashCode());
        ois.close();
        return obj;
    }

    // serialize the given object and save it to file
    public static void serialize(Object obj, String fileName)
            throws Exception {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        System.out.println("Write hashcode="+obj.hashCode());
        fos.close();
    }
}
