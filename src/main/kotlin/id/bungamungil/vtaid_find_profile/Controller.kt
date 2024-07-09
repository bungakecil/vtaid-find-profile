package id.bungamungil.vtaid_find_profile

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@RequestMapping("/")
class Controller(
    private val creatorYouTubeChannelRepository: CreatorYouTubeChannelRepository,
    private val creatorMediaRepository: CreatorMediaRepository,
) {

    @PostMapping
    fun findByYouTubeChannelIds(@RequestBody request: FindByYouTubeChannelIdsRequest): List<CreatorYouTubeChannelWithSampleMediaList> {
        val creatorYouTubeChannelList = creatorYouTubeChannelRepository.findCreatorYouTubeChannelsByIdCreatorPlatformIdIn(request.youTubeChannelIds)
        val creatorMediaList = creatorMediaRepository.findByCreatorPlatformIdIn(request.youTubeChannelIds)
        val response = ArrayList<CreatorYouTubeChannelWithSampleMediaList>()
        for (creatorYouTubeChannel in creatorYouTubeChannelList) {
            response.add(
                CreatorYouTubeChannelWithSampleMediaList(
                    creatorYouTubeChannel,
                    creatorMediaList.filter { creatorMedia -> creatorMedia.id?.creatorId == creatorYouTubeChannel.id?.creatorId }.take(2)
                )
            )
        }
        return response
    }

}
