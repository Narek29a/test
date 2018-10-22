package com.narek.springtest.controller;


import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;

@RestController
public class UserController {


    private ArrayList<String> arrayList = new ArrayList<>();

    @RequestMapping(value = "getFiles", method = RequestMethod.POST)
    public ArrayList<String> getFiles(@RequestParam(value = "path") String path) {

        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                arrayList.add("file: " + f.getName());
            }
        }
        for (File f : files) {
            if (f.isDirectory()) {
                String p = f.getPath();
                arrayList.add("package: " + f.getPath());
                getFiles(p);
            }

        }

        return arrayList;
    }



}
