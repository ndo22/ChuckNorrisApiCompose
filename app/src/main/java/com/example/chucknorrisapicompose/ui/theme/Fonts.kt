package com.example.chucknorrisapicompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


internal object Fonts {
    val Title = TextStyle(

        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 26.sp,
        fontFeatureSettings = "pnum, lnum",
    )

    val Body = TextStyle(

        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp,
        fontFeatureSettings = "pnum, lnum",
    )

    val Caption = TextStyle(

        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp,
        fontFeatureSettings = "pnum, lnum",
    )
}

val AppTypography = Typography(
    h1 = Fonts.Title,
    h2 = Fonts.Title,
    h3 = Fonts.Title,
    h4 = Fonts.Title,
    h5 = Fonts.Title,
    h6 = Fonts.Title,
    subtitle1 = Fonts.Title,
    subtitle2 = Fonts.Title,
    body1 = Fonts.Body,
    body2 = Fonts.Body,
    button = Fonts.Body,
    caption = Fonts.Caption,
    overline = Fonts.Caption
)