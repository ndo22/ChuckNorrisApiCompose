package com.example.chucknorrisapicompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


internal object Fonts {

    val SmallTitle = TextStyle(

        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp,
        fontFeatureSettings = "pnum, lnum",
    )

    val SmallBody = TextStyle(

        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp,
        fontFeatureSettings = "pnum, lnum",
    )

    val SmallCaption = TextStyle(

        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp,
        fontFeatureSettings = "pnum, lnum",
    )

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

    val LargeTitle = TextStyle(

        fontSize = 28.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 32.sp,
        fontFeatureSettings = "pnum, lnum",
    )

    val LargeBody = TextStyle(

        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 26.sp,
        fontFeatureSettings = "pnum, lnum",
    )

    val LargeCaption = TextStyle(

        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 26.sp,
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

val AppSmallTypography = Typography(
    h1 = Fonts.SmallTitle,
    h2 = Fonts.SmallTitle,
    h3 = Fonts.SmallTitle,
    h4 = Fonts.SmallTitle,
    h5 = Fonts.SmallTitle,
    h6 = Fonts.SmallTitle,
    subtitle1 = Fonts.SmallTitle,
    subtitle2 = Fonts.SmallTitle,
    body1 = Fonts.SmallBody,
    body2 = Fonts.SmallBody,
    button = Fonts.SmallBody,
    caption = Fonts.SmallCaption,
    overline = Fonts.SmallCaption
)


val AppLargeTypography = Typography(
    h1 = Fonts.LargeTitle,
    h2 = Fonts.LargeTitle,
    h3 = Fonts.LargeTitle,
    h4 = Fonts.LargeTitle,
    h5 = Fonts.LargeTitle,
    h6 = Fonts.LargeTitle,
    body1 = Fonts.LargeBody,
    body2 = Fonts.LargeBody,
    button = Fonts.LargeBody,
    caption = Fonts.LargeCaption,
    overline = Fonts.LargeCaption
)