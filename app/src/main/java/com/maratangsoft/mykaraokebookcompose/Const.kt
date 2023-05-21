package com.maratangsoft.mykaraokebookcompose

const val FAVORITE = "FAVORITE"
const val SEARCH = "SEARCH"
const val NEW_SONG = "NEW_SONG"
const val POPULAR = "POPULAR"

enum class Brand(val text: Int) {
    TJ(R.string.radio_btn_tj),
    KY(R.string.radio_btn_ky)
}

enum class SortType(val text: Int) {
    FAVORITED_DESC(R.string.favorite_dropdown_fav_desc), // default
    TITLE_ASC(R.string.favorite_dropdown_title_asc),
    NUMBER_ASC(R.string.favorite_dropdown_no_asc),
    SINGER_ASC(R.string.favorite_dropdown_singer_asc),
}

enum class SearchType(val text: Int) {
    TITLE(R.string.search_dropdown_title), // default
    NUMBER(R.string.search_dropdown_no),
    SINGER(R.string.search_dropdown_singer)
}

enum class MonthType {
    THIS_MONTH, // default
    LAST_MONTH,
    TWO_MONTHS_BEFORE,
    THREE_MONTHS_BEFORE,
    FOUR_MONTHS_BEFORE
}

enum class Language(val text: Int) {
    KO(R.string.lan_ko), // default
    EN(R.string.lan_en),
    JA(R.string.lan_ja),
    ZH(R.string.lan_zh)
}