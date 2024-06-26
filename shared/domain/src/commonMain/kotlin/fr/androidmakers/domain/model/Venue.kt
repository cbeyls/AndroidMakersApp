package fr.androidmakers.domain.model

data class Venue(
    var address: String = "",
    var coordinates: String = "",
    var description: String = "",
    var descriptionFr: String = "",
    var imageUrl: String = "",
    val floorPlanUrl: String?,
    var name: String = "No Venue"
)
