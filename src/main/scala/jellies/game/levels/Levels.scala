package jellies.game.levels

import jellies.game.metadata.InformationText
import jellies.game.LevelSpecification
import AbstractLevel._
import jellies.game.metadata.NoAutoSolve

object Levels {
  val levels: Seq[LevelSpecification] =
    LevelSequence(
      MovementLevel,
      SimplePuzzleLevel,
      SuspensionInAir,
      GravityPropagation,
      GravityTutorial,
      Support,
      FirstTandem,
      SimpleTandem,
      SecondTandem,
      FlippedTandem,
      Halves,
      Inversion,
      Corners,
      NewFour,
      Bridge,
      Stars,
      Pit,
      Hook,
      Ferry,
      Blue)
      
  object MovementLevel extends AbstractLevel with Down {
    val asciiField = """
      ...........
      ...........
      .1.......2.
      XXX.....XXX
      XXX.....XXX
      XXX.....XXX
      XXX.1.2.XXX
      """
    override def metadata = Seq(
      InformationText("Hi! The coloured blocks are jellies."),
      InformationText("You can move the jellies left or right"),
      InformationText("by clicking on them."),
      InformationText("If you are on a touch device, you can"),
      InformationText("swipe the jellies left or right."),
      InformationText("When jellies of the same colour touch, they merge."),
      InformationText("The goal is to merge all the red jellies"),
      InformationText("together and all the green jellies together."))
  }
  object SimplePuzzleLevel extends AbstractLevel with Down {
    val asciiField = """
      ....1.X....
      ....11X....
      ....XXX....
      22.......22
      XX..1....XX
      XX.11....XX
      """
    override def metadata = Seq(
      InformationText("If you have a keyboard, you can use these shortcuts:"),
      InformationText("Press R to restart."),
      InformationText("Press U to undo."),
      InformationText("Press Y to redo."),
      InformationText("Press S to skip the level."))
  }
  object SuspensionInAir extends AbstractLevel with Down {
    val asciiField = """
      .......1.
      .....2.1.
      ..X....1.
      22X....1.
      """
    override def metadata = Seq(
      InformationText("Sometimes jellies are in the air."),
      InformationText("When a jelly is in the air, you can't move it by clicking on it."),
      InformationText("However, you can still move it in other ways."))
  }
  object GravityPropagation extends AbstractLevel with Down {
    val asciiField = """
      11.XXXXX
      11.XXXXX
      X..XXXXX
      ..22XXXX
      .....XXX
      ...222XX
      X......X
      .2....2X
      122222..
      X.......
      """
    override def metadata = Seq(
      InformationText("If a jelly is connected to the ground before you move,"),
      InformationText("it will be connected to the ground after you move."),
      InformationText("Sometimes this means it will bring other jellies down with it."))
  }
  object Support extends AbstractLevel with Down {
    val asciiField = """
      X...11
      X...22
      X...XX
      X2111X
      X.2.2X
      X....X
      .....X
      X....X
      """
    override def metadata = Seq(
      InformationText("A jelly is 'connected to the ground' if it"),
      InformationText("wouldn't move if gravity were applied to it."),
      InformationText("So the red jelly in the middle is not connected to the"),
      InformationText("ground because it's only supported by other jellies."))
  }
  object SimpleTandem extends AbstractLevel with DownRight {
    val asciiField = """
      1...
      .X..
      ...2
      ...1
      .212
      """
  }
  object FirstTandem extends AbstractLevel with DownRight {
    val asciiField = """
      .......
      .......
      .......
      ...X...
      .1.X.1.
      """
    override def metadata = Seq(
      InformationText("Now there are two players: left and right."),
      InformationText("They work together to solve the same level."),
      InformationText("However, depending on your perspective, different"),
      InformationText("jellies could be 'on the ground' or 'in the air'."))
  }
  object SecondTandem extends AbstractLevel with DownRight {
    val asciiField = """
      ....1..
      ....X..
      .......
      ....1..
      2X.2...
      .......
      XXX.X..
      XXX2XX.
      XX222X.
      """
  }
  object FlippedTandem extends AbstractLevel with DownLeft {
    val asciiField = """
      ....1..
      ....X..
      .......
      ....1..
      2X.2...
      .......
      XXX.X..
      XXX2XX.
      XX222X.
      """
  }
  object Inversion extends AbstractLevel with DownUp {
    val asciiField = """
      XXXXXXXXX
      XXXXXXXXX
      X....1XXX
      X22..XXXX
      XX.XXXXXX
      X...1.XXX
      X..1..XXX
      X..1.2XXX
      """
  }
  object InversionComplex extends AbstractLevel with DownUp {
    val asciiField = """
      1.2.1.XXX
      XXXXX.XXX
      2...2.XXX
      X22..XXXX
      XX.XXXXXX
      X...1.XXX
      X..1..XXX
      X..1.2XXX
      """
  }
  object Stars extends AbstractLevel with DownRight {
    val asciiField = """
      XXXXXXXXXX
      X..1.....X
      X2X.1..X.X
      X..1.1...X
      X...2....X
      X...X....X
      X........X
      XXXXXXXXXX
      """
  }
  object FourPart extends AbstractLevel with DownRight {
    val asciiField = """
      ...X1..
      .2.....
      111X1.2
      X.XXX.2
      ..1X.2X
      ....212
      1.1XX22
      """
    override def metadata = Seq(NoAutoSolve)
  }
  object Halves extends AbstractLevel with DownUp {
    val asciiField = """
      .....
      .....
      .....
      21.12
      XX.XX
      21.12
      .....
      .....
      .....
      """
    override def metadata = Seq(NoAutoSolve)
  }
  object Hook extends AbstractLevel with DownUp {
    val asciiField = """
      ...22
      ...X2
      1.1..
      XXXX.
      2121.
      .....
      .....
      """
  }
  object Checkerboard extends AbstractLevel with DownRight {
    val asciiField = """
      ..2..
      12121
      21212
      """
  }
  object AnotherLevel extends AbstractLevel with DownRight {
    val asciiField = """
      ...122
      2221..
      ..1222
      221..1
      .....1
      """
  }
  object YetAnotherLevel extends AbstractLevel with DownRight {
    val asciiField = """
      .1212.
      .2121.
      1.21.2
      .2..1.
      2....1
      """
  }
  object YetYetAnotherLevel extends AbstractLevel with DownRight {
    val asciiField = """
      21212
      1...1
      2...2
      1...1
      21212
      """
  }
  object Pit extends AbstractLevel with DownRight {
    val asciiField = """
     1X.......
     11...2.21
     XX...XXXX
     XX...XXXX
     XX..2XXXX
      """
  }
  object Corners extends AbstractLevel with DownRight {
    val asciiField = """
      1...1
      ...X.
      ...2.
      .X2..
      1...2
      """
  }
  object Blue extends AbstractLevel with DownRight {
    val asciiField = """
      1.......
      ....X.X.
      ..X.....
      ........
      .X..X..2
      .....X.3
      .X.....1
      ....2313
      """
    override def metadata = Seq(
        NoAutoSolve)
  }
  object Ferry extends AbstractLevel with DownUp {
    val asciiField = """
      XX..X..XXXXXX
      1X..X..XXXXXX
      1.......123XX
      1.......213XX
      1X..X..XXXXXX
      XX..X..XXXXXX
      """
    override def metadata = Seq(
        InformationText("Blue jellies are just like red or green jellies."))
  }
  object GravityTutorial extends AbstractLevel with Down {
    val asciiField = """
      XX1X1XX2
      22.....2
      2.....22
      XX.XXXXX
      XX1XXXXX
      """
  }
  object NewFour extends AbstractLevel with DownRight {
    val asciiField = """
      ...X...
      .2...1.
      ..1X2..
      X.XXX.X
      ..2X1..
      .1...2.
      ...X...
      """
    override def metadata = Seq(NoAutoSolve)
  }
  object Bridge extends AbstractLevel with DownUp {
    val asciiField = """
      XXXX....XX
      XXXX....XX
      1..1....X1
      .12......1
      2..2....X1
      XXXX....XX
      XXXX....XX
      """
  }
}