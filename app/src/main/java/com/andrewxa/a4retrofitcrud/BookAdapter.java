package com.andrewxa.a4retrofitcrud;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.andrewxa.a4retrofitcrud.bd.Book;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookAdapter extends ArrayAdapter<Book> {
    private Context context;
    private List<Book> listBooks;

    @BindView(R.id.bookId)
    TextView bookId;

    @BindView(R.id.bookTitle)
    TextView bookTitle;

    @BindView(R.id.bookAuthor)
    TextView bookAuthor;

    @BindView(R.id.bookDescription)
    TextView bookDescription;

    @BindView(R.id.bookPublished)
    TextView bookPublished;


    public BookAdapter(@NonNull Context context, int resource, @NonNull List<Book> objects) {
        super(context, resource, objects);
        this.context = context;
        listBooks = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listbook, parent, false);

        ButterKnife.bind(this,rowView);

        bookId.setText(String.format("Это ID %d",listBooks.get(position).getId()));
        bookTitle.setText(String.format("Это заголовок %s" ,listBooks.get(position).getTitle()));
        bookAuthor.setText((String.format("Это автор %s", listBooks.get(position).getAuthor())));
        bookDescription.setText(String.format("Здесь описание %s", listBooks.get(position).getDescription()));
        bookPublished.setText(String.format("Дата публикации %d", listBooks.get(position).getPublished()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BookActivity.class);

                intent.putExtra("id", listBooks.get(position).getId());
                intent.putExtra("title", listBooks.get(position).getTitle());
                intent.putExtra("author", listBooks.get(position).getAuthor());
                intent.putExtra("description", listBooks.get(position).getDescription());
                intent.putExtra("published", listBooks.get(position).getPublished());

                context.startActivity(intent);
            }
        });

        return rowView;

    }
}
