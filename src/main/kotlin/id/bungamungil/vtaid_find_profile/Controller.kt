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
    fun findByYouTubeChannelIds(@RequestBody request: FindByYouTubeChannelIdsRequest): List<CreatorYouTubeChannelWithSampleMediaList> {
        val creatorYouTubeChannelList = creatorYouTubeChannelRepository.findCreatorYouTubeChannelsByIdCreatorPlatformIdIn(request.youTubeChannelIds)
        val creatorMediaList = creatorMediaRepository.findByCreatorPlatformIdIn(request.youTubeChannelIds)
        val uri = UriComponentsBuilder.fromUri(URI("https://youtube.googleapis.com/youtube/v3/channels"))
            .queryParam("part", "snippet,contentDetails,statistics")
            .queryParam("key", youTubeDataProperties.key)
            .queryParam("id", request.youTubeChannelIds)
            .build()
            .toUri()
        val youTubeChannels = restTemplate.getForEntity(uri, YouTubeAPIChannels::class.java).body?.items
        val response = ArrayList<CreatorYouTubeChannelWithSampleMediaList>()
        for (creatorYouTubeChannel in creatorYouTubeChannelList) {
            response.add(
                CreatorYouTubeChannelWithSampleMediaList(
                    creatorYouTubeChannel,
                    creatorMediaList.filter { creatorMedia -> creatorMedia.id?.creatorId == creatorYouTubeChannel.id?.creatorId }.take(2),
                    youTubeChannels?.firstOrNull { youTubeChannel -> youTubeChannel.id == creatorYouTubeChannel.id?.creatorPlatformId }?.snippet?.description
                )
            )
        }
        return response
    }

}
