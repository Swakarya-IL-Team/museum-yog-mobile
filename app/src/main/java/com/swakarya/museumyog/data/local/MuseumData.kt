package com.swakarya.museumyog.data.local

import com.swakarya.museumyog.R
import com.swakarya.museumyog.data.local.entity.EventInfo
import com.swakarya.museumyog.data.local.entity.FasilitasInfo
import com.swakarya.museumyog.data.local.entity.KoleksiItem
import com.swakarya.museumyog.data.local.entity.Museum
import com.swakarya.museumyog.data.local.entity.Review
import com.swakarya.museumyog.data.local.entity.TransportInfo

object MuseumData {
    val initialMuseums = listOf(
        Museum(
            1,
            "Museum Keraton Ngayogyakarta Hadiningrat",
            listOf(
                R.drawable.museum_keraton,
                R.drawable.museum_keraton1,
                R.drawable.museum_keraton2
            ),
            "2.5 km",
            "Jl. Rotowijayan, Kadipaten",
            "5.0",
            "200-250 Kunjungan/Hari",
            "Museum Keraton Ngayogyakarta Hadiningrat atau keraton yogyakarta merupakan istana resmi Kesultanan Ngayogyakarta Hadiningrat yang kini berlokasi di Kota Yogyakarta, Daerah Istimewa yogyakarta, Indonesia. ",
            "Jl. Rotowijayan, Kadipaten, Kecamatan Kraton, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55132",
            "082226373138",
            "08.00 - 13.30 WIB",
            listOf(
                TransportInfo("train", "Stasiun Lempuyangan", "100m"),
                TransportInfo("train", "Stasiun Yogyakarta", "100m")
            ),
            listOf(
                FasilitasInfo("toilet", "Toilet Duduk dan Jongkok"),
                FasilitasInfo("masjid", "Masjid Bersih")
            ),
            eventInfo = listOf(
                EventInfo(R.drawable.event, "Workshop Membatik Hadir Kembali!", "25 Agustus 2024")
            ),
            koleksi = listOf(
                KoleksiItem(
                    image = R.drawable.koleksi1,
                    name = "Koleksi Sri Sultan Hamenkubuwana IX",
                    description = "Sejumlah koleksi peninggalan Sri Sultan HB IX, antara lain foto-foto, piagam,medali,tanda jasa,surat keputusan presiden, baju-baju bersejarah beliau,koleksi mobil-mobilan beliau sewaktu kecil,peralatan memasak,kamera yang sering di pergunakan beliau, dan berbagai benda lainnya."
                ),
                KoleksiItem(
                    image = R.drawable.kolesi2,
                    name = "Museum Batik Keraton Yogya",
                    description = "Di Museum Batik menyimpan berbagai macam koleksi kain batik,patung,lukisan,topeng batik,bahan-bahan pewarna,peralatan membatik,serta sepeda tua sebagai pengangkut batik ( dari masa HB VIII s/d HB X ). Koleksi ini merupakan hibah dari dari trah Sri Sultan dan hibah di pengusaha Batik di Yogyakarta."
                ),
                KoleksiItem(
                    image = R.drawable.koleksi3,
                    name = "Koleksi Museum Kristal",
                    description = "Museum Kristal menyimpan berbagai koleksi kristal milik Keraton, seperti kristal polos, guci,hiasan meja,kristal tempat buah, meja rias dari kuningan dan koleksi berbagai benda lainnya."
                )
            ),
            reviews = listOf(
                Review(
                    name = "Tegar Wibisana",
                    rate = "5.0",
                    date = "10 Agustus 2023",
                    comment = "Fasilitas di Museum Keraton Ngayogyakarta Hadiningrat cukup baik, namun ada ruang untuk peningkatan. Tetap memungkinkan pengunjung menikmati koleksi berharga dan merasakan kekayaan budaya Jawa."
                ),
                Review(
                    name = "Althaaf",
                    rate = "4.5",
                    date = "10 Agustus 2024",
                    comment = "ga expect museum nya seru banget! buat semua kalangan umur juga pasti seru dan nyaman. tempatnya bersih dan adem. baru tau museum kereta nya modern dan banyak fitur seruu, dari self photo yang bisa di download, ada permainan lari sama tangkap dari xbox, bisa mewarnai terus gambar nya nanti di scan terus muncul!\uD83E\uDD29 terus setiap liat koleksi keretanya jadi takjub sendiri karena keren keren apalagu kereta yang ga boleh di foto, keren banget belajar sejarahnya. pokoknya harus dateng karena seruu!!!"
                )
            )
        ),
        Museum(
            2,
            "Museum Dirgantara Mandala",
            listOf(
                R.drawable.museum_dirgantara,
                R.drawable.museum_dirgantara1,
                R.drawable.museum_dirgantara2,
                R.drawable.museum_dirgantara3
            ),

            "1.2 km",
            "Kompleks Pangkalan Udara Adisupcipto",
            "5.0",
            "200-250 Kunjungan/Hari",
            "Deskripsi Museum Keraton",
            "Jl. Rotowijayan, Kadipaten, Kecamatan Kraton, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55132",
            "082226373138",
            "08.00 - 13.30 WIB",
            listOf(
                TransportInfo("train", "Stasiun Lempuyangan", "100m"),
                TransportInfo("train", "Stasiun Yogyakarta", "100m")
            ),
            listOf(
                FasilitasInfo("toilet", "Toilet Duduk dan Jongkok"),
                FasilitasInfo("masjid", "Masjid Bersih")
            ),
            eventInfo = listOf(
                EventInfo(R.drawable.event, "Workshop Membatik Hadir Kembali!", "05 September 2024")
            ),
            koleksi = listOf(
                KoleksiItem(
                    image = R.drawable.koleksi1,
                    name = "Koleksi Sri Sultan Hamenkubuwana IX",
                    description = "Sejumlah koleksi peninggalan Sri Sultan HB IX, antara lain foto-foto, piagam,medali,tanda jasa,surat keputusan presiden, baju-baju bersejarah beliau,koleksi mobil-mobilan beliau sewaktu kecil,peralatan memasak,kamera yang sering di pergunakan beliau, dan berbagai benda lainnya."
                ),
                KoleksiItem(
                    image = R.drawable.kolesi2,
                    name = "Museum Batik Keraton Yogya",
                    description = "Di Museum Batik menyimpan berbagai macam koleksi kain batik,patung,lukisan,topeng batik,bahan-bahan pewarna,peralatan membatik,serta sepeda tua sebagai pengangkut batik ( dari masa HB VIII s/d HB X ). Koleksi ini merupakan hibah dari dari trah Sri Sultan dan hibah di pengusaha Batik di Yogyakarta."
                ),
                KoleksiItem(
                    image = R.drawable.koleksi3,
                    name = "Koleksi Museum Kristal",
                    description = "Museum Kristal menyimpan berbagai koleksi kristal milik Keraton, seperti kristal polos, guci,hiasan meja,kristal tempat buah, meja rias dari kuningan dan koleksi berbagai benda lainnya."
                )
            ),
            reviews = listOf(
                Review(
                    name = "Tegar Wibisana",
                    rate = "5.0",
                    date = "10 Agustus 2023",
                    comment = "Fasilitas di Museum Keraton Ngayogyakarta Hadiningrat cukup baik, namun ada ruang untuk peningkatan. Tetap memungkinkan pengunjung menikmati koleksi berharga dan merasakan kekayaan budaya Jawa."
                ),
                Review(
                    name = "Althaaf",
                    rate = "4.5",
                    date = "10 Agustus 2024",
                    comment = "ga expect museum nya seru banget! buat semua kalangan umur juga pasti seru dan nyaman. tempatnya bersih dan adem. baru tau museum kereta nya modern dan banyak fitur seruu, dari self photo yang bisa di download, ada permainan lari sama tangkap dari xbox, bisa mewarnai terus gambar nya nanti di scan terus muncul!\uD83E\uDD29 terus setiap liat koleksi keretanya jadi takjub sendiri karena keren keren apalagu kereta yang ga boleh di foto, keren banget belajar sejarahnya. pokoknya harus dateng karena seruu!!!"
                )
            )
        ),
        Museum(
            3,
            "Museum Benteng Vredeburg",
            listOf(
                R.drawable.museum_benteng,
                R.drawable.museum_keraton
            ),
            "200 m",
            "Jl. Margo Mulyo No.6, Ngupasan",
            "5.0",
            "200-250 Kunjungan/Hari",
            "Deskripsi Museum Keraton",
            "Jl. Rotowijayan, Kadipaten, Kecamatan Kraton, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55132",
            "082226373138",
            "08.00 - 13.30 WIB",
            listOf(
                TransportInfo("train", "Stasiun Lempuyangan", "100m"),
                TransportInfo("train", "Stasiun Yogyakarta", "250m")
            ),
            listOf(
                FasilitasInfo("toilet", "Toilet Duduk dan Jongkok"),
                FasilitasInfo("masjid", "Masjid Bersih")
            ),
            eventInfo = listOf(
                EventInfo(R.drawable.event, "Workshop Membatik Hadir Kembali! ", "22 Desember 2024")
            ),
            koleksi = listOf(
                KoleksiItem(
                    image = R.drawable.koleksi1,
                    name = "Koleksi Sri Sultan Hamenkubuwana IX",
                    description = "Sejumlah koleksi peninggalan Sri Sultan HB IX, antara lain foto-foto, piagam,medali,tanda jasa,surat keputusan presiden, baju-baju bersejarah beliau,koleksi mobil-mobilan beliau sewaktu kecil,peralatan memasak,kamera yang sering di pergunakan beliau, dan berbagai benda lainnya."
                ),
                KoleksiItem(
                    image = R.drawable.kolesi2,
                    name = "Museum Batik Keraton Yogya",
                    description = "Di Museum Batik menyimpan berbagai macam koleksi kain batik,patung,lukisan,topeng batik,bahan-bahan pewarna,peralatan membatik,serta sepeda tua sebagai pengangkut batik ( dari masa HB VIII s/d HB X ). Koleksi ini merupakan hibah dari dari trah Sri Sultan dan hibah di pengusaha Batik di Yogyakarta."
                ),
                KoleksiItem(
                    image = R.drawable.koleksi3,
                    name = "Koleksi Museum Kristal",
                    description = "Museum Kristal menyimpan berbagai koleksi kristal milik Keraton, seperti kristal polos, guci,hiasan meja,kristal tempat buah, meja rias dari kuningan dan koleksi berbagai benda lainnya."
                )
            ),
            reviews = listOf(
                Review(
                    name = "Tegar Wibisana",
                    rate = "5.0",
                    date = "10 Agustus 2023",
                    comment = "Fasilitas di Museum Keraton Ngayogyakarta Hadiningrat cukup baik, namun ada ruang untuk peningkatan. Tetap memungkinkan pengunjung menikmati koleksi berharga dan merasakan kekayaan budaya Jawa."
                ),
                Review(
                    name = "Althaaf",
                    rate = "4.5",
                    date = "10 Agustus 2024",
                    comment = "ga expect museum nya seru banget! buat semua kalangan umur juga pasti seru dan nyaman. tempatnya bersih dan adem. baru tau museum kereta nya modern dan banyak fitur seruu, dari self photo yang bisa di download, ada permainan lari sama tangkap dari xbox, bisa mewarnai terus gambar nya nanti di scan terus muncul!\uD83E\uDD29 terus setiap liat koleksi keretanya jadi takjub sendiri karena keren keren apalagu kereta yang ga boleh di foto, keren banget belajar sejarahnya. pokoknya harus dateng karena seruu!!!"
                )
            )
        ),
//        Museum(
//            4,
//            "Museum Sonobudoyo",
//            R.drawable.museum_sonobudoyo,
//            "200 m",
//            "Jl. Pangurakan No.6, Ngupasan, Kec. Gondomanan",
//            "5.0",
//            "200-250 Kunjungan/Hari",
//            "Deskripsi Museum Keraton",
//            "Jl. Rotowijayan, Kadipaten, Kecamatan Kraton, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55132",
//            "082226373138",
//            "08.00 - 13.30 WIB",
//            "Stasiun Lempuyangan 100m, Stasiun Yogyakarta 100m"
//        ),
//        Museum(
//            5,
//            "Museum Biologi UGM",
//            R.drawable.museum_biologi_ugm,
//            "200 m",
//            "Jl. Sultan Agung No.22, Wirogunan, Kec. Mergangsan",
//            "5.0",
//            "200-250 Kunjungan/Hari",
//            "Deskripsi Museum Keraton",
//            "Jl. Rotowijayan, Kadipaten, Kecamatan Kraton, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55132",
//            "082226373138",
//            "08.00 - 13.30 WIB",
//            "Stasiun Lempuyangan 100m, Stasiun Yogyakarta 100m"
//        ),
//        Museum(
//            6,
//            "Museum Wahanarata",
//            R.drawable.museum_wahanarata,
//            "354 m",
//            "Jl. Rotowijayan, Kadipaten, Kecamatan Kraton",
//            "5.0",
//            "200-250 Kunjungan/Hari",
//            "Deskripsi Museum Keraton",
//            "Jl. Rotowijayan, Kadipaten, Kecamatan Kraton, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55132",
//            "082226373138",
//            "08.00 - 13.30 WIB",
//            "Stasiun Lempuyangan 100m, Stasiun Yogyakarta 100m"
//        ),
//        Museum(
//            7,
//            "Museum Wayang Kekayon",
//            R.drawable.museum_wayang,
//            "313 m",
//            "Jl. Jogja-Wonosari Km 7 No 277, National Rte 3, Kalangan, Baturetno, Banguntapan, Bantul Regency,",
//            "5.0",
//            "200-250 Kunjungan/Hari",
//            "Deskripsi Museum Keraton",
//            "Jl. Rotowijayan, Kadipaten, Kecamatan Kraton, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55132",
//            "082226373138",
//            "08.00 - 13.30 WIB",
//            "Stasiun Lempuyangan 100m, Stasiun Yogyakarta 100m"
//        )
    )
}