package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.models.UserList
import com.example.myapplication.network.Service
import com.example.myapplication.ui.MainFragment
import com.example.myapplication.ui.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val BaseUrl =
    "https://jsonplaceholder.typicode.com/"
private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var binding: ActivityMainBinding


    lateinit var userList: ArrayList<UserList>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<MainFragment>(R.id.nav_host_fragment)
            }
        }
      /*  binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)*/

       // getMethod()
      /*  val bottomSheetFragment=BottomSheetFragment()
        binding.createButton.setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager,"BottomSheetDialog")
            /* val intent = Intent(this, CreateActivity::class.java)
             startActivity(intent)*/

        }*/

      /*  binding.detailButton.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }*/


    }


    /*private fun showData(body: List<UserList.User>) {
        binding.recyclerView.apply {
            //val listOfPosts = mutableListOf<PostDetail>()
            val adapter = RecyclerViewAdapter(this@MainActivity, body)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }*/

    /* fun getMethod() {
         val retrofit = Retrofit.Builder()
             .baseUrl(BaseUrl)
             .addConverterFactory(GsonConverterFactory.create())
             .build()

         val postService = retrofit.create(service::class.java)
         postService.getPosts()
             .enqueue(object : Callback<List<User>> {
                 override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                     if (response.isSuccessful) {
                         showData(response.body()!!)
                     }
                 }

                 override fun onFailure(call: Call<List<User>>, t: Throwable) {
                     Log.i(TAG, "onFailure $t")
                 }

             })
     }*/
    //1
    fun getMethod() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val postService = retrofit.create(Service::class.java)
        postService.groupList("1")

            .enqueue(object : Callback<List<UserList.User>> {

                override fun onResponse(
                    call: Call<List<UserList.User>>,
                    response: Response<List<UserList.User>>
                ) {

                    if (response.isSuccessful) {
                       // showData(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<List<UserList.User>>, t: Throwable) {
                    Log.i(TAG, "onFailure $t")
                }

            })
    }

    /* override fun onItemEditCLick(user: User) {
         val intent = Intent(this@MainActivity, DetailsActivity::class.java)
         intent.putExtra("user_id", user.id)
         startActivityForResult(intent, 1000)
     }
     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

         if(requestCode == 1000) {
            getMethod()
         }
         super.onActivityResult(requestCode, resultCode, data)
     }*/

}
