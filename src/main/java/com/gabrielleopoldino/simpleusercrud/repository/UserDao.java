package com.gabrielleopoldino.simpleusercrud.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.gabrielleopoldino.simpleusercrud.model.User;

public class UserDao {
    private String filename;
    private RandomAccessFile randomAccessFile;
    private AtomicInteger index = new AtomicInteger(0);

    public UserDao(String filename) throws FileNotFoundException {
        this.filename = filename;
        this.randomAccessFile = new RandomAccessFile(filename, "rw");
    }

    public User getFirst() throws IOException {
        randomAccessFile.seek(0);
        String line = randomAccessFile.readLine();
        User user = new User(index.getAndIncrement(), line);
        return user;
    }

    public User getByIndex(int index) throws IOException {
        randomAccessFile.seek(0);
        String s;
        int i = 0;
        do {
            s = randomAccessFile.readLine();
            if (i == index && s != null){
                return new User(i, s);
            }
            i++;
        } while(s != null && i <= index);
        return null;
        
    }

    public List<User> getAll() throws IOException {
        LinkedList<User> list = new LinkedList<User>();
        String s; 
        int i = 0;
        randomAccessFile.seek(0);
        while ((s = randomAccessFile.readLine()) != null) {
            list.add(new User(i++, s));
        }
        return list;
    }

    public int save(String user) throws IOException {
        String s; 
        int i = 0;
        randomAccessFile.seek(0);
        while (randomAccessFile.readLine() != null) {
            i++;
        }
        randomAccessFile.seek(randomAccessFile.getFilePointer());
        randomAccessFile.write((user+"\n").getBytes("UTF-8"));
        return i;
    }

}