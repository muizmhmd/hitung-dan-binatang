package com.muiz.kebunbinatangapp

class Binatang {
    var nama: String? = null
    var deskripsi: String? = null
    var gambar: Int? = null
    var binatangBuas: Boolean? = null

    constructor(nama: String?, deskripsi: String?, gambar: Int?, binatangBuas: Boolean?) {
        this.nama = nama
        this.deskripsi = deskripsi
        this.gambar = gambar
        this.binatangBuas = binatangBuas
    }
}