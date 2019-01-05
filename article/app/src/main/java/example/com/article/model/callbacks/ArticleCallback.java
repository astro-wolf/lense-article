package example.com.article.model.callbacks;

import com.google.gson.annotations.SerializedName;
import example.com.article.model.pojo.ArticleInfo;

import java.util.ArrayList;

public class ArticleCallback {

    @SerializedName("status")
    public String status = "";
    @SerializedName("articles")
    public ArrayList<ArticleInfo> articleList = new ArrayList<>();

}
