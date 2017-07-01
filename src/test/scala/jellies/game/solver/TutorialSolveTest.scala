package jellies.game.solver

import org.scalatest._
import jellies.game.levels.Tutorial

private class TutorialSolveTest extends FunSuite with Matchers {
  for ((level, index) <- Tutorial.levels.zipWithIndex) {
    test(s"test that tutorial level ${index + 1} is solvable") {
      val solver = new Solver(level)
      solver.solve shouldBe a [solver.Solution]
      val solution = solver.solve.asInstanceOf[solver.Solution] 
      info(s"${solution.states.length - 1} moves")
    }
  }
}