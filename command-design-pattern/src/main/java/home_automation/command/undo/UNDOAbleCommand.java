package home_automation.command.undo;

public interface UNDOAbleCommand {
    void execute();
    void undo();
}
