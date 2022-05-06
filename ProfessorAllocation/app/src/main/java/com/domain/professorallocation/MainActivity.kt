package com.domain.professorallocation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.domain.professorallocation.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var retrofitConfig: Retrofit

    private lateinit var adapter: CursoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        retrofitConfig = RetrofitConfig.retrofit
        adapter = CursoAdapter(updateCourse = ::createDialog, delete = {})
        viewBinding.rvCurso.adapter = adapter

        setupRequestGetAll()
    }

    private fun createDialog(id: String) {
        val builder = AlertDialog.Builder(this)

        val view = layoutInflater.inflate(R.layout.dialog_cad, null)
        builder.setView(view)
            .setPositiveButton(
                R.string.bt_cad
            ) { dialog, id ->
                val editText = view.findViewById<EditText>(R.id.courseName)
                // Chamar metodo que executa a request

                setupUpdateRequest(id = id, CursoPutDTO(""))
            }
            .setNegativeButton(
                R.string.bt_cancel
            ) { dialog, id ->
                dialog.dismiss()
            }
        builder.show()
    }

    private fun setupUpdateRequest(id: String, curso: CursoPutDTO) {
        val service = retrofitConfig.create(CursoService::class.java)
        val call = service.alterCurso(id, curso)
    }

    private fun setupRequestGetAll() {
        val service = retrofitConfig.create(CursoService::class.java)
        val call = service.getAll()

        call.enqueue(object : Callback<List<Curso>> {
            override fun onResponse(call: Call<List<Curso>>, response: Response<List<Curso>>) {

                if (response.isSuccessful) {
                    val resposta = response.body()

                    resposta?.let {
                        adapter.setData(it)
                    }
                } else {

                    val erro = response.errorBody()?.toString() ?: "Sem resposta"

                    AlertDialog.Builder(this@MainActivity)
                        .setTitle("Algo errado!")
                        .setMessage(erro)
                        .setNegativeButton("OK") { _, _ ->
                            finish()
                        }
                        .show()
                }
            }

            override fun onFailure(call: Call<List<Curso>>, t: Throwable) {
                AlertDialog.Builder(this@MainActivity)
                    .setTitle("ERRO")
                    .setMessage("Algo de errado aconteceu!")
                    .setNegativeButton("OK") { _, _ ->
                        finish()
                    }
                    .show()
            }
        })
    }

}