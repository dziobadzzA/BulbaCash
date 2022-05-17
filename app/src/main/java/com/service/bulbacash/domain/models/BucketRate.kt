package com.service.bulbacash.domain.models

data class BucketRate(
    var firstElement: Rate?,
    var secondElement:Rate?,
    var coeffiecient: Double,
    var typeFirst: Int,
    var typeSecond: Int,
    var ID: Long
    )