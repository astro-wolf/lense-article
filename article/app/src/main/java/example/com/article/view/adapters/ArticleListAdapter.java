package example.com.article.view.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import example.com.article.R;
import example.com.article.model.pojo.ArticleInfo;

import java.util.ArrayList;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ArticleHolder> {

    private Context context;
    private ArrayList<ArticleInfo> articleList = new ArrayList<>();

    public ArticleListAdapter(Context context, ArrayList<ArticleInfo> articleList) {
        this.context = context;
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public ArticleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_article_item,
                viewGroup,
                false);
        return new ArticleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleHolder articleHolder, int position) {
        articleHolder.bind(articleList.get(position));
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class ArticleHolder extends RecyclerView.ViewHolder {
        private TextView titleTv;
        private TextView descriptionTv;
        private ImageView articleIv;

        ArticleHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.tv_article_title);
            descriptionTv = itemView.findViewById(R.id.tv_article_desc);
            articleIv = itemView.findViewById(R.id.iv_article);
        }

        void bind(ArticleInfo articleInfo) {
            titleTv.setText("Title: \n" + articleInfo.title);
            descriptionTv.setText("Description: \n" + articleInfo.description);
            Glide.with(context)
                    .load(articleInfo.image)
                    .into(articleIv);
        }
    }

}
