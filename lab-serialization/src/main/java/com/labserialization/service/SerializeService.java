package com.labserialization.service;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class SerializeService {

    private SerializeService() {}

    public static byte[] convertObjectToBytes(Object obj) {
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        try (ObjectOutputStream ois = new ObjectOutputStream(boas)) {
            ois.writeObject(obj);
            return boas.toByteArray();
        } catch (IOException ioe) {
            log.error("Error to convert in bytes", ioe);
        }
        throw new RuntimeException();
    }

    public static Object convertBytesToObject(byte[] bytes) {
        InputStream is = new ByteArrayInputStream(bytes);
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException ioe) {
            log.error("Error to read bytes", ioe);
        }
        throw new RuntimeException();
    }
}
