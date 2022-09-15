package com.example.babistone_auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.babistone_auth.adapteur.DataAdapter
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_show_book_firestore.*

data class User(
    val name:String = "",
    val image:String =""
)
class UserViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
class ShowBookFirestore : AppCompatActivity() {
    private companion object{
        private const val TAG = "MainActivity"
    }
    private lateinit var auth:FirebaseAuth
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_book_firestore)
        add_data.setOnClickListener {
            Intent(this,FirestorePage::class.java).also {
                startActivity(it)
            }
        }
        auth = Firebase.auth
        val query :CollectionReference = db.collection("info_book")
        val options = FirestoreRecyclerOptions.Builder<User>()
            .setQuery(query,User::class.java)
            .setLifecycleOwner(this).build()
        val adapter = object :FirestoreRecyclerAdapter<User,UserViewHolder>(options){
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.liste_row,parent,false)
                return UserViewHolder(view)
            }

            override fun onBindViewHolder(holder: UserViewHolder, position: Int, model: User) {
                val txtname:TextView = holder.itemView.findViewById(R.id.name_liste)
                val txtbook:TextView = holder.itemView.findViewById(R.id.nm)
                txtname.text = model.name
                txtbook.text = model.image
            }

        }
        rv_user.adapter = adapter
        rv_user.layoutManager = LinearLayoutManager(this)
    }

}