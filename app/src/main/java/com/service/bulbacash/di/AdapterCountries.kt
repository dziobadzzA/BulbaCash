package com.service.bulbacash.di

import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import com.service.bulbacash.R
import com.service.bulbacash.domain.models.Currency
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AdapterCountries {

    private var list = listOf<Currency>()
    private var currentIndex = 0

    private fun getAdapterWorkBuckets(imageView: ImageView) = object : AdapterView.OnItemSelectedListener {

        override fun onItemSelected(adapterView: AdapterView<*>?, view: View?,
            i: Int, l: Long) {
            imageView.setImageResource(getListWithIcon(list[i]))
            currentIndex = i
        }

        override fun onNothingSelected(adapterView: AdapterView<*>?) {
            return
        }

    }

    fun getCurrentElement() = list[currentIndex]

    @Provides
    fun provideAdapterWorkBuckets(): AdapterCountries = AdapterCountries

    fun getListText() = mapperCurrencyList(list)

    fun getListWithIcon(item: Currency) = getIconCountries(item.Cur_ID)

    fun getListenerToSpinner(imageView: ImageView) = getAdapterWorkBuckets(imageView = imageView)

    fun setListAdapter(list: List<Currency>) {
        this.list = list
    }

    private fun mapperCurrencyList(list: List<Currency>): List<String> {
        val mapList = mutableListOf<String>()
        for (item in list)
            mapList.add(item.Cur_Name)
        return mapList.toList()
    }

    fun getCurrencyFromIndex(cur_ID: Int): Int = list.indexOfFirst { it.Cur_ID == cur_ID }

    fun getIconCountries(cur_ID: Int) = when(cur_ID) {
        1 -> R.drawable.al
        2 -> R.drawable.dz
        5 -> R.drawable.ar
        6 -> R.drawable.bg
        7 -> R.drawable.at
        12 -> R.drawable.be
        19 -> R.drawable.europeanunion
        23 -> R.drawable.ca
        26 -> R.drawable.lk
        27 -> R.drawable.cl
        28 -> R.drawable.cn
        29 -> R.drawable.co
        35 -> R.drawable.cy
        36 -> R.drawable.dk
        40 -> R.drawable.et
        43 -> R.drawable.fi
        44 -> R.drawable.fr
        46 -> R.drawable.ge
        51 -> R.drawable.gr
        57 -> R.drawable.hk
        58 -> R.drawable.`is`
        59 -> R.drawable.`in`
        61 -> R.drawable.ir
        62 -> R.drawable.iq
        63 -> R.drawable.ie
        64 -> R.drawable.il
        65 -> R.drawable.it
        67 -> R.drawable.jp
        68 -> R.drawable.jo
        69 -> R.drawable.ke
        71 -> R.drawable.kr
        72 -> R.drawable.kw
        73 -> R.drawable.la
        74 -> R.drawable.lb
        77 -> R.drawable.ly
        78 -> R.drawable.lu
        87 -> R.drawable.mx
        88 -> R.drawable.mn
        89 -> R.drawable.ma
        93 -> R.drawable.np
        94 -> R.drawable.nl
        98 -> R.drawable.nz
        100 -> R.drawable.ng
        101 -> R.drawable.no
        102 -> R.drawable.pk
        106 -> R.drawable.pe
        107 -> R.drawable.ph
        108 -> R.drawable.pl
        109 -> R.drawable.pt
        116 -> R.drawable.sa
        119 -> R.drawable.sg
        120 -> R.drawable.vn
        121 -> R.drawable.si
        123 -> R.drawable.za
        125 -> R.drawable.es
        126 -> R.drawable.sd
        129 -> R.drawable.se
        130 -> R.drawable.ch
        131 -> R.drawable.sy
        132 -> R.drawable.th
        135 -> R.drawable.ae
        136 -> R.drawable.tn
        137 -> R.drawable.tr
        139 -> R.drawable.ua
        140 -> R.drawable.mk
        141 -> R.drawable.ru
        142 -> R.drawable.eg
        143 -> R.drawable.gb
        145 -> R.drawable.us
        152 -> R.drawable.tw
        154 -> R.drawable.tj
        155 -> R.drawable.uz
        156 -> R.drawable.am
        157 -> R.drawable.az
        169 -> R.drawable.ua
        170 -> R.drawable.au
        171 -> R.drawable.cz
        172 -> R.drawable.ee
        173 -> R.drawable.hu
        174 -> R.drawable.kz
        175 -> R.drawable.kg
        176 -> R.drawable.lv
        177 -> R.drawable.lt
        178 -> R.drawable.md
        179 -> R.drawable.ro
        180 -> R.drawable.sk
        181 -> R.drawable.tm
        182 -> R.drawable.tj
        183 -> R.drawable.az
        184 -> R.drawable.am
        187 -> R.drawable.ge
        188 -> R.drawable.pl
        189 -> R.drawable.br
        190 -> R.drawable.ru
        191 -> R.drawable.bg
        192 -> R.drawable.uz
        193 -> R.drawable.af
        198 -> R.drawable.br
        200 -> R.drawable.de
        201 -> R.drawable.af
        206 -> R.drawable.af
        207 -> R.drawable.uy
        219 -> R.drawable.pl
        220 -> R.drawable.tr
        221 -> R.drawable.hu
        222 -> R.drawable.kz
        223 -> R.drawable.kg
        224 -> R.drawable.ua
        225 -> R.drawable.ee
        226 -> R.drawable.az
        227 -> R.drawable.al
        228 -> R.drawable.af
        229 -> R.drawable.vn
        230 -> R.drawable.ge
        231 -> R.drawable.la
        232 -> R.drawable.mn
        233 -> R.drawable.ng
        234 -> R.drawable.pe
        235 -> R.drawable.ro
        236 -> R.drawable.tj
        237 -> R.drawable.th
        239 -> R.drawable.za
        240 -> R.drawable.kr
        241 -> R.drawable.ve
        244 -> R.drawable.my
        245 -> R.drawable.rs
        248 -> R.drawable.id
        249 -> R.drawable.hr
        250 -> R.drawable.cn
        251 -> R.drawable.mx
        254 -> R.drawable.cn
        256 -> R.drawable.tr
        257 -> R.drawable.tm
        259 -> R.drawable.ve
        260 -> R.drawable.tm
        262 -> R.drawable.sd
        264 -> R.drawable.ir
        265 -> R.drawable.ge
        266 -> R.drawable.lb
        267 -> R.drawable.tr
        268 -> R.drawable.ua
        269 -> R.drawable.tj
        270 -> R.drawable.am
        271 -> R.drawable.az
        272 -> R.drawable.ro
        273 -> R.drawable.ro
        274 -> R.drawable.tm
        277 -> R.drawable.jp
        279 -> R.drawable.ve
        280 -> R.drawable.id
        281 -> R.drawable.mk
        282 -> R.drawable.sa
        283 -> R.drawable.lk
        286 -> R.drawable.nz
        287 -> R.drawable.ro
        288 -> R.drawable.hr
        290 -> R.drawable.ua
        291 -> R.drawable.dk
        292 -> R.drawable.europeanunion
        293 -> R.drawable.pl
        294 -> R.drawable.`is`
        295 -> R.drawable.jp
        296 -> R.drawable.md
        297 -> R.drawable.no
        298 -> R.drawable.ru
        300 -> R.drawable.kg
        301 -> R.drawable.kz
        302 -> R.drawable.tr
        303 -> R.drawable.ir
        304 -> R.drawable.cn
        305 -> R.drawable.cz
        306 -> R.drawable.se
        307 -> R.drawable.dz
        308 -> R.drawable.ar
        309 -> R.drawable.af
        310 -> R.drawable.th
        311 -> R.drawable.ve
        312 -> R.drawable.br
        313 -> R.drawable.kr
        314 -> R.drawable.hk
        315 -> R.drawable.mk
        316 -> R.drawable.ae
        317 -> R.drawable.vn
        318 -> R.drawable.eg
        319 -> R.drawable.`in`
        320 -> R.drawable.iq
        321 -> R.drawable.ke
        322 -> R.drawable.la
        323 -> R.drawable.co
        324 -> R.drawable.hr
        325 -> R.drawable.ge
        326 -> R.drawable.al
        327 -> R.drawable.my
        328 -> R.drawable.ma
        329 -> R.drawable.mx
        330 -> R.drawable.ng
        331 -> R.drawable.np
        332 -> R.drawable.il
        333 -> R.drawable.pe
        334 -> R.drawable.tw
        335 -> R.drawable.tm
        336 -> R.drawable.pk
        337 -> R.drawable.ro
        338 -> R.drawable.id
        339 -> R.drawable.za
        340 -> R.drawable.sa
        341 -> R.drawable.rs
        342 -> R.drawable.sy
        343 -> R.drawable.tj
        344 -> R.drawable.sd
        345 -> R.drawable.uz
        346 -> R.drawable.uy
        347 -> R.drawable.ph
        348 -> R.drawable.hu
        349 -> R.drawable.lk
        350 -> R.drawable.et
        351 -> R.drawable.tn
        352 -> R.drawable.la
        353 -> R.drawable.az
        354 -> R.drawable.ve
        355 -> R.drawable.jp
        356 -> R.drawable.ve
        371 -> R.drawable.ca
        374 -> R.drawable.cl
        392 -> R.drawable.jo
        394 -> R.drawable.kw
        395 -> R.drawable.lb
        398 -> R.drawable.ly
        421 -> R.drawable.sg
        426 -> R.drawable.ch
        429 -> R.drawable.gb
        431 -> R.drawable.us
        440 -> R.drawable.au
        441 -> R.drawable.bg
        446 -> R.drawable.mn
        448 -> R.drawable.nz
        449 -> R.drawable.ua
        450 -> R.drawable.dk
        451 -> R.drawable.europeanunion
        452 -> R.drawable.pl
        453 -> R.drawable.`is`
        454 -> R.drawable.ml
        455 -> R.drawable.no
        456 -> R.drawable.ru
        458 -> R.drawable.kg
        459 -> R.drawable.kz
        460 -> R.drawable.tr
        461 -> R.drawable.ir
        462 -> R.drawable.cn
        463 -> R.drawable.cz
        464 -> R.drawable.se
        465 -> R.drawable.dz
        466 -> R.drawable.ar
        467 -> R.drawable.af
        468 -> R.drawable.th
        469 -> R.drawable.br
        470 -> R.drawable.kr
        471 -> R.drawable.hk
        472 -> R.drawable.mk
        473 -> R.drawable.ae
        474 -> R.drawable.vn
        475 -> R.drawable.eg
        476 -> R.drawable.`in`
        477 -> R.drawable.iq
        478 -> R.drawable.ke
        479 -> R.drawable.co
        480 -> R.drawable.hr
        481 -> R.drawable.ge
        482 -> R.drawable.al
        483 -> R.drawable.my
        484 -> R.drawable.mx
        485 -> R.drawable.ng
        486 -> R.drawable.np
        487 -> R.drawable.il
        488 -> R.drawable.pe
        489 -> R.drawable.tw
        490 -> R.drawable.tm
        491 -> R.drawable.pk
        492 -> R.drawable.ro
        493 -> R.drawable.id
        494 -> R.drawable.za
        495 -> R.drawable.sa
        496 -> R.drawable.rs
        497 -> R.drawable.sy
        498 -> R.drawable.tj
        499 -> R.drawable.sd
        500 -> R.drawable.uz
        501 -> R.drawable.uy
        502 -> R.drawable.ph
        503 -> R.drawable.hu
        504 -> R.drawable.lk
        505 -> R.drawable.tn
        506 -> R.drawable.la
        507 -> R.drawable.az
        508 -> R.drawable.jp
        509 -> R.drawable.ve
        510 -> R.drawable.am
        else -> R.drawable.ic_baseline_language_24
    }

}