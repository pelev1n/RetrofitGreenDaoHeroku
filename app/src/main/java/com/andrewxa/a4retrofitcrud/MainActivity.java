package com.andrewxa.a4retrofitcrud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.andrewxa.a4retrofitcrud.bd.Book;
import com.andrewxa.a4retrofitcrud.bd.BookDao;
import com.andrewxa.a4retrofitcrud.bd.DaoSession;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private boolean flag;
    private DaoSession mDaoSession = null;
    private BookDao mBooksItemDao = null;

    @BindView(R.id.btnAddBook)
    Button btnAddBook;

    @BindView(R.id.btnGetBookList)
    Button btnGetBookList;

    @BindView(R.id.listView)
    ListView listView;

    BookInterface bookInterface;
    List<Book> listOfBooks = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        flag = true;

        mDaoSession = ((App) getApplication()).getDaoSession();
        mBooksItemDao = mDaoSession.getBookDao();
        mBooksItemDao.deleteAll();

        bookInterface = ApiUtils.getBookInterface();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(flag) {
            flag=false;
        } else {
            getBookList();
        }
    }

    @OnClick(R.id.btnAddBook)
    public void onClick() {
        Intent intent = new Intent(MainActivity.this, BookActivity.class);
        intent.putExtra("bookName", "");
        startActivity(intent);
    }


    private void setAdapter() {

        List<Book> newsItemList = mBooksItemDao.loadAll();

        BookAdapter bookAdapter = new BookAdapter(MainActivity.this, R.layout.listbook, mBooksItemDao.loadAll());
        listView.setAdapter(bookAdapter);
    }
    @OnClick(R.id.btnGetBookList)
    public void getBookList() {
        Call<List<Book>> call = bookInterface.getBooks();
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful()) {
                    /*mBooksItemDao.deleteAll();*/
                    List<Book> books = response.body();
                    mBooksItemDao.insertOrReplaceInTx(books);
                }
                setAdapter();
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
            }
        });
    }
}
