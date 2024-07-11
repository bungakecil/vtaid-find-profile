package id.bungamungil.vtaid_find_profile

data class Awardee(
    val id: String?,
    val name: String?,
    val profileImageURL: String?,
    val biography: String?,
    val showcases: List<Showcase>?,
    val pvcProfileURL: String?
)
