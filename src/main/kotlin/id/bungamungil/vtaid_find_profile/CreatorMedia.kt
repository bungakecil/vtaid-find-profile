package id.bungamungil.vtaid_find_profile

import jakarta.persistence.*
import org.hibernate.annotations.Immutable
import java.time.Instant
import java.time.LocalTime

/**
 * Mapping for DB view
 */
@Immutable
@Table(name = "v_media_creator_with_timezone")
@Entity
open class CreatorMedia protected constructor() {
    @EmbeddedId
    open var id: CreatorMediaId? = null

    @Column(name = "creator_name", nullable = false, length = 200)
    open var creatorName: String? = null
        protected set

    @Column(name = "profile_id", length = 50)
    open var profileId: String? = null
        protected set

    @Column(name = "anon_id", nullable = false, length = 10)
    open var anonId: String? = null
        protected set

    @Column(name = "country_code", nullable = false, length = 2)
    open var countryCode: String? = null
        protected set

    @Column(name = "avatar_img", length = 200)
    open var avatarImg: String? = null
        protected set

    @Column(name = "avatar_img_media_platform", length = 4)
    open var avatarImgMediaPlatform: String? = null
        protected set

    @Column(name = "country_name", nullable = false, length = 100)
    open var countryName: String? = null
        protected set

    @Column(name = "media_platform_profile_name", nullable = false, length = 500)
    open var mediaPlatformProfileName: String? = null
        protected set

    @Column(name = "avatar_url", nullable = false, length = 500)
    open var avatarUrl: String? = null
        protected set

    @Column(name = "avatar_hash", nullable = false, length = 256)
    open var avatarHash: String? = null
        protected set

    @Column(name = "is_enable", nullable = false)
    open var isEnable: Byte? = null
        protected set

    @Column(name = "media_platform_code", nullable = false, length = 4)
    open var mediaPlatformCode: String? = null
        protected set

    @Column(name = "media_platform_name", nullable = false, length = 50)
    open var mediaPlatformName: String? = null
        protected set

    @Column(name = "creator_platform_id", nullable = false, length = 100)
    open var creatorPlatformId: String? = null
        protected set

    @Column(name = "title", nullable = false, length = 1000)
    open var title: String? = null
        protected set

    @Column(name = "media_type_code", length = 50)
    open var mediaTypeCode: String? = null
        protected set

    @Column(name = "media_type_name", nullable = false)
    open var mediaTypeName: String? = null
        protected set

    @Column(name = "thumbnail_url", nullable = false, length = 500)
    open var thumbnailUrl: String? = null
        protected set

    @Column(name = "view_count", nullable = false)
    open var viewCount: Long? = null
        protected set

    @Column(name = "comment_count", nullable = false)
    open var commentCount: Long? = null
        protected set

    @Column(name = "like_count", nullable = false)
    open var likeCount: Long? = null
        protected set

    @Column(name = "fav_count", nullable = false)
    open var favCount: Long? = null
        protected set

    @Column(name = "stream_ccv", columnDefinition = "int UNSIGNED")
    open var streamCcv: Long? = null
        protected set

    @Column(name = "stream_ccv_max", columnDefinition = "int UNSIGNED")
    open var streamCcvMax: Long? = null
        protected set

    @Column(name = "created_date", nullable = false)
    open var createdDate: Instant? = null
        protected set

    @Column(name = "media_duration")
    open var mediaDuration: LocalTime? = null
        protected set

    @Lob
    @Column(name = "stream_status")
    open var streamStatus: String? = null
        protected set

    @Column(name = "stream_date")
    open var streamDate: Instant? = null
        protected set

    @Column(name = "finished_date")
    open var finishedDate: Instant? = null
        protected set

    @Column(name = "content_created_date_timezoned")
    open var contentCreatedDateTimezoned: Instant? = null
        protected set

    @Lob
    @Column(name = "status", nullable = false)
    open var status: String? = null
        protected set

    @Column(name = "input_time", nullable = false)
    open var inputTime: Instant? = null
        protected set

    @Column(name = "modif_time", nullable = false)
    open var modifTime: Instant? = null
        protected set
}