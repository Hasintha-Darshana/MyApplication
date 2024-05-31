package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Contact> contactArrayList;
    public static RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    private SearchView searchView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactArrayList = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler_ViewContacts);
        searchView = findViewById(R.id.search_View);
        Button addContactButton = findViewById(R.id.add_ContactButton);

        // Add contacts here
        contactArrayList.add(new Contact("Samith Dinushan", "076 673 5732", "123 Galle Road, Colombo 3", "January 12, 1998"));
        contactArrayList.add(new Contact("Kaushal Sampath", "076 452 6789", "456 Kandy Road, Peradeniya, Kandy", "March 15, 1998"));
        contactArrayList.add(new Contact("Nawodi Godakanda", "071 236 1147", "789 Negombo Road, Katunayake", "July 23, 2000"));
        contactArrayList.add(new Contact("Hasintha Darshana", "078 800 5612", "10 Matara Road, Galle", "November 28, 1995"));
        contactArrayList.add(new Contact("Nadun Sameera", "077 745 2236", "11 Rajapihilla Mawatha, Kandy", "April 17, 2000"));
        contactArrayList.add(new Contact("Sumudu Chamika", "077 905 4598", "12 St. Joseph Street, Negombo", "August 29, 1998"));
        contactArrayList.add(new Contact("Hiran Pamod", "071 673 9000", "21 Stanley Road, Batticaloa", "February 13, 1999"));
        contactArrayList.add(new Contact("Thiwanka Nayanajith", "076 673 4922", "6/2, Perera Place, Ratnapura", "June 20, 1998"));
        contactArrayList.add(new Contact("Sachini Wasana", "071 461 5596", "24 Lake Drive, Anuradhapura", "December 11, 1988"));
        contactArrayList.add(new Contact("Milani Thathsarani", "078 259 6375", "13 Main Street, Jaffnaa", "May 26, 1998"));
        contactArrayList.add(new Contact("Chamindu Peris", "077 510 2398", "12, Wickrama Mawatha, Polonnaruwa", "September 27, 1999"));
        contactArrayList.add(new Contact("Dilshan Kavishka", "077 589 2301", "3C, Fernando Gardens, Batticaloa", "January 19, 2000"));
        contactArrayList.add(new Contact("Kamindu Vithana", "076 358 4040", "23 Queen's Road, Nuwara Eliya", "March 14, 1998"));
        contactArrayList.add(new Contact("Dilki Hansika", "078 321 4562", "45, Perera Street, Nuwara Eliya", "July 17, 1999"));
        contactArrayList.add(new Contact("Imashi Fonseka ", "072 489 2567", "9/4, Rajapaksa Road, Ampara", "November 25, 1998"));
        contactArrayList.add(new Contact("Isuru Lakshan", "071 305 7448", "63, Mendis Lane, Hambantota", "April 19, 2000"));
        contactArrayList.add(new Contact("Nethmi Miyuranga", "077 852 3611", "17A, Fernando Place, Kalutara", "August 22, 1998"));
        contactArrayList.add(new Contact("Sanjaya Prasad", "076 485 3698", "6 Temple Road, Dambulla", "February 23, 1999"));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(contactArrayList, this);
        recyclerView.setAdapter(adapter);

        // Set up search functionality
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        // Set up add contact button
        addContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                startActivity(intent);
            }
        });
    }
}
