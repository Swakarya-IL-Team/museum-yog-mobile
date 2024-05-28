
@Composable
fun StarRatingBar(
    maxStars: Int = 5,
    reviewRating: Float,
    onRatingChanged: (Float) -> Unit
) {
    val density = LocalDensity.current.density
    val starSize = (12f * density).dp
    val starSpacing = (0.5f * density).dp

    Row {
        for (i in 1..maxStars) {
            val isSelected = i <= reviewRating
            val icon = if (isSelected) painterResource(id = R.drawable.icon_bintang)else painterResource(id = R.drawable.icon_bintang_outlined)
            val iconTintColor = if (isSelected) Color(0xFFFED330) else Color(0xFFFED330)
            Icon(
                painter = icon, contentDescription = null,
                tint = iconTintColor,
                modifier = Modifier
                    .selectable(
                        selected = isSelected,
                        onClick = {
                            onRatingChanged(i.toFloat())
                        }
                    )
                    .width(starSize)
                    .height(starSize)
            )
            if (i < maxStars) {
                Spacer(modifier = Modifier.width(starSpacing))
            }
        }
    }
}