package com.example.myapp.models

import org.springframework.data.util.ProxyUtils
import java.io.Serializable
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

/**
 * Abstract class so that we can ensure all requirements for Hibernate model classes are fulfilled.
 */
@MappedSuperclass
abstract class AbstractModelPersistable<T : Serializable> {
    companion object {
        /**
         * Static final value for serializable version uid (since this is a Serializable).
         */
        private val serializableVersionUID = -5554308939380869754L
    }

    @Id
    @GeneratedValue
    private var id: T? = null

    fun getId(): T? = id

    /**
     * Always returns 31 so that the requirement for non-changing hashcodes is satisfied
     * (change later?).
     */
    override fun hashCode(): Int = 31

    /**
     * Easy toString method
     */
    override fun toString(): String = "Entity of type ${this.javaClass.name} with id: $id"

    /**
     * Standard equals, returns true if this id is equal to that id
     */
    override fun equals(other: Any?): Boolean {
        other ?: return false

        if (this === other) return true

        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as AbstractModelPersistable<*>

        return if (null == this.getId()) false else this.getId() == other.getId()
    }
}