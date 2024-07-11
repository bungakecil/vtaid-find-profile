package id.bungamungil.vtaid_find_profile.youtube_api.response

data class YouTubeAPIChannels (

  var kind     : String?          = null,
  var etag     : String?          = null,
  var pageInfo : PageInfo?        = PageInfo(),
  var items    : ArrayList<Items> = arrayListOf()

)