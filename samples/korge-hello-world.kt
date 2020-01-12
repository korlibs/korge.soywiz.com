import com.soywiz.klock.*
import com.soywiz.korge.*
import com.soywiz.korge.tween.*
import com.soywiz.korge.view.*
import com.soywiz.korim.format.*
import com.soywiz.korio.async.*
import com.soywiz.korio.file.std.*
import com.soywiz.korma.geom.*
import com.soywiz.korma.interpolation.*

suspend fun main() = Korge(width = 512, height = 512) {
    val minAngle = (-16).degrees
    val maxAngle = (+16).degrees

    val image = image(resourcesVfs["korge.png"].readBitmap()) {
        rotation = maxAngle
        anchor(.5, .5)
        scale(.8)
        position(256, 256)
    }

    while (true) {
        image.tween(
                image::rotation[minAngle],
                time = 1.seconds, easing = Easing.EASE_IN_OUT
        )
        image.tween(
                image::rotation[maxAngle],
                time = 1.seconds, easing = Easing.EASE_IN_OUT
        )
    }
}