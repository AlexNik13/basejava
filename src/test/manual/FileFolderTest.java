package test.manual;

import main.service.RecursionFileService;
import main.service.RecursionFileServiceImpl;

import java.io.File;

public class FileFolderTest {
    public static void main(String[] args) {
        RecursionFileService recursionFileService = new RecursionFileServiceImpl();

        File file = new File("/home/user/UAPP/3/basejava/src");
        recursionFileService.printFolderAndFile(file, 0);
    }
}
