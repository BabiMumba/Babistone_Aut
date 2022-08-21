package com.example.babistone_auth

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.babistone_auth.adapteur.DataAdapter
import com.example.babistone_auth.model.library
import com.google.firebase.firestore.*

class ResultatActivity : AppCompatActivity() {
    private lateinit var recyclerview:RecyclerView
    private lateinit var listeabook:ArrayList<library>
    private lateinit var monAdapter: DataAdapter
    private lateinit var db:FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultat)

        recyclerview = findViewById(R.id.recycler)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)

        listeabook= arrayListOf()
        monAdapter = DataAdapter(listeabook)
        recyclerview.adapter = monAdapter

        EvenChangeListener()
    }

    private fun EvenChangeListener() {
        db = FirebaseFirestore.getInstance()
        db.collection("info_book")
            .addSnapshotListener(object :EventListener<QuerySnapshot>{
                @SuppressLint("NotifyDataSetChanged")
                override fun onEvent(
                    value: QuerySnapshot?,
                    error: FirebaseFirestoreException?
                ) {
                    if (error != null){
                        Log.e("Firestore Error", error.message.toString())
                        return
                    }
                    for (dc:DocumentChange in value?.documentChanges!!){
                        if (dc.type == DocumentChange.Type.ADDED){
                            listeabook.add(dc.document.toObject(library::class.java))
                        }
                    }
                    monAdapter.notifyDataSetChanged()
                }

            })
    }
}