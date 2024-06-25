package home_automation.command;

public interface UNDOAbleCommand {
    void execute();
    void undo();
}
