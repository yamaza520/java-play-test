import java.util.Date

import logics.TestLogic
import models.Task
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
      TestLogic.isAmerica(task.getById(1L)) must beTrue
      TestLogic.isAmerica(task.getById(2L)) must beFalse
    }
  }
}
