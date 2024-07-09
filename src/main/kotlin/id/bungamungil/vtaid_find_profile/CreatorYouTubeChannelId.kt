package id.bungamungil.vtaid_find_profile

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*

@Embeddable
open class CreatorYouTubeChannelId : Serializable {
    @Column(name = "creator_id", nullable = false)
    open var creatorId: Int? = null
        protected set

    @Column(name = "creator_platform_id", length = 100)
    open var creatorPlatformId: String? = null
        protected set

    override fun hashCode(): Int = Objects.hash(creatorId, creatorPlatformId)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as CreatorYouTubeChannelId

        return creatorId == other.creatorId &&
                creatorPlatformId == other.creatorPlatformId
    }

    companion object {
        private const val serialVersionUID = -79257183420046546L
    }
}