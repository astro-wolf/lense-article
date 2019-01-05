package example.com.article.presenter;

import android.support.annotation.NonNull;
import example.com.article.interfaces.ArticleInterface;
import example.com.article.model.callbacks.ArticleCallback;
import example.com.article.model.webRequest.RetrofitRequest;
import example.com.article.common.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticlePresenter {

    private ArticleInterface articleInterface;

    public ArticlePresenter(ArticleInterface articleInterface) {
        this.articleInterface = articleInterface;
    }

    public void getArticleList() {
        articleInterface.onApiStart();
        RetrofitRequest
                .retrofitGetRequest()
                .getArticleList()
                .enqueue(new Callback<ArticleCallback>() {
                    @Override
                    public void onResponse(@NonNull Call<ArticleCallback> call,
                                           @NonNull Response<ArticleCallback> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            articleInterface.onArticleList(response.body().articleList);
                        } else {
                            articleInterface.onFailure(Constants.SOMETHING_WENT_WRONG);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ArticleCallback> call,
                                          @NonNull Throwable t) {
                        articleInterface.onFailure(Constants.SOMETHING_WENT_WRONG);
                    }
                });
    }

}
