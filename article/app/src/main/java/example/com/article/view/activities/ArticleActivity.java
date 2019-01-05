package example.com.article.view.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import example.com.article.R;
import example.com.article.interfaces.ArticleInterface;
import example.com.article.model.pojo.ArticleInfo;
import example.com.article.presenter.ArticlePresenter;
import example.com.article.view.adapters.ArticleListAdapter;

import java.util.ArrayList;

public class ArticleActivity extends AppCompatActivity implements ArticleInterface {

    private TextView loadingTv;
    private RecyclerView articleRv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        handleEvents();
    }

    //region utility methods
    private void initViews() {
        setContentView(R.layout.activity_article);
        loadingTv = findViewById(R.id.tv_loading);
        articleRv = findViewById(R.id.rv_articles);
        articleRv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void handleEvents() {
        ArticlePresenter articlePresenter = new ArticlePresenter(this);
        articlePresenter.getArticleList();
    }

    private void showMessage(boolean show, String message) {
        loadingTv.setText(message);
        loadingTv.setVisibility(show ? View.VISIBLE : View.GONE);
        articleRv.setVisibility(show ? View.GONE : View.VISIBLE);
    }
    //end region

    //region API callbacks
    @Override
    public void onArticleList(ArrayList<ArticleInfo> articleList) {
        if (articleList.isEmpty()) {
            showMessage(true, "No articles right now");
        } else {
            showMessage(false, "");
            ArticleListAdapter articleListAdapter = new ArticleListAdapter(this, articleList);
            articleRv.setAdapter(articleListAdapter);
        }
    }

    @Override
    public void onApiStart() {
        showMessage(true, "Loading...");
    }

    @Override
    public void onFailure(String message) {
        showMessage(true, message);
    }
    //endregion
}
