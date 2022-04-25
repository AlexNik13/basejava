package main.service;

import main.exception.NotFolderException;

import java.io.File;

public class RecursionFileServiceImpl implements RecursionFileService {
    public static final String TAB = "\t";

    @Override
    public void printFolderAndFile(File file, int step) {
        if (!file.isDirectory()) {
            throw new NotFolderException(file.getName() + " is not folder");
        }

        String tab = "";
        File[] folders = file.listFiles();
        for (int i = 0; i < step; i++) {
            tab = tab.concat(TAB);
        }
        System.out.println(tab + file.getName());
        for (File f : folders) {
            if (f.isDirectory()) {
                printFolderAndFile(f, step + 1);
            } else {
                System.out.println(tab + TAB + f.getName());
            }
        }
    }

}
