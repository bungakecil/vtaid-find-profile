package id.bungamungil.vtaid_find_profile

import id.bungamungil.vtaid_find_profile.youtube_api.response.YouTubeAPIChannels
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI


@CrossOrigin
@RestController
@RequestMapping("/")
class Controller(
    private val creatorYouTubeChannelRepository: CreatorYouTubeChannelRepository,
    private val creatorMediaRepository: CreatorMediaRepository,
    private val restTemplate: RestTemplate,
    private val youTubeDataProperties: YouTubeDataProperties
) {

    @PostMapping
    fun findByYouTubeChannelIds(@RequestBody request: FindByYouTubeChannelIdsRequest): List<Awardee> {
        val creatorYouTubeChannelList = creatorYouTubeChannelRepository.findCreatorYouTubeChannelsByIdCreatorPlatformIdIn(request.youTubeChannelIds)
        val creatorMediaList = creatorMediaRepository.findByCreatorPlatformIdIn(request.youTubeChannelIds)
        val uri = UriComponentsBuilder.fromUri(URI("https://youtube.googleapis.com/youtube/v3/channels"))
            .queryParam("part", "snippet,contentDetails,statistics")
            .queryParam("key", youTubeDataProperties.key)
            .queryParam("id", request.youTubeChannelIds)
            .build()
            .toUri()
        val youTubeChannels = restTemplate.getForEntity(uri, YouTubeAPIChannels::class.java).body?.items
        val response = ArrayList<Awardee>()
        for (creatorYouTubeChannel in creatorYouTubeChannelList) {
            val channelInfo = youTubeChannels
                ?.firstOrNull { youTubeChannel -> youTubeChannel.id == creatorYouTubeChannel.id?.creatorPlatformId }
            response.add(
                Awardee(
                    creatorYouTubeChannel.id?.creatorPlatformId,
                    channelInfo?.snippet?.title,
                    channelInfo?.snippet?.thumbnails?.default?.url,
                    channelInfo?.snippet?.description,
                    creatorMediaList.filter { creatorMedia -> creatorMedia.id?.creatorId == creatorYouTubeChannel.id?.creatorId }.take(2).map {
                        Showcase(
                            it.id?.mediaId,
                            it.title,
                            it.thumbnailUrl,
                            "https://www.youtube.com/watch?v=" + it.id?.mediaId,
                            null
                        )
                    },
                    "https://pvc.moe/creator/p/" + creatorYouTubeChannel.anonId + "." + creatorYouTubeChannel.creatorName?.slugify()
                )
            )
        }
        return response
    }

}
