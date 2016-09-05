package ru.sbertech.test.lesson17;



public class DocumentExecutor {
    public void exec(Document document) {

       document.getExecBehavior().exec(document);
    }
}
