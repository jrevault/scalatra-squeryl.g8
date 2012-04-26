package com.jispot.rest

import javax.servlet.http.HttpServlet
import org.squeryl.Session
import org.squeryl.SessionFactory
import org.squeryl.adapters.PostgreSqlAdapter

/**
 * Startup Servlet :
 * - Database initialization
 */
class StartupServlet extends HttpServlet {

  val db_driver = "org.postgresql.Driver"
  val db_url = "jdbc:postgresql://localhost:5432/jispot"
  val db_username = "postgres"
  val db_password = "123erty"
   
  override def init() = {
    Class.forName( db_driver );
    SessionFactory.concreteFactory = Some( ()=> Session.create(
        java.sql.DriverManager.getConnection( db_url, db_username, db_password ), new PostgreSqlAdapter ) )
  }

}
