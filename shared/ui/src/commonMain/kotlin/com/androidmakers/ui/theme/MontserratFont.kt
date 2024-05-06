package com.androidmakers.ui.theme

import androidmakersapp.shared.ui.generated.resources.Res
import androidmakersapp.shared.ui.generated.resources.montserrat_Black
import androidmakersapp.shared.ui.generated.resources.montserrat_BlackItalic
import androidmakersapp.shared.ui.generated.resources.montserrat_Bold
import androidmakersapp.shared.ui.generated.resources.montserrat_BoldItalic
import androidmakersapp.shared.ui.generated.resources.montserrat_ExtraBold
import androidmakersapp.shared.ui.generated.resources.montserrat_ExtraBoldItalic
import androidmakersapp.shared.ui.generated.resources.montserrat_ExtraLight
import androidmakersapp.shared.ui.generated.resources.montserrat_ExtraLightItalic
import androidmakersapp.shared.ui.generated.resources.montserrat_Italic
import androidmakersapp.shared.ui.generated.resources.montserrat_Light
import androidmakersapp.shared.ui.generated.resources.montserrat_LightItalic
import androidmakersapp.shared.ui.generated.resources.montserrat_Medium
import androidmakersapp.shared.ui.generated.resources.montserrat_MediumItalic
import androidmakersapp.shared.ui.generated.resources.montserrat_Regular
import androidmakersapp.shared.ui.generated.resources.montserrat_SemiBold
import androidmakersapp.shared.ui.generated.resources.montserrat_SemiBoldItalic
import androidmakersapp.shared.ui.generated.resources.montserrat_Thin
import androidmakersapp.shared.ui.generated.resources.montserrat_ThinItalic
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font


@Composable
fun montserratExtraLight() = Font(
  resource = Res.font.montserrat_ExtraLight,
  weight = FontWeight.ExtraLight,
  style = FontStyle.Normal
)

@Composable
fun montserratExtraLightItalic() = Font(
  resource = Res.font.montserrat_ExtraLightItalic,
  weight = FontWeight.ExtraLight,
  style = FontStyle.Italic
)

@Composable
fun montserratLight() = Font(
  resource = Res.font.montserrat_Light,
  weight = FontWeight.Light,
  style = FontStyle.Normal
)

@Composable
fun montserratLightItalic() = Font(
  resource = Res.font.montserrat_LightItalic,
  weight = FontWeight.Light,
  style = FontStyle.Italic
)

@Composable
fun montserratThin() = Font(
  resource = Res.font.montserrat_Thin,
  weight = FontWeight.Thin,
  style = FontStyle.Normal
)

@Composable
fun montserratThinItalic() = Font(
  resource = Res.font.montserrat_ThinItalic,
  weight = FontWeight.Thin,
  style = FontStyle.Italic
)

@Composable
fun montserratRegular() = Font(
  resource = Res.font.montserrat_Regular,
  weight = FontWeight.Normal,
  style = FontStyle.Normal
)

@Composable
fun montserratItalic() = Font(
  resource = Res.font.montserrat_Italic,
  weight = FontWeight.Normal,
  style = FontStyle.Italic
)

@Composable
fun montserratMedium() = Font(
  resource = Res.font.montserrat_Medium,
  weight = FontWeight.Medium,
  style = FontStyle.Normal
)

@Composable
fun montserratMediumItalic() = Font(
  resource = Res.font.montserrat_MediumItalic,
  weight = FontWeight.Medium,
  style = FontStyle.Italic
)

@Composable
fun montserratSemiBold() = Font(
  resource = Res.font.montserrat_SemiBold,
  weight = FontWeight.SemiBold,
  style = FontStyle.Normal
)

@Composable
fun montserratSemiBoldItalic() = Font(
  resource = Res.font.montserrat_SemiBoldItalic,
  weight = FontWeight.SemiBold,
  style = FontStyle.Italic
)

@Composable
fun montserratBold() = Font(
  resource = Res.font.montserrat_Bold,
  weight = FontWeight.Bold,
  style = FontStyle.Normal
)

@Composable
fun montserratBoldItalic() = Font(
  resource = Res.font.montserrat_BoldItalic,
  weight = FontWeight.Bold,
  style = FontStyle.Italic
)

@Composable
fun montserratExtraBold() = Font(
  resource = Res.font.montserrat_ExtraBold,
  weight = FontWeight.ExtraBold,
  style = FontStyle.Normal
)

@Composable
fun montserratExtraBoldItalic() = Font(
  resource = Res.font.montserrat_ExtraBoldItalic,
  weight = FontWeight.ExtraBold,
  style = FontStyle.Italic
)

@Composable
fun montserratBlack() = Font(
  resource = Res.font.montserrat_Black,
  weight = FontWeight.Black,
  style = FontStyle.Normal
)

@Composable
fun montserratBlackItalic() = Font(
  resource = Res.font.montserrat_BlackItalic,
  weight = FontWeight.Black,
  style = FontStyle.Italic
)

@Composable
fun montserratFamily() = FontFamily(
  montserratBlack(),
  montserratBlackItalic(),
  montserratBold(),
  montserratBoldItalic(),
  montserratExtraBold(),
  montserratExtraBoldItalic(),
  montserratExtraLight(),
  montserratExtraLightItalic(),
  montserratItalic(),
  montserratLight(),
  montserratLightItalic(),
  montserratMedium(),
  montserratMediumItalic(),
  montserratRegular(),
  montserratSemiBold(),
  montserratSemiBoldItalic(),
  montserratThin(),
  montserratThinItalic()
)
