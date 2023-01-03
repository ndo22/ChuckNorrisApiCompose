package com.example.chucknorrisapicompose.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
)

val AppShapes = Shapes(
        small = RoundedCornerShape(percent = 25),
        medium = RoundedCornerShape(size = 8.dp),
        large = RoundedCornerShape(size = 0.dp)
)