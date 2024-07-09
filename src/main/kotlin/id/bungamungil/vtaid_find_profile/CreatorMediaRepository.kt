package id.bungamungil.vtaid_find_profile

import org.springframework.data.jpa.repository.JpaRepository

interface CreatorMediaRepository: JpaRepository<CreatorMedia, CreatorMediaId> {

    fun findByCreatorPlatformIdIn(youTubeChannelIds: List<String>): List<CreatorMedia>

}
