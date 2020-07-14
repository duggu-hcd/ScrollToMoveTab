package duggu.scroll.tabchange

data class SubCategoryModel(
    val services: List<String?>? = null,
    val name: String? = "",
    var isSelected: Boolean = false,
    var scrollPosition : Int = 0
)