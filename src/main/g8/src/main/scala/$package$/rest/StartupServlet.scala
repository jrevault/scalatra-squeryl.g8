package $package$.rest

import javax.servlet.http.HttpServlet
import org.squeryl.Session
import org.squeryl.SessionFactory
import org.squeryl.adapters.PostgreSqlAdapter

/**
 * Startup Servlet :
 * - Database initialization
 */
class StartupServlet extends HttpServlet {

  val db_driver = "$db_driver$"
  val db_url = "$db_url$"
  val db_username = "$db_username$"
  val db_password = "$db_password$"
   
  override def init() = {
    Class.forName( db_driver );
    SessionFactory.concreteFactory = Some( ()=> Session.create(
        java.sql.DriverManager.getConnection( db_url, db_username, db_password ), new $db_adapter$ ) )
  }

}
