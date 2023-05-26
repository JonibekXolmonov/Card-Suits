package com.frt.cardsuits.screens.game

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frt.cardsuits.R
import com.frt.cardsuits.utils.NonRepeatingRandom
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor() : ViewModel() {

    private val _score = mutableStateOf(0)
    val score get() = _score

    private val _lives = mutableStateOf(3)
    val lives get() = _lives

    private val _time = mutableStateOf(6000)
    val time get() = _time

    private val _image1 = mutableStateOf(images.random())
    val image1 get() = _image1

    private val _image2 = mutableStateOf(images.random())
    val image2 get() = _image2

    private val _image3 = mutableStateOf(images.random())
    val image3 get() = _image3

    private val _image4 = mutableStateOf(images.random())
    val image4 get() = _image4

    private val _image5 = mutableStateOf(images.random())
    val image5 get() = _image5

    private val _image6 = mutableStateOf(images.random())
    val image6 get() = _image6

    private val _image7 = mutableStateOf(images.random())
    val image7 get() = _image7

    private val _image8 = mutableStateOf(images.random())
    val image8 get() = _image8

    private val _image9 = mutableStateOf(images.random())
    val image9 get() = _image9

    private val _image10 = mutableStateOf(images.random())
    val image10 get() = _image10

    private val _image11 = mutableStateOf(images.random())
    val image11 get() = _image11

    private val _image12 = mutableStateOf(images.random())
    val image12 get() = _image12

    fun accelerate() {
        viewModelScope.launch {
            while (isActive) {
                delay(6000)
                if (_time.value >= 4000) {
                    _time.value -= 500
                }
            }
        }
    }

    fun generate1() {
        viewModelScope.launch {
            _image1.value = images.random()
        }
    }

    fun generate2() {
        viewModelScope.launch {
            _image2.value = images.random()
        }
    }

    fun generate3() {
        viewModelScope.launch {
            _image3.value = images.random()
        }
    }

    fun generate4() {
        viewModelScope.launch {
            _image4.value = images.random()
        }
    }

    fun generate5() {
        viewModelScope.launch {
            _image5.value = images.random()
        }
    }

    fun generate6() {
        viewModelScope.launch {
            _image6.value = images.random()
        }
    }

    fun generate7() {
        viewModelScope.launch {
            _image7.value = images.random()
        }
    }

    fun generate8() {
        viewModelScope.launch {
            _image8.value = images.random()
        }
    }

    fun generate9() {
        viewModelScope.launch {
            _image9.value = images.random()
        }
    }

    fun generate10() {
        viewModelScope.launch {
            _image10.value = images.random()
        }
    }

    fun generate11() {
        viewModelScope.launch {
            _image11.value = images.random()
        }
    }

    fun generate12() {
        viewModelScope.launch {
            _image12.value = images.random()
        }
    }

    //x offset
    private val _xOffset1 = mutableStateOf(10.dp)
    val xOffset1 get() = _xOffset1

    private val _xOffset2 = mutableStateOf(12.dp)
    val xOffset2 get() = _xOffset2

    private val _xOffset3 = mutableStateOf(0.dp)
    val xOffset3 get() = _xOffset3

    private val _xOffset4 = mutableStateOf(10.dp)
    val xOffset4 get() = _xOffset4

    private val _xOffset5 = mutableStateOf(12.dp)
    val xOffset5 get() = _xOffset5

    private val _xOffset6 = mutableStateOf(8.dp)
    val xOffset6 get() = _xOffset6

    private val _xOffset7 = mutableStateOf((-10).dp)
    val xOffset7 get() = _xOffset7

    private val _xOffset8 = mutableStateOf(12.dp)
    val xOffset8 get() = _xOffset8

    private val _xOffset9 = mutableStateOf((-10).dp)
    val xOffset9 get() = _xOffset9

    private val _xOffset10 = mutableStateOf(8.dp)
    val xOffset10 get() = _xOffset10

    private val _xOffset11 = mutableStateOf((-10).dp)
    val xOffset11 get() = _xOffset11

    private val _xOffset12 = mutableStateOf(12.dp)
    val xOffset12 get() = _xOffset12

    fun generateOffset1() {
        viewModelScope.launch {
            _xOffset1.value = (-20..20).random().dp
        }
    }

    fun generateOffset2() {
        viewModelScope.launch {
            _xOffset2.value = (-20..20).random().dp
        }
    }

    fun generateOffset3() {
        viewModelScope.launch {
            _xOffset3.value = (-20..20).random().dp
        }
    }

    fun generateOffset4() {
        viewModelScope.launch {
            _xOffset4.value = (-20..20).random().dp
        }
    }

    fun generateOffset5() {
        viewModelScope.launch {
            _xOffset5.value = (-20..20).random().dp
        }
    }

    fun generateOffset6() {
        viewModelScope.launch {
            _xOffset6.value = (-20..20).random().dp
        }
    }

    fun generateOffset7() {
        viewModelScope.launch {
            _xOffset7.value = (-20..20).random().dp
        }
    }

    fun generateOffset8() {
        viewModelScope.launch {
            _xOffset8.value = (-20..20).random().dp
        }
    }

    fun generateOffset9() {
        viewModelScope.launch {
            _xOffset9.value = (-20..20).random().dp
        }
    }

    fun generateOffset10() {
        viewModelScope.launch {
            _xOffset10.value = (-20..20).random().dp
        }
    }

    fun generateOffset11() {
        viewModelScope.launch {
            _xOffset11.value = (-20..20).random().dp
        }
    }

    fun generateOffset12() {
        viewModelScope.launch {
            _xOffset12.value = (-20..20).random().dp
        }
    }

    fun decreaseLive() {
        viewModelScope.launch {
            _lives.value--
        }
    }

    fun increaseScore() {
        viewModelScope.launch {
            _score.value++
        }
    }

    fun reset() {
        _lives.value = 3
        _score.value = 0
        _time.value = 6000
    }
}

val images =
    listOf(R.drawable.spade, R.drawable.club, R.drawable.diamond, R.drawable.heart)