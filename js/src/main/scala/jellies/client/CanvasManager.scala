package jellies.client

import org.scalajs.dom
import jellies.game
import jellies.layout
import jellies.game.Location
import jellies.game.MoveResult

class CanvasManager(val canvas: dom.html.Canvas) {
  private var drawnModel: Seq[layout.ModelView] = Seq()
  private var oldDimensions: Option[(Int, Int, Int, Int)] = None
  private var infoFromLastRender: Seq[RenderInfo] = Seq()
  private var devicePixelRatio: Option[Double] = None
  private var optAnimation: Option[MoveAnimation] = None
  
  checkDimensions()
  
  def setModelView(m: layout.ModelView*) = {
    drawnModel = m
    redraw()
  }
  
  def redraw(): Unit = {
    if (optAnimation.exists(!_.isDone(currentTimeSeconds))) {
      dom.window.requestAnimationFrame(x => redraw())
    } else {
      optAnimation = None
    }
    
    checkDimensions()
    val results = Render(
        new WrappedContext(canvas.getContext("2d").
            asInstanceOf[dom.raw.CanvasRenderingContext2D]),
        Rect(Pt(0, 0), Pt(canvas.width, canvas.height)),
        drawnModel,
        animationFunction)
    infoFromLastRender = results
  }
  
  def animateMove(result: MoveResult) = {
    optAnimation = Some(new MoveAnimation(currentTimeSeconds, result))
  }
  
  private def currentTimeSeconds =
    Seconds(System.currentTimeMillis() / 1000.0)
  
  private def animationFunction: Location => Pt = {
    optAnimation match {
      case Some(x) => x(currentTimeSeconds)
      case None => (loc => Pt(loc.x, loc.y))
    }
  }
  
  def checkDimensions(): Unit = {
    val ratio: Double = dom.window.devicePixelRatio
    devicePixelRatio = Some(ratio)
    val styleWidth: Int = dom.window.innerWidth.toInt
    val styleHeight: Int = dom.window.innerHeight.toInt
    val realWidth: Int = (ratio * dom.window.innerWidth).toInt
    val realHeight: Int = (ratio * dom.window.innerHeight).toInt
    val newDimensions = Some(styleWidth, styleHeight, realWidth, realHeight)
    if (newDimensions != oldDimensions) {
      oldDimensions = newDimensions
      canvas.width = realWidth
      canvas.height = realHeight
      canvas.style.width = styleWidth + "px"
      canvas.style.height = styleHeight + "px"
      redraw()
    }
  }
  
  def interpret(pParam: Pt): Option[RenderInfo] = {
    val p = pParam * devicePixelRatio.getOrElse(1)
    infoFromLastRender.find(_.region contains p)
  }
  
  def showMessage(msg: String) = dom.window.alert(msg)
}