package duke;

import duke.command.Command;
import duke.exception.DukeException;
import duke.task.Ui;

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage);
    }

    public void run() {

        // Initialise
        ui.showWelcome();
        boolean isExit = false;

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.print(e.toString());
            }
        }
        ui.showExit();
    }

    public static void main(String[] args) {
        new Duke("./data/duke.txt").run();
    }
}
