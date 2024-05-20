package com.swakarya.museumyog.presentation.ProfileMenu.KebijakanPrivasi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swakarya.museumyog.R
import com.swakarya.museumyog.ui.theme.MuseumyogmobileTheme
import com.swakarya.museumyog.ui.theme.greenku
import com.swakarya.museumyog.ui.theme.worksans
import com.swakarya.museumyog.ui.theme.worksansbold

@Composable
fun KebijakanPrivasi(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Box(contentAlignment = Alignment.TopCenter) {
            Image(
                painter = painterResource(id = R.drawable.background_edit_bahasa),
                contentDescription = "Background Edit Bahasa",
                alignment = Alignment.TopCenter
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box {
                    IconButton(
                        modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                        onClick = { /*TODO*/ }) {
                        Box(
                            modifier = Modifier
                                .background(Color.White, CircleShape)
                                .padding(horizontal = 1.dp, vertical = 1.dp)
                        ) {
                            Icon(
                                modifier = Modifier.size(30.dp),
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "IconBack",
                                tint = greenku
                            )
                        }

                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Text(
                            text = "Kebijakan Privasi",
                            fontFamily = worksansbold,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(33.dp))

        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = "Efektif pada: [Tanggal]\n" +
                        "Kami, Swakarya, menghargai kepercayaan Anda pada kami untuk menjaga informasi pribadi Anda aman. " +
                        "Kebijakan Privasi ini menjelaskan bagaimana kami mengumpulkan, menggunakan, dan melindungi informasi pribadi Anda ketika Anda menggunakan aplikasi pemesanan tiket museum dan informasi museum kami.",
                fontFamily = worksans,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Justify
            )

            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Informasi yang Kami Kumpulkan:",
                fontFamily = worksans,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Justify
            )
            Row {
                Text(
                    modifier = Modifier.padding(start = 8.dp, bottom = 4.dp),
                    text = "1. ",
                    fontFamily = worksans,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    textAlign = TextAlign.Justify
                )

                Text(
                    modifier = Modifier.padding(start = 8.dp, bottom = 4.dp),
                    text = "Informasi Pribadi: Kami dapat mengumpulkan informasi pribadi Anda seperti nama, alamat email, nomor telepon, dan informasi pembayaran ketika Anda menggunakan layanan kami.",
                    fontFamily = worksans,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    textAlign = TextAlign.Justify
                )
            }

            Row {
                Text(
                    modifier = Modifier.padding(start = 8.dp, bottom = 16.dp),
                    text = "2. ",
                    fontFamily = worksans,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    textAlign = TextAlign.Justify
                )

                Text(
                    modifier = Modifier.padding(start = 8.dp, bottom = 16.dp),
                    text = "Informasi Penggunaan: Kami dapat mengumpulkan informasi tentang bagaimana Anda menggunakan aplikasi kami, termasuk riwayat pencarian, aktivitas browsing, dan interaksi dengan fitur-fitur aplikasi.",
                    fontFamily = worksans,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    textAlign = TextAlign.Justify
                )
            }

            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Bagaimana Kami Menggunakan Informasi Anda: ",
                fontFamily = worksans,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Justify
            )

            Row {
                Text(
                    modifier = Modifier.padding(start = 8.dp, bottom = 4.dp),
                    text = "1. ",
                    fontFamily = worksans,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    textAlign = TextAlign.Justify
                )

                Text(
                    modifier = Modifier.padding(start = 8.dp, bottom = 4.dp),
                    text = "Memberikan Layanan: Kami menggunakan informasi Anda untuk memproses pemesanan tiket museum, mengirimkan konfirmasi, dan memberikan informasi terkait kunjungan Anda.",
                    fontFamily = worksans,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    textAlign = TextAlign.Justify
                )
            }

            Row {
                Text(
                    modifier = Modifier.padding(start = 8.dp, bottom = 16.dp),
                    text = "2. ",
                    fontFamily = worksans,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    textAlign = TextAlign.Justify
                )

                Text(
                    modifier = Modifier.padding(start = 8.dp, bottom = 16.dp),
                    text = "Perbaikan Layanan: Kami menggunakan informasi penggunaan untuk memahami kebutuhan pengguna, meningkatkan layanan kami, dan menyesuaikan pengalaman pengguna.",
                    fontFamily = worksans,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    textAlign = TextAlign.Justify
                )
            }

            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Bagaimana Kami Berbagi Informasi Anda: ",
                fontFamily = worksans,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Justify
            )
            Row {
                Text(
                    modifier = Modifier.padding(start = 8.dp, bottom = 4.dp),
                    text = "1. ",
                    fontFamily = worksans,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    textAlign = TextAlign.Justify
                )

                Text(
                    modifier = Modifier.padding(start = 8.dp, bottom = 4.dp),
                    text = "Mitra Layanan: Kami dapat berbagi informasi Anda dengan mitra layanan seperti penyedia pembayaran untuk memproses pembayaran Anda.",
                    fontFamily = worksans,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    textAlign = TextAlign.Justify
                )
            }

            Row {
                Text(
                    modifier = Modifier.padding(start = 8.dp, bottom = 16.dp),
                    text = "2. ",
                    fontFamily = worksans,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    textAlign = TextAlign.Justify
                )

                Text(
                    modifier = Modifier.padding(start = 8.dp, bottom = 16.dp),
                    text = "Kepatuhan Hukum: Kami dapat mengungkap informasi Anda jika diperlukan untuk mematuhi hukum atau perintah pengadilan.",
                    fontFamily = worksans,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    textAlign = TextAlign.Justify
                )
            }

            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Keamanan Informasi Anda:",
                fontFamily = worksans,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Justify
            )
            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = "Kami berkomitmen untuk melindungi informasi pribadi Anda dan mengimplementasikan langkah-langkah keamanan yang sesuai untuk mencegah akses yang tidak sah, penggunaan, atau pengungkapan.",
                fontFamily = worksans,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Justify
            )

            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Perubahan Kebijakan Privasi:",
                fontFamily = worksans,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Justify
            )

            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = "Kami dapat memperbarui Kebijakan Privasi ini dari waktu ke waktu dan akan memberi tahu Anda tentang perubahan melalui pembaruan aplikasi atau kontak langsung.",
                fontFamily = worksans,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Justify
            )

            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = "Dengan menggunakan aplikasi kami, Anda menyetujui pengumpulan, penggunaan, dan pengungkapan informasi Anda sesuai dengan Kebijakan Privasi ini.",
                fontFamily = worksans,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Justify
            )

            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Jika Anda memiliki pertanyaan atau kekhawatiran tentang Kebijakan Privasi kami, silakan hubungi kami di [Email Kontak].",
                fontFamily = worksans,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Justify
            )

            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Terima kasih telah menggunakan aplikasi kami.",
                fontFamily = worksans,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview
@Composable
fun KebijakanPrivasiPreview() {
    MuseumyogmobileTheme {
        KebijakanPrivasi()
    }
}