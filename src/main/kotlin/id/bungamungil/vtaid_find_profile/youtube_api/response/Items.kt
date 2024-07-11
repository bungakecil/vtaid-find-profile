package id.bungamungil.vtaid_find_profile.youtube_api.response

data class Items (

  var kind           : String?         = null,
  var etag           : String?         = null,
  var id             : String?         = null,
  var snippet        : Snippet?        = Snippet(),
  var contentDetails : ContentDetails? = ContentDetails(),
  var statistics     : Statistics?     = Statistics()

)