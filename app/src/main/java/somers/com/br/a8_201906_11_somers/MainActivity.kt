package somers.com.br.a8_201906_11_somers

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contatos = mutableListOf(
                Contato("jorge","(11) 982446277"),
                Contato("jorg1","(11) 982411111"),
                Contato("jorg2","(11) 982422222"),
                Contato("jorg3","(11) 982433333")
                )

        repeat(200){
            contatos.add(Contato("Contato ${it}","(11) ${it*234}"))
        }

        val adapter = ContatoAdapter()

        rvContatos.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        rvContatos.adapter = adapter

        adapter.updateItems(contatos)
    }
}
