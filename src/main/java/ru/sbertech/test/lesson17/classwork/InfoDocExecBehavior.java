package ru.sbertech.test.lesson17.classwork;


public class InfoDocExecBehavior implements ExecBehavior{
    @Override
    public void exec(Document D) {
        System.out.println("This is Info Document");
    }
}
