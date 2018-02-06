package com.yg.kitchen.cookMp3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * 文件夹遍历
 * Created by Ada.YG on 2018/2/6
 */
public class TransferMp3ToSony {
    private String desPath = "H:\\MUSIC\\english";
    private int count = 0;
    public static void main(String[] args){
        String sourcePath = "F:\\english";
        File pFile = new File(sourcePath);
        File[] files = pFile.listFiles();
        TransferMp3ToSony transferMp3ToSony = new TransferMp3ToSony();
        transferMp3ToSony.getFiles(files);
        System.out.print("Finished.");
    }
    private void getFiles(File[] files){
        Arrays.stream(files).forEach(file->{
            if(file.isDirectory()){
                getFiles(file.listFiles());
            }else if(file.getName().contains("pb")){
                try(OutputStream out = new FileOutputStream(Paths.get(desPath,file.getName()).toFile())) {
                    Files.copy(Paths.get(file.getParent() + File.separator + file.getName()),out);
                    System.out.print("The "+ count +" file copied");
                    count++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}



