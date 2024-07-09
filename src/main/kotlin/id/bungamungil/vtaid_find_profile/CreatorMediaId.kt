package id.bungamungil.vtaid_find_profile

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*

@Embeddable
open class CreatorMediaId : Serializable {
    @Column(name = "creator_id", nullable = false)
    open var creatorId: Int? = null
        protected set

    @Column(name = "media_id", nullable = false, length = 180)
    open var mediaId: String? = null
        protected set

    override fun hashCode(): Int = Objects.hash(creatorId, mediaId)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as CreatorMediaId

        return creatorId == other.creatorId &&
                mediaId == other.mediaId
    }

    companion object {
        private const val serialVersionUID = -4406069978891834350L
    }
}