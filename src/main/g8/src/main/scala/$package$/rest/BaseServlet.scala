package $package$.rest

import org.scalatra._
import org.squeryl.PrimitiveTypeMode._
import com.codahale.jerkson.Json

import $package$.domain.Schema
import $package$.domain.model.User
import $package$.vo.Rsp

class BaseServlet extends ScalatraServlet {

  // ***************************************
  // GLOBAL METHODS

  before() {
    println("Before " + this.getClass)
  }
  after() {
    println("After " + this.getClass)
  }
  notFound {
    <html>
      <body>
        <h1>Ooops</h1>
        I'm terribly sorry, but we have a 404 not found problem here!
        {this.getClass}
      </body>
    </html>
  }

  // ***************************************
  // BUSINESS METHODS

  /**
   * Start page
   */
  get("/") {
    <html>
      <body>
        <h1>G8 scalatra/squeryl template</h1>
        <p>
          Base url : https://github.com/jrevault/g8-scalatra-squeryl
        </p>

        <h2>Introduction</h2>
        <p>
          Wonderfull, you are now the proud owner of a fully-functionnal working scalatra/squeryl project !<br />
          Imgine how many billions of years of evolution universe needed to come to this precise point !(Well... how useless is that point is out of current scope)...
        </p>

        <h2>Database</h2>
        <p>
          By default everything is configured for a PostgreSQL database named groovydb (lower case), so if you don't have one just jump inside PGAdmin or your console and create it !
          Otherwise if you want to changes these informations, modify them in src/ inside $package$StartupServlet<br />
          For instance here is your database configuration (well at least when the project was generated) :
          <ul>
            <li>Driver : $db_driver$</li>
            <li>URL : $db_url$</li>
            <li>Username : $db_username$</li>
            <li>Password : $db_password$</li>
            <li>Adapter : $db_adapter$ (list available <a href="http://squeryl.org/supported-databases.html" >here</a>)</li>
          </ul>
          Once your database is configured you can jump to the next section.
        </p>

        <h2>REST functions</h2>
        <p>
          What do we have in here :
          <ul>
            <li><a href="http://localhost:8080/" >http://localhost:8080/</a> : This web page</li>
            <li><a href="http://localhost:8080/db/init" >http://localhost:8080/db/init</a> : Initialises your database schema.<br />
            This URL should return a JSON string saying 'Schema created'</li>
          </ul>
          Now use some firefox plugin like <strong>REST Client</strong> in order to test these URLS :
          <ul>
            <li><b>METHOD</b>: POST, <b>URL</b> : http://localhost:8080/user/Arthur/Dent/42 : Creates a user named Arthur Dent of age 42</li>
            <li><b>METHOD</b>: POST, <b>URL</b> : http://localhost:8080/user/Marvin/Paranoid/89156484 : Creates a user named Marvin Paranoid of age 89156484</li>
            <li><b>METHOD</b>: GET, <b>URL</b> : http://localhost:8080/user/all : Retrieves all users from database</li>
            <li><b>METHOD</b>: GET, <b>URL</b> : http://localhost:8080/user/Arthur : Retrieves the user Arthur from database</li>
            <li><b>METHOD</b>: GET, <b>URL</b> : http://localhost:8080/user/Marvin : Retrieves the user Marvin from database</li>
            <li><b>METHOD</b>: DELETE, <b>URL</b> : http://localhost:8080/user/Arthur : Deletes the user Arthur from database</li>
          </ul>
          If you try to call an URL via GET instead of POST or DELETE, nothing will happen (this is a template not a complete application !<br />
          <br />
          Every URL returns JSON code, start hacking and have fun...
        </p>
      </body>
    </html>
  }

  get("/user/:firstname") {
    transaction {
      val data:User = Schema.t_user.where( r => r.firstname === params("firstname") ).single
      println("Data found : " + data.toString )
      Json.generate( new Rsp( "ok", data.toString ) )
    }
  }

  delete("/user/:firstname") {
    transaction {
      Schema.t_user.deleteWhere(r => r.firstname === params("firstname"))
      Json.generate( new Rsp( "ok", params("firstname")+ " deleted!" ) )
    }

  }
  
  post("/user/:firstname/:lastname/:age") {
    transaction {
      val data:User = Schema.t_user.insert( new User( params("firstname") , params("lastname") , params("age").toInt )  )
      println("Data added : " + data.toString )
      Json.generate( new Rsp( "ok", data.toString ) )
    }
  }

  get("/user/all") {
    transaction {
      Json.generate( new Rsp( "ok", Schema.t_user.toList ) )
    }
  }

  
  /**
   * Database schema initialisation, you should check localhost access only...
   */
  get("/db/init") {
    transaction {
      Schema.create
      println("Created the schema")
      Json.generate( new Rsp( "ok", "Schema created" ) )
    }
  }
}
