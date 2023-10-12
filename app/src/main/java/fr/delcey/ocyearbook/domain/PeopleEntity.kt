package fr.delcey.ocyearbook.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PeopleEntity(
    val id: Int,
    @DrawableRes
    val photoDrawableRes: Int,
    @StringRes
    val photoContentDescription: Int,
    @StringRes
    val name: Int,
    @StringRes
    val roleStringRes: Int,
    @StringRes
    val firstLanguageStringRes: Int,
    @StringRes
    val secondLanguageStringRes: Int?,
    @StringRes
    val greetStringRes: Int,
)