package yamaza520

import java.util.Date

import yamaza520.logics.TaskLogic
import yamaza520.models.Task
import org.junit.runner.RunWith
import org.specs2.mock.Mockito
import org.specs2.mutable._
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MockSpec extends Specification with Mockito {

  "mock check" should {
    "find america" in {
      val task = mock[Task]
      // modelを継承してんだからtask.find.byIdで呼び出したいんだけどなぁ
      task.getById(1L) returns new Task(1L, "america", new Date, new Date)
      task.getById(2L) returns new Task(2L, "france", new Date, new Date)

      // test
      TaskLogic.isAmerica(task.getById(1L)) must beTrue
      TaskLogic.isAmerica(task.getById(2L)) must beFalse
    }
  }
}
