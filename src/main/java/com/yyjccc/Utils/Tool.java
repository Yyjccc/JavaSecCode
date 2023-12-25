package com.yyjccc.Utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public  class Tool{

    public static String mode="normal";

    public static String filePath="ser.bin";
    public static void serialize(Object object) throws Exception {
        FileOutputStream fileOutputStream=new FileOutputStream(new File(filePath));
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        if(mode.equals("normal")){
            objectOutputStream.writeObject(object);
            System.out.println("序列化成功");
        } else if (mode.equals("base64")) {
            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
            ObjectOutputStream objectOut = new ObjectOutputStream(byteArrayOut);
            objectOut.writeObject(object);
            objectOut.flush();
            byte[] byteArray =byteArrayOut.toByteArray();
            String base64String=Base64.getEncoder().encodeToString(byteArray);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                // 将Base64字符串写入文件
                writer.write(base64String);
                System.out.println("序列化成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            throw new Exception("模式错误");
        }
    }

    public static Object unserialize() throws Exception {
        if (mode.equals("normal")) {
            FileInputStream fileInputStream=new FileInputStream(new File(filePath));
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            Object obj=objectInputStream.readObject();
            System.out.println("反序列化成功");
            return obj;
        } else if (mode.equals("base64")) {
            String base64String = new String(Files.readAllBytes(Paths.get(filePath)));
            byte[] byteArray = Base64.getDecoder().decode(base64String);
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArray));
            Object obj = objectInputStream.readObject();
            System.out.println("反序列化成功");
            return obj;
        } else {
            throw new Exception("模式错误");
        }
    }
    public static String NofileSerialze() throws Exception {
        if(mode.equals("normal")){

        } else if (mode.equals("base64")) {

        }else {
            throw new Exception("模式错误");
        }
        return null;
    }
    public static Object NofileUnserialize() throws Exception {

        if(mode.equals("normal")){

        } else if (mode.equals("base64")) {

        }else {
            throw new Exception("模式错误");
        }
        return null;
    }
}
