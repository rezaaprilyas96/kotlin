import tetap.SCAN
import tetap.admin
import tetap.perguruan
import java.util.*
import kotlin.collections.ArrayList

object tetap {
    val SCAN = Scanner(System.`in`)
    val admin = Admin()
    var perguruan = ""
}

enum class PengelolaKampus(val pengelola: String) {
    PTN("Perguruan Tinggi Negeri"),
    PTS("Perguruan Tinggi Swasta"),
    PTK("Perguruan Tinggi Kedinasan")
}

enum class PerguruanTinggi(val perguruan: String) {
    UNIVERSITAS("Universitas"),
    INSTITTUT("Institut"),
    SEKOLAHTINGGI("Sekolah Tinggi"),
    POLITEKNIK("Politeknik"),
    AKADEMIK("Akademik")
}

interface IFungsiAdmin {
    fun insertKampus(kampus: ModelKampus)
    fun showKampus()
    fun searchKampus()
    fun editKampus()
    fun deleteKampus()
}

data class ModelKampus(val idKampus: Int,
                       val namaKampus: String,
                       val alamatKampus: String,
                       val perguruan: String,
                       val pengelola: String)

abstract class Kampus() {
    val kampus = ArrayList<ModelKampus>()
}

class Admin : IFungsiAdmin, Kampus() {

    override fun insertKampus(kampus: ModelKampus) {
        super.kampus.add(kampus)
    }

    override fun showKampus() {

    }

    override fun searchKampus() {
        TODO("Not yet implemented")
    }

    override fun editKampus() {
        TODO("Not yet implemented")
    }

    override fun deleteKampus() {
        TODO("Not yet implemented")
    }

}

fun insertPengelola(): String {
    println("1. ${PerguruanTinggi.UNIVERSITAS.perguruan}")
    println("2. ${PerguruanTinggi.INSTITTUT.perguruan}")
    println("3. ${PerguruanTinggi.AKADEMIK.perguruan}")
    print("masukan pilihan perguruan tinggi : ")
    val perguruanTinggi = SCAN.nextInt()
    when (perguruanTinggi) {
        1 -> {
            return PerguruanTinggi.UNIVERSITAS.perguruan
        }
        2 -> {
            return PerguruanTinggi.INSTITTUT.perguruan
        }
        3 -> {
            return PerguruanTinggi.AKADEMIK.perguruan
        }
        4 -> {
            return PerguruanTinggi.POLITEKNIK.perguruan
        }
        else -> {
            return PerguruanTinggi.SEKOLAHTINGGI.perguruan
        }
    }
}

fun insertPerguruanTinggi(): String {
    println("1. ${PerguruanTinggi.UNIVERSITAS.perguruan}")
    println("2. ${PerguruanTinggi.INSTITTUT.perguruan}")
    println("3. ${PerguruanTinggi.AKADEMIK.perguruan}")
    println("4. ${PerguruanTinggi.POLITEKNIK.perguruan}")
    println("5. ${PerguruanTinggi.SEKOLAHTINGGI.perguruan}")
    print("masukan pilihan perguruan tinggi : ")
    val perguruanTinggi = SCAN.nextInt()

    when (perguruanTinggi) {
        1 -> {
            return PerguruanTinggi.UNIVERSITAS.perguruan
        }
        2 -> {
            return PerguruanTinggi.INSTITTUT.perguruan
        }
        3 -> {
            return PerguruanTinggi.AKADEMIK.perguruan
        }
        4 -> {
            return PerguruanTinggi.POLITEKNIK.perguruan
        }
        5 -> {
            return PerguruanTinggi.SEKOLAHTINGGI.perguruan
        }
        else -> {
            println("#masukan pilihan yang benar#")
            insertPerguruanTinggi()
            return ""
        }
    }
}

fun cek() {
    perguruan = insertPerguruanTinggi()
}

fun menu() {
    println("1. admin")
    println("2. dosen")
    println("3. mahasiswa")
    print("masukan pilihan : ")
    val input = SCAN.nextInt()

    when (input) {
        1 -> {
            SCAN.nextLine()
            print("masukan nama kampus : ")
            val namaKampus: String = SCAN.nextLine()

            print("masukan alamat kampus : ")
            val alamatKampus: String = SCAN.nextLine()

            perguruan = insertPerguruanTinggi()


            val insertKampus = ModelKampus(admin.kampus.size + 1, namaKampus, alamatKampus, perguruan, PengelolaKampus.PTS.pengelola)
            admin.insertKampus(insertKampus)

            admin.kampus.forEach { kampus ->
                println(kampus)
            }
            menu()
        }

        2 -> {

        }

        3 -> {

        }
        else -> {

        }
    }
}

fun main() {
    menu()
}