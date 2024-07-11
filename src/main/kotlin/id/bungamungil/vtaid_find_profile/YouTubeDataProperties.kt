package id.bungamungil.vtaid_find_profile

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("vtaid.youtube-data")
class YouTubeDataProperties {

    var key: String = ""

}