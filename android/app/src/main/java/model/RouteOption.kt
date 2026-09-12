package com.smarttransit.app.model

data class RouteOption(
    val typeLabel: String,
    val segmentIcons: String,
    val duration: String,
    val cost: String,
    val walkingDistance: String,
    val isRecommended: Boolean
)