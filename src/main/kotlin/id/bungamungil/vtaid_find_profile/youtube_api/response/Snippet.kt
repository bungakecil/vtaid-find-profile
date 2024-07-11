package id.bungamungil.vtaid_find_profile.youtube_api.response

data class Snippet (

  var title       : String?     = null,
  var description : String?     = null,
  var customUrl   : String?     = null,
  var publishedAt : String?     = null,
  var thumbnails  : Thumbnails? = Thumbnails(),
  var localized   : Localized?  = Localized(),
  var country     : String?     = null

)