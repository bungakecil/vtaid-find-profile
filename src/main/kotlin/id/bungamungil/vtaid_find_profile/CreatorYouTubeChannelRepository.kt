package id.bungamungil.vtaid_find_profile

import org.springframework.data.jpa.repository.JpaRepository

interface CreatorYouTubeChannelRepository: JpaRepository<CreatorYouTubeChannel, CreatorYouTubeChannelId> {

    fun findCreatorYouTubeChannelsByIdCreatorPlatformIdIn(youTubeChannelIds: List<String>): List<CreatorYouTubeChannel>

}