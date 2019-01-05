package example.com.article.model.webRequest;

import example.com.article.common.Constants;
import example.com.article.model.callbacks.ArticleCallback;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitGet {

    @GET(Constants.ARTICLES_URL)
    Call<ArticleCallback> getArticleList();

}
