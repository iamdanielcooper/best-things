package com.be.bestThings.user

import javax.persistence.*

@Entity
@Table(name = "users")
open class User(
    open val username: String,
    open val hashedPassword: String,
    open val isAdmin: Boolean? = false
) {
    @Id
    @SequenceGenerator(
        name = "userSequence",
        sequenceName = "userSequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "userSequence"
    )

    @Column(name = "id", nullable = false)
    open var id: Long? = null
}