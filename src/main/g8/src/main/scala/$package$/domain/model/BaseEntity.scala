package $package$.domain.model

import java.sql.Timestamp
import org.squeryl.KeyedEntity
import org.squeryl.annotations._

/**
 * Every model object has an id and a lestModified timestamp
 */
class BaseEntity extends KeyedEntity[Long] {

  @Column("id")
  val id:Long = 0

  @Column("lastmodified")
  var lastModified = new Timestamp(System.currentTimeMillis)

}
