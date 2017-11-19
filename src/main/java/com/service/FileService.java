package com.service;

import com.entity.User;
import java.util.*;
import com.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;

import java.util.List;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    public HashMap<String, ArrayList> getFiles()
    {
        File folder=new File("./uploads");

		/*Get files*/
        File[] files=folder.listFiles();
        int j = 0;
        String arrFile[] = new String[10];
        String arrFolder[] = {};
        HashMap<String, ArrayList> hm = new HashMap<String, ArrayList>();
        ArrayList folderList = new ArrayList();
        ArrayList fileList = new ArrayList();
        for (File file : files) {
            if(file.isFile()){
                System.out.println("File : "+file.getName());
                fileList.add(file.getName());
            }else{
                System.out.println("Folder : "+file.getName());
                folderList.add(folder.getName());
            }
        }
        hm.put("files",fileList);
        hm.put("folder", folderList);
        return hm;
    }

//    public void addUser(User user){
//        userRepository.save(user);
//    }
//
//    public List<User> login(String email,String password){
//        return userRepository.findByEmailAndPassword(email,password);
//    }
}