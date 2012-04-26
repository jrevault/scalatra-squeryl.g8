package $package$.rest.test

import org.scalatra.test.specs2._
import $package$.rest.BaseServlet

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html 
class BaseServletSpec extends ScalatraSpec {

  def is =
  "GET / on BaseServlet" ^
    "should return status 200" ! root200^
                                                end
    
  addServlet(classOf[BaseServlet], "/*")

  def root200 = get("/") { 
    status must_== 200
  }
}
