package $package$.domain.model

import org.squeryl.annotations.Column

/**
 * A User is someone ... awesome no ?
 */
case class User(
                 @Column("r_firstname") firstname: String,
                 @Column("r_lastname") lastname: String,
                 @Column("r_age") age: Int
               )
  extends BaseEntity

