package main.model;

public class Section implements Print {
    private String content;

    public Section(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println(content);
    }
}
