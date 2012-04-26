package $package$.domain

import org.squeryl._
import org.squeryl.PrimitiveTypeMode._
import $package$.domain.model._

object Schema extends Schema {

  // ********************************************************************
  // ****** T_USER
  val t_user = table[User]("t_user")
  on (t_user )(user => declare(
    user.id is (autoIncremented),
    user.firstname is (unique) // I do what I want even if it's stupid :)
  ))

}