package main.pattern;

import main.service.ResumeService;

public interface Decorator extends ResumeService {

    void useFile();
    void usePath();

}
