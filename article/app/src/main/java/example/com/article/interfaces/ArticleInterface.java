package example.com.article.interfaces;

import example.com.article.model.pojo.ArticleInfo;

import java.util.ArrayList;

public interface ArticleInterface extends BaseInterface {

    void onArticleList(ArrayList<ArticleInfo> articleList);

}
