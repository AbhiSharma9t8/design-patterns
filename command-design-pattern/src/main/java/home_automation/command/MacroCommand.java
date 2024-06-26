package home_automation.command;

import home_automation.command.undo.UNDOAbleCommand;

public class MacroCommand implements UNDOAbleCommand {

    UNDOAbleCommand[] commands;

    public MacroCommand(UNDOAbleCommand[] undoAbleCommands){
        this.commands = undoAbleCommands;
    }

    @Override
    public void execute() {
        for(UNDOAbleCommand c: commands){
            c.execute();
        }
    }

    @Override
    public void undo() {
        for(UNDOAbleCommand c: commands){
            c.undo();
        }
    }
}
