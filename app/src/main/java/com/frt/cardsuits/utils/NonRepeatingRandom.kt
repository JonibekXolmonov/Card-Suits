package com.frt.cardsuits.utils

import com.frt.cardsuits.R

object NonRepeatingRandom {
    private var previous = 1

    private fun retrieve(): Int {

        val rand = (1..4).random()
        return if (rand == previous) {
            retrieve() // recursive call if two subsequent retrieve() calls would return the same number
        } else {
            previous = rand // remember last random number
            rand
        }
    }

    private val images =
        listOf(R.drawable.spade, R.drawable.club, R.drawable.diamond, R.drawable.heart)

    fun getRandomImageId() = images.random()
}