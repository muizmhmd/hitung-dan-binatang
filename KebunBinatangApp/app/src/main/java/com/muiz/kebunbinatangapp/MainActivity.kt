package com.muiz.kebunbinatangapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_detail_binatang.*
import kotlinx.android.synthetic.main.activity_detail_binatang.view.*
import kotlinx.android.synthetic.main.item_list_binatang.view.*
import kotlinx.android.synthetic.main.item_list_binatang.view.txtDeskripsi
import kotlinx.android.synthetic.main.item_list_binatang.view.txtNama
import kotlinx.android.synthetic.main.list_binatang_buas.view.*

class MainActivity : AppCompatActivity() {

    var listBinatang = ArrayList<Binatang>()
    var adapter: AdapterBinatang? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listBinatang.add(
            Binatang("Kelinci", "Kelinci Rumah", R.drawable.kelinci, false)
        )
        listBinatang.add(
            Binatang("Beruang", "Grizlie Bear", R.drawable.beruang, true)
        )
        listBinatang.add(
            Binatang("Gajah", "Gajah Sumatera", R.drawable.gajah, false)
        )
        listBinatang.add(
            Binatang("Hariamau", "Harimau Jawa", R.drawable.harimau, true)
        )
        listBinatang.add(
            Binatang("Kanguru", "Kanguru Australia", R.drawable.kanguru, false)
        )
        listBinatang.add(
            Binatang("Kuda", "Kuda Betina", R.drawable.kuda, false)
        )
        listBinatang.add(
            Binatang("Trengiling", "Trengiling salah satau penyebab virus corona kata ahli", R.drawable.trenggiling, false)
        )

        adapter = AdapterBinatang(this, listBinatang)
//        ivBinatang.adapter = adapter
    }

    inner class AdapterBinatang: BaseAdapter {
        var listBinatang = ArrayList<Binatang>()
        var context: Context? = null

        constructor(context: Context?, listBinatang: ArrayList<Binatang>) : super() {
            this.listBinatang = listBinatang
            this.context = context
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val binatang = listBinatang[p0]
            if (binatang.binatangBuas == true){
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.list_binatang_buas, null)
                myView.txtNama.text = binatang.nama!!
                myView.txtDeskripsi.text = binatang.deskripsi!!
                myView.ivBinatang.setImageResource(binatang.gambar!!)
                myView.ivBinatang.setOnClickListener {
                    val intent = Intent(context, DetailBinatangActivity::class.java)
                    intent.putExtra("nama", binatang.nama!!)
                    intent.putExtra("deskripsi", binatang.deskripsi!!)
                    intent.putExtra("gambar", binatang.gambar!!)
                    context!!.startActivity(intent)
                }
                return myView
            } else {
                val binatang = listBinatang[p0]
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.item_list_binatang, null)
                myView.txtNama.text = binatang.nama!!
                myView.txtDeskripsi.text = binatang.deskripsi!!
                myView.ivBinatang.setImageResource(binatang.gambar!!)
                myView.ivBinatang.setOnClickListener {
                    val intent = Intent(context, DetailBinatangActivity::class.java)
                    intent.putExtra("nama", binatang.nama!!)
                    intent.putExtra("deskripsi", binatang.deskripsi!!)
                    intent.putExtra("gambar", binatang.gambar!!)
                    context!!.startActivity(intent)
                }
                return myView
            }
        }

        override fun getItem(p0: Int): Any {
            return listBinatang[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listBinatang.size
        }
    }

}
