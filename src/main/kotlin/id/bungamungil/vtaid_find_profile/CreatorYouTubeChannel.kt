package id.bungamungil.vtaid_find_profile

import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.hibernate.annotations.Immutable
import java.time.Instant
import java.time.LocalDate

/**
 * Mapping for DB view
 */
@Immutable
@Table(name = "v_creator_media_platform_yutu")
@Entity
open class CreatorYouTubeChannel protected constructor() {
    @EmbeddedId
    open var id: CreatorYouTubeChannelId? = null

    @Column(name = "creator_name", length = 500)
    open var creatorName: String? = null
        protected set

    @Column(name = "use_media_platform_name", nullable = false)
    open var useMediaPlatformName: Byte? = null
        protected set

    @Column(name = "creator_type_code", nullable = false, length = 6)
    open var creatorTypeCode: String? = null
        protected set

    @Column(name = "persona", nullable = false, length = 300)
    open var persona: String? = null
        protected set

    @Column(name = "anon_id", nullable = false, length = 10)
    open var anonId: String? = null
        protected set

    @Column(name = "profile_id", length = 50)
    open var profileId: String? = null
        protected set

    @Column(name = "birth_date")
    open var birthDate: LocalDate? = null
        protected set

    @Column(name = "gender_code")
    open var genderCode: Char? = null
        protected set

    @Column(name = "debut_date")
    open var debutDate: LocalDate? = null
        protected set

    @Column(name = "belong_to_user", length = 50)
    open var belongToUser: String? = null
        protected set

    @Column(name = "affiliate_id")
    open var affiliateId: Int? = null
        protected set

    @Column(name = "avatar_img", length = 200)
    open var avatarImg: String? = null
        protected set

    @Column(name = "avatar_img_media_platform", length = 4)
    open var avatarImgMediaPlatform: String? = null
        protected set

    @Column(name = "input_time", nullable = false)
    open var inputTime: Instant? = null
        protected set

    @Column(name = "modif_time", nullable = false)
    open var modifTime: Instant? = null
        protected set

    @Column(name = "media_platform_code", length = 4)
    open var mediaPlatformCode: String? = null
        protected set

    @Column(name = "media_platform_profile_name", length = 500)
    open var mediaPlatformProfileName: String? = null
        protected set

    @Column(name = "is_enable", nullable = false)
    open var isEnable: Boolean? = false
        protected set

    @Column(name = "follower_count")
    open var followerCount: Int? = null
        protected set

    @Column(name = "view_count")
    open var viewCount: Int? = null
        protected set

    @Column(name = "media_count")
    open var mediaCount: Int? = null
        protected set

    @Column(name = "avatar_url", length = 500)
    open var avatarUrl: String? = null
        protected set

    @Column(name = "avatar_hash", length = 256)
    open var avatarHash: String? = null
        protected set

    @Column(name = "has_membership")
    open var hasMembership: Byte? = null
        protected set

    @Column(name = "creator_card_path", length = 300)
    open var creatorCardPath: String? = null
        protected set

    @Column(name = "creator_card_file_name", length = 300)
    open var creatorCardFileName: String? = null
        protected set

    @Column(name = "country_code", nullable = false, length = 2)
    open var countryCode: String? = null
        protected set

    @Column(name = "active_time", length = 50)
    open var activeTime: String? = null
        protected set

    @Column(name = "country_name", length = 100)
    open var countryName: String? = null
        protected set

    @Column(name = "last_activity")
    open var lastActivity: Instant? = null
        protected set

    @Column(name = "media_platform_name", length = 50)
    open var mediaPlatformName: String? = null
        protected set

    @Column(name = "affiliate_name")
    open var affiliateName: String? = null
        protected set

    @Column(name = "last_activity_datediff")
    open var lastActivityDatediff: Int? = null
        protected set
}