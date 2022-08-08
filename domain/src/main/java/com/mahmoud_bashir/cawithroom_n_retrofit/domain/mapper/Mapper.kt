package com.mahmoud_bashir.cawithroom_n_retrofit.domain.mapper

interface Mapper<in FROM, out TO> {
    fun map(from: FROM): TO
}