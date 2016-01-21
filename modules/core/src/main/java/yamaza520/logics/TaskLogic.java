package yamaza520.logics;

import java.util.List;

import yamaza520.models.Task;
import play.Logger;
import play.db.ebean.Transactional;

public class TaskLogic {

    public static int iterate(int arg) {
        return arg + 1;
    }

    public static boolean getDbData() {
        List<Task> tasks = Task.find.all();
        tasks.forEach((final Task task) ->
            Logger.debug("id=" + task.getId().toString() + ", contents=" + task.getContents())
        );
        return true;
    }

    public static String getContents(Long id) {
        return Task.find.byId(id).getContents();
    }

    /**
     * contents is america?
     * @param task Task
     * @return true america
     */
    public static boolean isAmerica(Task task) {
        return task.getContents().equals("america");
    }

    @Transactional
    public static Task updateTransaction() {
        Task task = Task.find.byId(1L);
        task.setContents("updated");
        task.save();

        return task;
    }

}
